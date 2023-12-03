import java.util.ArrayList;

public class Game {

    private ArrayList<Drawn> allDrawns;
    private int gameId;

    public Game(int gameId, ArrayList<Drawn> allDrawns) {
        this.gameId = gameId;
        this.allDrawns = allDrawns;
    }

    public boolean isGamePossible(int redCubesLoaded, int greenCubesLoaded, int blueCubesLoaded) {
        boolean isPossible = true;
        for (Drawn drawn : allDrawns) {
            isPossible = isPossible && drawn.isDrawnPossible(redCubesLoaded, greenCubesLoaded, blueCubesLoaded);
        }

        return isPossible;
    }

    public int getGameId() {
        return gameId;
    }

    public int getPower() {
        int minRed = 0;
        int minBlue = 0;
        int minGreen = 0;
        for (Drawn drawn : allDrawns) {
            int currentRed = drawn.getRedCubesDrawn();
            int currentGreen = drawn.getGreenCubesDrawn();
            int currentBlue = drawn.getBlueCubesDrawn();
            if (currentRed > minRed)
                minRed = currentRed;
            if (currentGreen > minGreen)
                minGreen = currentGreen;
            if (currentBlue > minBlue)
                minBlue = currentBlue;
        }

        return minRed * minBlue * minGreen;

    }
}
