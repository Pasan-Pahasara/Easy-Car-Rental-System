package lk.ijse.easy.service.impl;

import lk.ijse.easy.dto.RentDTO;
import lk.ijse.easy.entity.Car;
import lk.ijse.easy.entity.Driver;
import lk.ijse.easy.entity.Rent;
import lk.ijse.easy.entity.RentDetails;
import lk.ijse.easy.enums.DriverRequestType;
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

        System.out.println(dto);

        if(dto.getDriverRequestType().equals("YES")){
            List<Driver> drivers = driverRepo.availableDrivers();
            int x;

            System.out.println("come");

            for (RentDetails rentDetails : rent.getRentDetails()){
                x=new Random().nextInt(drivers.size());
                rentDetails.setDriverID(drivers.get(x).getUser_Id());
                Car car = carRepo.findById(rentDetails.getCarID()).get();
                car.setCar_Availability(UNAVAILABLE);
                carRepo.save(car);
                drivers.get(x).setDriver_Availability(UNAVAILABLE);
                driverRepo.save(drivers.get(x));
            }
        }
        repo.save(rent);
    }

    @Override
    public String generateRentId() {
        String lastId = repo.generateRentId();
        String id = "";

        if (lastId != null) {
            int tempId = Integer.parseInt(lastId.split("-")[1]);
            tempId = tempId + 1;
            if (tempId <= 9) {
                id = "RE0-00" + tempId;
            } else if (tempId <= 99) {
                id = "RE0-0" + tempId;
            } else if (tempId <= 999) {
                id = "RE0-" + tempId;
            }
        } else {
            id = "RE0-001";
        }
        return id;
    }
}
