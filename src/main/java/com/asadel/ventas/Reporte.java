package com.asadel.ventas;

import java.io.File;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class Reporte 
{
    private JasperPrint reporte;
    private final String dirAsadel = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "Asadel";
    private final String dirFact = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "Asadel" + File.separator + "Facturas";
    private String path;
    
    private void directorio()
    {
        File dir = new File(dirAsadel);
        
        if (!dir.exists())
            dir.mkdir();
        
        dir = new File(dirFact);
        
        if (!dir.exists())
            dir.mkdir();        
    }
    
    public boolean generarFactura(int id, BigDecimal total)
    {
        boolean estado = false;
        
        try
        {
            Map <String, Object> parametros = new HashMap<>();
            String numFac = randomFac(id);
            path = dirFact + File.separator + "Factura_" + getDatePath() + ".pdf";
            
            parametros.put("Total", total);
            parametros.put("numFac", numFac);
            parametros.put("fecha", getDateFac());
            
            InputStream formato = this.getClass().getResourceAsStream("/Reporte/Factura.jasper");
            reporte = JasperFillManager.fillReport(formato, parametros, IUMain.control.getConnectionControl());
            estado = true;
         }
         catch (JRException ex)
         {
             JOptionPane.showMessageDialog(null, "Error al generar la Factura"+"\n"+ex.getMessage());
         }
        
        return estado;
    }
    
    public boolean generarFacturaDescuento(int id, BigDecimal total)
    {
        boolean estado = false;
        
        try
        {
            Map <String, Object> parametros = new HashMap<>();
            String numFac = randomFac(id);
            path = dirFact + File.separator + "Factura_" + getDatePath() + ".pdf";
            
            parametros.put("Total", total);
            parametros.put("numFac", numFac);
            parametros.put("fecha", getDateFac());
            
            InputStream formato = this.getClass().getResourceAsStream("/Reporte/FacturaDescuento.jasper");
            reporte = JasperFillManager.fillReport(formato, parametros, IUMain.control.getConnectionControl());
            estado = true;
         }
         catch (JRException ex)
         {
             JOptionPane.showMessageDialog(null, "Error al generar la FacturaDescuento"+"\n"+ex.getMessage());
         }
        
        return estado;
    }
    
    public JasperPrint generarReporteDiaArticulos()
    {
        try
        {
                
            InputStream formato = this.getClass().getResourceAsStream("/Reporte/ReporteDiaArticulos.jasper");
            reporte = JasperFillManager.fillReport(formato, null, IUMain.control.getConnectionControl());
        }
         catch (JRException ex)
         {
             JOptionPane.showMessageDialog(null, "Error al generar el ReporteDiaArt"+"\n"+ex.getMessage());
         }
        
        return reporte;
    }
    
    public JasperPrint generarReporteDiaVentas()
    {
        try
        {
            InputStream formato = this.getClass().getResourceAsStream("/Reporte/ReporteDiaVentas.jasper");
            reporte = JasperFillManager.fillReport(formato, null, IUMain.control.getConnectionControl());
        }
        catch (JRException ex)
        {
            JOptionPane.showMessageDialog(null, "Error al generar el ReporteDiaVen"+"\n"+ex.getMessage());
        }
        
        return reporte;
    }
    
    public JasperPrint generarReporteMesVentas()
    {
        try
        {
            InputStream formato = this.getClass().getResourceAsStream("/Reporte/ReporteMesVentas.jasper");
            reporte = JasperFillManager.fillReport(formato, null, IUMain.control.getConnectionControl());
        }
         catch (JRException ex)
         {
             JOptionPane.showMessageDialog(null, "Error al generar el ReporteMesVen"+"\n"+ex.getMessage());
         }
        
        return reporte;
    }
    
    public JasperPrint generarReporteMensual(Date fecha, int mes,  int year)
    {
        try
        {
            Map <String, Object> parametros = new HashMap<>();
            
            parametros.put("Fecha", fecha);
            parametros.put("Mes", mes);
            parametros.put("Año", year);
                
            InputStream formato = this.getClass().getResourceAsStream("/Reporte/ReporteMensual.jasper");
            reporte = JasperFillManager.fillReport(formato, parametros, IUMain.control.getConnectionControl());
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
            Map <String, Object> parametros = new HashMap<>();
            
            parametros.put("FecIni", ini);
            parametros.put("FecFin", fin);
            parametros.put("Total", total);
                           
            InputStream formato = this.getClass().getResourceAsStream("/Reporte/ReporteFechasVentas.jasper");
            reporte = JasperFillManager.fillReport(formato, parametros, IUMain.control.getConnectionControl());
         }
         catch (JRException ex)
         {
             JOptionPane.showMessageDialog(null, "Error al generar el ReporteFechasVentas \n"+ex.getMessage());
         }
        
        return reporte;
    }
    
    public JasperPrint generarReporteinFechasArticulos(String ini, String fin, BigDecimal total)
    {
        try
        {
            Map <String, Object> parametros = new HashMap<>();
            
            parametros.put("FecIni", ini);
            parametros.put("FecFin", fin);
            parametros.put("Total", total);
                           
            InputStream formato = this.getClass().getResourceAsStream("/Reporte/ReporteFechasArticulos.jasper");
            reporte = JasperFillManager.fillReport(formato, parametros, IUMain.control.getConnectionControl());
         }
         catch (JRException ex)
         {
             JOptionPane.showMessageDialog(null, "Error al generar el ReporteFechasArticulos \n"+ex.getMessage());
         }
        
        return reporte;
    }
    
    public JasperPrint searchFactura(String id)
    {
        try
        {
            Map <String, Object> parametros = new HashMap<>();
            
            parametros.put("numFac", id);
            
            InputStream formato = this.getClass().getResourceAsStream("/Reporte/SearchFactura.jasper");
            reporte = JasperFillManager.fillReport(formato, parametros, IUMain.control.getConnectionControl());
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
            JasperViewer.viewReport(reporte, false);
    }
    
    public void printFactura()
    {
        if (reporte != null)
        {
            directorio();
            
            try
            {
                JasperExportManager.exportReportToPdfFile(reporte, path);
            }
            catch (JRException ex)
            {
                 JOptionPane.showMessageDialog(null, "Error al exportar el Reporte"+"\n"+ex.getMessage());
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
            c = (char)num.nextInt(122);
            
            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))
            {
                serie += String.valueOf(c).toUpperCase();
                
                if (serie.length() == 5)
                    break;
            }
        }
        
        return id + "-" + serie;
    }
}