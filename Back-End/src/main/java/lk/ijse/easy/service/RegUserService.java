package lk.ijse.easy.service;

import lk.ijse.easy.dto.CustomDTO;
import lk.ijse.easy.dto.RegUserDTO;

import java.util.ArrayList;

/**
 * @author : ShEnUx
 * @time : 3:23 PM
 * @date : 2/13/2023
 * @since : 0.1.0
 **/
public interface RegUserService {
    void saveRegUser(RegUserDTO regUserDTO);
    void deleteRegUser(String id);
    void updateRegUser(RegUserDTO regUserDTO);
    ArrayList<RegUserDTO> getAllRegUsers();
    String generateCustomerId();
    CustomDTO getSumOfUsers();
}
