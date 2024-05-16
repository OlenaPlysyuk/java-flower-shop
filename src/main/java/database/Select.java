package database;

import com.example.flowerstore.florist.Accessories;
import com.example.flowerstore.florist.Bouquet;
import com.example.flowerstore.florist.Flower;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class Select {
    public boolean existUsers(String name,String email,String password)
    {
        String url = "jdbc:sqlserver://localhost:1434;database=FlowerShop;integratedSecurity=true;trustServerCertificate=true;encrypt=true;";
        try {
            Connection connection = DriverManager.getConnection(url);
            String SqlQuery = "SELECT * FROM dbo.Users";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            int ch = 0;
            while(resultSet.next())
            {
                System.out.println(resultSet.getString("Email"));
                System.out.println(resultSet.getString("Name"));
                if(email.equals(resultSet.getString("Email")) || name.equals(resultSet.getString("Name")))
                {
                    System.out.println("Error!Exists user with that name or email");
                    ch = 1;
                    break;
                }

            }
            connection.close();
            if(ch == 0)
            {
                Insert insert = new Insert();
                insert.insertUser(name, email, password);
                return true;
            }
            else
            {
                return false;
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean isUser(String name,String password)
    {
        String url = "jdbc:sqlserver://localhost:1434;database=FlowerShop;integratedSecurity=true;trustServerCertificate=true;encrypt=true;";
        try {
            Connection connection = DriverManager.getConnection(url);
            String SqlQuery = "SELECT * FROM dbo.Users";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            int ch = 0;
            System.out.println(name);
            System.out.println(password);
            while(resultSet.next())
            {
                System.out.println(resultSet.getString("Name"));
                System.out.println(resultSet.getString("Password"));
                if(name.equals(resultSet.getString("Name")) && password.equals(resultSet.getString("Password")))
                {
                    System.out.println("Log in is successful");
                    ch = 1;
                    break;
                }

            }
            connection.close();
            if(ch == 1)
            {
                return true;
            }
            else
            {
                return false;
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean existUserData()
    {
        String url = "jdbc:sqlserver://localhost:1434;database=FlowerShop;integratedSecurity=true;trustServerCertificate=true;encrypt=true;";
        try {
            Connection connection = DriverManager.getConnection(url);
            String SqlQuery = "SELECT * FROM dbo.ActUser";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            resultSet.next();
            String email = resultSet.getString("Email");
            System.out.println(email);
            SqlQuery = "SELECT * FROM dbo.Users";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SqlQuery);
            int ch = 0;
            while(resultSet.next()) {
                if (email.equals(resultSet.getString("Email"))) {
                    ch = resultSet.getInt("UserID");
                    break;
                }
            }
            SqlQuery = "SELECT * FROM dbo.UserData";
            resultSet = statement.executeQuery(SqlQuery);
            while(resultSet.next()) {
                if (ch == resultSet.getInt("UserID")) {
                    return true;
                }
            }
            connection.close();
            return false;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public int FindUser()
    {
        String url = "jdbc:sqlserver://localhost:1434;database=FlowerShop;integratedSecurity=true;trustServerCertificate=true;encrypt=true;";
        try {
            Connection connection = DriverManager.getConnection(url);
            String SqlQuery = "SELECT * FROM dbo.ActUser";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            resultSet.next();
            String email = resultSet.getString("Email");
            System.out.println(email);
            SqlQuery = "SELECT * FROM dbo.Users";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SqlQuery);
            int ch = 0;
            while(resultSet.next()) {
                if (email.equals(resultSet.getString("Email"))) {
                    ch = resultSet.getInt("UserID");
                    break;
                }
            }
            connection.close();
            System.out.println(ch);
            return ch;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ObservableList<Flower> SelectFlowers()
    {
        ObservableList<Flower> list = FXCollections.observableArrayList();
        String url = "jdbc:sqlserver://localhost:1434;database=FlowerShop;integratedSecurity=true;trustServerCertificate=true;encrypt=true;";
        try {
            Connection connection = DriverManager.getConnection(url);
            String SqlQuery = "SELECT * FROM dbo.Flower";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            int k = 0;
            while (resultSet.next() && k < 10) {
                int flowerId = resultSet.getInt("ID");
                String flowerName = resultSet.getString("Name");
                String flowerColor = resultSet.getString("Color");
                String scent = resultSet.getString("Scent");
                String size = resultSet.getString("Size");
                String description = resultSet.getString("Description");
                String producer = resultSet.getString("Producer");
                String countryOfOrigin = resultSet.getString("CountryOfOrigin");
                int price = resultSet.getInt("Price");
                int count = resultSet.getInt("Count");
                System.out.println("Chflower #" + flowerId +
                        "\n\tName:" + flowerName +
                        "\n\tColor:" + flowerColor +
                        "\n\tScent:" + scent +
                        "\n\tSize:" + size +
                        "\n\tDescription:" + description +
                        "\n\tProducer:" + producer +
                        "\n\tCountry of origin:" + countryOfOrigin +
                        "\n\tPrice:" + price +
                        "\n\tCount:" + count);
                list.add(new Flower(flowerName,flowerColor,scent,size,description,producer,countryOfOrigin,price,count));
                k++;
            }

            connection.close();
            return list;
        } catch (SQLException e){
            System.err.println("SQL State: " + e.getSQLState());
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("Message: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public ObservableList<Accessories> SelectAccessoirs()
    {
        ObservableList<Accessories> list = FXCollections.observableArrayList();

        String url = "jdbc:sqlserver://localhost:1434;database=FlowerShop;integratedSecurity=true;trustServerCertificate=true;encrypt=true;";
        try {
            Connection connection = DriverManager.getConnection(url);
            String SqlQuery = "SELECT * FROM dbo.Accessoirs";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("Name");
                String colour = resultSet.getString("Colour");
                int price = resultSet.getInt("Price");
                System.out.println("Accessoir #" + id +
                        "\n\tName:" + name +
                        "\n\tColour:" + colour +
                        "\n\tPrice:" + price);
                list.add(new Accessories(name,price,colour));
            }
            connection.close();
            return list;
        } catch (SQLException e){
            System.err.println("SQL State: " + e.getSQLState());
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("Message: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public int FlowerPrice(int ID)
    {
        String url = "jdbc:sqlserver://localhost:1434;database=FlowerShop;integratedSecurity=true;trustServerCertificate=true;encrypt=true;";
        try {
            Connection connection = DriverManager.getConnection(url);
            String SqlQuery = "SELECT * FROM dbo.Flower";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            int ch = 0;
            while(resultSet.next())
            {
                if(ID == (resultSet.getInt("ID")))
                {
                    ch = resultSet.getInt("Price");
                    break;
                }
            }
            return ch;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public int AccesPrice(int ID)
    {
        String url = "jdbc:sqlserver://localhost:1434;database=FlowerShop;integratedSecurity=true;trustServerCertificate=true;encrypt=true;";
        try {
            Connection connection = DriverManager.getConnection(url);
            String SqlQuery = "SELECT * FROM dbo.Accessoirs";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            int ch = 0;
            while(resultSet.next())
            {
                if(ID == (resultSet.getInt("ID")))
                {
                    ch = resultSet.getInt("Price");
                    break;
                }
            }
            return ch;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ObservableList<Bouquet> SelectBouquets()
    {
        ObservableList<Bouquet> list = FXCollections.observableArrayList();
        String url = "jdbc:sqlserver://localhost:1434;database=FlowerShop;integratedSecurity=true;trustServerCertificate=true;encrypt=true;";
        try {
            Connection connection = DriverManager.getConnection(url);
            String SqlQuery = "SELECT * FROM dbo.Bouquet";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SqlQuery);
            int k = 0;
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String flowerName = resultSet.getString("Name");
                String description = resultSet.getString("Des");
                int price = resultSet.getInt("Price");
                System.out.println("Bouquet #" + id +
                        "\n\tName:" + flowerName +
                        "\n\tDescription:" + description +
                        "\n\tPrice:" + price);
                list.add(new Bouquet(flowerName,price,description));
            }
            connection.close();
            return list;
        } catch (SQLException e){
            System.err.println("SQL State: " + e.getSQLState());
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("Message: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
