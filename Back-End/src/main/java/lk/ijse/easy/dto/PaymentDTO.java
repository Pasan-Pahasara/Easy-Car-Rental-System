package lk.ijse.easy.dto;

import lk.ijse.easy.entity.Rent;
import lk.ijse.easy.enums.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author : ShEnUx
 * @time : 2:51 PM
 * @date : 2/26/2023
 * @since : 0.1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PaymentDTO {
    private String paymentID;
    private RentDTO rentID;
    private PaymentType paymentType;
    private String date;
    private String time;
    private Double lostDamage;
    private Double rentFee;
    private Double driverFee;
    private Double total;
}
