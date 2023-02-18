package lk.ijse.easy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author : ShEnUx
 * @time : 9:00 PM
 * @date : 2/18/2023
 * @since : 0.1.0
 **/
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Payment {
    @Id
    private String payment_Id;
    private LocalDate payment_Date;
    private double amount;
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "rent_Id",referencedColumnName = "rent_Id",nullable = false)
    private Rent rent;
}
