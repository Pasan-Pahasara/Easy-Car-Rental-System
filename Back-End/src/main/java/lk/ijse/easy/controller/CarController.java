package lk.ijse.easy.controller;

import lk.ijse.easy.dto.CarDTO;
import lk.ijse.easy.embeded.ImageDTO;
import lk.ijse.easy.embeded.Rate;
import lk.ijse.easy.entity.Car;
import lk.ijse.easy.service.CarService;
import lk.ijse.easy.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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
    @PostMapping
    public ResponseUtil saveCar(@ModelAttribute CarDTO carDTO, @ModelAttribute Rate rent_Duration_Price, @ModelAttribute ImageDTO image) {
        carDTO.setRent_Duration_Price(rent_Duration_Price);
        carDTO.setImage(image);
        service.saveCar(carDTO);
        return new ResponseUtil("OK", "Successfully Registered..!", null);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCars(){
        return new ResponseUtil("OK","Successfully Loaded..!",service.getAllCars());
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping(params = {"car_Id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteCar(@RequestParam(name ="car_Id") String id) {
        service.deleteCar(id);
        return new ResponseUtil("OK","Successfully Deleted..! : "+id,null);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping(path = "/update")
    public ResponseUtil updateCar(@ModelAttribute CarDTO carDTO, @ModelAttribute Rate rent_Duration_Price, @ModelAttribute ImageDTO image){
        carDTO.setRent_Duration_Price(rent_Duration_Price);
        carDTO.setImage(image);
        service.updateCar(carDTO);
        return new ResponseUtil("OK","Successfully Updated..! : "+carDTO.getCar_Id(),null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/filterCarDetails",params = {"type","fuel_Type"})
    public ArrayList<CarDTO> searchDriverId(@RequestParam String type, @RequestParam String fuel_Type) {
        System.out.println(type);
        System.out.println(fuel_Type);
        return service.getFilerData(type,fuel_Type);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/searchCar", params = {"car_Id"})
    public Car searchCusId(String car_Id) {
        return service.searchCarId(car_Id);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "/generateCarId", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil generateCarId() {
        return new ResponseUtil("OK", "Successfully Generated ID..!", service.generateCarId());
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "/numberOfAvailableCars", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getSumAvailableCars() {
        return new ResponseUtil("OK", "Successfully Loaded Count..!", service.getSumAvailableCars());
    }
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "/numberOfReservedCars", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getSumReservedCars() {
        return new ResponseUtil("OK", "Successfully Loaded Count..!", service.getSumReservedCars());
    }
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "/numberOfMaintenanceCars", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getSumMaintainCars() {
        return new ResponseUtil("OK", "Successfully Loaded Count..!", service.getSumMaintainCars());
    }
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "/numberOfUnderMaintenanceCars", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getSumUnderMaintainCars() {
        return new ResponseUtil("OK", "Successfully Loaded Count..!", service.getSumUnderMaintainCars());
    }
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "/getAvailableCars")
    public ResponseUtil getAvailableCars() {
        return new ResponseUtil("OK", "Successfully Loaded Available Cars..!", service.getAvailableCars());
    }
}
