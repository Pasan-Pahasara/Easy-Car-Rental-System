package lk.ijse.easy.dto;

import lk.ijse.easy.embeded.Image;
import lk.ijse.easy.embeded.ImageDTO;
import lk.ijse.easy.embeded.Rate;
import lk.ijse.easy.enums.Availability;
import lk.ijse.easy.enums.CarType;
import lk.ijse.easy.enums.FuelType;
import lk.ijse.easy.enums.TransmissionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : ShEnUx
 * @time : 10:37 AM
 * @date : 2/14/2023
 * @since : 0.1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {
    private String car_Id;
    private String car_name;
    private String car_brand;
    private CarType type;
    private ImageDTO image;
    private int number_Of_Passengers;
    private TransmissionType transmission_Type;
    private FuelType fuel_Type;
    private Rate rent_Duration_Price;
    private String price_Extra_KM;
    private String registration_Number;
    private double free_Mileage;
    private String color;
    private Availability car_Availability;

}
