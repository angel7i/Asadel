package com.asadel.ventas.services;

import java.io.File;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.swing.JOptionPane;
import lombok.Setter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Reporte
{

    private static final Logger LOGGER = LoggerFactory.getLogger(Reporte.class);

    @Autowired
    private Control control;
    @Autowired
    private PropiedadesService propiedades;

    private JasperPrint reporte;
    private Path directorioReportes;
    private Path path;

    @Setter
    private Factura datosFactura;

    @PostConstruct
    public void init()
    {
        directorioReportes = Paths.get(propiedades.getDirectorioNotas());
        datosFactura = new Factura();
        LOGGER.info("Directorio de reportes: {}", directorioReportes);
    }

    public void updateDirectorio(String directorio)
    {
        directorioReportes = Paths.get(directorio);
        validateDirectorio();
    }

    private void validateDirectorio()
    {
        File dir = new File(directorioReportes.toString());

        if (!dir.exists())
        {
            dir.mkdir();
        }
    }

    public void clearFactura()
    {
        datosFactura = new Factura();
    }

    public boolean generarFactura(int id, BigDecimal total)
    {
        boolean estado = false;

        try
        {
            Map<String, Object> parametros = new HashMap<>();
            String numFac = randomFac(id);
            path = directorioReportes.resolve("Factura_" + getDatePath() + ".pdf");

            parametros.put("Total", total);
            parametros.put("numFac", numFac);
            parametros.put("fecha", getDateFac());
            parametros.put("obs", datosFactura.getAnticipo());

            if (datosFactura.getAnticipo().equals(BigDecimal.ZERO))
            {
                parametros.put("resta", BigDecimal.ZERO);
            }
            else
            {
                BigDecimal pendiente = total.subtract(datosFactura.getAnticipo());
                parametros.put("resta", pendiente);
            }

            parametros.put("cliente", datosFactura.getNombreCliente());
            parametros.put("telefono", datosFactura.getTelefono());
            parametros.put("observaciones", datosFactura.getObservaciones());

            InputStream formato = this.getClass().getResourceAsStream("/reports/Factura.jasper");
            reporte = JasperFillManager.fillReport(formato, parametros, control.getConnectionControl());
            estado = true;
        }
        catch (JRException ex)
        {
            JOptionPane.showMessageDialog(null, "Error al generar la Factura" + "\n" + ex.getMessage());
        }

        return estado;
    }

    public boolean generarFacturaDescuento(int id, BigDecimal total)
    {
        boolean estado = false;

        try
        {
            Map<String, Object> parametros = new HashMap<>();
            String numFac = randomFac(id);
            path = directorioReportes.resolve("Factura_" + getDatePath() + ".pdf");

            parametros.put("Total", total);
            parametros.put("numFac", numFac);
            parametros.put("fecha", getDateFac());

            InputStream formato = this.getClass().getResourceAsStream("/reports/FacturaDescuento.jasper");
            reporte = JasperFillManager.fillReport(formato, parametros, control.getConnectionControl());
            estado = true;
        }
        catch (JRException ex)
        {
            JOptionPane.showMessageDialog(null, "Error al generar la FacturaDescuento" + "\n" + ex.getMessage());
        }

        return estado;
    }

    public JasperPrint generarReporteDiaArticulos()
    {
        try
        {

            InputStream formato = this.getClass().getResourceAsStream("/reports/ReporteDiaArticulos.jasper");
            reporte = JasperFillManager.fillReport(formato, null, control.getConnectionControl());
        }
        catch (JRException ex)
        {
            JOptionPane.showMessageDialog(null, "Error al generar el ReporteDiaArt" + "\n" + ex.getMessage());
        }

        return reporte;
    }

    public JasperPrint generarReporteDiaVentas()
    {
        try
        {
            InputStream formato = this.getClass().getResourceAsStream("/reports/ReporteDiaVentas.jasper");
            reporte = JasperFillManager.fillReport(formato, null, control.getConnectionControl());
        }
        catch (JRException ex)
        {
            JOptionPane.showMessageDialog(null, "Error al generar el ReporteDiaVen" + "\n" + ex.getMessage());
        }

        return reporte;
    }

    public JasperPrint generarReporteMesVentas()
    {
        try
        {
            InputStream formato = this.getClass().getResourceAsStream("/reports/ReporteMesVentas.jasper");
            reporte = JasperFillManager.fillReport(formato, null, control.getConnectionControl());
        }
        catch (JRException ex)
        {
            JOptionPane.showMessageDialog(null, "Error al generar el ReporteMesVen" + "\n" + ex.getMessage());
        }

        return reporte;
    }

    public JasperPrint generarReporteMensual(Date fecha, int mes, int year)
    {
        try
        {
            Map<String, Object> parametros = new HashMap<>();

            parametros.put("Fecha", fecha);
            parametros.put("Mes", mes);
            parametros.put("Año", year);

            InputStream formato = this.getClass().getResourceAsStream("/reports/ReporteMensual.jasper");
            reporte = JasperFillManager.fillReport(formato, parametros, control.getConnectionControl());
        }
        catch (JRException ex)
        {
            JOptionPane.showMessageDialog(null, "Error al generar el ReporteMensual" + "\n" + ex.getMessage());
        }

        return reporte;
    }

    public JasperPrint generarReporteinFechasVentas(String ini, String fin, BigDecimal total)
    {
        try
        {
            Map<String, Object> parametros = new HashMap<>();

            parametros.put("FecIni", ini);
            parametros.put("FecFin", fin);
            parametros.put("Total", total);

            InputStream formato = this.getClass().getResourceAsStream("/reports/ReporteFechasVentas.jasper");
            reporte = JasperFillManager.fillReport(formato, parametros, control.getConnectionControl());
        }
        catch (JRException ex)
        {
            JOptionPane.showMessageDialog(null, "Error al generar el ReporteFechasVentas \n" + ex.getMessage());
        }

        return reporte;
    }

    public JasperPrint generarReporteinFechasArticulos(String ini, String fin, BigDecimal total)
    {
        try
        {
            Map<String, Object> parametros = new HashMap<>();

            parametros.put("FecIni", ini);
            parametros.put("FecFin", fin);
            parametros.put("Total", total);

            InputStream formato = this.getClass().getResourceAsStream("/reports/ReporteFechasArticulos.jasper");
            reporte = JasperFillManager.fillReport(formato, parametros, control.getConnectionControl());
        }
        catch (JRException ex)
        {
            JOptionPane.showMessageDialog(null, "Error al generar el ReporteFechasArticulos \n" + ex.getMessage());
        }

        return reporte;
    }

    public JasperPrint searchFactura(String id)
    {
        try
        {
            Map<String, Object> parametros = new HashMap<>();

            parametros.put("numFac", id);

            InputStream formato = this.getClass().getResourceAsStream("/reports/SearchFactura.jasper");
            reporte = JasperFillManager.fillReport(formato, parametros, control.getConnectionControl());
        }
        catch (JRException ex)
        {
            JOptionPane.showMessageDialog(null, "Error al buscar la Factura \n" + ex.getMessage());
        }

        return reporte;
    }

    public void showFactura()
    {
        if (reporte != null)
        {
            JasperViewer.viewReport(reporte, false);
        }
    }

    public void printFactura()
    {
        if (reporte != null)
        {
            validateDirectorio();

            try
            {
                JasperExportManager.exportReportToPdfFile(reporte, path.toString());
            }
            catch (JRException ex)
            {
                JOptionPane.showMessageDialog(null, "Error al exportar el reports" + "\n" + ex.getMessage());
            }
        }
    }

    public String getDateFac()
    {
        Calendar c = Calendar.getInstance(Locale.getDefault());
        SimpleDateFormat date = new SimpleDateFormat("dd/MMMMMM/yyyy HH:mm:ss a");
        String fecha = date.format(c.getTime());

        return fecha;
    }

    public String getDatePath()
    {
        Calendar c = Calendar.getInstance(Locale.getDefault());
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yy'_'HH-mm-a");
        String fecha = date.format(c.getTime());

        return fecha;
    }

    public String randomFac(int id)
    {
        Random num = new Random();
        String serie = "";
        char c;

        while (true)
        {
            c = (char) num.nextInt(122);

            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))
            {
                serie += String.valueOf(c).toUpperCase();

                if (serie.length() == 5)
                {
                    break;
                }
            }
        }

        return id + "-" + serie;
    }
}
