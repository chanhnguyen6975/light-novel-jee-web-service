package com.chanhnguyen.mapper;

import com.chanhnguyen.entity.*;

import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//Miss private
public class NovelMapper implements RowMapper<Novel>{

    @Override
    public Novel mapRow(ResultSet rs) {
        try {
            Novel Novel = new Novel();
            Novel.setId(rs.getInt("id"));
            //1-n relationship
            Status status = new Status();
            status.setId(rs.getInt("status_id"));
            status.setName(rs.getString("status_name"));
            Novel.setStatus(status);
            //1-n relationship
            Category category = new Category();
            category.setId(rs.getInt("category_id"));
            category.setName(rs.getString("category_name"));
            Novel.setCategory(category);

            //
            User createdBy = new User();
            createdBy.setId(rs.getInt("createdbyid"));
            createdBy.setFullName(rs.getString("createdbyfullname"));
            Novel.setCreatedBy(createdBy);

            User modifiedBy = new User();
            modifiedBy.setId(rs.getInt("modifiedbyid"));
            modifiedBy.setFullName(rs.getString("modifiedbyfullname"));
            Novel.setCreatedBy(modifiedBy);



            Novel.setTitle(rs.getString("title"));
            Novel.setImage(rs.getString("image"));
            Novel.setShortDescription(rs.getString("short_description"));
            Novel.setReference(rs.getString("reference"));
            Novel.setAuthor(rs.getString("author"));
            Novel.setCreatedDate(rs.getDate("createddate"));
            Novel.setModifiedDate(rs.getDate("modifieddate"));

            return Novel;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}