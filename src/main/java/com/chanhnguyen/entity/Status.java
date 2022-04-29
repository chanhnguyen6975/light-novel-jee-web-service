package com.chanhnguyen.entity;

import java.sql.Date;

public class Status extends General{
    private String name;

    public Status() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
