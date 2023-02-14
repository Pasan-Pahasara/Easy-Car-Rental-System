package lk.ijse.easy.dto;

import lk.ijse.easy.embeded.Name;
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
    private String role_Type;
    private Name name;
    private String contact_No;
    private String address;
    private String email;
    private String nic;
    private String license_No;
    private String password;
    private String nic_Img;
    private String license_Img;
}
