package com.chanhnguyen.mapper;

import com.chanhnguyen.entity.Role;
import com.chanhnguyen.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
// User - Role: 1 - n
//User là quan hệ 1
//Role là quan hệ nhiều
//1 User có 1 Role
//1 Role có nhiều User
//User -> Role
//1 User có 1 Role
//1 Role có nhiều User
//@OneToMany
//@ManyToOne

public class UserMapper implements RowMapper<User>{
    @Override
    public User mapRow(ResultSet rs) {
        try {
            User User = new User();
            User.setId(rs.getInt("id"));
            Role role = new Role();
            role.setName(rs.getString("rolename"));
            role.setCode(rs.getString("code"));

            User.setRole(role);
            User.setUsername(rs.getString("username"));
            User.setPassword(rs.getString("password"));
            User.setFullName(rs.getString("fullname"));
            User.setStatus(rs.getBoolean("status"));

            return User;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}