package lk.ijse.easy.dto;

import lk.ijse.easy.entity.RegUser;
import lk.ijse.easy.enums.RentRequestType;
import lk.ijse.easy.enums.RequestType;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * @author : ShEnUx
 * @time : 11:10 PM
 * @date : 2/23/2023
 * @since : 0.1.0
 **/
public class RentDTO {
    private String rentID;
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private LocalDate returnDate;
    private LocalTime returnTime;
    private RequestType requestType;
    private RentRequestType rentType;
    private String location;
    private RegUser regUser;

//    private List<DriverSchedule> driverSchedules;
    private List<RentDetailsDTO> rentDetails;
}
