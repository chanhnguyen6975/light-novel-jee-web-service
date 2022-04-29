package com.chanhnguyen.dao;

import com.chanhnguyen.entity.User;

import java.util.List;

public interface IUserDAO {
    User findById(Integer id);
    User findByUsernameAndPasswordAndStatus(String username, String password);
    List<User> findAll();
    //return id
    Integer insert(User User);
    //return affected row
    Integer update(User User);
    //return affected row
    Integer delete(Integer id);

    boolean checkLogin(User user);
}
