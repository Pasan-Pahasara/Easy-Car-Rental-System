package lk.ijse.easy.entity;

import lk.ijse.easy.embeded.Name;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author : ShEnUx
 * @time : 3:09 PM
 * @date : 2/13/2023
 * @since : 0.1.0
 **/
@Entity
@NoArgsConstructor
@Data
public class RegUser {
    @Id
    private String user_Id;

    @Embedded
    private Name name;
    private String contact_No;
    private String address;
    private String email;
    private String nic;
    private String license_No;
    private String nic_Img;
    private String license_Img;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;
}
