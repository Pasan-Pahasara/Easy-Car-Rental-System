package lk.ijse.easy.config;

import lk.ijse.easy.service.impl.RegUserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author : ShEnUx
 * @time : 5:06 PM
 * @date : 2/12/2023
 * @since : 0.1.0
 **/
@Configuration
@Import(JPAConfig.class)
@ComponentScan(basePackageClasses = {RegUserServiceImpl.class})
public class WebRootConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
