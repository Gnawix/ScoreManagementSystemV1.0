package com.sms.pojo;

public class User {
    private String username;
    private String password;
    private String perms;

    public User() {
    }

    public User(String username, String password, String perms) {
        this.username = username;
        this.password = password;
        this.perms = perms;
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

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }
}
