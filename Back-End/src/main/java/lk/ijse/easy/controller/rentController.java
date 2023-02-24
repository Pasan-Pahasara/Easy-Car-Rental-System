package lk.ijse.easy.controller;

import lk.ijse.easy.dto.RentDTO;
import lk.ijse.easy.service.RentService;
import lk.ijse.easy.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil placeOrder(@RequestBody RentDTO dto) {
        service.bookingCars(dto);
        return new ResponseUtil("Ok", "Successfully Purchased.!", null);
    }
}