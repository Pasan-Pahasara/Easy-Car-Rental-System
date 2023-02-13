package lk.ijse.easy.repo;

import lk.ijse.easy.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : ShEnUx
 * @time : 3:21 PM
 * @date : 2/13/2023
 * @since : 0.1.0
 **/
public interface CustomerRepo extends JpaRepository<Customer,String> {
}
