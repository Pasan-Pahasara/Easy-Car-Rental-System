package lk.ijse.easy.repo;

import lk.ijse.easy.entity.RegUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author : ShEnUx
 * @time : 3:21 PM
 * @date : 2/13/2023
 * @since : 0.1.0
 **/
public interface RegUserRepo extends JpaRepository<RegUser,String> {
    @Query(value = "SELECT user_Id FROM RegUser ORDER BY user_Id DESC LIMIT 1", nativeQuery = true)
    String generateCustomerId();

    @Query(value = "SELECT COUNT(user_Id) FROM RegUser", nativeQuery = true)
    int getSumOfUsers();
}
