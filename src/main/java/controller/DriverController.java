package controller;/*  gaajiCode
    99
    07/09/2024
    */

import dtos.DriverDTO;
import dtos.UserDTO;
import entity.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.DriverService;
import util.ResPonceUTIL;

@RestController
@RequestMapping("driver")
@CrossOrigin
public class DriverController {
    @Autowired
    private DriverService service;
    @PostMapping
    public ResPonceUTIL addDriver(@ModelAttribute DriverDTO driverDTO, @ModelAttribute UserDTO user){
        System.out.println(driverDTO);
        driverDTO.setUser(user);
        System.out.println(driverDTO);
        service.addDriver(driverDTO);
        return new ResPonceUTIL (200,"Successfully Added",null);
    }

    @GetMapping
    public ResPonceUTIL getAllDrivers(){
        return new ResPonceUTIL (200,"Successfully Loaded",service.getAllDrivers());
    }

    @GetMapping(params = {"driverID"})
    public Driver searchDriverId(String driverID) {
        return service.searchDriver(driverID);
    }

    @PutMapping
    public ResPonceUTIL  updateDriver(@ModelAttribute DriverDTO driverDTO, @ModelAttribute UserDTO user){
        System.out.println(driverDTO);
        driverDTO.setUser(user);
        System.out.println(driverDTO);
        service.updateDriver(driverDTO);
        return new ResPonceUTIL (200,"Successfully Added",null);
    }

    @DeleteMapping(params = {"driverId"})
    public ResPonceUTIL  deleteDriver(@RequestParam String driverId) {
        service.deleteDriver(driverId);
        return new ResPonceUTIL (200, "Successfully Deleted. :" + driverId, null);
    }

}
