package com.asadel.ventas.services;

import com.asadel.ventas.controllers.IUArticulos;
import com.asadel.ventas.controllers.IUDesktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ControlCaja
{

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ControlCaja.class);

    @Autowired
    private IUDesktop desktop;
    @Autowired
    public IUArticulos articulos;
    @Autowired
    private Control control;
    @Autowired
    private PropiedadesService propiedades;

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
        Path directorio = Paths.get(propiedades.getDirectorioBackup(), "AsadelBackup");
        File directorioBackup = directorio.toFile();

        if (!directorioBackup.exists())
        {
            directorioBackup.mkdir();
        }

        Calendar c = Calendar.getInstance(Locale.getDefault());
        SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd'_'HH-mm-a");
        String fecha = date.format(c.getTime());
        String command = "C:\\Program Files\\MySQL\\MySQL Server 5.5\\bin\\mysqldump -u admin -padmin papeleria --databases ";
        Path backup = directorio.resolve("PapeleriaBackup_" + fecha + ".sql");
        BufferedReader reader = null;
        BufferedWriter writer = null;

        try
        {
            Process runtimeProcess = Runtime.getRuntime().exec(command);
            reader = new BufferedReader(new InputStreamReader(new DataInputStream(runtimeProcess.getInputStream())));
            writer = new BufferedWriter(new FileWriter(backup.toFile()));
            String line;

            while ((line = reader.readLine()) != null)
            {
                writer.write(line);
                writer.newLine();
            }
        }
        catch (IOException ex)
        {
            LOGGER.error("No se puede crear backup de la caja: {}", ex.getMessage());
        }
        finally
        {
            try
            {
                if (reader != null)
                {
                    reader.close();
                }
                if (writer != null)
                {
                    writer.close();
                }
            }
            catch (IOException ex)
            {
                
            }
            
        }
    }
}
