package lk.ijse.easy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : ShEnUx
 * @time : 11:17 PM
 * @date : 2/23/2023
 * @since : 0.1.0
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RentDetailsDTO {
    private String carID;
    private String rentID;
    private String driverID;

}
