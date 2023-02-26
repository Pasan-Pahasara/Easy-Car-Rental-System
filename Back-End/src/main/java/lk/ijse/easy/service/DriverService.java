package lk.ijse.easy.service;

import lk.ijse.easy.dto.CustomDTO;
import lk.ijse.easy.dto.DriverDTO;

import java.util.ArrayList;

/**
 * @author : ShEnUx
 * @time : 10:45 PM
 * @date : 2/13/2023
 * @since : 0.1.0
 **/
public interface DriverService {
    void saveDriver(DriverDTO driverDTO);
    void deleteDriver(String id);
    void updateDriver(DriverDTO driverDTO);
    ArrayList<DriverDTO> getAllDrivers();
    CustomDTO getSumAvailableDrivers();
    ArrayList<DriverDTO> getAllAvailableDriver();
}
