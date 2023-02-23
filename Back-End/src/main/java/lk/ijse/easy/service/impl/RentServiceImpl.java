package lk.ijse.easy.service.impl;

import lk.ijse.easy.dto.RentDTO;
import lk.ijse.easy.entity.Car;
import lk.ijse.easy.entity.Driver;
import lk.ijse.easy.entity.Rent;
import lk.ijse.easy.entity.RentDetails;
import lk.ijse.easy.repo.CarRepo;
import lk.ijse.easy.repo.DriverRepo;
import lk.ijse.easy.repo.RentRepo;
import lk.ijse.easy.service.RentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;

import static lk.ijse.easy.enums.Availability.UNAVAILABLE;

/**
 * @author : ShEnUx
 * @time : 11:54 PM
 * @date : 2/23/2023
 * @since : 0.1.0
 **/
@Service
@Transactional
public class RentServiceImpl implements RentService {
    @Autowired
    private RentRepo repo;
    @Autowired
    private CarRepo carRepo;
    @Autowired
    private DriverRepo driverRepo;
    @Autowired
    private ModelMapper mapper;
    @Override
    public void bookingCars(RentDTO dto) {
        Rent rent = mapper.map(dto, Rent.class);

        if (repo.existsById(dto.getRentID())) {
            throw new RuntimeException("Booking" + dto.getRentID() + " Already added.!");
        }

        if(dto.getRequestType().equals("YES")){
            List<Driver> drivers = driverRepo.availableDrivers();
            int x;

            for (RentDetails rentDetails : rent.getRentDetails()){
                x=new Random().nextInt(drivers.size());
                rentDetails.setRentID(drivers.get(x).getUser_Id());
                Car car = carRepo.findById(rentDetails.getRentID()).get();
                car.setCar_Availability(UNAVAILABLE);
                driverRepo.save(drivers.get(x));
            }
        }
        repo.save(rent);
    }
}
