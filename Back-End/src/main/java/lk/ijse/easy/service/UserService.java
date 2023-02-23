package lk.ijse.easy.service;

import lk.ijse.easy.dto.UserDTO;

import java.util.ArrayList;

/**
 * @author : ShEnUx
 * @time : 11:22 PM
 * @date : 2/21/2023
 * @since : 0.1.0
 **/
public interface UserService {
    ArrayList<UserDTO> getAllRegUsers();
    UserDTO getRegUsers(String username,String password);
}
