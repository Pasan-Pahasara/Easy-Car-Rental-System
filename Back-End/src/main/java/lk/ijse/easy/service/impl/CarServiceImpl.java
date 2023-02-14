package lk.ijse.easy.service.impl;

import lk.ijse.easy.dto.CarDTO;
import lk.ijse.easy.entity.Car;
import lk.ijse.easy.entity.Driver;
import lk.ijse.easy.repo.CarRepo;
import lk.ijse.easy.service.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
        if (repo.existsById(carDTO.getCar_Id())) {
            throw new RuntimeException("User Already Exist. Please enter another id..!");
        }
        repo.save(mapper.map(carDTO, Car.class));
    }

    public void deleteCar(String id) {

    }

    public void updateCar(CarDTO carDTO) {

    }

    public ArrayList<CarDTO> getAllCars() {
        return null;
    }
}
