package com.chanhnguyen.dao;


import com.chanhnguyen.mapper.RowMapper;

import java.sql.SQLException;
import java.util.List;

public interface IGeneralDAO {
    //Define common method
    <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) throws SQLException, ClassNotFoundException;
    //return id
    Integer insert (String sql, Object... parameters) throws SQLException;
    //return affected row
    Integer update (String sql, Object... parameters) throws SQLException;
    Integer count (String sql, Object... parameters) throws SQLException;



}
