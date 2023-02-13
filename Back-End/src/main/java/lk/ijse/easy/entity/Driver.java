package lk.ijse.easy.entity;

import lk.ijse.easy.embeded.Name;
import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author : ShEnUx
 * @time : 10:35 PM
 * @date : 2/13/2023
 * @since : 0.1.0
 **/
@Entity
@Data
public class Driver {
    @Id
    private String driver_Id;
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
