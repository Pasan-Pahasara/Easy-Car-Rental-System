package lk.ijse.easy.service;

import lk.ijse.easy.dto.DriverDTO;
import lk.ijse.easy.dto.RegUserDTO;
import lk.ijse.easy.entity.Driver;

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
}
