package snakeGame;

import java.sql.Connection;
import java.sql.SQLException;

public class TestDB {

    public static void main(String[] args) {

        try (Connection conn = Database.getConnection()) {

            System.out.println("Connected to MySQL successfully!");

        } catch (SQLException e) {

            System.out.println("Database connection failed.");
            e.printStackTrace();
        }
    }
}
