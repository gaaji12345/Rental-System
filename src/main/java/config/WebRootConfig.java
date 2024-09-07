package config;/*  gaajiCode
    99
    04/09/2024
    */

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(JPAConfig.class)
public class WebRootConfig {
    public WebRootConfig() {
        System.out.println("Root Hiii");
    }
}
