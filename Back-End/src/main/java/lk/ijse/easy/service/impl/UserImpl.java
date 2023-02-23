package lk.ijse.easy.service.impl;

import lk.ijse.easy.dto.RegUserDTO;
import lk.ijse.easy.dto.UserDTO;
import lk.ijse.easy.repo.UserRepo;
import lk.ijse.easy.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

/**
 * @author : ShEnUx
 * @time : 11:23 PM
 * @date : 2/21/2023
 * @since : 0.1.0
 **/
@Service
@Transactional
public class UserImpl implements UserService {
    @Autowired
    private UserRepo repo;
    @Autowired
    private ModelMapper mapper;
    @Override
    public ArrayList<UserDTO> getAllRegUsers() {
        return mapper.map(repo.findAll(), new TypeToken<ArrayList<UserDTO>>() {
        }.getType());
    }

    @Override
    public UserDTO getRegUsers(String username, String password) {
       return mapper.map(repo.findUserByUser_NameAndPassword(username,password),UserDTO.class);
    }
}
