package lk.ijse.easy.dto;

import lk.ijse.easy.embeded.Name;
import lk.ijse.easy.enums.Availability;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;


/**
 * @author : ShEnUx
 * @time : 10:38 PM
 * @date : 2/13/2023
 * @since : 0.1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverDTO {
    private String user_Id;
    private Name name;
    private String contact_No;
    private String address;
    private String email;
    private Availability driver_Availability;
    private UserDTO user;
}
