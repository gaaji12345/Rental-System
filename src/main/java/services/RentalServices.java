package services;/*  gaajiCode
    99
    08/09/2024
    */

import dtos.CustomDTO;
import dtos.RentalDTO;

import java.util.ArrayList;

public interface RentalServices {
    void requestRent(RentalDTO rentalDTO);

    ArrayList<RentalDTO> getAllRentals();

    CustomDTO rentIdGenerate();

    void updateStatus(String rentalID,String status);
}
