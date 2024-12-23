package chapter3.boardgames.tictactoe;

import chapter3.boardgames.Player;

import static chapter3.boardgames.tictactoe.TicTacToeBoard.EMPTY;

public class DummyTTTPlayer implements Player<int[],int[][]> {
    @Override
    public int[] makeMove(int[][] board) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board.length; c++) {
                if (board[r][c]== EMPTY)
                    return new int[]{r,c};
            }
        }
        return null;
    }

    @Override
    public void init() {

    }

    @Override
    public void endGame() {

    }
}
