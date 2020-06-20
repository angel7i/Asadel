/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asadel.ventas.services;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Properties;
import org.apache.maven.shared.utils.PropertyUtils;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @author Angel
 */
@Component
public class PropiedadesService
{
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(PropiedadesService.class);

    private final Path propertiesPath;

    public PropiedadesService()
    {
        Path home = Paths.get(System.getenv("ASADEL_HOME"));
        propertiesPath = home.resolve("asadel.properties").normalize();
    }

    public String getTheme()
    {
        String property = null;

        try
        {
            Properties propiedades
                    = PropertyUtils.loadOptionalProperties(Files.newInputStream(propertiesPath, StandardOpenOption.READ));
            property = propiedades.getProperty("theme.name");
        }
        catch (IOException ex)
        {
            LOGGER.warn("{}", ex.getMessage());
        }

        return property;
    }

    public boolean updateTheme(String theme)
    {
        boolean complete = false;

        try
        {
            Properties propiedades
                    = PropertyUtils.loadOptionalProperties(Files.newInputStream(propertiesPath, StandardOpenOption.READ));
            propiedades.replace("theme.name", theme);
            propiedades.store(Files.newBufferedWriter(propertiesPath, StandardCharsets.UTF_8, StandardOpenOption.WRITE),
                    "Asadel");
            complete = true;
        }
        catch (IOException ex)
        {
            LOGGER.warn("{}", ex.getMessage());
        }

        return complete;
    }

    public String getDirectorioNotas()
    {
        String property = null;

        try
        {
            Properties propiedades
                    = PropertyUtils.loadOptionalProperties(Files.newInputStream(propertiesPath, StandardOpenOption.READ));
            property = propiedades.getProperty("notas.directorio");
        }
        catch (IOException ex)
        {
            LOGGER.warn("{}", ex.getMessage());
        }

        return property;
    }

    public boolean updateDirectorioNotas(String directorio)
    {
        boolean complete = false;

        try
        {
            Properties propiedades
                    = PropertyUtils.loadOptionalProperties(Files.newInputStream(propertiesPath, StandardOpenOption.READ));
            propiedades.replace("notas.directorio", directorio);
            propiedades.store(Files.newBufferedWriter(propertiesPath, StandardCharsets.UTF_8, StandardOpenOption.WRITE),
                    "Asadel");
            complete = true;
        }
        catch (IOException ex)
        {
            LOGGER.warn("{}", ex.getMessage());
        }

        return complete;
    }

    public String getDirectorioBackup()
    {
        String property = null;

        try
        {
            Properties propiedades
                    = PropertyUtils.loadOptionalProperties(Files.newInputStream(propertiesPath, StandardOpenOption.READ));
            property = propiedades.getProperty("backup.directorio");
        }
        catch (IOException ex)
        {
            LOGGER.warn("{}", ex.getMessage());
        }

        return property;
    }

    public boolean updateDirectorioBackup(String directorio)
    {
        boolean complete = false;

        try
        {
            Properties propiedades
                    = PropertyUtils.loadOptionalProperties(Files.newInputStream(propertiesPath, StandardOpenOption.READ));
            propiedades.replace("backup.directorio", directorio);
            propiedades.store(Files.newBufferedWriter(propertiesPath, StandardCharsets.UTF_8, StandardOpenOption.WRITE),
                    "Asadel");
            complete = true;
        }
        catch (IOException ex)
        {
            LOGGER.warn("{}", ex.getMessage());
        }

        return complete;
    }

    public String getMySQLDirectorio()
    {
        String property = null;

        try
        {
            Properties propiedades
                    = PropertyUtils.loadOptionalProperties(Files.newInputStream(propertiesPath, StandardOpenOption.READ));
            property = propiedades.getProperty("mysql.directorio");
        }
        catch (IOException ex)
        {
            LOGGER.warn("{}", ex.getMessage());
        }

        return property;
    }

    public String getMySQLUser()
    {
        String property = null;

        try
        {
            Properties propiedades
                    = PropertyUtils.loadOptionalProperties(Files.newInputStream(propertiesPath, StandardOpenOption.READ));
            property = propiedades.getProperty("mysql.user");
        }
        catch (IOException ex)
        {
            LOGGER.warn("{}", ex.getMessage());
        }

        return property;
    }

    public String getMySQLPwd()
    {
        String property = null;

        try
        {
            Properties propiedades
                    = PropertyUtils.loadOptionalProperties(Files.newInputStream(propertiesPath, StandardOpenOption.READ));
            property = propiedades.getProperty("mysql.pwd");
        }
        catch (IOException ex)
        {
            LOGGER.warn("{}", ex.getMessage());
        }

        return property;
    }
}
