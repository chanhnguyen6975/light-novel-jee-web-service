package com.chanhnguyen.service.impl;

import com.chanhnguyen.dao.ICommentDAO;
import com.chanhnguyen.entity.Comment;
import com.chanhnguyen.entity.Comment;
import com.chanhnguyen.service.ICommentService;

import javax.inject.Inject;
import java.util.List;

public class CommentService implements ICommentService {
    @Inject
    private ICommentDAO iCommentDAO;

    @Override
    public Comment findById(Integer id, Integer novelId) {
        return iCommentDAO.findById(id, novelId);
    }

    @Override
    public List<Comment> findAll(Integer novelId) {
        return iCommentDAO.findAll(novelId);
    }

    @Override
    public Comment insert(Comment Comment) {
        Integer CommentId = iCommentDAO.insert(Comment);
        return findById(CommentId, Comment.getNovel().getId());
    }

    @Override
    public Comment update(Comment Comment) {
        iCommentDAO.update(Comment);
        //
        return findById(Comment.getId(), Comment.getNovel().getId());
    }

    @Override
    public void delete(Integer id) {
        iCommentDAO.delete(id);
    }
}
