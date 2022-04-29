package com.chanhnguyen.service.impl;

import com.chanhnguyen.dao.IUserDAO;
import com.chanhnguyen.entity.User;
import com.chanhnguyen.service.IUserService;

import javax.inject.Inject;
import java.util.List;

public class UserService implements IUserService {
    @Inject
    private IUserDAO iUserDAO;

    @Override
    public User findById(Integer id) {
        return iUserDAO.findById(id);
    }

    @Override
    public User findByUsernameAndPasswordAndStatus(String username, String password) {
        return iUserDAO.findByUsernameAndPasswordAndStatus(username,password);
    }

    @Override
    public List<User> findAll() {
        return iUserDAO.findAll();
    }

    @Override
    public User insert(User User) {
        return findById(iUserDAO.insert(User));
    }

    @Override
    public User update(User User) {
        iUserDAO.update(User);
        return findById(User.getId());
    }

    @Override
    public void delete(Integer id) {
        iUserDAO.delete(id);
    }

    @Override
    public boolean checkLogin(User user) {
        return false;
    }
}
