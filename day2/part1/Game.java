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
}
