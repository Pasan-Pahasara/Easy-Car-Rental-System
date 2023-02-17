package lk.ijse.easy.dto;

import lk.ijse.easy.enums.RoleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : ShEnUx
 * @time : 1:08 PM
 * @date : 2/14/2023
 * @since : 0.1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String user_Id;
    private RoleType role_Type;
    private String user_Name;
    private String password;

    public UserDTO(RoleType role_Type, String user_Name, String password) {
        this.role_Type = role_Type;
        this.user_Name = user_Name;
        this.password = password;
    }
}
