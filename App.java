import java.sql.*;

public class App {
    public static void main(String[] args) {
        String url = "jdbc:mysql://db:3306/testdb"; // db = MySQL container name
        String user = "root";
        String password = "root";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();

            // Just create table and insert one row
            stmt.execute("CREATE TABLE IF NOT EXISTS users (name VARCHAR(50))");
            stmt.execute("INSERT INTO users (name) VALUES ('Satvik')");

            // Read and print
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                System.out.println("User: " + rs.getString("name"));
            }

            con.close();
        } catch (Exception e) {
            System.out.println("Error connecting to MySQL: " + e.getMessage());
        }
    }
}