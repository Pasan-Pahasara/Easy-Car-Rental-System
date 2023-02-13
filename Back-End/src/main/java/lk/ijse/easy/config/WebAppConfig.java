package lk.ijse.easy.config;

import lk.ijse.easy.advisor.AppWideExceptionHandler;
import lk.ijse.easy.controller.RegUserController;
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
@ComponentScan(basePackageClasses = {RegUserController.class, AppWideExceptionHandler.class})
public class WebAppConfig {
}
