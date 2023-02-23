package lk.ijse.easy.repo;

import lk.ijse.easy.dto.UserDTO;
import lk.ijse.easy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author : ShEnUx
 * @time : 11:19 PM
 * @date : 2/21/2023
 * @since : 0.1.0
 **/

public interface UserRepo extends JpaRepository<User,String> {

}
