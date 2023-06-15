package com.playdata.todos.dao;

import com.playdata.todos.config.JdbcConnection;
import com.playdata.todos.dto.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {

    private static final UserDao instance = new UserDao();

    private UserDao() {

    }

    public static UserDao getInstance (){
        return instance;
    }

    public void insert(User user){
        Connection conn = JdbcConnection.getJdbc();
        String sql ="insert into users(username,password,name)"+
                "values(?,?,?)";

        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1,user.getUsername());
            psmt.setString(2,user.getPassword());
            psmt.setString(3,user.getName());
            psmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

