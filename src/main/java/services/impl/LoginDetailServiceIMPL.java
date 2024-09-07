package services.impl;/*  gaajiCode
    99
    07/09/2024
    */

import dtos.LoginDetailDTO;
import entity.LoginDetail;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.LoginDetailRepo;
import services.LoginDetailServices;

@Service
public class LoginDetailServiceIMPL implements LoginDetailServices {
    @Autowired
    LoginDetailRepo repo;

    @Autowired
    ModelMapper modelMapper;
    @Override
    public void saveLoginDetail(LoginDetailDTO loginDetailDTO) {

        LoginDetail map =modelMapper.map(loginDetailDTO, LoginDetail.class);

        System.out.println(map);

        repo.save(map);

    }
}
