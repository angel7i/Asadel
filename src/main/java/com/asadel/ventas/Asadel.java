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
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 *
 * @author Angel
 */
@SpringBootApplication(scanBasePackages =
{
    "com.asadel.ventas"
})
public class Asadel
{

    public static final Color ACTIVE_COLOR = new Color(0, 153, 255);

    public static void main(String args[])
    {

        Properties properties = null;

        try
        {            
            Path home = Paths.get(System.getenv("ASADEL_HOME"));
	    Path propertiesPath = home.resolve("asadel.properties").normalize();
            properties = PropertyUtils.loadOptionalProperties(Files.newInputStream(propertiesPath, StandardOpenOption.READ));
        }
        catch (IOException ex)
        {
            JOptionPane.showMessageDialog(null, "No se encuentran las propiedades del sistema \n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
