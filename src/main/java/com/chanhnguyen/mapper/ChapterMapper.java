package com.chanhnguyen.mapper;

import com.chanhnguyen.entity.Chapter;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChapterMapper implements RowMapper<Chapter>{
    @Override
    public Chapter mapRow(ResultSet rs) {
        try {
            Chapter Chapter = new Chapter();
            Chapter.setId(rs.getInt("id"));
            Chapter.setTitle(rs.getString("title"));
            Chapter.setContent(rs.getString("content"));
            Chapter.setNovelId(rs.getInt("novel_id"));
            Chapter.setCreatedDate(rs.getDate("createddate"));
            Chapter.setModifiedDate(rs.getDate("modifieddate"));
            return Chapter;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}