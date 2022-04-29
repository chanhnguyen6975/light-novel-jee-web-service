package com.chanhnguyen.service;

import com.chanhnguyen.entity.Novel;
import com.chanhnguyen.paging.Pageble;

import java.util.List;

public interface INovelService {
    Novel findById(Integer id);
    List<Novel> findAll();
    List<Novel> findAllByCategoryId(Integer categoryId);
    List<Novel> findAllByCategoryId(Integer categoryId, Pageble pageble);

    //return object to send client
    Novel insert(Novel Novel);
    //return object to send client
    Novel update(Novel Novel);
    //delete by id, no return
    void delete(Integer id);


}
