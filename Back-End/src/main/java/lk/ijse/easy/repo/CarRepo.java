package lk.ijse.easy.repo;

import lk.ijse.easy.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : ShEnUx
 * @time : 10:41 AM
 * @date : 2/14/2023
 * @since : 0.1.0
 **/
public interface CarRepo extends JpaRepository<Car,String> {
    @Query(value = "SELECT * FROM Car WHERE type =?1 and fuel_Type=?2 and car_Availability='AVAILABLE' ", nativeQuery = true)
    ArrayList<Car> filterCar(String type, String fuel_Type);
    @Query(value = "SELECT car_Id FROM car ORDER BY car_Id DESC LIMIT 1", nativeQuery = true)
    String generateCarId();
    @Query(value = "SELECT COUNT(car_Id) FROM Car WHERE car_Availability='AVAILABLE'", nativeQuery = true)
    int getSumAvailableCars();
    @Query(value = "SELECT COUNT(car_Id) FROM Car WHERE car_Availability='UNAVAILABLE'", nativeQuery = true)
    int getSumReservedCars();
    @Query(value = "SELECT COUNT(car_Id) FROM Car WHERE car_Availability='MAINTAIN'", nativeQuery = true)
    int getSumMaintainCars();
    @Query(value = "SELECT COUNT(car_Id) FROM Car WHERE car_Availability='UNDER_MAINTAIN';", nativeQuery = true)
    int getSumUnderMaintainCars();
    @Query(value = "SELECT * FROM Car WHERE car_Availability='AVAILABLE'", nativeQuery = true)
    ArrayList<Car> getAvailableCars();
}
