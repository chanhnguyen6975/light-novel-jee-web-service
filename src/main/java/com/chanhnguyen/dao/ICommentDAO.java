package com.chanhnguyen.dao;

import com.chanhnguyen.entity.Comment;
import com.chanhnguyen.entity.Comment;

import java.util.List;

public interface ICommentDAO extends IGeneralDAO {
    Comment findById(Integer id, Integer novelId);
    List<Comment> findAll(Integer novelId);

    Integer insert(Comment Comment);
    Integer update(Comment Comment);
    Integer delete(Integer id);
}
