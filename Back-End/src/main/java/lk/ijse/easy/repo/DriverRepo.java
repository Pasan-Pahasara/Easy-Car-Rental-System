package lk.ijse.easy.repo;

import lk.ijse.easy.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author : ShEnUx
 * @time : 10:44 PM
 * @date : 2/13/2023
 * @since : 0.1.0
 **/
public interface DriverRepo extends JpaRepository<Driver,String> {
    @Query(value = "SELECT * FROM Driver WHERE driver_Availability='AVAILABLE'", nativeQuery = true)
    List<Driver> availableDrivers();

    @Query(value = "SELECT COUNT(user_Id) FROM Driver", nativeQuery = true)
    int getSumAvailableDrivers();
}
