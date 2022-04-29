package com.chanhnguyen.service;

import com.chanhnguyen.entity.Comment;

import java.util.List;

public interface ICommentService {
    //Catch error here
    Comment findById(Integer id, Integer novelId);
    //Find all Comments of novel
    //Why do we use Integer instead of int?
    List<Comment> findAll(Integer novelId);
    Comment insert(Comment Comment);
    //return object to send client
    Comment update(Comment Comment);
    //delete by id, no return
    void delete(Integer id);
}
