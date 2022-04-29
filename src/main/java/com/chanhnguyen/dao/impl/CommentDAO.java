package com.chanhnguyen.dao.impl;

import com.chanhnguyen.dao.ICommentDAO;
import com.chanhnguyen.entity.Comment;
import com.chanhnguyen.mapper.CommentMapper;

import java.util.List;

public class CommentDAO extends GeneralDAO implements ICommentDAO {

    @Override
    public Comment findById(Integer id, Integer novelId) {
        String sql = "";
        List<Comment> list = query(sql, new CommentMapper(), novelId, id);
        return list.isEmpty() ? null : list.get(0);
    }


    @Override
    public List<Comment> findAll(Integer novelId) {
        String sql = "SELECT c.id, c.content, c.createddate, c.modifieddate, n.id AS novel_id, n.title AS novel_title, u1.id AS createdbyid, u1.fullname AS createdbyfullname, u2.id AS modifiedbyid, u2.fullname AS modifiedbyfullname FROM comment AS c INNER JOIN users AS u1 ON c.createdby = u1.id INNER JOIN users AS u2 ON c.modifiedby = u2.id INNER JOIN novel AS n ON c.novel_id = n.id  WHERE novel_id  = ?";
        return query(sql, new CommentMapper(), novelId);
    }

    @Override
    public Integer insert(Comment Comment) {
        return null;
    }

    @Override
    public Integer update(Comment Comment) {
        return null;
    }

    @Override
    public Integer delete(Integer id) {
        return null;
    }


}
