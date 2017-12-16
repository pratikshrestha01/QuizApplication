package service.user;

import domains.user.User;
import utils.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserService {

    public User getUser(String name,String password) throws ClassNotFoundException {

        User user = null;
        try {
            String query = "select * from user where name=? and password=?";
            PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);

            pstm.setString(1, name);
            pstm.setString(2, password);


            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                user.setId(rs.getInt("id"));

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;


    }

    public User getUser(int id){

        User user = null;
        try {
            String query = "select * from user where id=?";
            PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);

            pstm.setInt(1, id);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                user.setId(rs.getInt("id"));

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public int checkUsername(String username){
        int ct = 0;
        User user = null;
        try {
            String query = "select * from user where name=?";
            PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);

            pstm.setString(1, username);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                ct = 1;
            }
            //ct = rs.getRow();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ct;
    }
    public List<User> getUserList(){

        List<User> userList = new ArrayList<User>();

        try {
            String query = "select * from user";
            PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                user.setId(rs.getInt("id"));

                userList.add(user);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public void addUser(User user){
        try {
            String query = "insert into user(name,password,role) values(?,?,?)";
            PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
            pstm.setString(1,user.getName());
            pstm.setString(2,user.getPassword());
            pstm.setString(3, user.getRole());

            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void delete(int id){
        try {
            String query = "delete from user where id=?";
            PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
            pstm.setInt(1,id);

            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void update(User user){
        try {
            String query = "update user set name=? , password=? , role=? where id=?";
            PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
            pstm.setString(1, user.getName());
            pstm.setString(2,user.getPassword());
            pstm.setString(3,user.getRole());
            pstm.setInt(4, user.getId());

            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



}
