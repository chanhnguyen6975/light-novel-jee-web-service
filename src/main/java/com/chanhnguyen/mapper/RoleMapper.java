package com.chanhnguyen.mapper;

import com.chanhnguyen.entity.Role;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleMapper implements RowMapper<Role>{
    @Override
    public Role mapRow(ResultSet rs) {
        try {
            Role Role = new Role();
            Role.setId(rs.getInt("id"));
            Role.setCode(rs.getString("code"));
            Role.setName(rs.getString("name"));
            Role.setCreatedDate(rs.getDate("createddate"));
            Role.setModifiedDate(rs.getDate("modifieddate"));
            return Role;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}