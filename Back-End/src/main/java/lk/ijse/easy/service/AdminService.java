package lk.ijse.easy.service;

import lk.ijse.easy.dto.AdminDTO;

import java.util.ArrayList;

/**
 * @author : ShEnUx
 * @time : 9:13 AM
 * @date : 2/14/2023
 * @since : 0.1.0
 **/
public interface AdminService {
    void saveAdmin(AdminDTO adminDTO);
    void deleteAdmin(String id);
    void updateAdmin(AdminDTO adminDTO);
    ArrayList<AdminDTO> getAdmin();
}
