package com.chanhnguyen.mapper;

import com.chanhnguyen.entity.Comment;
import com.chanhnguyen.entity.Novel;
import com.chanhnguyen.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentMapper implements RowMapper<Comment>{
    @Override
    public Comment mapRow(ResultSet rs) {
        try {
            Comment Comment = new Comment();
            Comment.setId(rs.getInt("id"));

            Comment.setContent(rs.getString("content"));

            //
            Novel novel = new Novel();
            novel.setId(rs.getInt("novel_id"));
            novel.setTitle(rs.getString("novel_title"));
            Comment.setNovel(novel);

            //
            User createdBy = new User();
            createdBy.setId(rs.getInt("createdbyid"));
            createdBy.setFullName(rs.getString("createdbyfullname"));
            Comment.setCreatedBy(createdBy);
            //
            User modifiedBy = new User();
            modifiedBy.setId(rs.getInt("modifiedbyid"));
            modifiedBy.setFullName(rs.getString("modifiedbyfullname"));
            Comment.setCreatedBy(modifiedBy);


            Comment.setCreatedDate(rs.getDate("createddate"));
            Comment.setModifiedDate(rs.getDate("modifieddate"));
            return Comment;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}