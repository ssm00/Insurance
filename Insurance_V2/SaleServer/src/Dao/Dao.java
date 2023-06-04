package Dao;

import java.sql.*;

public class Dao {
    private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    public void connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bunsan?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true", "root", "Q12345678@");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void create(String query) throws SQLException{
        statement = connect.createStatement();
        if (!statement.execute(query))
            System.out.println("insert OK!!!");
    }
    public ResultSet retrieve(String query) throws SQLException{
        statement = connect.createStatement();
        return resultSet = statement.executeQuery(query);
    }
    public void update(String query) throws SQLException{
        statement = connect.createStatement();
        if(!statement.execute(query))
            System.out.println("update OK!!!");
    }
    public void delete(String query) throws SQLException{
        statement = connect.createStatement();
        if(!statement.execute(query))
            System.out.println("delete OK!!!");
    }
}
