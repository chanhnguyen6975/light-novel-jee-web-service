package com.chanhnguyen.mapper;


import com.chanhnguyen.entity.CategoryGroup;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryGroupMapper implements RowMapper<CategoryGroup> {
    @Override
    public CategoryGroup mapRow(ResultSet resultSet){
        try {
            CategoryGroup categoryGroup = new CategoryGroup();
            categoryGroup.setId(resultSet.getInt("id"));
            categoryGroup.setName(resultSet.getString("name"));
            categoryGroup.setCreatedDate(resultSet.getDate("createddate"));
            categoryGroup.setModifiedDate(resultSet.getDate("modifieddate"));
            return categoryGroup;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
}
