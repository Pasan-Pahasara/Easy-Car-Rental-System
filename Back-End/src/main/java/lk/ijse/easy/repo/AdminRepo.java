package lk.ijse.easy.repo;

import lk.ijse.easy.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : ShEnUx
 * @time : 9:11 AM
 * @date : 2/14/2023
 * @since : 0.1.0
 **/
public interface AdminRepo extends JpaRepository<Admin,String> {
}
