package lk.ijse.easy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author : ShEnUx
 * @time : 9:16 PM
 * @date : 2/18/2023
 * @since : 0.1.0
 **/
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@IdClass(DriverSchedule_PK.class)
public class DriverSchedule {
    @Id
    private String driver_Id;
    @Id
    private String rent_Id;

    @ManyToOne
    @JoinColumn(name = "driver_Id",referencedColumnName = "user_Id",insertable = false,updatable = false)
    private Driver driver;

    @ManyToOne
    @JoinColumn(name = "rent_Id",referencedColumnName = "rent_Id",insertable = false,updatable = false)
    private Rent rent;
}
