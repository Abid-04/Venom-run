package snakeGame;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestDB {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/snake_game";
        String user = "root"; // your MySQL username
        String password = "Potsdam@12"; // your MySQL password

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to MySQL successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
