package lk.ijse.easy.service.impl;

import lk.ijse.easy.dto.RegUserDTO;
import lk.ijse.easy.entity.RegUser;
import lk.ijse.easy.repo.RegUserRepo;
import lk.ijse.easy.service.RegUserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

/**
 * @author : ShEnUx
 * @time : 3:36 PM
 * @date : 2/13/2023
 * @since : 0.1.0
 **/
@Service
@Transactional
public class RegUserServiceImpl implements RegUserService {
    @Autowired
    private RegUserRepo repo;
    @Autowired
    private ModelMapper mapper;

    public void saveRegUser(RegUserDTO regUserDTO) {
        if (repo.existsById(regUserDTO.getUser_Id())) {
            throw new RuntimeException("User Already Exist. Please enter another id..!");
        }
        repo.save(mapper.map(regUserDTO, RegUser.class));
    }

    public void deleteRegUser(String id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Wrong ID..Please enter valid id..!");
        }
        repo.deleteById(id);
    }

    public void updateRegUser(RegUserDTO regUserDTO) {
        if (!repo.existsById(regUserDTO.getUser_Id())) {
            throw new RuntimeException("Wrong ID..No Such a User to Update..!");
        }
        repo.save(mapper.map(regUserDTO, RegUser.class));
    }

    public ArrayList<RegUserDTO> getAllRegUsers() {
        return mapper.map(repo.findAll(), new TypeToken<ArrayList<RegUserDTO>>() {}.getType());
    }
}
