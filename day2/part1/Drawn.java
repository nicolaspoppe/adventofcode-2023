public class Drawn {
    private int redCubesDrawn;
    private int greenCubesDrawn;
    private int blueCubesDrawn;

    public Drawn() {

    }

    public void setRedCubesDrawn(int redCubesDrawn) {
        this.redCubesDrawn = redCubesDrawn;
    }

    public void setGreenCubesDrawn(int greenCubesDrawn) {
        this.greenCubesDrawn = greenCubesDrawn;
    }

    public void setBlueCubesDrawn(int blueCubesDrawn) {
        this.blueCubesDrawn = blueCubesDrawn;
    }

    public boolean isDrawnPossible(int redCubesLoaded, int greenCubesLoaded, int blueCubesLoaded) {
        return !(this.redCubesDrawn > redCubesLoaded || this.greenCubesDrawn > greenCubesLoaded
                || this.blueCubesDrawn > blueCubesLoaded);
    }
}
