package lk.ijse.easy.entity;

import lk.ijse.easy.embeded.Name;
import lk.ijse.easy.enums.Availability;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@Data
public class Driver {
    @Id
    private String user_Id;

    @Embedded
    private Name name;
    private String contact_No;
    private String address;
    private String email;

    @Enumerated(EnumType.STRING)
    private Availability driver_Availability;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;
}
