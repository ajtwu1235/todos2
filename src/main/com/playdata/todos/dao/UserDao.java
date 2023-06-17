package com.playdata.todos.dao;

import com.playdata.todos.config.JdbcConnection;
import com.playdata.todos.dto.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    public User me =null;

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

    public User login(String name, String password){
        Connection conn = JdbcConnection.getJdbc();
        String sql ="select * from users where name=? and  password=?";

        User user = null;

        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1,name);
            psmt.setString(2,password);
            ResultSet resultSet = psmt.executeQuery();
            while(resultSet.next()){

                user = makeUser(resultSet);
            }

           
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        me=user;
        
        return user;
    }

    private static User makeUser(ResultSet resultSet) throws SQLException {
        int anInt = resultSet.getInt("id");
        String username = resultSet.getString("username");
        String password = resultSet.getString("password");
        String name = resultSet.getString("name");
        String createAt = resultSet.getString("create_at");

        User user = new User(anInt, createAt, username, password, name);
        return user;
    }
}

