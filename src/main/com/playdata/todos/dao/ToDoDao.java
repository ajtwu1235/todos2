package com.playdata.todos.dao;

import com.playdata.todos.config.JdbcConnection;
import com.playdata.todos.dto.ToDos;
import com.playdata.todos.dto.TodoJoinUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListResourceBundle;

public class ToDoDao {

    private static final ToDoDao instance = new ToDoDao();

    public static ToDoDao getInstance (){
      return instance;
    }

    public void insert(ToDos todo){
        Connection conn = JdbcConnection.getJdbc();

        String sql="insert  into todos(user_id,content) values (?,?);";

        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setInt(1,todo.getUser_id());
            psmt.setString(2,todo.getContent());
            psmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<TodoJoinUser> findAll(){

        List<TodoJoinUser> list = new ArrayList<TodoJoinUser>();

        Connection conn = JdbcConnection.getJdbc();
        String sql="select * from todos as t join users u on u.id = t.user_id";

        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            ResultSet resultSet = psmt.executeQuery();

            while(resultSet.next()){

                int id = resultSet.getInt("id");
                String content =resultSet.getString("content");
                String createAt = resultSet.getString("create_at");
                int checked =resultSet.getInt("checked");
                String username = resultSet.getString("username");
                int user_id = resultSet.getInt("user_id");

                TodoJoinUser user = new TodoJoinUser(id,content,createAt,checked,username,user_id);
                list.add(user);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return list;
    }

    public TodoJoinUser findById(int todo_id){

        TodoJoinUser todoJoinUser;

        Connection conn = JdbcConnection.getJdbc();
        String sql="select * " +
                "from todos as t " +
                "join users u on u.id = t.user_id" +
                " where t.id=?";

        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setInt(1,todo_id);
            ResultSet resultSet = psmt.executeQuery();

            int id = resultSet.getInt("id");
            String content =resultSet.getString("content");
            String createAt = resultSet.getString("create_at");
            int checked =resultSet.getInt("checked");
            String username = resultSet.getString("username");
            int user_id = resultSet.getInt("user_id");

            todoJoinUser = new TodoJoinUser(id,content,createAt,checked,username,user_id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return todoJoinUser;
    }

    public void UpdateToDo(String content,int todo_id){
        Connection conn = JdbcConnection.getJdbc();

        String sql ="update todos set content=? where todos.id=?";

        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1,content);
            psmt.setInt(2,todo_id);
            psmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<TodoJoinUser> getByKeyword(String keyword){

        List<TodoJoinUser> list = new ArrayList<TodoJoinUser>();
        Connection conn = JdbcConnection.getJdbc();

        String sql ="select * from todos as t " +
                "join users u on u.id = t.user_id" +
                " where content like ? ";

        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1,"%"+keyword+"%");
            ResultSet resultSet = psmt.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String content =resultSet.getString("content");
                String createAt = resultSet.getString("create_at");
                int checked =resultSet.getInt("checked");
                String username = resultSet.getString("username");
                int user_id = resultSet.getInt("user_id");

                TodoJoinUser user = new TodoJoinUser(id,content,createAt,checked,username,user_id);
                list.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }
}
