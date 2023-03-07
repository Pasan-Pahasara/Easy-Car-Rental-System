package lk.ijse.easy.service;

import lk.ijse.easy.dto.CarDTO;
import lk.ijse.easy.dto.CustomDTO;
import lk.ijse.easy.entity.Car;

import java.util.ArrayList;

/**
 * @author : ShEnUx
 * @time : 10:43 AM
 * @date : 2/14/2023
 * @since : 0.1.0
 **/
public interface CarService {
    void saveCar(CarDTO carDTO);
    void deleteCar(String id);
    void updateCar(CarDTO carDTO);
    ArrayList<CarDTO> getAllCars();
    ArrayList<CarDTO> getFilerData(String type,String fuelType);
    Car searchCarId(String id);
    String generateCarId();
    CustomDTO getSumAvailableCars();
    CustomDTO getSumReservedCars();
    CustomDTO getSumMaintainCars();
    CustomDTO getSumUnderMaintainCars();
    ArrayList<CarDTO> getAvailableCars();
}
