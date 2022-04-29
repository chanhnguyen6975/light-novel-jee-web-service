package com.chanhnguyen.service.impl;

import com.chanhnguyen.dao.IChapterDAO;
import com.chanhnguyen.entity.Chapter;
import com.chanhnguyen.entity.Chapter;
import com.chanhnguyen.service.IChapterService;

import javax.inject.Inject;
import java.util.List;

public class ChapterService implements IChapterService {
    @Inject
    private IChapterDAO iChapterDAO;

    @Override
    public Chapter findById(Integer id, Integer novelId) {
        return iChapterDAO.findById(id, novelId);
    }

    @Override
    public List<Chapter> findAll(Integer novelId) {
        return iChapterDAO.findAll(novelId);
    }

    @Override
    public Chapter insert(Chapter Chapter) {
        Integer chapterId = iChapterDAO.insert(Chapter);
        return findById(chapterId, Chapter.getNovelId());
    }

    @Override
    public Chapter update(Chapter Chapter) {
        iChapterDAO.update(Chapter);
        //
        return findById(Chapter.getId(), Chapter.getNovelId());
    }

    @Override
    public void delete(Integer id) {
        iChapterDAO.delete(id);
    }
}
