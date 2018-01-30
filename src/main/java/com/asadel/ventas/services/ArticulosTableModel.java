package com.asadel.ventas.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.annotation.PostConstruct;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ArticulosTableModel extends AbstractTableModel
{

    @Autowired
    private Control control;

    private Connection conexion;
    private Statement instruccion;
    private ResultSet result;
    private ResultSetMetaData metaData;
    private int numFilas;
    private boolean estado = false;

    public ArticulosTableModel()
    {
    }

    public void init(String consulta) throws SQLException
    {
        conexion = control.getConnectionControl();
        instruccion = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        estado = true;
        Consulta(consulta);
    }

    @Override
    public Class getColumnClass(int columna) throws IllegalStateException
    {
        if (!estado)
        {
            throw new IllegalStateException("No hay conexion a la Base de Datos");
        }

        try
        {
            String nameClase = metaData.getColumnClassName(columna + 1);

            return Class.forName(nameClase);
        }
        catch (SQLException | ClassNotFoundException ex)
        {
        }

        return Object.class;
    }

    @Override
    public int getColumnCount() throws IllegalStateException
    {
        if (!estado)
        {
            throw new IllegalStateException("No hay conexion a la Base de Datos");
        }

        try
        {
            return metaData.getColumnCount();
        }
        catch (SQLException sqlex)
        {
        }

        return 0;
    }

    @Override
    public String getColumnName(int columna) throws IllegalStateException
    {
        if (!estado)
        {
            throw new IllegalStateException("No hay conexion a la Base de Datos");
        }

        try
        {
            if (columna == 0)
            {
                return "ID";
            }
            else
            {
                return metaData.getColumnName(columna + 1);
            }
        }
        catch (SQLException sqlex)
        {
        }

        return "";
    }

    @Override
    public int getRowCount() throws IllegalStateException
    {
        if (!estado)
        {
            throw new IllegalStateException("No hay conexion a la Base de Datos");
        }

        return numFilas;
    }

    @Override
    public Object getValueAt(int fila, int columna) throws IllegalStateException
    {
        if (!estado)
        {
            throw new IllegalStateException("No hay conexion a la Base de Datos");
        }

        try
        {
            result.absolute(fila + 1);

            return result.getObject(columna + 1);
        }
        catch (SQLException sqlex)
        {
        }

        return "";
    }

    public void removeValueAt(int rowIndex)
    {
        try
        {
            result.absolute(rowIndex + 1);
            result.deleteRow();
        }
        catch (SQLException sqlex)
        {
        }

        fireTableStructureChanged();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        switch (getColumnName(columnIndex))
        {
            case "Cantidad":
            case "Porcentaje":
            case "Activar":
                return true;
            default:
                return false;
        }
    }

    public void Consulta(String consulta) throws SQLException, IllegalStateException
    {
        if (!estado)
        {
            throw new IllegalStateException("No hay conexion a la Base de Datos");
        }

        if (consulta.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "No se ha realizado ninguna consulta", "Error en la Consulta ", 2);
        }
        else
        {
            result = instruccion.executeQuery(consulta);
            metaData = result.getMetaData();
            result.last();
            numFilas = result.getRow();
        }
    }

    public void closeBD()
    {
        if (estado)
        {
            try
            {
                result.close();
                instruccion.close();
                conexion.close();
                System.gc();
            }
            catch (SQLException sqlex)
            {
                JOptionPane.showMessageDialog(null, "No se cerro la conexion con la base de datos", "Error al Salir de la aplicacion ", 2);
            }
            finally
            {
                estado = false;
            }
        }
    }
}
