
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conns {
    public Statement stmt;
    public Connection c;

    public Conns() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/tms?serverTimezone=UTC&useSSL=false";
            // Try common credential options (root:root, root:''), useful for XAMPP
            String[][] creds = { { "root", "root" }, { "root", "" } };
            boolean connected = false;
            for (String[] cred : creds) {
                try {
                    c = DriverManager.getConnection(url, cred[0], cred[1]);
                    stmt = c.createStatement();
                    System.out.println("Database connected successfully with user='" + cred[0] + "'.");
                    connected = true;
                    break;
                } catch (SQLException se) {
                    // try next credential
                }
            }
            if (!connected) {
                // Final attempt without password parameter (some XAMPP setups)
                try {
                    c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tms?serverTimezone=UTC&useSSL=false",
                            "root", null);
                    stmt = c.createStatement();
                    System.out.println("Database connected successfully with user='root' (no password).\n");
                    connected = true;
                } catch (SQLException se) {
                    System.err.println(
                            "Database connection failed. Make sure MySQL is running and database 'tms' exists.");
                    System.err.println(
                            "Tried common credentials: root/root and root/(empty).\nError: " + se.getMessage());
                    se.printStackTrace();
                }
            }
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL Driver not found: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
