package banking;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Jdbc {
    private static final String url = "jdbc:mysql://localhost:3306/xyz";
    private static final String user = "root";
    private static final String password = "Immonit@2003";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
            //System.out.println("Database connected successfully.");
        } catch(SQLException e){
           // System.out.println("Failed to connect :" + e.getMessage() );
        }
            return connection;
    }
    
}
