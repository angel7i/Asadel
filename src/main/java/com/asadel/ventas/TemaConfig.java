package com.asadel.ventas;

import com.asadel.ventas.services.Control;
import javax.annotation.PostConstruct;
import static javax.swing.JFrame.setDefaultLookAndFeelDecorated;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Angel
 */
@Component
public class TemaConfig
{
    private static final Logger LOGGER = LoggerFactory.getLogger(TemaConfig.class);

    @Autowired
    private Control control;

    @PostConstruct
    public void init()
    {
        setDefaultLookAndFeelDecorated(true);
        
        try
        {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
            UIManager.put(SubstanceLookAndFeel.BUTTON_NO_MIN_SIZE_PROPERTY, Boolean.TRUE);
        } 
        catch (UnsupportedLookAndFeelException ex)
        {
            LOGGER.warn("{}", ex.getMessage());
        }

        SubstanceLookAndFeel.setSkin("org.pushingpixels.substance.api.skin." + control.getTheme());
    }
}
