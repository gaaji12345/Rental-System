package controller;/*  gaajiCode
    99
    07/09/2024
    */

import dtos.CarDTO;
import dtos.CustomDTO;
import dtos.meta.CarMetaDTO;
import entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.CarService;
import util.ResPonceUTIL;

import java.util.ArrayList;

@RestController
@RequestMapping("car")
@CrossOrigin
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping
    public ResPonceUTIL addCar(@ModelAttribute CarDTO carDTO){
        System.out.println(carDTO);
        carService.addCar(carDTO);
        return new ResPonceUTIL(200,"Successfully Added",null);
    }

    @GetMapping
    public ResPonceUTIL  getAllCars(){
        return new ResPonceUTIL(200,"Successfully Loaded",carService.getAllCars());
    }

    @GetMapping(path = "/view")
    public ArrayList<CarMetaDTO> getAllCarsList(){
        return carService.getAllCars();
    }

    @GetMapping(params = {"car_id"})
    public ResPonceUTIL searchCar(String car_id) {
        System.out.println(car_id);
        Car carDTO =carService.searchCar(car_id);
        return new ResPonceUTIL(200,"Successfully Updated",carDTO);
    }

    @GetMapping(params = {"carId"})
    public Car searchCar2( String carId) {
        System.out.println(carId);
        return carService.searchCar(carId);
    }

    @PutMapping
    public ResPonceUTIL updateCar(@ModelAttribute CarDTO carDTO){
        System.out.println(carDTO);
        carService.updateCar(carDTO);
        return new ResPonceUTIL(200,"Successfully Updated",null);
    }

    @DeleteMapping(params = {"carId"})
    public ResPonceUTIL deleteCar(@RequestParam String carId) {
        carService.deleteCar(carId);
        return new  ResPonceUTIL(200, "Successfully Deleted. :" + carId, null);
    }

    @GetMapping(path = "/IdGenerate")
    public @ResponseBody CustomDTO carIdGenerate() {
        return carService.carIdGenerate();
    }


}
