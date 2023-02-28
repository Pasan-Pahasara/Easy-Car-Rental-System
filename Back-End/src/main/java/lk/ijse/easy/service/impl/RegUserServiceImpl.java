package lk.ijse.easy.service.impl;

import lk.ijse.easy.dto.CustomDTO;
import lk.ijse.easy.dto.RegUserDTO;
import lk.ijse.easy.entity.RegUser;
import lk.ijse.easy.entity.User;
import lk.ijse.easy.enums.RoleType;
import lk.ijse.easy.repo.RegUserRepo;
import lk.ijse.easy.service.RegUserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Optional;

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
        RegUser regUser = new RegUser(regUserDTO.getUser_Id(), regUserDTO.getName(), regUserDTO.getContact_No(), regUserDTO.getAddress(), regUserDTO.getEmail(), regUserDTO.getNic(), regUserDTO.getLicense_No(), "", "", new User(regUserDTO.getUser().getUser_Id(), regUserDTO.getUser().getRole_Type(), regUserDTO.getUser().getUser_Name(), regUserDTO.getUser().getPassword()));
        if (repo.existsById(regUserDTO.getUser_Id()))
            throw new RuntimeException("User Already Exist. Please enter another id..!");

        try {
            byte[] bytes1 = regUserDTO.getLicense_Img().getBytes();
            byte[] bytes2 = regUserDTO.getNic_Img().getBytes();

//            String projectPath="D:\\IJSE\\Second Semester\\AAD (Advance API Development)\\Easy-Car-Rental-System\\Front-End\\assets\\img"

            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            File uploadsDir = new File(projectPath + "/uploads");
            System.out.println(projectPath);
            uploadsDir.mkdir();

            Path location2 = Paths.get(uploadsDir + "/nic" + regUser.getNic() + ".png");
            Path location1 = Paths.get(uploadsDir + "/license" + regUser.getLicense_No() + ".png");

            Files.write(location1, bytes1);
            Files.write(location2, bytes2);

            regUserDTO.getLicense_Img().transferTo(location1);
            regUserDTO.getNic_Img().transferTo(location2);

            regUser.setLicense_Img(location1.toString());
            regUser.setNic_Img(location2.toString());

            System.out.println(regUser);
//          repo.save(regUser);
            repo.save(mapper.map(regUser, RegUser.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteRegUser(String id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Wrong ID..Please enter valid id..!");
        }
        repo.deleteById(id);
    }

    public void updateRegUser(RegUserDTO regUserDTO) {
        System.out.println(regUserDTO);
        RegUser regUser = new RegUser(regUserDTO.getUser_Id(), regUserDTO.getName(), regUserDTO.getContact_No(), regUserDTO.getAddress(), regUserDTO.getEmail(), regUserDTO.getNic(), regUserDTO.getLicense_No(), new User(regUserDTO.getUser().getUser_Id(), regUserDTO.getUser().getRole_Type(), regUserDTO.getUser().getUser_Name(), regUserDTO.getUser().getPassword()));

        System.out.println(regUser.toString());


        if (!repo.existsById(regUserDTO.getUser_Id()))
            throw new RuntimeException("Wrong ID..No Such a User to Update..!");

        try {
            byte[] bytes1 = regUserDTO.getLicense_Img().getBytes();
            byte[] bytes2 = regUserDTO.getNic_Img().getBytes();

//            String projectPath="D:\\IJSE\\Second Semester\\AAD (Advance API Development)\\Easy-Car-Rental-System\\Front-End\\assets\\img"

            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            File uploadsDir = new File(projectPath + "/uploads");
            System.out.println(projectPath);
            uploadsDir.mkdir();

            Path location2 = Paths.get(uploadsDir + "/nic" + regUser.getNic() + ".png");
            Path location1 = Paths.get(uploadsDir + "/license" + regUser.getLicense_No() + ".png");

            Files.write(location1, bytes1);
            Files.write(location2, bytes2);

            regUserDTO.getLicense_Img().transferTo(location1);
            regUserDTO.getNic_Img().transferTo(location2);

            regUser.setLicense_Img(location1.toString());
            regUser.setNic_Img(location2.toString());

            System.out.println(regUser);
//          repo.save(regUser);
            repo.save(mapper.map(regUser, RegUser.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<RegUserDTO> getAllRegUsers() {
        return mapper.map(repo.findAll(), new TypeToken<ArrayList<RegUserDTO>>() {
        }.getType());
    }

    @Override
    public String generateCustomerId() {
        String lastId = repo.generateCustomerId();
        String id = "";

        if (lastId != null) {
            int tempId = Integer.parseInt(lastId.split("-")[1]);
            tempId = tempId + 1;
            if (tempId <= 9) {
                id = "C00-00" + tempId;
            } else if (tempId <= 99) {
                id = "C00-0" + tempId;
            } else if (tempId <= 999) {
                id = "C00-" + tempId;
            }
        } else {
            id = "C00-001";
        }
        return id;
    }

    @Override
    public CustomDTO getSumOfUsers() {
        return new CustomDTO(repo.getSumOfUsers());
    }
}
