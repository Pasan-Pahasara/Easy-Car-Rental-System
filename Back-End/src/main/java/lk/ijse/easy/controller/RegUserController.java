package lk.ijse.easy.controller;

import lk.ijse.easy.dto.RegUserDTO;
import lk.ijse.easy.service.RegUserService;
import lk.ijse.easy.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author : ShEnUx
 * @time : 3:07 PM
 * @date : 2/13/2023
 * @since : 0.1.0
 **/
@RestController
@CrossOrigin
@RequestMapping("/customer")
public class RegUserController {
    @Autowired
    private RegUserService service;
    @PostMapping
    public ResponseUtil saveRegUser(@ModelAttribute RegUserDTO regUserDTO) {
        service.saveRegUser(regUserDTO);
        return new ResponseUtil("OK", "Successfully Registered..!", null);
    }
}
