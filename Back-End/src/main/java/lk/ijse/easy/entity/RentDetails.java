package lk.ijse.easy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author : ShEnUx
 * @time : 8:40 PM
 * @date : 2/18/2023
 * @since : 0.1.0
 **/
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@IdClass(RentDetail_PK.class)
public class RentDetails {
    @Id
    private String car_Id;
    @Id
    private String rent_Id;

    @ManyToOne
    @JoinColumn(name = "rent_Id",referencedColumnName = "rent_Id",insertable = false,updatable = false)
    private Rent rent;

    @ManyToOne
    @JoinColumn(name = "car_Id",referencedColumnName = "car_Id",insertable = false,updatable = false)
    private Car car;
}
