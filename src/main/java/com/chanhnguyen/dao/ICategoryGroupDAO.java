package com.chanhnguyen.dao;

import com.chanhnguyen.entity.CategoryGroup;

import java.sql.SQLException;
import java.util.List;

public interface ICategoryGroupDAO extends IGeneralDAO{
    CategoryGroup findById(Integer id);
    List<CategoryGroup> findAll();
    //return id
    Integer insert(CategoryGroup categoryGroup);
    //return affected row
    Integer update(CategoryGroup categoryGroup);
    //return affected row
    Integer delete(Integer id);

}
