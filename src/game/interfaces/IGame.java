package game.interfaces;

public interface IGame {
    public void startGame();
    public void endGame();
    public void getProgress();
    public void createSudoku(int difficulty);
}
