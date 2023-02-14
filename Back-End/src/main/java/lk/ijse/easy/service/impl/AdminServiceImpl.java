package lk.ijse.easy.service.impl;

/**
 * @author : ShEnUx
 * @time : 9:24 AM
 * @date : 2/14/2023
 * @since : 0.1.0
 **/

import lk.ijse.easy.dto.AdminDTO;
import lk.ijse.easy.entity.Admin;
import lk.ijse.easy.entity.Driver;
import lk.ijse.easy.repo.AdminRepo;
import lk.ijse.easy.service.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepo repo;
    @Autowired
    private ModelMapper mapper;

    public void saveAdmin(AdminDTO adminDTO) {
        if (repo.existsById(adminDTO.getAdmin_Id())) {
            throw new RuntimeException("User Already Exist. Please enter another id..!");
        }
        repo.save(mapper.map(adminDTO, Admin.class));
    }

    public void deleteAdmin(String id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Wrong ID..Please enter valid id..!");
        }
        repo.deleteById(id);
    }

    public void updateAdmin(AdminDTO adminDTO) {

    }

    public ArrayList<AdminDTO> getAdmin() {
        return null;
    }
}
