package com.chanhnguyen.mapper;

import com.chanhnguyen.entity.Status;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StatusMapper implements RowMapper<Status>{
    @Override
    public Status mapRow(ResultSet rs) {
        try {
            Status Status = new Status();
            Status.setId(rs.getInt("id"));
            Status.setName(rs.getString("name"));
            Status.setCreatedDate(rs.getDate("createddate"));
            Status.setModifiedDate(rs.getDate("modifieddate"));
            return Status;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}