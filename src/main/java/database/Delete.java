package database;
import java.sql.*;
public class Delete {
    public void deleteActUser()
    {

        String url = "jdbc:sqlserver://localhost:1434;database=FlowerShop;integratedSecurity=true;trustServerCertificate=true;encrypt=true;";
        try {
            Connection connection = DriverManager.getConnection(url);
            //System.out.println("Connection to MSSQLSERVER02 for DeleteHelmetList established");
            String SqlQuery = "DELETE FROM dbo.ActUser";
            PreparedStatement preparedStatement = connection.prepareStatement(SqlQuery);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
