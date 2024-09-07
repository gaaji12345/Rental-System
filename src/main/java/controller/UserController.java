package controller;/*  gaajiCode
    99
    07/09/2024
    */

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.UserService;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {
    @Autowired
    UserService service;

    @GetMapping(params = {"userName"})
    public User findByUserName(String userName) {
        System.out.println(userName);
        return service.findByUserName(userName);
    }
    


}
