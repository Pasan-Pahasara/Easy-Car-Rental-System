package lk.ijse.easy.service.impl;

import lk.ijse.easy.dto.CustomDTO;
import lk.ijse.easy.dto.DriverDTO;
import lk.ijse.easy.dto.RegUserDTO;
import lk.ijse.easy.dto.RentDTO;
import lk.ijse.easy.entity.*;
import lk.ijse.easy.enums.DriverRequestType;
import lk.ijse.easy.repo.CarRepo;
import lk.ijse.easy.repo.DriverRepo;
import lk.ijse.easy.repo.RentRepo;
import lk.ijse.easy.service.RentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static lk.ijse.easy.enums.Availability.AVAILABLE;
import static lk.ijse.easy.enums.Availability.UNAVAILABLE;
import static lk.ijse.easy.enums.RentRequestType.CONFORM;
import static lk.ijse.easy.enums.RentRequestType.REJECT;

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
    private RentRepo rentRepo;
    @Autowired
    private ModelMapper mapper;

    @Override
    public void bookingCars(RentDTO dto) {
        Rent rent = mapper.map(dto, Rent.class);

        if (repo.existsById(dto.getRentID())) {
            throw new RuntimeException("Booking" + dto.getRentID() + " Already added.!");
        }


        if (dto.getDriverRequestType().equals(DriverRequestType.YES)) {
            List<Driver> drivers = driverRepo.availableDrivers();
            int x;

            System.out.println(drivers);

            for (RentDetails rentDetails : rent.getRentDetails()) {
                x = new Random().nextInt(drivers.size());
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
    public void deleteRent(String id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Wrong ID..Please enter valid id..!");
        }

        Rent rent = rentRepo.findById(id).get();
        Driver drivers = driverRepo.findById(rent.getRentDetails().get(0).getDriverID()).get();
        Car car = carRepo.findById(rent.getRentDetails().get(0).getCarID()).get();

        if (rent.getRentDetails().get(0).getDriverID() != null) {
            drivers.setDriver_Availability(AVAILABLE);
            driverRepo.save(drivers);
            car.setCar_Availability(AVAILABLE);
            carRepo.save(car);
        }
        repo.deleteById(id);
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

    @Override
    public CustomDTO getNumberOfBookings() {
        return new CustomDTO(repo.getNumberOfBookings());
    }

    @Override
    public CustomDTO getSumOfBookingActive() {
        return new CustomDTO(repo.getSumOfBookingActive());
    }

    @Override
    public ArrayList<RentDTO> getAllRents() {
        return mapper.map(repo.findAll(), new TypeToken<ArrayList<RentDTO>>() {
        }.getType());
    }

    @Override
    public void bookingConfirm(String rentID, String driverId) {
        Rent rent = rentRepo.findById(rentID).get();
        if (rent.getRentDetails().get(0).getDriverID() != null) {

            Driver drivers = driverRepo.findById(rent.getRentDetails().get(0).getDriverID()).get();
            drivers.setDriver_Availability(AVAILABLE);
            driverRepo.save(drivers);

            rent.getRentDetails().get(0).setDriverID(driverId);
            Driver driver = driverRepo.findById(rent.getRentDetails().get(0).getDriverID()).get();
            driver.setDriver_Availability(UNAVAILABLE);
            rent.setRentType(CONFORM);
            rentRepo.save(rent);
        }
        if (rent.getRentDetails().get(0).getDriverID() == null) {
            rent.setRentType(CONFORM);
            rentRepo.save(rent);
        }
    }

    @Override
    public void bookingReject(String rentID, String driverId) {
        Rent rent = rentRepo.findById(rentID).get();
        if (rent.getRentDetails().get(0).getDriverID() != null) {

            Driver drivers = driverRepo.findById(rent.getRentDetails().get(0).getDriverID()).get();
            drivers.setDriver_Availability(AVAILABLE);
            driverRepo.save(drivers);

            Car car = carRepo.findById(rent.getRentDetails().get(0).getCarID()).get();
            car.setCar_Availability(AVAILABLE);
            carRepo.save(car);

            rent.setRentType(REJECT);
            rentRepo.save(rent);
        }
        if (rent.getRentDetails().get(0).getDriverID() == null) {
            Car car = carRepo.findById(rent.getRentDetails().get(0).getCarID()).get();
            car.setCar_Availability(AVAILABLE);
            carRepo.save(car);

            rent.setRentType(REJECT);
            rentRepo.save(rent);
        }
    }

}
