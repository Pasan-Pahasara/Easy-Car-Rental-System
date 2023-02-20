package lk.ijse.easy.entity;

import lk.ijse.easy.enums.RequestType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author : ShEnUx
 * @time : 7:58 PM
 * @date : 2/18/2023
 * @since : 0.1.0
 **/
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Rent {
    @Id
    private String rent_Id;
    private LocalDate pick_Up_Date;
    private LocalTime pick_Up_Time;
    private LocalDate return_Date;
    @Enumerated(EnumType.STRING)
    private RequestType driver_Request_Type;
    private String location;

    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "user_RegID",referencedColumnName = "user_Id",nullable = false)
    private RegUser reg_User;
}