package lk.ijse.easy.entity;

import lk.ijse.easy.embeded.Name;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author : ShEnUx
 * @time : 10:35 PM
 * @date : 2/13/2023
 * @since : 0.1.0
 **/
@Entity
@NoArgsConstructor
@Data
public class Driver {
    @Id
    private String driver_Id;

    @Embedded
    private Name name;
    private String contact_No;
    private String address;
    private String email;
    private String nic_No;
    private String license_No;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;
}
