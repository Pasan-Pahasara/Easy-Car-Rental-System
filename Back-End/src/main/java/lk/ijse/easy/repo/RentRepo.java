package lk.ijse.easy.repo;

import lk.ijse.easy.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author : ShEnUx
 * @time : 11:50 PM
 * @date : 2/23/2023
 * @since : 0.1.0
 **/
public interface RentRepo extends JpaRepository<Rent, String> {
    @Query(value = "SELECT rentID FROM rent ORDER BY rentID DESC LIMIT 1", nativeQuery = true)
    String generateRentId();

    @Query(value = "SELECT COUNT(rentID) FROM rent", nativeQuery = true)
    int getNumberOfBookings();

    @Query(value = "SELECT COUNT(rentID) FROM Rent WHERE rentType='CONFORM'", nativeQuery = true)
    int getSumOfBookingActive();
}
