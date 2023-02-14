package lk.ijse.easy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author : ShEnUx
 * @time : 5:03 PM
 * @date : 2/12/2023
 * @since : 0.1.0
 **/
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"lk.ijse.easy.controller","lk.ijse.easy.advisor"})
public class WebAppConfig {
}
