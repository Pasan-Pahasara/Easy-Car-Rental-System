package lk.ijse.easy.controller;

import lk.ijse.easy.dto.DriverDTO;
import lk.ijse.easy.dto.PaymentDTO;
import lk.ijse.easy.service.PaymentService;
import lk.ijse.easy.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author : ShEnUx
 * @time : 1:49 PM
 * @date : 2/26/2023
 * @since : 0.1.0
 **/
@RestController
@CrossOrigin
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService service;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllPayments(){
        return new ResponseUtil("OK","Successfully Loaded..!",service.getAllPayments());
    }
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "/generatePaymentId", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil generatePaymentId() {
        return new ResponseUtil("OK", "Successfully Generated ID..!", service.generatePaymentId());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil savePayment(@RequestBody PaymentDTO paymentDTO) {
        service.savePayment(paymentDTO);
        return new ResponseUtil("OK", "Successfully Registered..!", null);
    }
}
