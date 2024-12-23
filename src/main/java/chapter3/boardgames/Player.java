package chapter3.boardgames;

public interface Player<M,BI> {
    M makeMove(BI bi);

    void init();

    void endGame();
}
