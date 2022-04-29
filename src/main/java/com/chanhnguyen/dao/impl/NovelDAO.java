package com.chanhnguyen.dao.impl;

import com.chanhnguyen.dao.INovelDAO;
import com.chanhnguyen.entity.Novel;
import com.chanhnguyen.mapper.NovelMapper;
import com.chanhnguyen.paging.Pageble;
import org.apache.commons.lang.StringUtils;

import java.util.List;
//Trong MSSQL bắt buộc phải ORDER BY khi dùng OFFSET

public class NovelDAO extends GeneralDAO implements INovelDAO {
    @Override
    public Novel findById(Integer id) {
        String sql = "SELECT " +
                "n.id," +
                "n.title, " +
                "n.image, " +
                "n.short_description, " +
                "n.reference, " +
                "n.author, " +
                "n.private, " +
                "n.status_id, " +
                "n.createddate, " +
                "n.createdby, " +
                "n.modifieddate, " +
                "n.modifiedby, " +
                "s.id AS status_id, " +
                "s.name AS status_name, " +
                "c.id AS category_id, " +
                "c.name AS category_name, " +
                "u1.id AS createdbyid, " +
                "u1.fullname AS createdbyfullname, " +
                "u2.id AS modifiedbyid, " +
                "u2.fullname AS modifiedbyfullname " +
                "FROM novel AS n INNER JOIN [status] AS s ON n.status_id = s.id " +
                "INNER JOIN category AS c ON n.category_id = c.id " +
                "INNER JOIN users AS u1 ON n.createdby = u1.id " +
                "INNER JOIN users AS u2 ON n.modifiedby = u2.id " +
                "WHERE n.id = ?";
        List<Novel> list = query(sql, new NovelMapper(), id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<Novel> findAll() {
        String sql = "SELECT " +
                "n.id," +
                "n.title, " +
                "n.image, " +
                "n.short_description, " +
                "n.reference, " +
                "n.author, " +
                "n.private, " +
                "n.status_id, " +
                "n.createddate, " +
                "n.createdby, " +
                "n.modifieddate, " +
                "n.modifiedby, " +
                "s.id AS status_id, " +
                "s.name AS status_name, " +
                "c.id AS category_id, " +
                "c.name AS category_name, " +
                "u1.id AS createdbyid, " +
                "u1.fullname AS createdbyfullname, " +
                "u2.id AS modifiedbyid, " +
                "u2.fullname AS modifiedbyfullname " +
                "FROM novel AS n INNER JOIN [status] AS s ON n.status_id = s.id " +
                "INNER JOIN category AS c ON n.category_id = c.id " +
                "INNER JOIN users AS u1 ON n.createdby = u1.id " +
                "INNER JOIN users AS u2 ON n.modifiedby = u2.id ";
        return query(sql, new NovelMapper());
    }

    @Override
    public List<Novel> findAll(Pageble pageble) {
        StringBuilder sql = new StringBuilder("SELECT " +
                "n.id," +
                "n.title, " +
                "n.image, " +
                "n.short_description, " +
                "n.reference, " +
                "n.author, " +
                "n.private, " +
                "n.status_id, " +
                "n.createddate, " +
                "n.createdby, " +
                "n.modifieddate, " +
                "n.modifiedby, " +
                "s.id AS status_id, " +
                "s.name AS status_name, " +
                "c.id AS category_id, " +
                "c.name AS category_name, " +
                "u1.id AS createdbyid, " +
                "u1.fullname AS createdbyfullname, " +
                "u2.id AS modifiedbyid, " +
                "u2.fullname AS modifiedbyfullname " +
                "FROM novel AS n INNER JOIN [status] AS s ON n.status_id = s.id " +
                "INNER JOIN category AS c ON n.category_id = c.id " +
                "INNER JOIN users AS u1 ON n.createdby = u1.id " +
                "INNER JOIN users AS u2 ON n.modifiedby = u2.id ");
        addPagination(pageble, sql);
        return query(sql.toString(), new NovelMapper());
    }

    private void addPagination(Pageble pageble, StringBuilder sql) {
        if (pageble.getSorter() != null && StringUtils.isNotBlank(pageble.getSorter().getSortName())) {
            sql.append(" ORDER BY ").append("n.").append(pageble.getSorter().getSortName()).append(" ").append(pageble.getSorter().getSortBy());
        } else {
            sql.append(" ORDER BY n.id");
        }
        if (pageble.getOffset() != null && pageble.getLimit() != null) {
            sql.append(" OFFSET ").append(pageble.getOffset()).append(" ROWS FETCH FIRST ").append(pageble.getLimit()).append(" ROWS ONLY");
        }
    }

    @Override
    public List<Novel> findAllByCategoryId(Integer categoryId) {
        String sql = "SELECT " +
                "n.id," +
                "n.title, " +
                "n.image, " +
                "n.short_description, " +
                "n.reference, " +
                "n.author, " +
                "n.private, " +
                "n.status_id, " +
                "n.createddate, " +
                "n.createdby, " +
                "n.modifieddate, " +
                "n.modifiedby, " +
                "s.id AS status_id, " +
                "s.name AS status_name, " +
                "c.id AS category_id, " +
                "c.name AS category_name, " +
                "u1.id AS createdbyid, " +
                "u1.fullname AS createdbyfullname, " +
                "u2.id AS modifiedbyid, " +
                "u2.fullname AS modifiedbyfullname " +
                "FROM novel AS n INNER JOIN [status] AS s ON n.status_id = s.id " +
                "INNER JOIN category AS c ON n.category_id = c.id " +
                "INNER JOIN users AS u1 ON n.createdby = u1.id " +
                "INNER JOIN users AS u2 ON n.modifiedby = u2.id " +
                "WHERE n.category_id= ?";
        return query(sql, new NovelMapper(), categoryId);
    }

    @Override
    public List<Novel> findAllByCategoryId(Integer categoryId, Pageble pageble) {
        StringBuilder sql = new StringBuilder("SELECT " +
                "n.id," +
                "n.title, " +
                "n.image, " +
                "n.short_description, " +
                "n.reference, " +
                "n.author, " +
                "n.private, " +
                "n.status_id, " +
                "n.createddate, " +
                "n.createdby, " +
                "n.modifieddate, " +
                "n.modifiedby, " +
                "s.id AS status_id, " +
                "s.name AS status_name, " +
                "c.id AS category_id, " +
                "c.name AS category_name, " +
                "u1.id AS createdbyid, " +
                "u1.fullname AS createdbyfullname, " +
                "u2.id AS modifiedbyid, " +
                "u2.fullname AS modifiedbyfullname " +
                "FROM novel AS n INNER JOIN [status] AS s ON n.status_id = s.id " +
                "INNER JOIN category AS c ON n.category_id = c.id " +
                "INNER JOIN users AS u1 ON n.createdby = u1.id " +
                "INNER JOIN users AS u2 ON n.modifiedby = u2.id " +
                "WHERE n.category_id = ?"
                );
        addPagination(pageble, sql);
        return query(sql.toString(), new NovelMapper(), categoryId);
    }


    @Override
    public Integer insert(Novel Novel) {
        String
                sql = "INSERT INTO novel(" +
                "title, " +
                "image, " +
                "short_description, " +
                "reference, " +
                "author, " +
                "status_id, " +
                "category_id ) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        return insert(sql,
                Novel.getTitle(),
                Novel.getImage(),
                Novel.getShortDescription(),
                Novel.getReference(),
                Novel.getAuthor(),
                1,
                1
        );
    }

    @Override
    public Integer update(Novel Novel) {
        String sql = "UPDATE novel " +
                "SET title = ?, " +
                "image = ?, " +
                "short_description = ?, " +
                "reference = ?,  " +
                "author = ?,  " +
                "status_id = ?,  " +
                "category_id = ?  " +
                "WHERE id = ? ";
        return update(sql,
                Novel.getTitle(),
                Novel.getImage(),
                Novel.getShortDescription(),
                Novel.getReference(),
                Novel.getAuthor(),
                1,
                1,
                Novel.getId());
    }

    @Override
    public Integer delete(Integer id) {
        String sql = "DELETE FROM novel WHERE id = ? ";
        return update(sql, id);
    }
}
