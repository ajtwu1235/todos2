package com.playdata.todos.dto;

public class ToDos {

    private int id;
    private int user_id;
    private String content;
    private String create_at;
    private Integer checked;

    public ToDos(int user_id, String content, Integer checked) {
        this.user_id = user_id;
        this.content = content;
        this.checked = checked;
    }

    public int getId() {
        return id;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getContent() {
        return content;
    }

    public String getCreate_at() {
        return create_at;
    }

    public Integer getChecked() {
        return checked;
    }
}
