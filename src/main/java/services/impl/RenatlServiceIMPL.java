package services.impl;/*  gaajiCode
    99
    08/09/2024
    */

import dtos.CustomDTO;
import dtos.RentalDTO;
import entity.Rental;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repo.CarRepo;
import repo.RentalRepo;
import services.RentalServices;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RenatlServiceIMPL implements RentalServices {
    @Autowired
    private RentalRepo rentalRepo;

    private CarRepo carRepo;



    @Autowired
    private ModelMapper mapper;
    @Override
    public void requestRent(RentalDTO rentalDTO) {
        Rental rent = mapper.map(rentalDTO, Rental.class);
        rentalRepo.save(rent);
        System.out.println(rent);
    }

    @Override
    public ArrayList<RentalDTO> getAllRentals() {
        List<Rental> all = rentalRepo.findAll();
        return mapper.map(all, new TypeToken<List<RentalDTO>>() {
        }.getType());
    }

    @Override
    public CustomDTO rentIdGenerate() {
        return new CustomDTO(rentalRepo.getLastIndex());
    }

    @Override
    public void updateStatus(String rentalID, String status) {

        Rental rental = rentalRepo.findById(rentalID).get();
        rental.setStatus(status);
        rentalRepo.save(rental);

        rental.getRentDetails();

        String status1 = rental.getStatus();

    }
}
