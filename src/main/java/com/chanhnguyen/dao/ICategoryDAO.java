package com.chanhnguyen.dao;

import com.chanhnguyen.entity.Category;

import java.util.List;

public interface ICategoryDAO {
    Category findById(Integer id);
    List<Category> findAll();
    //return id
    Integer insert(Category Category);
    //return affected row
    Integer update(Category Category);
    //return affected row
    Integer delete(Integer id);
}
