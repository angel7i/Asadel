package com.asadel.ventas;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 *
 * @author Angel
 */
@SpringBootApplication(scanBasePackages ={"com.asadel.ventas"})
public class Asadel
{
    public static void main(String args[])
    {      
        SpringApplicationBuilder builder = new SpringApplicationBuilder(Asadel.class);
        builder.headless(false);
        builder.bannerMode(Banner.Mode.OFF);
        builder.web(false);        
        builder.run(args);
    }
}
