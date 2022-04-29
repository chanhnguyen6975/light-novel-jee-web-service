package com.chanhnguyen.service;

import com.chanhnguyen.entity.Chapter;

import java.util.List;

public interface IChapterService {
    //Catch error here
    Chapter findById(Integer id, Integer novelId);
    //Find all chapters of novel
    //Why do we use Integer instead of int?
    List<Chapter> findAll(Integer novelId);
    Chapter insert(Chapter Chapter);
    //return object to send client
    Chapter update(Chapter Chapter);
    //delete by id, no return
    void delete(Integer id);
}
