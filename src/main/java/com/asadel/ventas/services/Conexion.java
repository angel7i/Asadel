package com.asadel.ventas.services;

import com.mysql.cj.exceptions.CJException;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import javax.annotation.PostConstruct;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class Conexion {

    private final PropiedadesService propiedades;
    private final ApplicationContext ctx;

    private Connection conn = null;

    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String properties = "?allowPublicKeyRetrieval=true&useSSL=false&connectTimeout=0&socketTimeout=0&autoReconnect=true";
    private final String connectionPath = "jdbc:mysql://localhost/papeleria" + properties;

    private String user;
    private String secret;
    private Path bdExe;

    @PostConstruct
    public void setConfiguracion() {
//        try {
//            Class.forName(driver).getDeclaredConstructor().newInstance();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error 1\n" + e.getMessage(), "No se Encontro Driver", 2);
//            System.exit(0);
//        }

        user = propiedades.getDBUser();
        secret = propiedades.getDBSecret();
        bdExe = Paths.get(propiedades.getDBHome());

        try {
            conn = DriverManager.getConnection(connectionPath, user, secret);
        } catch (SQLException e) {
             e.printStackTrace();

            if (e instanceof SQLNonTransientConnectionException) {
                var cause = e.getCause();

                if (cause instanceof CJException) {
                    setDataBase();
                } else {
                    JOptionPane.showMessageDialog(null, "No se encuentra la Base de Datos:\n" + "Revisa si la Base de datos se esta ejecutando...", "ERROR BD", 2);
                    SpringApplication.exit(ctx, () -> 0);
                    System.exit(0);
                }
            }
        }

        try {
            conn = DriverManager.getConnection(connectionPath, user, secret);
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error 2.2\n" + ex.getMessage(), "Error al conectarse a la BD", 2);
            SpringApplication.exit(ctx, () -> -1);
            System.exit(-1);
        }
    }

    public Connection getConnection() {
        return conn;
    }

    private void setUser() {
        log.info("Crear usuario...");
        Path exe = bdExe.resolve("bin/mysql.exe");
        String createUser = "\"" + exe.toString() + "\"" + " -u root -pasadel -e "
                + String.format("\"CREATE USER [IF NOT EXISTS] '%s'@'localhost' IDENTIFIED BY '%s'; ", user, secret)
                + String.format("GRANT ALL PRIVILEGES ON *.* TO '%s'@'localhost'; \"", user);
        Process runtimeProcess = null;

        try {
            log.info("Exec: {}", createUser);
            runtimeProcess = Runtime.getRuntime().exec(createUser);

            if (runtimeProcess.waitFor(15, TimeUnit.SECONDS)) {
                log.info("El usuario de la BD fue creado correctamente...");
            } else {
                log.error("No se puede crear el usuario...");
                JOptionPane.showMessageDialog(null, "No se puede crear Usuario", "Error", JOptionPane.ERROR_MESSAGE);
                SpringApplication.exit(ctx, () -> -1);
                System.exit(-1);
            }
        } catch (IOException | InterruptedException ex) {
            log.error("Crear user: {}", ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error Usuario", JOptionPane.ERROR_MESSAGE);
            SpringApplication.exit(ctx, () -> -1);
            System.exit(-1);
        }
    }

    private void setDataBase() {
        int opt = JOptionPane.showConfirmDialog(null, "Desea instalar la base de datos?", "No existe base de datos", JOptionPane.YES_NO_OPTION, 2);

        if (opt == JOptionPane.YES_OPTION) {
            File backup = Paths.get(propiedades.getBackupDirectory()).toFile();

            if (backup.exists()) {
                if (backup.listFiles().length != 0) {
                    int def = JOptionPane.showConfirmDialog(null, "Instalar configuracion por defecto?", "Existe una configuración previa", JOptionPane.YES_NO_OPTION, 2);

                    if (def == JOptionPane.YES_OPTION) {
                        configDefault();
                    } else {
                        configManual();
                    }
                } else {
                    configManual();
                }
            } else {
                configManual();
            }
        } else {
            SpringApplication.exit(ctx, () -> 0);
            System.exit(0);
        }
    }

    private void configDefault() {
        setUser();
        File backups = Paths.get(propiedades.getBackupDirectory()).toFile();

        for (File f
                : backups.listFiles()) {
            log.trace("File: {}", f);
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

        if (opt == JOptionPane.YES_OPTION) {
            Path exe = bdExe.resolve("bin\\mysql.exe");

            String createSchema = "\"" + exe.toString() + "\"" + " -u " + user + " -p" + secret + " -e \"CREATE SCHEMA Papeleria\"";
            String[] restore = new String[]{
                exe.toString(), "--user=" + user, "--password=" + user, "-e", "source " + backup.getAbsolutePath()
            };
            Process runtimeProcess = null;

            try {
                log.info("Exec: {}", createSchema);
                runtimeProcess = Runtime.getRuntime().exec(createSchema);
                //var output = new StreamGobbler(runtimeProcess.getInputStream(), System.out::println);
                //Executors.newSingleThreadExecutor().submit(output);

                if (runtimeProcess.waitFor() == 0) {
                    runtimeProcess = Runtime.getRuntime().exec(restore);
                } else {

                    JOptionPane.showMessageDialog(null, "No se puede crear SCHEMA", "Error", JOptionPane.ERROR_MESSAGE);
                    SpringApplication.exit(ctx, () -> -1);
                    System.exit(-1);
                }

                if (runtimeProcess.waitFor() == 0) {
                    JOptionPane.showMessageDialog(null, "Base instalada correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No se puede instalar base de datos", "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
            } catch (HeadlessException | IOException | InterruptedException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error ", JOptionPane.ERROR_MESSAGE);
                System.exit(-1);
            }
        } else {
            configManual();
        }
    }

    private void configManual() {
        setUser();
        File archivo = null;
        JFileChooser selector = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.sql", "sql");
        selector.setFileFilter(filtro);
        selector.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int resultado = selector.showOpenDialog(new JFrame());

        if (resultado == JFileChooser.CANCEL_OPTION) {
            selector.cancelSelection();
            System.exit(0);
        } else {
            archivo = selector.getSelectedFile();

            if ((archivo == null) || (archivo.getName().equals(""))) {
                JOptionPane.showMessageDialog(null, "Archivo erroneo");
                selector.cancelSelection();
                SpringApplication.exit(ctx, () -> 0);
                SpringApplication.exit(ctx, () -> 0);
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

            if (opt == JOptionPane.NO_OPTION) {
                configManual();
                return;
            }

            Path exe = bdExe.resolve("bin\\mysql.exe");

            String createSchema ="\"" + exe.toString() + "\"" + " -u " + user + " -p" + secret + " -e \"CREATE SCHEMA Papeleria\"";
            String[] restore = new String[]{
                exe.toString(), "--user=" + user, "--password=" + secret, "-e", "source " + archivo.getAbsolutePath()
            };
            Process runtimeProcess = null;

            try {
                log.info("Exec: {}", createSchema);
                runtimeProcess = Runtime.getRuntime().exec(createSchema);

                if (runtimeProcess.waitFor() == 0) {
                    runtimeProcess = Runtime.getRuntime().exec(restore);
                } else {
                    JOptionPane.showMessageDialog(null, "No se puede crear SCHEMA", "Error", JOptionPane.ERROR_MESSAGE);
                    SpringApplication.exit(ctx, () -> 0);
                    System.exit(0);
                }

                if (runtimeProcess.waitFor() == 0) {
                    JOptionPane.showMessageDialog(null, "Base instalada correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No se puede instalar base de datos", "Error", JOptionPane.ERROR_MESSAGE);
                    SpringApplication.exit(ctx, () -> 0);
                    System.exit(0);
                }
            } catch (HeadlessException | IOException | InterruptedException ex) {
                log.warn("Error ConfigManual-> {}: {}", ex.getClass().getSimpleName(), ex.getMessage());
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error ConfigManual", JOptionPane.ERROR_MESSAGE);
                SpringApplication.exit(ctx, () -> 0);
                System.exit(0);
            }
        }
    }

    private static class StreamGobbler implements Runnable {

        private InputStream inputStream;
        private Consumer<String> consumer;

        public StreamGobbler(InputStream inputStream, Consumer<String> consumer) {
            this.inputStream = inputStream;
            this.consumer = consumer;
        }

        @Override
        public void run() {
            new BufferedReader(new InputStreamReader(inputStream)).lines()
                    .forEach(consumer);
        }
    }
}
