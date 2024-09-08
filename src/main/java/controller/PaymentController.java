package controller;/*  gaajiCode
    99
    08/09/2024
    */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.PaymentService;
import util.ResPonceUTIL;

@RestController
@RequestMapping("payment")
@CrossOrigin
public class PaymentController {
    @Autowired
    private PaymentService service;

    @GetMapping
    public ResPonceUTIL getAllPayments(){
        return new ResPonceUTIL(200,"Successfully Loaded",service.getAllPayments());
    }

    @PostMapping(params = {"paymentID","total"})
    public void updatePayment(String paymentID, String total){
        service.updatePayment(paymentID,total);
    }
}
