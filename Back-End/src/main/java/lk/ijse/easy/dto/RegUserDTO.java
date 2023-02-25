package lk.ijse.easy.dto;

import lk.ijse.easy.embeded.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;


/**
 * @author : ShEnUx
 * @time : 3:17 PM
 * @date : 2/13/2023
 * @since : 0.1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegUserDTO {
    private String user_Id;
    private Name name;
    private String contact_No;
    private String address;
    private String email;
    private String nic;
    private String license_No;
    private MultipartFile nic_Img;
    private MultipartFile license_Img;
    private UserDTO user;

}
