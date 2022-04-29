package com.chanhnguyen.service.impl;

import com.chanhnguyen.dao.INovelDAO;
import com.chanhnguyen.entity.Novel;
import com.chanhnguyen.paging.Pageble;
import com.chanhnguyen.service.INovelService;

import javax.inject.Inject;
import java.util.List;

public class NovelService implements INovelService {
    @Inject
    private INovelDAO iNovelDAO;

    @Override
    public Novel findById(Integer id) {
        return iNovelDAO.findById(id);
    }

    @Override
    public List<Novel> findAll() {
        return iNovelDAO.findAll();
    }

    @Override
    public List<Novel> findAllByCategoryId(Integer categoryId) {
        return iNovelDAO.findAllByCategoryId(categoryId);
    }


    @Override
    public List<Novel> findAllByCategoryId(Integer categoryId, Pageble pageble) {
        return iNovelDAO.findAllByCategoryId(categoryId,pageble);
    }

    @Override
    public Novel insert(Novel Novel) {
        return findById(iNovelDAO.insert(Novel));
    }

    @Override
    public Novel update(Novel Novel) {
        iNovelDAO.update(Novel);
        return findById(Novel.getId());
    }

    @Override
    public void delete(Integer id) {
        iNovelDAO.delete(id);
    }
}
