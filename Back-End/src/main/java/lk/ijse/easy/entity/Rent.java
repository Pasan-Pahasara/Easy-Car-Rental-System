package lk.ijse.easy.entity;

import lk.ijse.easy.enums.RentRequestType;
import lk.ijse.easy.enums.DriverRequestType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

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
    private String rentID;
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private LocalDate returnDate;
    private LocalTime returnTime;
    @Enumerated(EnumType.STRING)
    private DriverRequestType driverRequestType;
    @Enumerated(EnumType.STRING)
    private RentRequestType rentType;
    private String location;

    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "userID",referencedColumnName = "user_Id",nullable = false)
    private RegUser regUser;

    @OneToMany(mappedBy = "rent",cascade = CascadeType.ALL)
    private List<RentDetails> rentDetails;

}
