package com.asadel.ventas;

import java.awt.Color;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Properties;
import static javax.swing.JFrame.setDefaultLookAndFeelDecorated;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import org.apache.maven.shared.utils.PropertyUtils;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 *
 * @author Angel
 */
@SpringBootApplication(scanBasePackages
        =
        {
            "com.asadel.ventas"
        })
public class Asadel
{

    private static final Logger LOGGER = LoggerFactory.getLogger(Asadel.class);

    public static final Color ACTIVE_COLOR = new Color(0, 153, 255);

    public static void main(String args[])
    {

        Properties properties = null;

        try
        {
            Path home = Paths.get(System.getenv("ASADEL_HOME"));
            Path propertiesPath = home.resolve("asadel.properties").normalize();
            properties = PropertyUtils.loadOptionalProperties(Files.newInputStream(propertiesPath, StandardOpenOption.READ));
            LOGGER.info("Leer propiedades de: {}", propertiesPath);
        }
        catch (IOException | NullPointerException ex)
        {
            LOGGER.error("La variable ASADEL_HOME no se encuentra en el sistema");
            JOptionPane.showMessageDialog(null, "ASADEL_HOME: No se encuentran las propiedades del sistema \n", "Error sistema", JOptionPane.ERROR_MESSAGE);
        }

        String theme = properties.getProperty("theme.name");
        setDefaultLookAndFeelDecorated(true);
        UIManager.put(SubstanceLookAndFeel.BUTTON_NO_MIN_SIZE_PROPERTY, Boolean.TRUE);
        SubstanceLookAndFeel.setSkin("org.pushingpixels.substance.api.skin." + theme);

        SwingUtilities.invokeLater(() ->
        {
            SpringApplicationBuilder builder = new SpringApplicationBuilder(Asadel.class);
            builder.headless(false);
            builder.bannerMode(Banner.Mode.OFF);
            builder.web(false);
            builder.run(args);
        });
    }
}
