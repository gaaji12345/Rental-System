package services.impl;/*  gaajiCode
    99
    07/09/2024
    */


import entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.UserRepo;
import services.UserService;

@Service
public class UserServiceIMPL implements UserService {


    @Autowired
    UserRepo userRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public User findByUserName(String userName) {
        return modelMapper.map(userRepo.findByUserName(userName), User.class);
    }
}
