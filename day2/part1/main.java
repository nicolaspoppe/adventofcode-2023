import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

class day2 {
    public static Integer getGameId(String game) {
        return Integer.parseInt(game.substring(5));
    }

    public static void main(String[] args) throws Exception {
        File file = new File(".\\data.txt");
        int redCubesLoaded = 12;
        int greenCubesLoaded = 13;
        int blueCubesLoaded = 14;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            ArrayList<Game> allGames = new ArrayList<Game>();
            String line;
            while ((line = br.readLine()) != null) {
                String[] gameAndDataApart = line.split(":");
                int gameId = getGameId(gameAndDataApart[0]);

                String[] allDrawnsString = gameAndDataApart[1].split(";");
                ArrayList<Drawn> allDrawns = new ArrayList<Drawn>();
                for (String drawn : allDrawnsString) {
                    String[] allSingleColorDrawn = drawn.split(",");
                    Drawn currentDrawn = new Drawn();
                    for (String singleColorDrawn : allSingleColorDrawn) {
                        int colorIndex = singleColorDrawn.indexOf("red");
                        if (colorIndex != -1) {
                            int red = Integer.parseInt(singleColorDrawn.substring(1, colorIndex - 1));
                            currentDrawn.setRedCubesDrawn(red);
                            continue;
                        }
                        colorIndex = singleColorDrawn.indexOf("green");
                        if (colorIndex != -1) {
                            int green = Integer.parseInt(singleColorDrawn.substring(1, colorIndex - 1));
                            currentDrawn.setGreenCubesDrawn(green);
                            continue;
                        }
                        colorIndex = singleColorDrawn.indexOf("blue");
                        if (colorIndex != -1) {
                            int blue = Integer.parseInt(singleColorDrawn.substring(1, colorIndex - 1));
                            currentDrawn.setBlueCubesDrawn(blue);
                        }
                    }
                    allDrawns.add(currentDrawn);
                }
                allGames.add(new Game(gameId, allDrawns));
            }

            int counter = 0;
            for (Game g : allGames) {
                if (g.isGamePossible(redCubesLoaded, greenCubesLoaded, blueCubesLoaded)) {
                    counter += g.getGameId();

                }
            }
            System.out.println(counter);
        }

    }
}
