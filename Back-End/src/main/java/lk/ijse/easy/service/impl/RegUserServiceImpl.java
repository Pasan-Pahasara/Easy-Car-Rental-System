package lk.ijse.easy.service.impl;

import lk.ijse.easy.dto.RegUserDTO;
import lk.ijse.easy.service.RegUserService;
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
    public void saveRegUser(RegUserDTO regUserDTO) {

    }

    public void deleteRegUser(String id) {

    }

    public void updateRegUser(RegUserDTO regUserDTO) {

    }

    public ArrayList<RegUserDTO> getAllRegUsers() {
        return null;
    }
}
