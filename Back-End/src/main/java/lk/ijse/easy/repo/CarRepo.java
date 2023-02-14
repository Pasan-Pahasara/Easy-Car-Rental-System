package lk.ijse.easy.repo;

import lk.ijse.easy.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : ShEnUx
 * @time : 10:41 AM
 * @date : 2/14/2023
 * @since : 0.1.0
 **/
public interface CarRepo extends JpaRepository<Car,String> {
}
