package com.chanhnguyen.mapper;

import com.chanhnguyen.entity.Category;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper implements RowMapper<Category>{
    @Override
    public Category mapRow(ResultSet rs) {
        try {
            Category Category = new Category();
            Category.setId(rs.getInt("id"));
            Category.setName(rs.getString("name"));
            Category.setGroupId(rs.getInt("group_id"));
            Category.setCreatedDate(rs.getDate("createddate"));
            Category.setModifiedDate(rs.getDate("modifieddate"));
            return Category;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
