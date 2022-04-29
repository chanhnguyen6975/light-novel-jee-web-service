package com.chanhnguyen.service;

import com.chanhnguyen.entity.CategoryGroup;

import java.sql.SQLException;
import java.util.List;

public interface ICategoryGroupService {
    //Catch error here
    CategoryGroup findById(Integer id);
    List<CategoryGroup> findAll();
    //return object to send client
    CategoryGroup insert(CategoryGroup categoryGroup);
    //return object to send client
    CategoryGroup update(CategoryGroup categoryGroup);
    //delete by id, no return
    void delete(Integer id);
}
