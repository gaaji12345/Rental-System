package controller;/*  gaajiCode
    99
    04/09/2024
    */

import dtos.CustomDTO;
import dtos.CustomerDTO;
import dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.CustomerService;
import util.ResPonceUTIL;

@RestController
@RequestMapping("customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService service;


    @PostMapping
    public ResPonceUTIL addCustomer(@ModelAttribute CustomerDTO customerDTO, @ModelAttribute UserDTO user){
        System.out.println(customerDTO);
        customerDTO.setUser(user);
        System.out.println(customerDTO);
        service.addCustomer(customerDTO);
        return new ResPonceUTIL(200,"Successfully Added",null);
    }

    @GetMapping
    public ResPonceUTIL getAllCustomers(){
        return new ResPonceUTIL(200,"Successfully Loaded",service.getAllCustomers());
    }


    @GetMapping(path = "/IdGenerate")
    public @ResponseBody CustomDTO customerIdGenerate() {
        return service.customerIdGenerate();
    }

    @PostMapping(params = {"userName"})
    public ResPonceUTIL addCustomer(String userName){
        CustomerDTO cusDetail = service.getCusDetail(userName);
        return new ResPonceUTIL(200,"Successfully Loaded",cusDetail);
    }



}
