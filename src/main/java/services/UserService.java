package services;/*  gaajiCode
    99
    07/09/2024
    */

import entity.User;

public interface UserService {
    User findByUserName(String userName);
}
