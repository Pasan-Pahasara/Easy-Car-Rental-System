package lk.ijse.easy.repo;

import lk.ijse.easy.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : ShEnUx
 * @time : 11:50 PM
 * @date : 2/23/2023
 * @since : 0.1.0
 **/
public interface RentRepo extends JpaRepository<Rent, String> {
}
