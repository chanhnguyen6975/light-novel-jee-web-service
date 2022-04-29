package com.chanhnguyen.service.impl;

import com.chanhnguyen.dao.ICategoryDAO;
import com.chanhnguyen.entity.Category;
import com.chanhnguyen.service.ICategoryService;

import javax.inject.Inject;
import java.util.List;

public class CategoryService implements ICategoryService {
    @Inject
    private ICategoryDAO iCategoryDAO;

    @Override
    public Category findById(Integer id) {
        return iCategoryDAO.findById(id);
    }

    @Override
    public List<Category> findAll() {
        return iCategoryDAO.findAll();
    }

    @Override
    public Category insert(Category Category) {
        return findById(iCategoryDAO.insert(Category));
    }

    @Override
    public Category update(Category Category) {
        iCategoryDAO.update(Category);
        return findById(Category.getId());
    }

    @Override
    public void delete(Integer id) {
        iCategoryDAO.delete(id);
    }
}
