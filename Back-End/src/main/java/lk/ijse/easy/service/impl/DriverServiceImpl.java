package lk.ijse.easy.service.impl;

import lk.ijse.easy.dto.DriverDTO;
import lk.ijse.easy.entity.Driver;
import lk.ijse.easy.entity.RegUser;
import lk.ijse.easy.repo.DriverRepo;
import lk.ijse.easy.service.DriverService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

/**
 * @author : ShEnUx
 * @time : 10:49 PM
 * @date : 2/13/2023
 * @since : 0.1.0
 **/
@Service
@Transactional
public class DriverServiceImpl implements DriverService {
    @Autowired
    private DriverRepo repo;
    @Autowired
    private ModelMapper mapper;

    public void saveDriver(DriverDTO driverDTO) {
        if (repo.existsById(driverDTO.getDriver_Id())) {
            throw new RuntimeException("User Already Exist. Please enter another id..!");
        }
        repo.save(mapper.map(driverDTO, Driver.class));
    }

    public void deleteDriver(String id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Wrong ID..Please enter valid id..!");
        }
        repo.deleteById(id);
    }

    public void updateDriver(DriverDTO driverDTO) {
        if (!repo.existsById(driverDTO.getDriver_Id())) {
            throw new RuntimeException("Wrong ID..No Such a User to Update..!");
        }
        repo.save(mapper.map(driverDTO, Driver.class));
    }

    public ArrayList<DriverDTO> getAllDrivers() {
        return null;
    }
}
