package controller;/*  gaajiCode
    99
    07/09/2024
    */

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.UserService;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {
    @Autowired
    UserService service;

    @GetMapping(params = {"userName"})
    public User findByUserName( @RequestParam("userName") String userName) {
        System.out.println(userName);
        return service.findByUserName(userName);
    }




}
