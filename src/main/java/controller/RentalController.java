package controller;/*  gaajiCode
    99
    08/09/2024
    */

import dtos.CustomDTO;
import dtos.PaymentDTO;
import dtos.RentCarDetailDTO;
import dtos.RentalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.RentalServices;
import util.ResPonceUTIL;

import java.util.Collections;


@RestController
@RequestMapping("rent")
@CrossOrigin
public class RentalController {
    @Autowired
    private RentalServices rentalService;

    @PostMapping
    public ResPonceUTIL requestRent(@ModelAttribute RentalDTO rentalDTO, @ModelAttribute RentCarDetailDTO rentCarDetailDTO, @ModelAttribute PaymentDTO paymentDTO){
        rentalDTO.setCustomerID("C00-001");
        rentalDTO.setStatus("PENDING");

        rentalDTO.setRentDetails(Collections.singletonList(rentCarDetailDTO));

        rentCarDetailDTO.setPayment(paymentDTO);
        paymentDTO.setWaiverSlip(paymentDTO.getWaiverSlip());
        System.out.println(rentalDTO);
        System.out.println(paymentDTO);

        rentalService.requestRent(rentalDTO);


        return new ResPonceUTIL (200,"Successfully Added",rentalDTO);
    }

    @PostMapping(path = "/manyRents")
    public ResPonceUTIL  requestRents(@RequestBody RentalDTO dto) {
        rentalService.requestRent(dto);
        return new ResPonceUTIL (200, "Successfully Purchased.!", dto);
    }


    @GetMapping("/get")
    public ResPonceUTIL  getAllRentals(){
        return new ResPonceUTIL (200,"Successfully Loaded",rentalService.getAllRentals());
    }

    @GetMapping(path = "/IdGenerate")
    public @ResponseBody CustomDTO rentIdGenerate() {
        return rentalService.rentIdGenerate();
    }


    @PostMapping(params = {"rentID","status"})
    public ResPonceUTIL  updateStatus(String rentID,String status) {
        rentalService.updateStatus(rentID,status);
        return new ResPonceUTIL (200, "Successfully Purchased.!", status);
    }

}
