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
//@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@IdClass(DriverSchedule_PK.class)
public class DriverSchedule {
    @Id
    private String driverID;
    @Id
    private String rentID;

    @ManyToOne
    @JoinColumn(name = "driverID",referencedColumnName = "user_Id",insertable = false,updatable = false)
    private Driver driver;

    @ManyToOne
    @JoinColumn(name = "rentID",referencedColumnName = "rentID",insertable = false,updatable = false)
    private Rent rent;
}
