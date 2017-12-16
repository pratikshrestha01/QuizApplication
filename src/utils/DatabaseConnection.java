package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Ravi on 04/07/2016.
 */
public class DatabaseConnection {

    String url = "jdbc:mysql://localhost:3306/quiz";
    String username = "root";
    String pwd = "";

    Connection connection = null;
    public DatabaseConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, pwd);
            System.out.println("connection success!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public PreparedStatement getPreparedStatement(String query) {

        try {
            PreparedStatement pstm = connection.prepareStatement(query);
            return pstm;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Connection getConnection() {
        return connection;
    }
}
