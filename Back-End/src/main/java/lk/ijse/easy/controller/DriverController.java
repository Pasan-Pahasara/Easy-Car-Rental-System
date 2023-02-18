package lk.ijse.easy.controller;

import lk.ijse.easy.dto.DriverDTO;
import lk.ijse.easy.dto.UserDTO;
import lk.ijse.easy.embeded.Name;
import lk.ijse.easy.service.DriverService;
import lk.ijse.easy.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author : ShEnUx
 * @time : 10:42 PM
 * @date : 2/13/2023
 * @since : 0.1.0
 **/
@RestController
@CrossOrigin
@RequestMapping("/driver")
public class DriverController {
    @Autowired
    private DriverService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveDriver(@ModelAttribute DriverDTO driverDTO, @ModelAttribute UserDTO userDTO, @ModelAttribute Name name) {
        driverDTO.setUserDTO(userDTO);
        driverDTO.setName(name);
        service.saveDriver(driverDTO);
        System.out.println(driverDTO);
        return new ResponseUtil("OK", "Successfully Registered..!", null);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllDrivers(){
        return new ResponseUtil("OK","Successfully Loaded..!",service.getAllDrivers());
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping(params = {"user_Id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteDriver(@RequestParam(name ="user_Id") String id) {
        service.deleteDriver(id);
        return new ResponseUtil("OK","Successfully Deleted..! : "+id,null);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateDriver(@RequestBody DriverDTO driverDTO){
        service.updateDriver(driverDTO);
        return new ResponseUtil("OK","Successfully Updated..! : "+driverDTO.getUser_Id(),null);
    }
}
