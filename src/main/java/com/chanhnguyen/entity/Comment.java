package com.chanhnguyen.entity;

import java.sql.Date;

public class Comment extends General{
    private String content;
    private Novel novel;

    public Novel getNovel() {
        return novel;
    }

    public void setNovel(Novel novel) {
        this.novel = novel;
    }

    public Comment() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
