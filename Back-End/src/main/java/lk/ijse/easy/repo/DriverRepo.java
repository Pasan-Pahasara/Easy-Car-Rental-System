package lk.ijse.easy.repo;

import lk.ijse.easy.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : ShEnUx
 * @time : 10:44 PM
 * @date : 2/13/2023
 * @since : 0.1.0
 **/
public interface DriverRepo extends JpaRepository<Driver,String> {
}
