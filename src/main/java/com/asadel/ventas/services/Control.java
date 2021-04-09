package com.asadel.ventas.services;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.swing.JOptionPane;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class Control {

    private final Conexion conexionFactory;
    //**************************************************************************
    //*
    //*
    //                      CONSTANTES PARA LAS CONSULTAS

    public final static String SELECTARTICULOS = "SELECT idArticulo, Nombre, preciosArt.Precio, Info, Tipo from Articulos "
            + "JOIN preciosArt ON "
            + "Articulos.idArticulo = preciosArt.idPreciosArt ";
    public final static String SELECTBIOGRAFIAS = "SELECT idBiografia, Nombre, preciosVar.Precio, Info, Tipo from Biografias "
            + "JOIN preciosVar ON "
            + "Biografias.Tipo = preciosVar.idPreciosVar ";
    public final static String SELECTESQUEMAS = "SELECT idEsquema, Nombre, preciosVar.Precio, Info, Tipo from Esquemas "
            + "JOIN preciosVar ON "
            + "Esquemas.Tipo = preciosVar.idPreciosVar ";
    public final static String SELECTMAPAS = "SELECT idMapa, Nombre, preciosVar.Precio, Info, Tipo from Mapas "
            + "JOIN preciosVar ON "
            + "Mapas.Tipo = preciosVar.idPreciosVar ";
    public final static String SELECTMONOGRAFIAS = "SELECT idMonografia, Nombre, preciosVar.Precio, Info, Tipo from Monografias "
            + "JOIN preciosVar ON "
            + "Monografias.Tipo = preciosVar.idPreciosVar ";
    public final static String SELECTRELIEVES = "SELECT idRelieve, Nombre, preciosVar.Precio, Info, Tipo from Relieves "
            + "JOIN preciosVar ON "
            + "Relieves.Tipo = preciosVar.idPreciosVar ";
    public final static String SELECTLISTA = "SELECT idArticuloLista AS ID, Nombre, Cantidad, Precio, Subtotal "
            + "FROM articuloLista JOIN Lista ON "
            + "articuloLista.Lista_idLista = Lista.idLista "
            + "WHERE Lista.Estado = 1 "
            + "ORDER BY articuloLista.idVenta ";
    public final static String SELECTDESCUENTO = "SELECT idArticulo AS Id, Nombre, p.Precio, p.Descuento, "
            + "ROUND(100 - (100 * (p.Descuento/p.Precio))) AS Porcentaje, "
            + "(p.Precio != p.Descuento) as Activar "
            + "FROM Articulos a INNER JOIN PreciosArt p ON "
            + "a.idArticulo = p.idPreciosArt ";

    public final static String SELECTALLARTICULOS = SELECTARTICULOS
            + "UNION "
            + SELECTMONOGRAFIAS
            + "UNION "
            + SELECTBIOGRAFIAS
            + "UNION "
            + SELECTRELIEVES
            + "UNION "
            + SELECTMAPAS
            + "UNION "
            + SELECTESQUEMAS;
    //*
    //*
    //*
    //**************************************************************************

    private Connection conexion;
    private PreparedStatement ps;
    private Statement statement;
    private ResultSet rs;

    @PostConstruct
    public void init() {
        try {
            conexion = conexionFactory.getConnection();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error 3\n" + e.getMessage(), "Error de Conexion", 2);
        }
        

        log.info("Base de datos iniciada: {}", conexion != null);
    }

    public Connection getConnectionControl() {
        return conexion;
    }

    public void closeControl() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se Cerro la Conexion en la BD \nError BD" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void insertPrecioArt(Articulo a) {
        String insert = null;

        try {
            if (!a.getId().isEmpty()) {
                insert = "INSERT INTO preciosArt VALUES(?,?,?)";
                ps = conexion.prepareStatement(insert);
                ps.setString(1, a.getId());
                ps.setBigDecimal(2, a.getPrecio());
                ps.setBigDecimal(3, a.getDescuento());
            } else {
                insert = "INSERT INTO preciosArt (Precio, Descuento) VALUES(?,?)";
                ps = conexion.prepareStatement(insert);
                ps.setBigDecimal(1, a.getPrecio());
                ps.setBigDecimal(2, a.getDescuento());
            }

            ps.executeUpdate();
            ps.close();
            insertArticulo(a);
        } catch (SQLException e) {
            changeID(a.getId());
            updateID(a);
        }
//        catch (SQLException ex)
//        {
//            JOptionPane.showMessageDialog(null, "No se agrego el precioArt \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//        }
    }

    public void insertArticulo(Articulo a) {
        try {
            String insert = "INSERT INTO Articulos VALUES(?,?,?,?)";
            String select = "SELECT idPreciosArt FROM PreciosArt ORDER BY idPreciosArt DESC LIMIT 1 ";
            statement = conexion.createStatement();
            rs = statement.executeQuery(select);

            if (rs.next()) {
                int id = rs.getInt("idPreciosArt");

                if (!a.getId().isEmpty()) {
                    id = Integer.parseInt(a.getId());
                }

                ps = conexion.prepareStatement(insert);
                ps.setInt(1, id);
                ps.setString(2, a.getNombre());
                ps.setString(3, a.getInfo());
                ps.setString(4, a.getTipo());
                ps.executeUpdate();
                statement.close();
                ps.close();
            }

            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se agrego el Articulo \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void changeID(String id) {
        try {
            String select = "SELECT * FROM articulos a "
                    + "JOIN preciosArt p "
                    + "ON a.idArticulo = p.idPreciosArt "
                    + "WHERE idArticulo = ?";

            ps = conexion.prepareStatement(select);
            ps.setString(1, id);
            rs = ps.executeQuery();
            rs.next();

            Articulo a = new Articulo("", rs.getString("Nombre"),
                    rs.getString("Info"), rs.getString("Tipo"), rs.getBigDecimal("Precio"),
                    rs.getBigDecimal("Descuento"));
            insertPrecioArt(a);
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se realizo el cambio de ID\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateID(Articulo a) {
        try {
            String update = "UPDATE preciosArt SET Precio=?, Descuento=? "
                    + "WHERE idPreciosArt = ?";

            ps = conexion.prepareStatement(update);
            ps.setBigDecimal(1, a.getPrecio());
            ps.setBigDecimal(2, a.getDescuento());
            ps.setString(3, a.getId());
            ps.executeUpdate();

            update = "UPDATE articulos SET Nombre=?, Info=?, Tipo=? "
                    + "WHERE idArticulo = ? ";
            ps = conexion.prepareStatement(update);
            ps.setString(1, a.getNombre());
            ps.setString(2, a.getInfo());
            ps.setString(3, a.getTipo());
            ps.setString(4, a.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se realizo la actualización de ID\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void insertMonografia(Articulo articulo) {
        try {
            String insert = "INSERT INTO Monografias VALUES(?,?,?,?,?)";

            ps = conexion.prepareStatement(insert);
            ps.setString(1, articulo.getId());
            ps.setString(2, articulo.getNombre());
            ps.setString(3, articulo.getInfo());
            ps.setString(4, articulo.getTipo());
            ps.setString(5, articulo.getTipo());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se agregro la Monografia \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void insertBiografia(Articulo articulo) {
        try {
            String insert = "INSERT INTO Biografias VALUES(?,?,?,?,?)";

            ps = conexion.prepareStatement(insert);
            ps.setString(1, articulo.getId());
            ps.setString(2, articulo.getNombre());
            ps.setString(3, articulo.getInfo());
            ps.setString(4, articulo.getTipo());
            ps.setString(5, articulo.getTipo());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se agrego la Biografia \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void insertRelieve(Articulo articulo) {
        try {
            String insert = "INSERT INTO Relieves VALUES(?,?,?,?,?)";

            ps = conexion.prepareStatement(insert);
            ps.setString(1, articulo.getId());
            ps.setString(2, articulo.getNombre());
            ps.setString(3, articulo.getInfo());
            ps.setString(4, articulo.getTipo());
            ps.setString(5, articulo.getTipo());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se agrego el Relieve \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void insertMapa(Articulo articulo) {
        try {
            String insert = "INSERT INTO Mapas VALUES(?,?,?,?,?)";

            ps = conexion.prepareStatement(insert);
            ps.setString(1, articulo.getId());
            ps.setString(2, articulo.getNombre());
            ps.setString(3, articulo.getInfo());
            ps.setString(4, articulo.getTipo());
            ps.setString(5, articulo.getTipo());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se agrego el Mapa \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void insertEsquema(Articulo articulo) {
        try {
            String insert = "INSERT INTO Esquemas VALUES(?,?,?,?,?)";

            ps = conexion.prepareStatement(insert);
            ps.setString(1, articulo.getId());
            ps.setString(2, articulo.getNombre());
            ps.setString(3, articulo.getInfo());
            ps.setString(4, articulo.getTipo());
            ps.setString(5, articulo.getTipo());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se agrego el Esquema \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updatePrecioArt(Articulo oldArticulo, Articulo newArticulo) {
        try {
            String update = "UPDATE preciosArt SET idPreciosArt=?, Precio=?, Descuento=? "
                    + "WHERE idPreciosArt = ?";

            ps = conexion.prepareStatement(update);
            ps.setString(1, newArticulo.getId());
            ps.setBigDecimal(2, newArticulo.getPrecio());
            ps.setBigDecimal(3, newArticulo.getDescuento());
            ps.setString(4, oldArticulo.getId());
            ps.executeUpdate();
            ps.close();
            updateArticulo(newArticulo);
        } catch (SQLException e) {
            changeID(newArticulo.getId());
            deletePrecioArt(oldArticulo);
            deleteArticulo(newArticulo);
            deletePrecioArt(newArticulo);
            insertPrecioArt(newArticulo);
        }
//        catch (SQLException ex)
//        {
//            ex.printStackTrace();
//            JOptionPane.showMessageDialog(null, "No se actualizo el precioArt \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//        }
    }

    public void updateArticulo(Articulo newArticulo) {
        try {
            String insert = "INSERT INTO Articulos VALUES(?, ?, ?, ?)";

            ps = conexion.prepareStatement(insert);
            ps.setString(1, newArticulo.getId());
            ps.setString(2, newArticulo.getNombre());
            ps.setString(3, newArticulo.getInfo());
            ps.setString(4, newArticulo.getTipo());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se actualizo el Articulo \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updatePrecioVar(String tipo, BigDecimal precio) {
        try {
            String update = "UPDATE preciosVar SET idPreciosVar=?, Precio=? "
                    + "WHERE idPreciosVar = '" + tipo + "'";

            ps = conexion.prepareStatement(update);
            ps.setString(1, tipo);
            ps.setBigDecimal(2, precio);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se actualizo el precioVar \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateBiografia(Articulo oldArticulo, Articulo newArticulo) {
        try {
            String update = "UPDATE Biografias SET idBiografia=?, Nombre=?, Info=?, Tipo=?, PreciosVar_idPreciosVar=? "
                    + "WHERE idBiografia = '" + oldArticulo.getId() + "'";

            ps = conexion.prepareStatement(update);
            ps.setString(1, newArticulo.getId());
            ps.setString(2, newArticulo.getNombre());
            ps.setString(3, newArticulo.getInfo());
            ps.setString(4, newArticulo.getTipo());
            ps.setString(5, newArticulo.getTipo());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se actualizo la Biografia \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateEsquema(Articulo oldArticulo, Articulo newArticulo) {
        try {
            String update = "UPDATE Esquemas SET idEsquema=?, Nombre=?, Info=?, Tipo=?, PreciosVar_idPreciosVar=? "
                    + "WHERE idEsquema = '" + oldArticulo.getId() + "'";

            ps = conexion.prepareStatement(update);
            ps.setString(1, newArticulo.getId());
            ps.setString(2, newArticulo.getNombre());
            ps.setString(3, newArticulo.getInfo());
            ps.setString(4, newArticulo.getTipo());
            ps.setString(5, newArticulo.getTipo());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se actualizo el Esquema \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateMapa(Articulo oldArticulo, Articulo newArticulo) {
        try {
            String update = "UPDATE Mapas SET idMapa=?, Nombre=?, Info=?, Tipo=?, PreciosVar_idPreciosVar=? "
                    + "WHERE idMapa='" + oldArticulo.getId() + "'";

            ps = conexion.prepareStatement(update);
            ps.setString(1, newArticulo.getId());
            ps.setString(2, newArticulo.getNombre());
            ps.setString(3, newArticulo.getInfo());
            ps.setString(4, newArticulo.getTipo());
            ps.setString(5, newArticulo.getTipo());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se actualizo el Mapa \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateMonografia(Articulo oldArticulo, Articulo newArticulo) {
        try {
            String update = "UPDATE Monografias SET idMonografia=?, Nombre=?, Info=?, Tipo=?, PreciosVar_idPreciosVar=? "
                    + "WHERE idMonografia= '" + oldArticulo.getId() + "'";

            ps = conexion.prepareStatement(update);
            ps.setString(1, newArticulo.getId());
            ps.setString(2, newArticulo.getNombre());
            ps.setString(3, newArticulo.getInfo());
            ps.setString(4, newArticulo.getTipo());
            ps.setString(5, newArticulo.getTipo());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se actualizo la Monografia \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateRelieve(Articulo oldArticulo, Articulo newArticulo) {
        try {
            String update = "UPDATE Relieves SET idRelieve=?, Nombre=?, Info=?, Tipo=?, PreciosVar_idPreciosVar=? "
                    + "WHERE idRelieve = '" + oldArticulo.getId() + "'";

            ps = conexion.prepareStatement(update);
            ps.setString(1, newArticulo.getId());
            ps.setString(2, newArticulo.getNombre());
            ps.setString(3, newArticulo.getInfo());
            ps.setString(4, newArticulo.getTipo());
            ps.setString(5, newArticulo.getTipo());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se actualizo el Relieve \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deletePrecioArt(Articulo articulo) {
        try {
            String delete = "DELETE FROM preciosArt WHERE idPreciosArt = '" + articulo.getId() + "'";

            ps = conexion.prepareStatement(delete);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede borrar el precioArt\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteArticulo(Articulo articulo) {
        try {
            String delete = "DELETE FROM Articulos WHERE idArticulo = '" + articulo.getId() + "'";

            ps = conexion.prepareStatement(delete);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede borrar el Articulo \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteBiografia(Articulo articulo) {
        try {
            String delete = "DELETE FROM Biografias WHERE idBiografia = '" + articulo.getId() + "'";

            ps = conexion.prepareStatement(delete);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede borrar la Biografia \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteEsquema(Articulo articulo) {
        try {
            String delete = "DELETE FROM Esquemas WHERE idEsquema = '" + articulo.getId() + "'";

            ps = conexion.prepareStatement(delete);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede borrar el Esquema \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteMapa(Articulo articulo) {
        try {
            String delete = "DELETE FROM Mapas WHERE idMapa = '" + articulo.getId() + "'";

            ps = conexion.prepareStatement(delete);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede borrar el Mapa \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteMonografia(Articulo articulo) {
        try {
            String delete = "DELETE FROM Monografias WHERE idMonografia = '" + articulo.getId() + "'";

            ps = conexion.prepareStatement(delete);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede borrar la Monografia \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteRelieve(Articulo articulo) {
        try {
            String delete = "DELETE FROM Relieves WHERE idRelieve = '" + articulo.getId() + "'";

            ps = conexion.prepareStatement(delete);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede borrar el Relieve \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void openCajaMes() {
        try {
            String insert = "INSERT INTO CajaMes (Estado, FecInicio, Total) VALUES(?, ?, ?)";

            Calendar c = Calendar.getInstance(Locale.getDefault());
            SimpleDateFormat date = new SimpleDateFormat("yy.MM.dd");
            String fecha = date.format(c.getTime());

            ps = conexion.prepareStatement(insert);
            ps.setBoolean(1, true);
            ps.setString(2, fecha);
            ps.setBigDecimal(3, BigDecimal.ZERO);
            ps.executeUpdate();
            ps.close();

            JOptionPane.showMessageDialog(null, "Se ABRIO una nueva Caja Mensual", "Caja", 1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede ABRIR una CajaMes \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void closeCajaMes() {
        try {
            String select = "SELECT idCajaMes FROM CajaMes "
                    + "WHERE Estado = '1' ";

            statement = conexion.createStatement();
            rs = statement.executeQuery(select);
            int id = 0;

            if (rs.next()) {
                id = rs.getInt("idCajaMes");
            } else {
                statement.close();
                rs.close();
                return;
            }

            select = "SELECT MONTH(fecInicio) from CajaMes AS Mes "
                    + "WHERE idCajaMes = '" + id + "'";
            rs = statement.executeQuery(select);
            int mes = 0;

            if (rs.next()) {
                mes = rs.getInt(1);
            }

            select = "SELECT MONTH(now()) = '" + mes + "' AS Estado ";
            rs = statement.executeQuery(select);

            if (rs.next()) {
                boolean estado = rs.getBoolean(1);

                if (!estado) {
                    Calendar c = Calendar.getInstance(Locale.getDefault());
                    SimpleDateFormat date = new SimpleDateFormat("yy.MM.dd");
                    String fecha = date.format(c.getTime());

                    String update = "UPDATE CajaMes SET Estado=?, FecFin=? "
                            + "WHERE idCajaMes = '" + id + "'";

                    ps = conexion.prepareStatement(update);
                    ps.setBoolean(1, false);
                    ps.setString(2, fecha);
                    ps.executeUpdate();
                    ps.close();
                }
            }

            statement.close();
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se puede CERRAR la CajaMes \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void openCajaDia(Caja caja) {
        try {
            String insert = "INSERT INTO CajaDia VALUES(?, ?, ?, ?, ?, ?, ?)";
            String select = "SELECT idCajaDia FROM CajaDia ORDER BY idCajaDia DESC LIMIT 1 ";

            statement = conexion.createStatement();
            rs = statement.executeQuery(select);

            int idCajaDia = 1;

            if (rs.next()) {
                idCajaDia = rs.getInt("idCajaDia") + 1;
            }

            select = "SELECT idCajaMes FROM CajaMes "
                    + "WHERE Estado = '1' ORDER BY idCajaMes DESC LIMIT 1 ";
            rs = statement.executeQuery(select);

            int idCajaMes = 1;

            if (rs.next()) {
                idCajaMes = rs.getInt("idCajaMes");
            } else {
                openCajaMes();
                select = "SELECT idCajaMes FROM CajaMes "
                        + "WHERE Estado = '1'  ORDER BY idCajaMes DESC LIMIT 1 ";
                rs = statement.executeQuery(select);

                if (rs.next()) {
                    idCajaMes = rs.getInt("idCajaMes");
                }
            }

            ps = conexion.prepareStatement(insert);
            ps.setInt(1, idCajaDia);
            ps.setBoolean(2, caja.getEstado());
            ps.setString(3, caja.getAbierta());
            ps.setString(4, caja.getCierre());
            ps.setBigDecimal(5, caja.getInicio());
            ps.setBigDecimal(6, caja.getRecaudado());
            ps.setInt(7, idCajaMes);
            ps.executeUpdate();
            statement.close();
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede ABRIR la CajaDia \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void closeCajaDia(Caja caja) {
        try {
            String select = "SELECT idCajaDia FROM CajaDia "
                    + "WHERE Estado = '1'";

            statement = conexion.createStatement();
            rs = statement.executeQuery(select);

            int id = 0;

            if (rs.next()) {
                id = rs.getInt("idCajaDia");

                String update = "UPDATE CajaDia SET Estado=?, Cierre=?, Recaudado=? "
                        + "WHERE idCajaDia = '" + id + "'";

                ps = conexion.prepareStatement(update);
                ps.setBoolean(1, caja.getEstado());
                ps.setString(2, caja.getCierre());
                ps.setBigDecimal(3, caja.getRecaudado());
                ps.executeUpdate();
            }

            select = "SELECT idCajaMes FROM CajaMes ORDER BY idCajaMes DESC LIMIT 1 ";

            statement = conexion.createStatement();
            rs = statement.executeQuery(select);

            if (rs.next()) {
                id = rs.getInt("idCajaMes");

                BigDecimal totalDia = getTotalCajaMes(id);
                String update = "UPDATE CajaMes SET Total=? "
                        + "WHERE idCajaMes = '" + id + "'";

                ps = conexion.prepareStatement(update);
                ps.setBigDecimal(1, totalDia);
                ps.executeUpdate();
            }

            statement.close();
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede CERRAR la CajaDia \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public BigDecimal getRecaudadoCajaDia() {
        BigDecimal total = BigDecimal.ZERO.setScale(2);

        try {
            String select = "SELECT Recaudado FROM CajaDia ORDER BY idCajaDia DESC LIMIT 1 ";

            statement = conexion.createStatement();
            rs = statement.executeQuery(select);

            if (rs.next()) {
                total = rs.getBigDecimal("Recaudado");
            } else {
                statement.close();
                rs.close();
                System.out.println("Error SELECT Recaudado FROM cajaDia");

                return total;
            }

            statement.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se encontro el valor Recaudado\n de la CajaDia \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return total;
    }

    public boolean getEstadoCajaDia() {
        boolean estado = false;

        try {
            String select = "SELECT idCajaDia FROM CajaDia ORDER BY idCajaDia  DESC LIMIT 1 ";

            statement = conexion.createStatement();
            rs = statement.executeQuery(select);

            int id = 0;
            if (rs.next()) {
                id = rs.getInt("idCajaDia");
            } else {
                statement.close();
                rs.close();
                return estado;
            }

            select = "SELECT Estado FROM CajaDia "
                    + "WHERE idCajaDia = '" + id + "'";

            rs = statement.executeQuery(select);

            if (rs.next()) {
                estado = rs.getBoolean("Estado");
            }

            statement.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se encontro el Estado de la CajaDia \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return estado;
    }

    public void setEstadoCaja(int id, boolean estado) {
        try {
            String update = "UPDATE CajaDia SET Estado=?  "
                    + "WHERE idCajaDia = '" + id + "'";

            ps = conexion.prepareStatement(update);
            ps.setBoolean(1, estado);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede actualizar el Estado de la CajaDia \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public BigDecimal getTotalFactura(String id) {
        BigDecimal total = null;

        try {
            String select = "SELECT SUM(Subtotal) AS Total FROM articuloVendido av "
                    + "JOIN Lista l "
                    + "ON av.Lista_idLista = l.idLista "
                    + "WHERE l.idLista = ?";

            ps = conexion.prepareStatement(select);
            ps.setString(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                total = rs.getBigDecimal("Total");

                if (total == null) {
                    total = BigDecimal.ZERO.setScale(2);
                }
            }

            ps.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede conseguir el Total de la Venta \n" + ex.getMessage(), "Error", 2);
        }

        return total;
    }

    public BigDecimal getTotalVenta() {
        BigDecimal total = BigDecimal.ZERO;

        try {
            String select = "SELECT SUM(Subtotal) AS Total FROM articuloLista "
                    + "JOIN Lista ON "
                    + "articuloLista.Lista_idLista = Lista.idLista "
                    + "WHERE Lista.Estado = '1'";

            statement = conexion.createStatement();
            rs = statement.executeQuery(select);

            if (rs.next()) {
                total = rs.getBigDecimal("Total");
                total = total == null ? BigDecimal.ZERO : total;

            } else {
                total = BigDecimal.ZERO.setScale(2);
            }

            statement.close();
            rs.close();
        } catch (SQLException ex) {
            total = BigDecimal.ZERO;
            JOptionPane.showMessageDialog(null, "No se puede conseguir el Total de la Venta \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        log.trace("TotalVenta: {}", total);

        return total.setScale(2);
    }

    public BigDecimal getTotalLista() {
        BigDecimal total = null;

        try {
            String select = "SELECT SUM(Total) AS Total FROM Lista "
                    + "JOIN CajaDia ON "
                    + "Lista.CajaDia_idCajaDia = CajaDia.idCajaDia "
                    + "WHERE CajaDia.Estado = '1' ";

            statement = conexion.createStatement();
            rs = statement.executeQuery(select);

            if (rs.next()) {
                total = rs.getBigDecimal("Total");

                if (total == null) {
                    total = BigDecimal.ZERO.setScale(2);
                }
            }

            statement.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede conseguir el Total de la Listas \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return total;
    }

    public BigDecimal getTotalCajaMes(int id) {
        BigDecimal total = null;

        try {
            String select = "SELECT SUM(Recaudado) AS Total FROM CajaDia "
                    + "JOIN CajaMes ON "
                    + "CajaDia.CajaMes_idCajaMes = CajaMes.idCajaMes "
                    + "WHERE CajaMes.idCajaMes = ? ";

            ps = conexion.prepareStatement(select);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                total = rs.getBigDecimal("Total");

                if (total == null) {
                    total = BigDecimal.ZERO.setScale(2);
                }
            }

            ps.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede conseguir el Total de la CajaDia \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return total;
    }

    public int getIdLista() {
        int id = 0;

        try {
            String select = "SELECT idLista FROM Lista "
                    + "WHERE Estado = '1' ";

            statement = conexion.createStatement();
            rs = statement.executeQuery(select);

            if (rs.next()) {
                id = rs.getInt("idLista");
            }

            statement.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede conseguir el ID de la Lista \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return id;
    }

    public void insertArticuloLista(Articulo articulo) {
        try {
            String select = "SELECT idLista FROM Lista "
                    + "WHERE Estado = '1'";

            statement = conexion.createStatement();
            rs = statement.executeQuery(select);

            int id;

            if (rs.next()) {
                id = rs.getInt("idLista");
            } else {
                statement.close();
                rs.close();
                JOptionPane.showMessageDialog(null, "Lista Cerrada", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String insert = "INSERT INTO articuloLista (idarticuloLista, Nombre, Cantidad, Precio, Subtotal, Lista_idLista) "
                    + "VALUES(?,?,?,?,?,?)";

            ps = conexion.prepareStatement(insert);
            ps.setString(1, articulo.getId());
            ps.setString(2, articulo.getNombre());
            ps.setInt(3, articulo.getCantidad());
            ps.setBigDecimal(4, articulo.getPrecio());
            ps.setBigDecimal(5, articulo.getSubtotal());
            ps.setInt(6, id);
            ps.executeUpdate();

            insert = "INSERT INTO articuloVendido (idArticulo, Estado, Nombre, Info, Cantidad, Precio, Subtotal, lista_idLista) "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

            ps = conexion.prepareStatement(insert);
            ps.setString(1, articulo.getId());
            ps.setBoolean(2, true);
            ps.setString(3, articulo.getNombre());
            ps.setString(4, articulo.getInfo());
            ps.setInt(5, articulo.getCantidad());
            ps.setBigDecimal(6, articulo.getPrecio());
            ps.setBigDecimal(7, articulo.getSubtotal());
            ps.setInt(8, getIdLista());
            ps.executeUpdate();
            statement.close();
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            updateArticuloLista(articulo, 1);
//            if (ex instanceof MySQLIntegrityConstraintViolationException)
//            {
//                updateArticuloLista(articulo, 1);
//            }
//            else
//            {
//                JOptionPane.showMessageDialog(null, "No se agrego el Articulo a la Lista de Ventas \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//            }
        }
    }

    public boolean updateArticuloLista(Articulo articulo, int opc) {
        boolean estado = false;

        try {
            String select = "SELECT Cantidad FROM articuloLista "
                    + "WHERE idArticuloLista = '" + articulo.getId() + "'";

            statement = conexion.createStatement();
            rs = statement.executeQuery(select);
            int cantidad = 0;

            if (rs.next()) {
                if (opc == 1) {
                    cantidad = rs.getInt("Cantidad") + 1;
                } else if (opc == 2) {
                    cantidad = articulo.getCantidad();
                } else {
                    cantidad = rs.getInt("Cantidad") - 1;

                    if (cantidad == 0) {
                        deleteArticuloLista(articulo);
                        estado = true;
                    }
                }

                articulo.setSubtotal(cantidad);
            }

            String update = "UPDATE articuloLista SET Cantidad=?, Subtotal=? "
                    + "WHERE idArticuloLista = '" + articulo.getId() + "'";

            ps = conexion.prepareStatement(update);
            ps.setInt(1, cantidad);
            ps.setBigDecimal(2, articulo.getSubtotal());
            ps.executeUpdate();

            update = "UPDATE articuloVendido SET Cantidad=?, Subtotal=? "
                    + "WHERE Estado = 1 "
                    + "AND idArticulo = '" + articulo.getId() + "' ";

            ps = conexion.prepareStatement(update);
            ps.setInt(1, cantidad);
            ps.setBigDecimal(2, articulo.getSubtotal());
            ps.executeUpdate();
            statement.close();
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo actualizar el Articulo de la Lista de Ventas \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return estado;
    }

    public void deleteArticuloLista(Articulo articulo) {
        try {
            String delete = "DELETE FROM articuloLista "
                    + "WHERE idArticuloLista = '" + articulo.getId() + "'";

            ps = conexion.prepareStatement(delete);
            ps.executeUpdate();

            delete = "DELETE FROM articuloVendido "
                    + "WHERE Estado = 1 "
                    + "AND idArticulo = '" + articulo.getId() + "' ";

            ps = conexion.prepareStatement(delete);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede borrar el Articulo de la Lista de Ventas \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void clearArticulosLista() {
        try {
            String delete = "DELETE articuloVendido FROM articuloVendido "
                    + "JOIN Lista ON "
                    + "articuloVendido.Lista_idLista = Lista.idLista "
                    + "WHERE Lista.Estado = '1' ";

            ps = conexion.prepareStatement(delete);
            ps.executeUpdate();

            delete = "TRUNCATE TABLE articuloLista ";

            ps = conexion.prepareStatement(delete);
            ps.executeUpdate();

            String select = "SELECT idLista FROM Lista "
                    + "WHERE Estado = '1' ";

            ps = conexion.prepareStatement(select);
            rs = ps.executeQuery();
            int id = 0;

            if (rs.next()) {
                id = rs.getInt("idLista");
            } else {
                ps.close();

                return;
            }

            delete = "DELETE FROM Lista WHERE idLista = ? ";
            ps = conexion.prepareStatement(delete);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pueden borrar los Articulos de la Lista de Ventas  \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public BigDecimal getPreciosVar(String tipo) {
        BigDecimal precio = null;

        try {
            String select = "SELECT Precio FROM PreciosVar "
                    + "WHERE idPreciosVar = '" + tipo + "'";

            statement = conexion.createStatement();
            rs = statement.executeQuery(select);

            if (rs.next()) {
                precio = rs.getBigDecimal("Precio");
            }

            statement.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se encontro el precioVar del Articulo \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return precio;
    }

    public void setPrecioVar(String tipo, BigDecimal precio) {
        try {
            String update = "UPDATE PreciosVar SET Precio=?  "
                    + "WHERE idPreciosVar = '" + tipo + "'";

            ps = conexion.prepareStatement(update);
            ps.setBigDecimal(1, precio);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se actualizo el precioVar del Articulo \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public BigDecimal getPrecioDescuento(String id) {
        BigDecimal precio = null;

        try {
            String select = "SELECT Descuento FROM PreciosArt "
                    + "WHERE idPreciosArt = '" + id + "'";

            statement = conexion.createStatement();
            rs = statement.executeQuery(select);

            if (rs.next()) {
                precio = rs.getBigDecimal("Descuento");
            }

            statement.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se encontro el descuento del Articulo \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return precio;
    }

    public void setDescuentoGlobal(int porcentaje) {
        try {
            String update = "UPDATE Descuento SET Porcentaje=? "
                    + "WHERE idDescuento = '1'";

            ps = conexion.prepareStatement(update);
            ps.setInt(1, porcentaje);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se actualizo el Descuento Global \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public BigDecimal getDescuentoGlobal() {
        BigDecimal descuento = null;

        try {
            String select = "SELECT Porcentaje FROM Descuento ";

            statement = conexion.createStatement();
            rs = statement.executeQuery(select);

            if (rs.next()) {
                descuento = rs.getBigDecimal("Porcentaje");
                descuento = new BigDecimal("100.00").subtract(descuento);
            }

            statement.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se encuentra el Descuento Global \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return descuento.setScale(0);
    }

    public void setDescuentoArticulo(String id, boolean custom, int porciento) {
        try {
            String update = "UPDATE preciosArt SET Descuento = preciosArt.Precio - (((SELECT Porcentaje FROM Descuento) / 100) * preciosArt.Precio) "
                    + "WHERE idPreciosArt = '" + id + "'";

            if (custom) {
                update = "UPDATE preciosArt SET Descuento = preciosArt.Precio - ((" + porciento + "/ 100) * preciosArt.Precio) "
                        + "WHERE idPreciosArt = '" + id + "'";
            }

            ps = conexion.prepareStatement(update);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se Actualizo el Descuento del Articulo\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void removeDescuentoArticulo(String id) {
        try {
            String update = "UPDATE preciosArt SET Descuento = ? "
                    + "WHERE idPreciosArt = '" + id + "'";

            String select = "SELECT Precio FROM preciosArt "
                    + "WHERE idPreciosArt = '" + id + "'";

            statement = conexion.createStatement();
            rs = statement.executeQuery(select);

            if (rs.next()) {
                BigDecimal precio = rs.getBigDecimal("Precio");

                ps = conexion.prepareStatement(update);
                ps.setBigDecimal(1, precio);
                ps.executeUpdate();
            }

            statement.close();
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se removio el Descuento del Articulo \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setPrecioDescuentoLista() {
        try {
            String update = "UPDATE articuloLista JOIN preciosArt "
                    + "ON articuloLista.idArticuloLista = preciosArt.idPreciosArt "
                    + "SET articuloLista.Precio = preciosArt.Descuento, "
                    + "articuloLista.Subtotal = preciosArt.Descuento * articuloLista.Cantidad";

            ps = conexion.prepareStatement(update);
            ps.executeUpdate();

            update = "UPDATE articuloVendido av JOIN preciosArt pa "
                    + "ON av.idArticulo = pa.idPreciosArt "
                    + "SET av.Precio = pa.Descuento, "
                    + "av.Subtotal = pa.Descuento * av.Cantidad "
                    + "WHERE Estado = 1 ";

            ps = conexion.prepareStatement(update);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pueden establecer los \nDescuentos de los Articulos \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setPrecioLista() {
        try {
            String update = "UPDATE articuloLista JOIN preciosArt "
                    + "ON articuloLista.idArticuloLista = preciosArt.idPreciosArt "
                    + "SET articuloLista.Precio = preciosArt.Precio, "
                    + "articuloLista.Subtotal = preciosArt.Precio * articuloLista.Cantidad";

            ps = conexion.prepareStatement(update);
            ps.executeUpdate();

            update = "UPDATE articuloVendido av JOIN preciosArt pa "
                    + "ON av.idArticulo = pa.idPreciosArt "
                    + "SET av.Precio = pa.Precio, "
                    + "av.Subtotal = pa.Precio * av.Cantidad "
                    + "WHERE av.Estado = 1 ";

            ps = conexion.prepareStatement(update);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede establecer los \nPrecios de los Articulos \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateDescuentosGlobalArt() {
        try {
            String update = "UPDATE Papeleria.preciosArt "
                    + "JOIN Articulos "
                    + "ON Articulos.idArticulo = preciosArt.idPreciosArt "
                    + "SET Descuento = preciosArt.Precio - (((SELECT Porcentaje FROM Descuento) / 100) * preciosArt.Precio) "
                    + "WHERE Articulos.Tipo = 'Papeleria'";

            ps = conexion.prepareStatement(update);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se actualizaron los\nDescuentos de los Articulos \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void openLista() {
        int id = 1;

        try {
            String select = "SELECT idLista FROM Lista ORDER BY idLista DESC LIMIT 1 ";

            statement = conexion.createStatement();
            rs = statement.executeQuery(select);

            if (rs.next()) {
                id = rs.getInt("idLista") + 1;
            }

            select = "SELECT idCajaDia FROM CajaDia "
                    + "WHERE Estado = '1'";
            rs = statement.executeQuery(select);

            int cajaid = 1;

            if (rs.next()) {
                cajaid = rs.getInt("idCajaDia");
            }

            Calendar c = Calendar.getInstance(Locale.getDefault());
            SimpleDateFormat date = new SimpleDateFormat("yy.MM.dd");
            String fecha = date.format(c.getTime());

            String insert = "INSERT INTO Lista VALUES(?, ?, ?, ?, ?, ?)";

            ps = conexion.prepareStatement(insert);
            ps.setInt(1, id);
            ps.setString(2, fecha);
            ps.setNull(3, Types.NULL);
            ps.setBigDecimal(4, BigDecimal.ZERO);
            ps.setBoolean(5, true);
            ps.setInt(6, cajaid);
            ps.executeUpdate();
            statement.close();
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se creo la Lista \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void closeLista() {
        try {
            String select = "SELECT idLista FROM Lista "
                    + "WHERE Estado = '1' ";

            ps = conexion.prepareStatement(select);
            rs = ps.executeQuery();
            int id = 1;

            if (rs.next()) {
                id = rs.getInt("idLista");
            }

            Calendar c = Calendar.getInstance(Locale.getDefault());
            SimpleDateFormat date = new SimpleDateFormat("HH:mm:ss");
            String time = date.format(c.getTime());

            String update = "UPDATE Lista SET Hora = ?, Total = ?, Estado = ? "
                    + "WHERE idLista = ? ";

            ps = conexion.prepareStatement(update);
            ps.setString(1, time);
            ps.setBigDecimal(2, getTotalVenta());
            ps.setBoolean(3, false);
            ps.setInt(4, id);
            ps.executeUpdate();

            update = "UPDATE articuloVendido SET Estado = ? "
                    + "WHERE lista_idLista = ? ";

            ps = conexion.prepareStatement(update);
            ps.setBoolean(1, false);
            ps.setInt(2, id);
            ps.executeUpdate();

            select = "SELECT idCajaDia FROM CajaDia ORDER BY idCajaDia DESC LIMIT 1 ";
            ps = conexion.prepareStatement(select);
            rs = ps.executeQuery();

            if (rs.next()) {
                id = rs.getInt("idCajaDia");
            } else {
                id = 1;
            }

            update = "UPDATE CajaDia SET Recaudado=? "
                    + "WHERE idCajaDia = ? ";

            ps = conexion.prepareStatement(update);
            ps.setBigDecimal(1, getTotalLista());
            ps.setInt(2, id);
            ps.executeUpdate();
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se cerro el Total de la Lista \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean getEstadoLista() {
        boolean estado = false;
        int id;

        try {
            String select = "SELECT idLista FROM Lista ORDER BY idLista DESC LIMIT 1 ";

            statement = conexion.createStatement();
            rs = statement.executeQuery(select);

            if (rs.next()) {
                id = rs.getInt("idLista");
            } else {
                statement.close();
                rs.close();
                return false;
            }

            select = "SELECT Estado FROM Lista "
                    + "WHERE idLista = '" + id + "'";

            rs = statement.executeQuery(select);

            if (rs.next()) {
                estado = rs.getBoolean("Estado");
            }

            statement.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se encontro el Estado de la Lista \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return estado;
    }

    public BigDecimal getSumaTotalReporte(String fecinicio, String fecfinal) {
        BigDecimal total = null;

        try {
            String select = "SELECT SUM(Total) AS Total FROM Lista "
                    + "WHERE Estado = '0' AND "
                    + "Fecha BETWEEN '" + fecinicio + "' AND '" + fecfinal + "'";

            statement = conexion.createStatement();
            rs = statement.executeQuery(select);

            if (rs.next()) {
                total = rs.getBigDecimal("Total");
            } else {
                return total;
            }

            statement.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede conseguir el Total de las Cajas \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return total;
    }

    public String getNameSystem(String id) {
        String name = "";

        try {
            String select = "SELECT Nombre FROM Info "
                    + "WHERE idInfo = '" + id + "' ";

            statement = conexion.createStatement();
            rs = statement.executeQuery(select);

            if (rs.next()) {
                name = rs.getString("Nombre");
            } else {
                return name;
            }

            statement.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede obtener el Nombre del Sistema\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return name;
    }

    public void setNameSystem(String name) {
        String update = "UPDATE Info SET Nombre = ? "
                + "WHERE idInfo = 'Nombre'";

        try {
            ps = conexion.prepareStatement(update);
            ps.setString(1, name);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se actualizo el Nombre del Sistema\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void cancelarLista(String id) {
        try {
            BigDecimal totalLista = getTotalFactura(id);
            String delete = "DELETE FROM Lista "
                    + "WHERE idLista = ?";

            ps = conexion.prepareStatement(delete);
            ps.setString(1, id);
            ps.executeUpdate();

            String select = "SELECT idCajaDia FROM CajaDia "
                    + "WHERE Estado = '1' ";

            ps = conexion.prepareStatement(select);
            rs = ps.executeQuery();

            if (rs.next()) {
                int idCaja = rs.getInt("idCajaDia");
                BigDecimal total = getRecaudadoCajaDia().subtract(totalLista);

                String update = "UPDATE CajaDia SET Recaudado=? "
                        + "WHERE idCajaDia = ?";

                ps = conexion.prepareStatement(update);
                ps.setBigDecimal(1, total.setScale(2));
                ps.setInt(2, idCaja);
                ps.executeUpdate();
            }

            ps.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede cancelar la lista \n" + ex.getMessage(), "Error", 2);
        }
    }

    public void deleteItemCancelacion(Articulo item, String id) {
        try {
            BigDecimal totalLista = getTotalFactura(id);
            String update = "";
            String select = "SELECT Subtotal FROM articuloVendido "
                    + "WHERE idArticuloVendido = ?";

            ps = conexion.prepareStatement(select);
            ps.setString(1, item.getId());
            rs = ps.executeQuery();

            BigDecimal subtotal = BigDecimal.ZERO;

            if (rs.next()) {
                subtotal = rs.getBigDecimal("Subtotal");
                totalLista = totalLista.subtract(subtotal).setScale(2);
            }

            String delete = "DELETE FROM articuloVendido "
                    + "WHERE idArticuloVendido = ?";

            ps = conexion.prepareStatement(delete);
            ps.setString(1, item.getId());
            ps.executeUpdate();

            if (totalLista.equals(BigDecimal.ZERO.setScale(2))) {
                delete = "DELETE FROM Lista "
                        + "WHERE idLista = ?";

                ps = conexion.prepareStatement(delete);
                ps.setString(1, id);
                ps.executeUpdate();
            } else {
                update = "UPDATE Lista SET Total=? "
                        + "WHERE idLista = ?";

                ps = conexion.prepareStatement(update);
                ps.setBigDecimal(1, totalLista);
                ps.setString(2, id);
                ps.executeUpdate();
            }

            select = "SELECT idCajaDia FROM CajaDia "
                    + "WHERE Estado = '1' ";

            ps = conexion.prepareStatement(select);
            rs = ps.executeQuery();

            if (rs.next()) {
                int idCaja = rs.getInt("idCajaDia");

                update = "UPDATE CajaDia SET Recaudado=? "
                        + "WHERE idCajaDia = ?";

                ps = conexion.prepareStatement(update);
                ps.setBigDecimal(1, getRecaudadoCajaDia().subtract(subtotal));
                ps.setInt(2, idCaja);
                ps.executeUpdate();
            }

            ps.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede eliminar el item \n" + ex.getMessage(), "Error", 2);
        }
    }

    /**
     *
     * @param item
     * @param id
     * @param opc Valor entero para definir si se agrega o elimina una unidad a
     * la cantidad del articulo 0 = eliminar 1 = aumentar 2 = cambio variable
     */
    public void updateItemCancelacion(Articulo item, String id, int opc) {
        try {
            String select = "SELECT Cantidad FROM articuloVendido "
                    + "WHERE idArticuloVendido = ? ";

            ps = conexion.prepareStatement(select);
            ps.setString(1, item.getId());
            rs = ps.executeQuery();
            int cantidad = 0;
            BigDecimal subtotal = null;

            if (rs.next()) {

                if (opc == 1) {
                    cantidad = rs.getInt("Cantidad") + 1;
                    subtotal = getRecaudadoCajaDia().add(item.getPrecio());
                } else if (opc == 2) {
                    cantidad = rs.getInt("Cantidad");
                    subtotal = item.getPrecio().multiply(new BigDecimal(item.getCantidad() - cantidad));
                    subtotal = getRecaudadoCajaDia().add(subtotal);
                    cantidad = item.getCantidad();
                } else {
                    cantidad = rs.getInt("Cantidad") - 1;
                    subtotal = getRecaudadoCajaDia().subtract(item.getPrecio());

                    if (cantidad == 0) {
                        deleteItemCancelacion(item, id);

                        return;
                    }
                }
            }

            item.setSubtotal(cantidad);
            String update = "UPDATE articuloVendido SET Cantidad=?, Subtotal=? "
                    + "WHERE idArticuloVendido = ?";

            ps = conexion.prepareStatement(update);
            ps.setInt(1, cantidad);
            ps.setBigDecimal(2, item.getSubtotal());
            ps.setString(3, item.getId());
            ps.executeUpdate();

            BigDecimal totalLista = getTotalFactura(id);

            update = "UPDATE Lista SET Total=? "
                    + "WHERE idLista = ?";

            ps = conexion.prepareStatement(update);
            ps.setBigDecimal(1, totalLista);
            ps.setString(2, id);
            ps.executeUpdate();

            select = "SELECT idCajaDia FROM CajaDia "
                    + "WHERE Estado = '1' ";

            ps = conexion.prepareStatement(select);
            rs = ps.executeQuery();

            if (rs.next()) {
                int idCaja = rs.getInt("idCajaDia");

                update = "UPDATE CajaDia SET Recaudado=? "
                        + "WHERE idCajaDia = ?";

                ps = conexion.prepareStatement(update);
                ps.setBigDecimal(1, subtotal);
                ps.setInt(2, idCaja);
                ps.executeUpdate();
            }

            ps.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede modificar el item \n" + ex.getMessage(), "Error cancelacion", 2);
        }
    }

    public boolean setDirBackup(String dir) {
        String update = "UPDATE Info SET Nombre = ? "
                + "WHERE idInfo = 'Backup'";

        try {
            ps = conexion.prepareStatement(update);
            ps.setString(1, dir);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se actualizo la ruta de respaldo\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    public String getDirBackup() {
        String dir = "";

        try {
            String select = "SELECT Nombre FROM Info "
                    + "WHERE idInfo = 'Backup'";

            ps = conexion.prepareStatement(select);
            rs = ps.executeQuery();

            if (rs.next()) {
                dir = rs.getString("Nombre");
            } else {
                return dir;
            }

            ps.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede obtener la ruta de respaldo\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return dir;
    }

    public boolean setTheme(String theme) {
        String update = "UPDATE Info SET Nombre = ? "
                + "WHERE idInfo = 'Theme'";

        try {
            ps = conexion.prepareStatement(update);
            ps.setString(1, theme);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se actualizo el tema\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    public String getTheme() {
        String theme = "";

        try {
            String select = "SELECT Nombre FROM Info "
                    + "WHERE idInfo = 'Theme'";

            ps = conexion.prepareStatement(select);
            rs = ps.executeQuery();

            if (rs.next()) {
                theme = rs.getString("Nombre");
            } else {
                return theme;
            }

            ps.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede obtener el tema\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return theme;
    }

    public boolean setDirectorioReportes(String directorio) {
        String update = "UPDATE Info SET Nombre = ? "
                + "WHERE idInfo = 'DirectorioReportes'";

        try {
            ps = conexion.prepareStatement(update);
            ps.setString(1, directorio);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se actualizo el directorio de reportes\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    public String getDirectorioReportes() {
        String directorio = "";

        try {
            String select = "SELECT Nombre FROM Info "
                    + "WHERE idInfo = 'DirectorioReportes'";

            ps = conexion.prepareStatement(select);
            rs = ps.executeQuery();

            if (rs.next()) {
                directorio = rs.getString("Nombre");
            } else {
                return directorio;
            }

            ps.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede obtener el directorio de reportes\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return directorio;
    }
}
