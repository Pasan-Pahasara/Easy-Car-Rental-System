package lk.ijse.easy.controller;

import lk.ijse.easy.dto.CarDTO;
import lk.ijse.easy.service.CarService;
import lk.ijse.easy.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author : ShEnUx
 * @time : 10:40 AM
 * @date : 2/14/2023
 * @since : 0.1.0
 **/
@RestController
@CrossOrigin
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveCar(@RequestBody CarDTO carDTO) {
        service.saveCar(carDTO);
        return new ResponseUtil("OK", "Successfully Registered..!", null);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCars(){
        return new ResponseUtil("OK","Successfully Loaded..!",service.getAllCars());
    }
}
