package lk.ijse.easy.controller;

import lk.ijse.easy.dto.RentDTO;
import lk.ijse.easy.service.RentService;
import lk.ijse.easy.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author : ShEnUx
 * @time : 11:32 PM
 * @date : 2/23/2023
 * @since : 0.1.0
 **/
@RestController
@CrossOrigin
@RequestMapping("/rent")
public class rentController {
    @Autowired
    private RentService service;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllRents(){
        return new ResponseUtil("OK","Successfully Loaded..!",service.getAllRents());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil placeOrder(@RequestBody RentDTO dto) {
        service.bookingCars(dto);
        return new ResponseUtil("Ok", "Successfully Purchased.!", null);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "/generateRentId", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil generateRentId() {
        return new ResponseUtil("OK", "Successfully Generated ID..!", service.generateRentId());
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "/dailyBookings", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getNumberOfBookings() {
        return new ResponseUtil("OK", "Successfully Loaded Count..!", service.getNumberOfBookings());
    }
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "/dailyActiveBookings", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getSumOfBookingActive() {
        return new ResponseUtil("OK", "Successfully Loaded Count..!", service.getSumOfBookingActive());
    }
}
