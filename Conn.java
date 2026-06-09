import java.sql.*;

public class Conn {

    public Connection c;
    public Statement s;

    public Conn() {
        try {
            // Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect
            c = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/TravelManagement",
                    "root",
                    "case8055"
            );

            s = c.createStatement();
            System.out.println("Database Connected Successfully!");

        } catch (Exception e) {
            System.out.println("Database Connection Failed!");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Conn(); // test connection
    }
}
