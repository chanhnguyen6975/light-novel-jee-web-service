package com.chanhnguyen.dao;

import com.chanhnguyen.entity.Novel;
import com.chanhnguyen.paging.Pageble;

import java.util.List;

public interface INovelDAO extends IGeneralDAO{
    Novel findById(Integer id);
    List<Novel> findAll();
    List<Novel> findAll(Pageble pageble);
    List<Novel> findAllByCategoryId(Integer categoryId);
    List<Novel> findAllByCategoryId(Integer categoryId, Pageble pageble);

    //return id
    Integer insert(Novel Novel);
    //return affected row
    Integer update(Novel Novel);
    //return affected row
    Integer delete(Integer id);
}
