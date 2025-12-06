import java.sql.ResultSet;

public class DbInspector {
    public static void main(String[] args) {
        try {
            Conns c = new Conns();
            ResultSet rs = c.stmt.executeQuery("SELECT username, password FROM account");
            System.out.println("Accounts in DB:");
            int count = 0;
            while (rs.next()) {
                String u = rs.getString("username");
                String p = rs.getString("password");
                System.out.println(" - " + u + " : " + p);
                count++;
            }
            if (count == 0)
                System.out.println("(no rows found in account table)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
