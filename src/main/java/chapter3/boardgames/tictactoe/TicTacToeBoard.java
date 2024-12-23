package chapter3.boardgames.tictactoe;

import chapter3.boardgames.Board;

public class TicTacToeBoard implements Board<int[], int[][], Integer  > {
    public static final int EMPTY = 0;
    public static final int ROW = 0;
    public static final int COL = 1;
    int[][] board;
    int current;

    @Override
    public boolean isGameOver() {
        /* todo: Checks the game is over acc.to tictactoe*/
        if (isFull())
            return true;
        return false;
    }

    private boolean isFull() {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board.length; c++) {
                if (board[r][c]== EMPTY)
                    return false;
            }
        }
        return true;
    }

    @Override
    public int[][] boardInfo() {
        int[][] copy = new int[board.length][];
        for (int i = 0; i < board.length; i++) {
            copy[i]= board[i].clone();
        }
        return copy;
    }

    @Override
    public int init(Integer boardSize) {
        board = new int[boardSize][boardSize];
        current =0;
        return current; // First player
    }

    @Override
    public void endGame() {
    }

    @Override
    public int update(int[] move) {
        if (!isValid(move))
            return current;

        board[move[ROW]][move[COL]] = current+1;
        current = (current+1)%2;

        return current;
    }

    private boolean isValid(int[] move) {
        return  ( move[ROW]<board.length && move[ROW]>=0 &&
                  move[COL]<board.length && move[COL]>=0 && board[move[ROW]][move[COL]]==EMPTY
        );
     }
}
