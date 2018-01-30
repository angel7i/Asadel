package com.asadel.ventas.services;

import com.asadel.ventas.controllers.IUArticulos;
import com.asadel.ventas.controllers.IUDesktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ControlCaja 
{
    @Autowired
    private IUDesktop desktop;
    @Autowired
    public  IUArticulos articulos;
    @Autowired
    private Control control;
    
    public boolean openCaja()
    {
        boolean estado = false;
        
        if (!control.getEstadoCajaDia())
        {
            Calendar c = Calendar.getInstance(Locale.getDefault());
            SimpleDateFormat date = new SimpleDateFormat("yy.MM.dd HH.mm.ss");
            String fecha = date.format(c.getTime());
            Caja caja = new Caja(true, fecha, null, BigDecimal.ZERO, BigDecimal.ZERO);
            control.openCajaDia(caja);
            estado = true;
        }
        else
        {
            JOptionPane.showMessageDialog(null, "La Caja ya esta ABIERTA");
        }
        
        return estado;
    }
    
    public boolean closeCaja()
    {
        boolean estado = false;
                       
        if (control.getEstadoCajaDia())
        {
            int opt = JOptionPane.showConfirmDialog(null, "Desea CERRAR la Caja?", "Confirmar Cierre de la Caja", JOptionPane.YES_NO_OPTION, 2);
            
            if (opt == JOptionPane.YES_OPTION)
            {
                Calendar c = Calendar.getInstance(Locale.getDefault());
                SimpleDateFormat date = new SimpleDateFormat("yy.MM.dd HH.mm.ss");
                String fecha = date.format(c.getTime());
                Caja caja = new Caja();
                caja.setEstado(false);
                caja.setCierre(fecha);
                caja.setRecaudado(control.getRecaudadoCajaDia());

                if (control.getEstadoLista())
                {
                    control.clearArticulosLista();
                }

                control.closeCajaDia(caja);
                desktop.showReportes(true);
                articulos.showTotal();
                estado = true;
                backup();
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "La Caja ya esta CERRADA");
        }
        
        return estado;
    }
    
    private void backup()
    {
        File backup = new File(control.getDirBackup() + File.separator + "AsadelBackup");
                
        if (!backup.exists())
            backup.mkdir();
        
        Calendar c = Calendar.getInstance(Locale.getDefault());
        SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd'_'HH-mm-a");//dd-MM-yyyy'_'HH-mm-a");
        String fecha = date.format(c.getTime());
        String command = "C:\\Program Files\\MySQL\\MySQL Server 5.5\\bin\\mysqldump.exe -u admin -padmin papeleria --databases ";
        String file = backup + File.separator + "PapeleriaBackup_" + fecha + ".sql";
        
        new Thread(() ->
        {
            try
            {
                Process runtimeProcess = Runtime.getRuntime().exec(command);
                BufferedReader reader = new BufferedReader(new InputStreamReader(new DataInputStream(runtimeProcess.getInputStream())));
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                String line;
                
                while((line=reader.readLine()) != null)
                {
                    writer.write(line);
                    writer.newLine();
                }
                
                reader.close();
                writer.close();
            }
            catch (Exception ex)
            {
                SwingUtilities.invokeLater(() ->
                {
                    JOptionPane.showInternalMessageDialog(null, ex.getMessage(), "Error ", JOptionPane.ERROR_MESSAGE);
                    System.exit(-1);
                });
            }
        }).start();
    }
}
