package lk.ijse.easy.dto;

import lk.ijse.easy.embeded.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author : ShEnUx
 * @time : 9:07 AM
 * @date : 2/14/2023
 * @since : 0.1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDTO {
    private String admin_Id;
    private Name name;
    private String contact_No;
    private String address;
    private String email;
    private String nic;
    private UserDTO user;
}
