package com.chanhnguyen.entity;

import java.sql.Date;

public class User extends General{
    private String username;
    private String password;
    private String fullName;
    private boolean status;
    private Integer rodeId;
    private Role role;

    public User() {
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Integer getRodeId() {
        return rodeId;
    }

    public void setRodeId(Integer rodeId) {
        this.rodeId = rodeId;
    }
}
