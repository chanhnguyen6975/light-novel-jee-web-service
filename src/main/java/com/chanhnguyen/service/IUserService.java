package com.chanhnguyen.service;

import com.chanhnguyen.entity.User;

import java.util.List;

public interface IUserService {
    User findById(Integer id);
    User findByUsernameAndPasswordAndStatus(String username, String password);
    List<User> findAll();
    //return id
    User insert(User User);
    //return affected row
    User update(User User);
    //return affected row
    void delete(Integer id);

    boolean checkLogin(User user);
}
