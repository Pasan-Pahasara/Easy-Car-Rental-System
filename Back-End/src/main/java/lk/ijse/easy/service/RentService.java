package lk.ijse.easy.service;

import lk.ijse.easy.dto.CustomDTO;
import lk.ijse.easy.dto.RentDTO;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author : ShEnUx
 * @time : 11:53 PM
 * @date : 2/23/2023
 * @since : 0.1.0
 **/
public interface RentService {
    void bookingCars(@RequestBody RentDTO dto);
    String generateRentId();
    CustomDTO getNumberOfBookings();
    CustomDTO getSumOfBookingActive();
}
