package services.impl;/*  gaajiCode
    99
    07/09/2024
    */

import dtos.CarDTO;
import dtos.CustomDTO;
import dtos.meta.CarMetaDTO;
import entity.Car;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.CarRepo;
import services.CarService;

import java.util.ArrayList;

@Service
public class CarServiceIMPL implements CarService {
    @Autowired
    private CarRepo carRepo;

    @Autowired
    private ModelMapper mapper;
    @Override
    public void addCar(CarDTO dto) {

    }

    @Override
    public ArrayList<CarMetaDTO> getAllCars() {
        return null;
    }

    @Override
    public Car searchCar(String id) {
        return null;
    }

    @Override
    public void updateCar(CarDTO dto) {

    }

    @Override
    public void deleteCar(String carId) {

    }

    @Override
    public CustomDTO carIdGenerate() {
        return null;
    }
}
