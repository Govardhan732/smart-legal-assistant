import java.sql.*;

public class DBHandler {
    public static void save(String query, String category, String advice) {
        String url = "jdbc:mysql://localhost:3306/legal_ai";
        String username = "root";
        String password = "admin123"; // 🔁 Change if yours is different

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "INSERT INTO legal_queries (user_query, predicted_category, advice) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, query);
            stmt.setString(2, category);
            stmt.setString(3, advice);
            stmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

