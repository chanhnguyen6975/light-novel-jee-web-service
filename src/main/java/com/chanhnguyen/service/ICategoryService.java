package com.chanhnguyen.service;

import com.chanhnguyen.entity.Category;

import java.util.List;

public interface ICategoryService {
    //Catch error here
    Category findById(Integer id);
    List<Category> findAll();
    //return object to send client
    Category insert(Category Category);
    //return object to send client
    Category update(Category Category);
    //delete by id, no return
    void delete(Integer id);
}
