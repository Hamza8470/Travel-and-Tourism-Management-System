public class DbAddUser1 {
    public static void main(String[] args) {
        try {
            Conns c = new Conns();
            // check if user1 exists
            java.sql.ResultSet rs = c.stmt.executeQuery("SELECT username FROM account WHERE username='user1'");
            if (rs.next()) {
                System.out.println("user1 already exists in account table");
                return;
            }
            // insert customer and account
            c.stmt.executeUpdate(
                    "INSERT INTO customer (username,name,email,phone,address,gender) VALUES ('user1','John Doe','john@example.com','1234567890','123 Main St','Male')");
            c.stmt.executeUpdate(
                    "INSERT INTO account (username,name,password,security,answer) VALUES ('user1','John Doe','password123','Your fav Books ?','answer123')");
            System.out.println("Inserted user1 into customer and account tables.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
