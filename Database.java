
package snakeGame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {

    private static final String URL =
        "jdbc:mysql://localhost:3306/snake_game";

    private static final String USER =
        System.getenv("DB_USER");

    private static final String PASSWORD =
        System.getenv("DB_PASSWORD");

    // This is to create and return a database connection
    public static Connection getConnection() throws SQLException {

        if (USER == null || PASSWORD == null) {
            throw new SQLException(
                "Missing DB_USER or DB_PASSWORD environment variable."
            );
        }

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Saving player's score
    public static void saveScore(String playerName, int score) {

        String sql =
            "INSERT INTO scores (player_name, score) VALUES (?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, playerName);
            stmt.setInt(2, score);

            stmt.executeUpdate();
            System.out.println("Score saved!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // getting the highest score
    public static int getHighestScore() {

        String sql =
            "SELECT MAX(score) AS max_score FROM scores";

        int highest = 0;

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                highest = rs.getInt("max_score");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return highest;
    }
}


	        
}
