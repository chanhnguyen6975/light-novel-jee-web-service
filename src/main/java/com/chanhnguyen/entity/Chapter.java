package com.chanhnguyen.entity;

import java.sql.Date;

public class Chapter extends General{
    private String title;
    private String content;
    private Integer novelId;

    public Chapter() {
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getNovelId() {
        return novelId;
    }

    public void setNovelId(Integer novelId) {
        this.novelId = novelId;
    }
}
