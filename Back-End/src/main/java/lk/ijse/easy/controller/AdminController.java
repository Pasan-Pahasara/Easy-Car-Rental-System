package lk.ijse.easy.controller;

import lk.ijse.easy.dto.AdminDTO;
import lk.ijse.easy.dto.RegUserDTO;
import lk.ijse.easy.service.AdminService;
import lk.ijse.easy.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author : ShEnUx
 * @time : 9:08 AM
 * @date : 2/14/2023
 * @since : 0.1.0
 **/
@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveAdmin(@RequestBody AdminDTO adminDTO) {
        service.saveAdmin(adminDTO);
        return new ResponseUtil("OK", "Successfully Registered..!", null);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAdmin(){
        return new ResponseUtil("OK","Successfully Loaded..!",service.getAdmin());
    }
}
