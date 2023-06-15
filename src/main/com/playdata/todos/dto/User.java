package com.playdata.todos.dto;

public class User {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(Integer id, String createAt, String username, String password, String name) {
        this.id = id;
        this.createAt = createAt;
        this.username = username;
        this.password = password;
        this.name = name;
    }

    private String createAt;
    private String username;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    private String password;
    private String name;
}
