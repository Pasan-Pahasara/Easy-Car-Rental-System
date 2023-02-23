package lk.ijse.easy.service.impl;

import lk.ijse.easy.dto.CarDTO;
import lk.ijse.easy.embeded.Image;
import lk.ijse.easy.entity.Car;
import lk.ijse.easy.enums.Availability;
import lk.ijse.easy.enums.CarType;
import lk.ijse.easy.enums.FuelType;
import lk.ijse.easy.enums.TransmissionType;
import lk.ijse.easy.repo.CarRepo;
import lk.ijse.easy.service.CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 * @author : ShEnUx
 * @time : 10:45 AM
 * @date : 2/14/2023
 * @since : 0.1.0
 **/
@Service
@Transactional
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepo repo;
    @Autowired
    private ModelMapper mapper;

    public void saveCar(CarDTO carDTO) {
        Car car = new Car(carDTO.getCar_Id(), carDTO.getCar_name(), carDTO.getCar_brand(), carDTO.getType(), new Image(), carDTO.getNumber_Of_Passengers(), carDTO.getTransmission_Type(), carDTO.getFuel_Type(), carDTO.getRent_Duration_Price(), carDTO.getPrice_Extra_KM(), carDTO.getRegistration_Number(), carDTO.getFree_Mileage(), carDTO.getColor(), carDTO.getCar_Availability());
        if (repo.existsById(carDTO.getCar_Id())) {
            throw new RuntimeException("Car Already Exist. Please enter another id..!");
        }

        try {

            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            File uploadsDir = new File(projectPath + "/uploads");
            System.out.println(projectPath);
            uploadsDir.mkdir();

            carDTO.getImage().getFront_View().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + carDTO.getImage().getFront_View().getOriginalFilename()));
            carDTO.getImage().getBack_View().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + carDTO.getImage().getBack_View().getOriginalFilename()));
            carDTO.getImage().getSide_View().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + carDTO.getImage().getSide_View().getOriginalFilename()));
            carDTO.getImage().getInterior().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + carDTO.getImage().getInterior().getOriginalFilename()));

            car.getImage().setFront_View("uploads/" + carDTO.getImage().getFront_View().getOriginalFilename());
            car.getImage().setBack_View("uploads/" + carDTO.getImage().getBack_View().getOriginalFilename());
            car.getImage().setSide_View("uploads/" + carDTO.getImage().getSide_View().getOriginalFilename());
            car.getImage().setInterior("uploads/" + carDTO.getImage().getInterior().getOriginalFilename());

        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }

        System.out.println(car);
        repo.save(car);
    }

    public void deleteCar(String id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Wrong ID..Please enter valid id..!");
        }
        repo.deleteById(id);
    }

    public void updateCar(CarDTO carDTO) {
        Car car = new Car(carDTO.getCar_Id(), carDTO.getCar_name(), carDTO.getCar_brand(), carDTO.getType(), new Image(), carDTO.getNumber_Of_Passengers(), carDTO.getTransmission_Type(), carDTO.getFuel_Type(), carDTO.getRent_Duration_Price(), carDTO.getPrice_Extra_KM(), carDTO.getRegistration_Number(), carDTO.getFree_Mileage(), carDTO.getColor(), carDTO.getCar_Availability());
        if (!repo.existsById(carDTO.getCar_Id())) {
            throw new RuntimeException("Wrong ID..No Such a User to Update..!");
        }

        try {

            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            File uploadsDir = new File(projectPath + "/uploads");
            System.out.println(projectPath);
            uploadsDir.mkdir();

            carDTO.getImage().getFront_View().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + carDTO.getImage().getFront_View().getOriginalFilename()));
            carDTO.getImage().getBack_View().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + carDTO.getImage().getBack_View().getOriginalFilename()));
            carDTO.getImage().getSide_View().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + carDTO.getImage().getSide_View().getOriginalFilename()));
            carDTO.getImage().getInterior().transferTo(new File(uploadsDir.getAbsolutePath() + "/" + carDTO.getImage().getInterior().getOriginalFilename()));

            car.getImage().setFront_View("uploads/" + carDTO.getImage().getFront_View().getOriginalFilename());
            car.getImage().setBack_View("uploads/" + carDTO.getImage().getBack_View().getOriginalFilename());
            car.getImage().setSide_View("uploads/" + carDTO.getImage().getSide_View().getOriginalFilename());
            car.getImage().setInterior("uploads/" + carDTO.getImage().getInterior().getOriginalFilename());

        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }

        System.out.println(car);
        repo.save(car);
    }

    public ArrayList<CarDTO> getAllCars() {
        return mapper.map(repo.findAll(), new TypeToken<ArrayList<CarDTO>>() {
        }.getType());
    }
}
