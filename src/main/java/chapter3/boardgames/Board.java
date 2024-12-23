package chapter3.boardgames;

public interface Board<M, BI, BII> {
    boolean isGameOver();
    BI boardInfo();

    int init(BII bii); // returns the current player

    void endGame();//// hook

    int update(M move); // returns the current player
}
