package com.asadel.ventas.services;

import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.springframework.stereotype.Component;

@Component
public class Conexion 
{
    private final String driver = "com.mysql.jdbc.Driver";
    private final String bd = "Papeleria";
    private final String login = "admin";
    private final String password = "admin";
    private final String properties = "?connectTimeout=0 & socketTimeout=0 & autoReconnect=true";
    private final String url = "jdbc:mysql://localhost/" + bd + properties;
    
    
    private Conexion() 
    {        
    }
    
    public void init()
    {
        try
        {
            Class.forName(driver).newInstance();
        }
        catch(ClassNotFoundException e)
        {
            JOptionPane.showMessageDialog(null, "Error 1\n" + e.getMessage(), "No se Encontro Driver", 2);
            System.exit(0);
        }
        catch (InstantiationException | IllegalAccessException e)
        {
            JOptionPane.showMessageDialog(null, "Error 1.1\n" + e.getMessage(), "No se Encontro Driver.instance()", 2);
            System.exit(0);
        }
    }

    public Connection getConnection()
    {
        Connection conn = null;
        
        try
        {
            conn = DriverManager.getConnection(url, login, password);
        }
        catch (MySQLSyntaxErrorException e)
        {
            setDataBase();
            
            try
            {
                conn = DriverManager.getConnection(url, login, password);
            }
            catch (SQLException ex)
            {
                JOptionPane.showMessageDialog(null, "Error 2.2\n" + ex.getMessage(), "Error al conectarse a la BD", 2); 
                System.exit(0);
            }
        }
        catch(SQLException ex)
        {
            setUser();
            
            try
            {
                conn = DriverManager.getConnection(url, login, password);
            }
            catch (MySQLSyntaxErrorException ex1)
            {
                setDataBase();
            
                try
                {
                    conn = DriverManager.getConnection(url, login, password);
                }
                catch (SQLException ex2)
                {
                    JOptionPane.showMessageDialog(null, "Error 2.1\n" + ex2.getMessage(), "Error al conectarse a la BD", 2); 
                    System.exit(0);
                }
                
            }
            catch (SQLException ex3)
            {
                JOptionPane.showMessageDialog(null, "Error 2\n" + ex.getMessage(), "Error al conectarse a la BD", 2); 
                System.exit(0);
            }
        }
        
        return conn;
    }
    
    private void setUser()
    {
        String createUser = "C:\\Program Files\\MySQL\\MySQL Server 5.5\\bin\\mysql.exe -u root -proot -e " +
                        "\"GRANT ALL PRIVILEGES ON *.* TO admin@'%' IDENTIFIED BY 'admin' WITH GRANT OPTION\"" ;
        Process runtimeProcess = null;

        try
        {
             runtimeProcess = Runtime.getRuntime().exec(createUser);

            if (runtimeProcess.waitFor() != 0)
            {
                JOptionPane.showMessageDialog(null, "No se puede crear Usuario", "Error", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
            else
            {
                
            }
        }
        catch (IOException | InterruptedException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error ", JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }
    }
    
    private void setDataBase()
    {
        int opt = JOptionPane.showConfirmDialog(null, "Desea instalar la base de datos?", "No existe base de datos", JOptionPane.YES_NO_OPTION, 2);
        
        if (opt == JOptionPane.YES_OPTION)
        {
            File backup = new File("H:\\AsadelBackup");
        
            if (backup.exists())
            {
                if (backup.listFiles().length != 0)
                {
                    int def = JOptionPane.showConfirmDialog(null, "Instalar configuracion por defecto?", "Existe una configuración previa", JOptionPane.YES_NO_OPTION, 2);

                    if (def == JOptionPane.YES_OPTION)
                    {
                        configDefault();
                    }
                    else
                    {
                        configManual();
                    }
                }
                else
                {
                    configManual();
                }           
            }
            else
            {
                configManual();
            }   
        }
        else
        {
            System.exit(0);    
        }     
    }
    
    private void configDefault()
    {
        File backups = new File("H:\\AsadelBackup");
        
        for (File f : backups.listFiles())
        {
            System.out.println(f);
        }  
        
        File backup = backups.listFiles()[backups.listFiles().length - 1];
        String[] info = backup.getAbsolutePath().split("_");
        String day = info[1].substring(6, 8);
        String month = info[1].substring(4, 6);
        String year = info[1].substring(0, 4);
        String hour = info[2].substring(0, 2);
        String min = info[2].substring(3, 5);
        String tim = info[2].substring(6, 8);
        String msg = "Restaurar base de datos del:\n" + day + "/" + month + "/" + year
                + " a las " + hour + ":" + min + " " + tim;
        
        int opt = JOptionPane.showConfirmDialog(null, msg, "Configuracion", JOptionPane.YES_NO_OPTION, 2);
        
        if (opt == JOptionPane.YES_OPTION)
        {
            String createSchema = "C:\\Program Files\\MySQL\\MySQL Server 5.5\\bin\\mysql.exe -u root -proot -e \"CREATE SCHEMA Papeleria\"";
            String[] restore = new String[] {"C:\\Program Files\\MySQL\\MySQL Server 5.5\\bin\\mysql.exe", "--user=root", "--password=root", "-e", "source " + backup.getAbsolutePath()};  
            Process runtimeProcess = null;

            try
            {
                runtimeProcess = Runtime.getRuntime().exec(createSchema);

                if (runtimeProcess.waitFor() == 0)
                {
                    runtimeProcess = Runtime.getRuntime().exec(restore);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "No se puede crear SCHEMA", "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }

                if (runtimeProcess.waitFor() == 0)
                {
                    JOptionPane.showMessageDialog(null, "Base instalada correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "No se puede instalar base de datos", "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
            }
            catch (Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error ", JOptionPane.ERROR_MESSAGE);
                System.exit(-1);
            }            
        }
        else
        {
            configManual();
        }
    }
    
    private void configManual()
    {
        File archivo = null;
        JFileChooser selector = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.sql","sql"); 
        selector.setFileFilter(filtro); 
        selector.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int resultado = selector.showOpenDialog(new JFrame());

        if ( resultado == JFileChooser.CANCEL_OPTION )
        {
            selector.cancelSelection();
            System.exit(0);
        }
        else
        {
            archivo = selector.getSelectedFile();

            if ((archivo == null ) || (archivo.getName().equals("")))
            {
                JOptionPane.showMessageDialog(null, "Archivo erroneo");
                selector.cancelSelection();
                System.exit(0);
            }
            
            String[] info = archivo.getAbsolutePath().split("_");
            String day = info[1].substring(6, 8);
            String month = info[1].substring(4, 6);
            String year = info[1].substring(0, 4);
            String hour = info[2].substring(0, 2);
            String min = info[2].substring(3, 5);
            String tim = info[2].substring(6, 8);
            String msg = "Restaurar base de datos del:\n" + day + "/" + month + "/" + year
                    + " a las " + hour + ":" + min + " " + tim;

            int opt = JOptionPane.showConfirmDialog(null, msg, "Configuracion", JOptionPane.YES_NO_OPTION, 2);
            
            if (opt == JOptionPane.NO_OPTION)
            {
                configManual();
                return;
            }

            String createSchema = "C:\\Program Files\\MySQL\\MySQL Server 5.5\\bin\\mysql.exe -u root -proot -e \"CREATE SCHEMA Papeleria\"";
            String[] restore = new String[] {"C:\\Program Files\\MySQL\\MySQL Server 5.5\\bin\\mysql.exe", "--user=root", "--password=root", "-e", "source " + archivo.getAbsolutePath()};  
            Process runtimeProcess = null;

            try
            {
                runtimeProcess = Runtime.getRuntime().exec(createSchema);

//                    InputStreamReader entrada = new InputStreamReader(runtimeProcess.getInputStream());
//                    BufferedReader stdInput = new BufferedReader(entrada);
//                    String salida = null;

//                    if((salida = stdInput.readLine()) != null)
//                    {
//                        System.out.println("Comando ejecutado Correctamente");
//                        
//                        while ((salida=stdInput.readLine()) != null)
//                        {
//                            System.out.println(salida);
//                        }
//                    }

                if (runtimeProcess.waitFor() == 0)
                {
                    runtimeProcess = Runtime.getRuntime().exec(restore);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "No se puede crear SCHEMA", "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }

                if (runtimeProcess.waitFor() == 0)
                {
                    JOptionPane.showMessageDialog(null, "Base instalada correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "No se puede instalar base de datos", "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
            }
            catch (Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error ", JOptionPane.ERROR_MESSAGE);
                System.exit(-1);
            }       
        }
    }
}
