package com.chanhnguyen.dao.impl;

import com.chanhnguyen.dao.ICategoryGroupDAO;
import com.chanhnguyen.entity.CategoryGroup;
import com.chanhnguyen.mapper.CategoryGroupMapper;

import java.util.List;

public class CategoryGroupDAO extends GeneralDAO implements ICategoryGroupDAO {
    @Override
    public CategoryGroup findById(Integer id) {
        String sql = "SELECT * FROM category_group WHERE id = ?";
        List<CategoryGroup> list = query(sql, new CategoryGroupMapper(), id);
        return list.isEmpty() ? null : list.get(0);

    }

    @Override
    public List<CategoryGroup> findAll() {
        String sql = "SELECT * FROM category_group";
        return query(sql, new CategoryGroupMapper());
    }

    @Override
    public Integer insert(CategoryGroup categoryGroup) {
        String sql = "";
        sql = "INSERT INTO category_group(name) VALUES (?)";
        return insert(sql, categoryGroup.getName());
    }

    @Override
    public Integer update(CategoryGroup categoryGroup) {
        String sql = "";
        sql = "UPDATE category_group SET name = ? WHERE id = ? ";
        return update(sql, categoryGroup.getName(), categoryGroup.getId());
    }
    @Override
    public Integer delete(Integer id) {
        String sql = "";
        sql = "DELETE FROM category_group WHERE id = ? ";
        return update(sql, id);
    }

}
