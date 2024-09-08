package services;/*  gaajiCode
    99
    07/09/2024
    */

import dtos.CarDTO;
import dtos.CustomDTO;
import dtos.meta.CarMetaDTO;
import entity.Car;

import java.util.ArrayList;

public interface CarService {
    void addCar(CarDTO dto);

    ArrayList<CarMetaDTO> getAllCars();

    Car searchCar(String id);

    void updateCar(CarDTO dto);

    void deleteCar(String carId);

    CustomDTO carIdGenerate();

}
