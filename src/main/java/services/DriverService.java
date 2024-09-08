package services;/*  gaajiCode
    99
    07/09/2024
    */

import dtos.DriverDTO;
import entity.Driver;

import java.util.ArrayList;

public interface DriverService {
    void addDriver(DriverDTO driverDTO);
    ArrayList<DriverDTO> getAllDrivers();

    Driver searchDriver(String id);

    void updateDriver(DriverDTO dto);

    void deleteDriver(String id);
}
