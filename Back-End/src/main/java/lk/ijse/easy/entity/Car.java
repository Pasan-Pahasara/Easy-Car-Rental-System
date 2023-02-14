package lk.ijse.easy.entity;

import lk.ijse.easy.embeded.Image;
import lk.ijse.easy.embeded.Rate;
import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author : ShEnUx
 * @time : 10:21 AM
 * @date : 2/14/2023
 * @since : 0.1.0
 **/
@Entity
@Data
public class Car {
    @Id
    private String car_Id;
    private String name;
    private String brand;
    private String type;
    @Embedded
    private Image image;
    private int number_Of_Passengers;
    private String transmission_Type;
    private String fuel_Type;
    @Embedded
    private Rate rent_Duration_Price;
    private String price_Extra_KM;
    private  String registration_Number;
    private int car_qty;
    private String color;
}
