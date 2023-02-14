package lk.ijse.easy.entity;

import lk.ijse.easy.embeded.Name;
import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author : ShEnUx
 * @time : 9:05 AM
 * @date : 2/14/2023
 * @since : 0.1.0
 **/
@Entity
@Data
public class Admin {
    @Id
    private String admin_Id;
    private String role_Type;
    @Embedded
    private Name name;
    private String contact_No;
    private String address;
    private String email;
    private String nic;
    private String password;
}
