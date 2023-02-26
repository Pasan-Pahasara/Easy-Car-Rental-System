package lk.ijse.easy.service;

import lk.ijse.easy.dto.PaymentDTO;

import java.util.ArrayList;

/**
 * @author : ShEnUx
 * @time : 2:12 PM
 * @date : 2/26/2023
 * @since : 0.1.0
 **/
public interface PaymentService {
    String generatePaymentId();
    void savePayment(PaymentDTO paymentDTO);
    ArrayList<PaymentDTO> getAllPayments();
}
