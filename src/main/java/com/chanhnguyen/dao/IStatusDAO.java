package com.chanhnguyen.dao;

import com.chanhnguyen.entity.Status;

import java.util.List;

public interface IStatusDAO extends IGeneralDAO{
    Status findById(Integer id);
    List<Status> findAll();
    //return id
    Integer insert(Status Status);
    //return affected row
    Integer update(Status Status);
    //return affected row
    Integer delete(Integer id);

}
