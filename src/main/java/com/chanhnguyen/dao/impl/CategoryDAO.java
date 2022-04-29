package com.chanhnguyen.dao.impl;

import com.chanhnguyen.dao.ICategoryDAO;
import com.chanhnguyen.entity.Category;
import com.chanhnguyen.mapper.CategoryMapper;

import java.util.List;

public class CategoryDAO extends GeneralDAO implements ICategoryDAO {

    @Override
    public Category findById(Integer id) {
        String sql = "SELECT * FROM category WHERE id = ?";
        List<Category> list = query(sql, new CategoryMapper(), id);
        return list.isEmpty() ? null : list.get(0);

    }

    @Override
    public List<Category> findAll() {
        String sql = "SELECT * FROM category";
        return query(sql, new CategoryMapper());
    }

    @Override
    public Integer insert(Category Category) {
        String sql = "";
        sql = "INSERT INTO category(name) VALUES (?)";
        return insert(sql, Category.getName());
    }

    @Override
    public Integer update(Category Category) {
        String sql = "";
        sql = "UPDATE category SET name = ? WHERE id = ? ";
        return update(sql, Category.getName(), Category.getId());
    }
    @Override
    public Integer delete(Integer id) {
        String sql = "";
        sql = "DELETE FROM category WHERE id = ? ";
        return update(sql, id);
    }
}
