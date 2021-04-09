/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asadel.ventas.services;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 *
 * @author Angel
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class PropiedadesService {

    private final Properties appProperties;

    private Path homePath;

    @PostConstruct
    public void init() {
        homePath = Paths.get(System.getenv("ASADEL_HOME"));
    }

    public String getTheme() {
        return appProperties.getProperty("theme.name");
    }

    public String getBillsDirectory() {
        var dir = homePath.resolve("facturas").toFile();

        if (!dir.exists()) {
            dir.mkdir();
        }

        return homePath.resolve("facturas").toString();
    }

    public String getBackupDirectory() {
        var dir = homePath.resolve("backups").toFile();

        if (!dir.exists()) {
            dir.mkdir();
        }

        return homePath.resolve("backups").toString();
    }

    public String getDBHome() {
        return appProperties.getProperty("mysql.directorio");
    }

    public String getDBUser() {
        return appProperties.getProperty("mysql.user");
    }

    public String getDBSecret() {
        return appProperties.getProperty("mysql.pwd");
    }
}
