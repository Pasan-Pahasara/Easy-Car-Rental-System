package lk.ijse.easy.dto;

import lk.ijse.easy.embeded.Name;
import lombok.Data;

import javax.persistence.Embedded;

/**
 * @author : ShEnUx
 * @time : 3:17 PM
 * @date : 2/13/2023
 * @since : 0.1.0
 **/
@Data
public class RegUserDTO {
    private String user_Id;
    private String role_Type;
    @Embedded
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
