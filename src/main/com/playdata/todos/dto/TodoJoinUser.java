package com.playdata.todos.dto;

public class TodoJoinUser {

    private Integer id;
    private String content;

    private String createAt;

    private int checked;

    private String name;

    private Integer uid;

    public TodoJoinUser(Integer id, String content, String createAt, int checked, String name, Integer uid) {
        this.id = id;
        this.content = content;
        this.createAt = createAt;
        this.checked = checked;
        this.name = name;
        this.uid = uid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public int isChecked() {
        return checked;
    }

    public void setChecked(int checked) {
        this.checked = checked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}
