package chapter3.boardgames.tictactoe;

import chapter3.boardgames.BoardGame;

public class TicTacToe extends BoardGame<TicTacToeBoard,int[],int[][],Integer> {

    int boardSize;

    public TicTacToe(TicTacToeBoard board,int boardSize) {
        super(board);
        this.boardSize = boardSize;
    }

    @Override
    protected Integer _init() {
        if (players.size()!=2)
            throw new RuntimeException("TicTacToe requires 2 players");

        return boardSize;
    }

    public static void main(String[] args) {
        TicTacToeBoard tttBoard = new TicTacToeBoard();
        TicTacToe ttt = new TicTacToe(tttBoard,3);
        ttt.addPlayer(new DummyTTTPlayer());
        ttt.addPlayer(new DummyTTTPlayer());
        ttt.setRenderer(new TicTacToeRenderer());
        ttt.setPause(1000);

        ttt.play();
    }

    /* todo: Implement a board game under agame package*/
}
