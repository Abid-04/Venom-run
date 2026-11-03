
package snakeGame;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Database {

    private static final Path SCORE_FOLDER = Paths.get(
        System.getProperty("user.home"), ".venom-run"
    );

    public static void saveScore(String level, int score) {
        int highest = getHighestScore(level);

        if (score > highest) {
            try {
                Files.createDirectories(SCORE_FOLDER);
                Files.writeString(
                    SCORE_FOLDER.resolve(level + ".txt"),
                    String.valueOf(score)
                );
                System.out.println(level + " high score saved: " + score);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static int getHighestScore(String level) {
        Path file = SCORE_FOLDER.resolve(level + ".txt");

        if (!Files.exists(file)) {
            return 0;
        }

        try {
            return Integer.parseInt(Files.readString(file).trim());
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
