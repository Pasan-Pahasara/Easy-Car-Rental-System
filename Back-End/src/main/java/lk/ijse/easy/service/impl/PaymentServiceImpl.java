package lk.ijse.easy.service.impl;

import lk.ijse.easy.dto.PaymentDTO;
import lk.ijse.easy.entity.Payment;
import lk.ijse.easy.repo.PaymentRepo;
import lk.ijse.easy.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

/**
 * @author : ShEnUx
 * @time : 2:14 PM
 * @date : 2/26/2023
 * @since : 0.1.0
 **/
@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepo paymentRepo;
    @Autowired
    private ModelMapper mapper;
    @Override
    public String generatePaymentId() {
        String lastId = paymentRepo.generatePaymentId();
        String id = "";

        if (lastId != null) {
            int tempId = Integer.parseInt(lastId.split("-")[1]);
            tempId = tempId + 1;
            if (tempId <= 9) {
                id = "P00-00" + tempId;
            } else if (tempId <= 99) {
                id = "P00-0" + tempId;
            } else if (tempId <= 999) {
                id = "P00-" + tempId;
            }
        } else {
            id = "P00-001";
        }
        return id;
    }

    @Override
    public void savePayment(PaymentDTO paymentDTO) {
        if (paymentRepo.existsById(paymentDTO.getPaymentID())) {
            throw new RuntimeException("User Already Exist. Please enter another id..!");
        }
        System.out.println(paymentDTO);
        paymentRepo.save(mapper.map(paymentDTO, Payment.class));
    }

    @Override
    public ArrayList<PaymentDTO> getAllPayments() {
        return mapper.map(paymentRepo.findAll(),new TypeToken<ArrayList<PaymentDTO>>() {}.getType());
    }
}
