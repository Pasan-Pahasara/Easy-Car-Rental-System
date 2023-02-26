package lk.ijse.easy.repo;

import lk.ijse.easy.entity.Car;
import lk.ijse.easy.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author : ShEnUx
 * @time : 2:15 PM
 * @date : 2/26/2023
 * @since : 0.1.0
 **/
public interface PaymentRepo extends JpaRepository<Payment,String> {
    @Query(value = "SELECT paymentID FROM payment ORDER BY paymentID DESC LIMIT 1;", nativeQuery = true)
    String generatePaymentId();
}
