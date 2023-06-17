package com.playdata.todos.dao;

import com.playdata.todos.config.JdbcConnection;
import com.playdata.todos.dto.ToDos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ToDoDao {

    private static final ToDoDao instance = new ToDoDao();

    public static ToDoDao getInstance (){
      return instance;
    }

    public void insert(ToDos todo){
        Connection conn = JdbcConnection.getJdbc();

        String sql="insert  into todos(id,user_id,content) values (?,?,?);";

        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setInt(1,todo.getId());
            psmt.setInt(2,todo.getUser_id());
            psmt.setString(3,todo.getContent());
            psmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
