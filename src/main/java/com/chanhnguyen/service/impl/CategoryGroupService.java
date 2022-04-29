package com.chanhnguyen.service.impl;

import com.chanhnguyen.dao.ICategoryGroupDAO;
import com.chanhnguyen.entity.CategoryGroup;
import com.chanhnguyen.service.ICategoryGroupService;

import javax.inject.Inject;
import java.util.List;

public class CategoryGroupService implements ICategoryGroupService {
    @Inject
    private ICategoryGroupDAO iCategoryGroupDAO;

    @Override
    public CategoryGroup findById(Integer id) {
        return iCategoryGroupDAO.findById(id);
    }

    @Override
    public List<CategoryGroup> findAll() {
        return iCategoryGroupDAO.findAll();
    }

    @Override
    public CategoryGroup insert(CategoryGroup categoryGroup) {
        return findById(iCategoryGroupDAO.insert(categoryGroup));
    }

    @Override
    public CategoryGroup update(CategoryGroup categoryGroup) {
        iCategoryGroupDAO.update(categoryGroup);
        return findById(categoryGroup.getId());
    }

    @Override
    public void delete(Integer id) {
        iCategoryGroupDAO.delete(id);
    }
}
