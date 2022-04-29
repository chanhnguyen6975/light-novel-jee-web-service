package com.chanhnguyen.entity;


import java.sql.Date;

//Giới tính
//Bối cảnh
//Dịch, sáng tác or convert
public class CategoryGroup extends General{
    private String name;

    public CategoryGroup() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
