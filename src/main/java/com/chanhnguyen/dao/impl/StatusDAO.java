package com.chanhnguyen.dao.impl;

import com.chanhnguyen.dao.IStatusDAO;
import com.chanhnguyen.entity.Status;
import com.chanhnguyen.mapper.StatusMapper;

import java.util.List;

public class StatusDAO extends GeneralDAO implements IStatusDAO {
    @Override
    public Status findById(Integer id) {
        String sql = "SELECT * FROM status WHERE id = ?";
        List<Status> list = query(sql, new StatusMapper(), id);
        return list.isEmpty() ? null : list.get(0);

    }

    @Override
    public List<Status> findAll() {
        String sql = "SELECT * FROM status";
        return query(sql, new StatusMapper());
    }

    @Override
    public Integer insert(Status Status) {
        String sql = "";
        sql = "INSERT INTO status(name) VALUES (?)";
        return insert(sql, Status.getName());
    }

    @Override
    public Integer update(Status Status) {
        String sql = "";
        sql = "UPDATE status SET name = ? WHERE id = ? ";
        return update(sql, Status.getName(), Status.getId());
    }
    @Override
    public Integer delete(Integer id) {
        String sql = "";
        sql = "DELETE FROM status WHERE id = ? ";
        return update(sql, id);
    }

}
