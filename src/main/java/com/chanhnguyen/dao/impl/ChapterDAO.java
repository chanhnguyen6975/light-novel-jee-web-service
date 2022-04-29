package com.chanhnguyen.dao.impl;

import com.chanhnguyen.dao.IChapterDAO;
import com.chanhnguyen.entity.Chapter;
import com.chanhnguyen.entity.Novel;
import com.chanhnguyen.mapper.ChapterMapper;

import java.util.List;

public class ChapterDAO extends GeneralDAO implements IChapterDAO {

    @Override
    public Chapter findById(Integer id, Integer novelId) {
        String sql = "SELECT * " +
                "FROM chapter AS c INNER JOIN novel AS n " +
                "ON c.novel_id = n.id " +
                "WHERE c.novel_id = ? AND c.id = ?";

        //Select all chapters of novel identified , then select one.
        List<Chapter> list = query(sql, new ChapterMapper(), novelId, id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<Chapter> findAll(Integer novelId) {
        String sql = "SELECT * " +
                "FROM chapter AS c INNER JOIN novel AS n " +
                "ON c.novel_id = n.id " +
                "WHERE c.novel_id = ?";
        return query(sql, new ChapterMapper(), novelId);
    }

    @Override
    public Integer insert(Chapter chapter) {
        String sql = "INSERT INTO chapter(title, content, novel_id) VALUES(?, ?, ?)";
        return insert(sql, chapter.getTitle(), chapter.getContent(), chapter.getNovelId());
    }

    @Override
    public Integer update(Chapter chapter) {
        String sql = "UPDATE chapter SET title = ?, content = ? WHERE id = ?";
        return update(sql, chapter.getTitle(), chapter.getContent(), chapter.getId());
    }

    @Override
    public Integer delete(Integer id) {
        String sql = "DELETE FROM chapter WHERE id = ?";
        return update(sql,id);
    }


}
