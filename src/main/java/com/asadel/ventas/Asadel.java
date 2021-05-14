package com.asadel.ventas;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import static javax.swing.JFrame.setDefaultLookAndFeelDecorated;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import lombok.extern.slf4j.Slf4j;
import org.pushingpixels.substance.api.SubstanceCortex;
import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author Angel
 */
@Slf4j
@SpringBootApplication(scanBasePackages
        = {
            "com.asadel.ventas"
        })
public class Asadel {

    public static final Color ACTIVE_COLOR = new Color(97, 203, 234);

    private static Properties appProperties;

    @Bean
    public Properties appProperties() {
        return appProperties;
    }

    public static void main(String args[]) {
        appProperties = new Properties();
        Path home = Paths.get(System.getenv("ASADEL_HOME"));
        Path propertiesPath = home.resolve("asadel.properties").normalize();

        try (var inputStream = new FileInputStream(propertiesPath.toFile())) {
            appProperties.load(inputStream);
            log.info("Leer propiedades de: {}", propertiesPath);
        } catch (IOException | NullPointerException ex) {
            log.error("La variable ASADEL_HOME no se encuentra en el sistema");
            JOptionPane.showMessageDialog(null, "ASADEL_HOME: No se encuentran las propiedades del sistema \n", "Error sistema", JOptionPane.ERROR_MESSAGE);
        }

        setDefaultLookAndFeelDecorated(true);

        SwingUtilities.invokeLater(()
                -> {
            SubstanceCortex.GlobalScope.setSkin("org.pushingpixels.substance.api.skin.MistAquaSkin");
            SpringApplicationBuilder builder = new SpringApplicationBuilder(Asadel.class);
            builder.headless(false);
            builder.bannerMode(Banner.Mode.OFF);
            builder.web(WebApplicationType.NONE);
            builder.run(args);
        });
    }
}
