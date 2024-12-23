package chapter5.sudoku;



import utils.ConsolPen;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.IntStream;


class SudokuBoard  {

    public static final int EMPTY = 0;


    private int[][] board;
    private int boardSize;
    private int blockSize;


    SudokuBoard(int[][] board) {
        this.board = board;
        boardSize = board.length;
        blockSize = (int) Math.sqrt(boardSize);// Casting a double value into integer
    }

    SudokuBoard(int boardSize)
    {
        board = new int[boardSize][boardSize];
        this.boardSize = boardSize;
        this.blockSize = (int) Math.sqrt(boardSize);
    }

    SudokuBoard(SudokuBoard other)
    {
        boardSize = other.boardSize;
        blockSize = other.blockSize;
        board = new int[boardSize][boardSize];
        for (int r = 0; r < boardSize; r++) {
            for (int c = 0; c < boardSize; c++) {
                board[r][c]= other.board[r][c];
            }
        }

    }


    // Getter of each element of the board
    int get(int row, int col)
    {
        return board[row][col];
    }

    public int getBoardSize() {
        return boardSize;
    }

    public int getBlockSize() {
        return blockSize;
    }

    public String toString() {
        String st= "";

        st += boardLine();

        for (int row = 0; row < boardSize; row++) {
            st += rowToString(row);
            if ((row+1)%blockSize==0)
                st += boardLine();
        }

        return st;
    }

    private String rowToString(int row) {

        String st ="| ";
        for (int col = 0; col < boardSize; col++) {
            st += cellToString(row,col);
            if ( (col+1)%blockSize==0 )
                st += ConsolPen.colorize(ConsolPen.BLACK_BOLD_BRIGHT,"| ");
        }
        return st + "\n";
    }

    private String cellToString(int row, int col) {
        if (board[row][col]==EMPTY)
            return ConsolPen.colorize(ConsolPen.ANSI_YELLOW,". ");
        else
            return ConsolPen.colorize(ConsolPen.BLUE_BOLD_BRIGHT, board[row][col] + " ");
    }

    private String boardLine() {
        String st = "";
        int len = (boardSize+blockSize)*2+1;
        for (int i = 0; i < len; i++) {
            st += ConsolPen.colorize(ConsolPen.BLACK_BOLD_BRIGHT,"=");
        }
        return st +"\n";
    }

    /**
     * returns the given row as an array
     * @param row
     * @return
     */
    private int[] row(int row)
    {
        return board[row];
    }

    /**
     * returns the given column as an array
     * @param col
     * @return
     */
    private int[] col(int col)
    {
        int[] colArray= new int[boardSize];
        for (int r = 0; r <boardSize ; r++) {
            colArray[r]=board[r][col];
        }
        return colArray;
    }

    /**
     * returns the given block as an array
     * @param b
     * @return
     */
    private int[] block(int b)
    {
        int[] block= new int[boardSize];
        int tr = blockSize* (b / blockSize);
        int tc = blockSize* (b % blockSize);
        for (int r = 0; r < blockSize; r++) {
            for (int c = 0; c < blockSize; c++) {
                block[r*blockSize+c]=board[tr+r][tc+c];
            }
        }
        return block;
    }

    private boolean isValid() {
        Supplier<Integer[]> producer = ()->IntStream.range(0,boardSize).boxed().toArray(Integer[]::new);
        return Validator.validateAll(producer, Arrays.asList(this::row,this::col,this::block),this::validArray);
    }

    private boolean validArray(int[] arr) {
        int[] counts = new int[boardSize+1];

        for (int num: arr)
        {
            if (num<0 || num>boardSize)
                return false;

            if (num==EMPTY)
                continue;

            counts[num]++;
            if (counts[num]>1)
                return false;

        }
        return true;
    }


    public static void main(String[] args) {
        SudokuBoard sb = new SudokuBoard(9);

        sb.board[0][4]= 3;
        sb.board[5][2]= 6;
        sb.board[5][1]= 4;
        sb.board[4][2]= 7;
       // sb.board[3][0]= 7;


        System.out.println(sb);
        System.out.println(sb.isValid());
    }




}
