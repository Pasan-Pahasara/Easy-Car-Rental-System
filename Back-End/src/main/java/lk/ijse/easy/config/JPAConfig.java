package lk.ijse.easy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author : ShEnUx
 * @time : 3:04 PM
 * @date : 2/13/2023
 * @since : 0.1.0
 **/
@Configuration
@EnableJpaRepositories(basePackageClasses = {})
public class JPAConfig {
}
