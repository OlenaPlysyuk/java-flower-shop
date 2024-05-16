package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {
    public boolean insertUser(String name,String email,String password)
    {
        String url = "jdbc:sqlserver://localhost:1434;database=FlowerShop;integratedSecurity=true;trustServerCertificate=true;encrypt=true;";
        try {
            Connection connection = DriverManager.getConnection(url);
            String SqlQuery = "INSERT INTO dbo.Users VALUES (" + "'" + name + "','" + email + "','" + password + "');";
            PreparedStatement preparedStatement = connection.prepareStatement(SqlQuery);
            preparedStatement.execute();
            connection.close();
            return true;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean insertActUser(String name,String email,String password)
    {
        String url = "jdbc:sqlserver://localhost:1434;database=FlowerShop;integratedSecurity=true;trustServerCertificate=true;encrypt=true;";
        try {
            Connection connection = DriverManager.getConnection(url);
            String SqlQuery = "INSERT INTO dbo.ActUser VALUES (" + "'" + email + "','" + name + "','" + password + "');";
            PreparedStatement preparedStatement = connection.prepareStatement(SqlQuery);
            preparedStatement.execute();
            connection.close();
            return true;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean insertUserData(int userID,String phone,String address,String payment)
    {
        String url = "jdbc:sqlserver://localhost:1434;database=FlowerShop;integratedSecurity=true;trustServerCertificate=true;encrypt=true;";
        try {
            Connection connection = DriverManager.getConnection(url);
            String SqlQuery = "INSERT INTO dbo.UserData VALUES (" + "'" + userID + "','" + phone + "','" + address + "','" + payment + "');";
            PreparedStatement preparedStatement = connection.prepareStatement(SqlQuery);
            preparedStatement.execute();
            connection.close();
            return true;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean insertMadedBouquets(int userID,int flow_id,int a_id,int price)
    {
        String url = "jdbc:sqlserver://localhost:1434;database=FlowerShop;integratedSecurity=true;trustServerCertificate=true;encrypt=true;";
        try {
            Connection connection = DriverManager.getConnection(url);
            String SqlQuery = "INSERT INTO dbo.MadedBouquets VALUES (" + "'" + userID + "','" + flow_id + "','" + a_id + "','" + price + "');";
            PreparedStatement preparedStatement = connection.prepareStatement(SqlQuery);
            preparedStatement.execute();
            connection.close();
            return true;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean insertUserBouquets(int userID,int bou_id)
    {
        String url = "jdbc:sqlserver://localhost:1434;database=FlowerShop;integratedSecurity=true;trustServerCertificate=true;encrypt=true;";
        try {
            Connection connection = DriverManager.getConnection(url);
            String SqlQuery = "INSERT INTO dbo.UserBouquets VALUES (" + "'" + userID + "','" + bou_id + "');";
            PreparedStatement preparedStatement = connection.prepareStatement(SqlQuery);
            preparedStatement.execute();
            connection.close();
            return true;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean insertUserFlowers(int userID,int flowerID,int count,int summ)
    {
        String url = "jdbc:sqlserver://localhost:1434;database=FlowerShop;integratedSecurity=true;trustServerCertificate=true;encrypt=true;";
        try {
            Connection connection = DriverManager.getConnection(url);
            String SqlQuery = "INSERT INTO dbo.UserFlowers VALUES (" + "'" + userID + "','" + flowerID + "','" + count + "','" + summ + "');";
            PreparedStatement preparedStatement = connection.prepareStatement(SqlQuery);
            preparedStatement.execute();
            connection.close();
            return true;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
