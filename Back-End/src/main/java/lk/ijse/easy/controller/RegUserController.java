package lk.ijse.easy.controller;

import lk.ijse.easy.dto.RegUserDTO;
import lk.ijse.easy.dto.UserDTO;
import lk.ijse.easy.embeded.Name;
import lk.ijse.easy.service.RegUserService;
import lk.ijse.easy.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static lk.ijse.easy.enums.RoleType.REGISTERED_USER;

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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveRegUser(@ModelAttribute RegUserDTO regUserDTO, @ModelAttribute UserDTO userDTO, @ModelAttribute Name name) {
        regUserDTO.setUser(userDTO);
        regUserDTO.setName(name);
        service.saveRegUser(regUserDTO);
        return new ResponseUtil("OK", "Successfully Registered..!", null);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllRegUser(){
        return new ResponseUtil("OK","Successfully Loaded..!",service.getAllRegUsers());
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping(params = {"user_Id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteRegUser(@RequestParam(name ="user_Id") String id) {
        service.deleteRegUser(id);
        return new ResponseUtil("OK","Successfully Deleted..! : "+id,null);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping(path = "/update")
    public ResponseUtil updateRegUser(@ModelAttribute RegUserDTO regUserDTO, @ModelAttribute UserDTO userDTO, @ModelAttribute Name name){
        regUserDTO.setUser(userDTO);
        regUserDTO.setName(name);
        regUserDTO.getUser().setRole_Type(REGISTERED_USER);
        service.updateRegUser(regUserDTO);
        return new ResponseUtil("OK","Successfully Updated..! : "+regUserDTO.getUser_Id(),null);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "/generateCustomerId", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil generateCustomerId() {
        return new ResponseUtil("OK", "Successfully Generated ID..!", service.generateCustomerId());
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "/numberOfUsers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getSumOfUsers() {
        return new ResponseUtil("OK", "Successfully Loaded Count..!", service.getSumOfUsers());
    }
}
