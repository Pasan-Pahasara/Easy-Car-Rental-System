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
    private String paymentID;
    private LocalDate paymentDate;
    private double amount;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "rentID", referencedColumnName = "rentID", nullable = false)
    private Rent rent;
}
