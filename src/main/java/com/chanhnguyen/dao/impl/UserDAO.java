package com.chanhnguyen.dao.impl;

import com.chanhnguyen.dao.IUserDAO;
import com.chanhnguyen.entity.User;
import com.chanhnguyen.mapper.UserMapper;

import java.util.List;

public class UserDAO extends GeneralDAO implements IUserDAO {
    @Override
    public User findById(Integer id) {
        String sql = "SELECT u.id, u.username, u.password, u.fullname, u.status, r.name AS rolename, r.code FROM users AS u INNER JOIN roles AS r ON u.roleid = r.id WHERE u.id = ?";
        List<User> list = query(sql, new UserMapper(), id);
        return list.isEmpty() ? null : list.get(0);

    }

    @Override
    public User findByUsernameAndPasswordAndStatus(String username, String password) {
        String sql = "SELECT u.id, u.username, u.password, u.fullname, u.status, r.name AS rolename, r.code FROM users AS u INNER JOIN roles AS r ON u.roleid = r.id WHERE u.status = 0 AND u.username = ? AND u.password = ?";
        List<User> list = query(sql, new UserMapper(), username, password);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<User> findAll() {
        String sql = "SELECT u.id, u.username, u.password, u.fullname, u.status, r.name AS rolename, r.code FROM users AS u INNER JOIN roles AS r ON u.roleid = r.id";
        return query(sql, new UserMapper());
    }

    @Override
    public Integer insert(User User) {
        String
                sql = "INSERT INTO users(" +
                "username, " +
                "password, " +
                "fullname, " +
                "status, " +
                "role_id " +
                "VALUES (?, ?, ?, ?)";
        return insert(sql,
                User.getUsername(),
                User.getPassword(),
                User.getFullName(),
                User.isStatus(),
                User.getRodeId()
        );
    }

    @Override
    public Integer update(User User) {
        String sql = "";
        sql = "UPDATE users " +
                "SET " +
                "username = ?, " +
                "password = ?, " +
                "fullname = ?, " +
                "status = ? " +
                "role_id = ?, " +
                "WHERE id = ? ";
        return update(sql,
                User.getUsername(),
                User.getPassword(),
                User.getFullName(),
                User.isStatus(),
                User.getRodeId(),
                User.getId()

        );
    }
    @Override
    public Integer delete(Integer id) {
        String sql = "";
        sql = "DELETE FROM users WHERE id = ? ";
        return update(sql, id);
    }
    @Override
    public boolean checkLogin(User user) {
        return false;
    }
}
