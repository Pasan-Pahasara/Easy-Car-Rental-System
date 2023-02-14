package lk.ijse.easy.dto;

import lk.ijse.easy.embeded.Name;
import lk.ijse.easy.enums.Availability;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author : ShEnUx
 * @time : 10:38 PM
 * @date : 2/13/2023
 * @since : 0.1.0
 **/
@Data
@NoArgsConstructor
public class DriverDTO {
    private String driver_Id;
    private Name name;
    private String contact_No;
    private String address;
    private String email;
    private String nic_No;
    private String license_No;
    private Availability driver_Availability;
    private UserDTO user;
}
