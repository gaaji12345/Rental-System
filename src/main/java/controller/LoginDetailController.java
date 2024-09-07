package controller;/*  gaajiCode
    99
    07/09/2024
    */

import dtos.LoginDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.LoginDetailServices;
import util.ResPonceUTIL;

@RestController
@RequestMapping("logindetail")
@CrossOrigin
public class LoginDetailController {

    @Autowired
    LoginDetailServices services;

    @PostMapping
    public ResPonceUTIL saveLoginDetail(@RequestBody LoginDetailDTO loginDetailDTO) {
        System.out.println(loginDetailDTO);
        services.saveLoginDetail(loginDetailDTO);


        return new ResPonceUTIL(200, "Successfully Loaded", loginDetailDTO);
    }
}
