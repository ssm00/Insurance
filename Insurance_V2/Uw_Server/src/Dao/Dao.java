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
    public void create(String query){

        try {
            statement = connect.createStatement();
            if (!statement.execute(query))
                System.out.println("insert OK!!!");
        } catch (SQLException e) {
            System.out.println("저장에 실패했습니다. 다시 시도해주세요.");
        }
    }
    public ResultSet retrieve(String query){
        try {
            statement = connect.createStatement();
            return resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("불러오기에 실패했습니다. 다시 시도해주세요.");
        }
        return resultSet;
    }
    public void update(String query){
        try {
            statement = connect.createStatement();
            if(!statement.execute(query))
                System.out.println("update OK!!!");
        } catch (SQLException e) {
            System.out.println("저장에 실패했습니다. 다시 시도해주세요.");
        }
    }
    public void delete(String query){
        try {
            statement = connect.createStatement();
            if(!statement.execute(query))
                System.out.println("delete OK!!!");
        } catch (SQLException e) {
            System.out.println("삭제에 실패했습니다. 다시 시도해주세요.");
        }
    }
}
