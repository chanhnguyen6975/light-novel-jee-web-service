package com.chanhnguyen.dao;

import com.chanhnguyen.entity.Chapter;
import com.chanhnguyen.entity.Novel;

import java.util.List;

public interface IChapterDAO extends IGeneralDAO{
    //Find a chapter of the novel
    Chapter findById(Integer id, Integer novelId);
    //Find all chapters of the novel
    //Why do we use Integer instead of int?
    List<Chapter> findAll(Integer novelId);

    //
    Integer insert(Chapter chapter);
    Integer update(Chapter chapter);
    Integer delete(Integer id);



}
