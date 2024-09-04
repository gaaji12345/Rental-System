package config;/*  gaajiCode
    99
    04/09/2024
    */

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan("controller")
public class WebAppConfig {

    public WebAppConfig() {
        System.out.println("Hiii");
    }
}
