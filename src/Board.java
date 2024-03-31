/**
 * a class that handle the board logic of the game tictactoe using the enum
 * Mark
 * @author amitai turkel
 */
public class Board {
    /**
     * the defult winstreack
     */
    private static final int WINSTREAKDEFULT =  3;
    /**
     * the defult size
     */
    private static final int SIZEDEFULT =  3;
    /**
     * how many mark we need in row to win
     */
    private int in_row_to_win;
    private int Size;
    private Mark[][] board;
    /**
     * a constructor that doesn't receive any parameters
     */
    public Board() {
        this.in_row_to_win = WINSTREAKDEFULT;
        this.Size = SIZEDEFULT;
        this.board = new Mark[this.Size][this.Size];
        for (int i = 0; i < this.Size; i++) {
            for (int j = 0; j < this.Size; j++) {
                this.board[i][j] = Mark.BLANK;
            }
        }
    }
    /**
     * a constructor that receive only the size of the board
     * @param size the size that the board will be nXn
     */
    Board(int size) {
        this.in_row_to_win = WINSTREAKDEFULT;
        this.Size = size;
        this.board = new Mark[this.Size][this.Size];
        for (int i = 0; i < this.Size; i++) {
            for (int j = 0; j < this.Size; j++) {
                this.board[i][j] = Mark.BLANK;
            }
        }
    }
    /**
     * return the size of the board
     */
    public int getSize() {
        return this.Size;
    }
    /**
     * a meathod that return the 2D array thar repesent the board.
     */
    public Mark[][] getBoard() {
        return this.board;
    }
    /**
     * a meathod that try to put the X or the O in the board, return false if failed
     * @param mark the mark we want to put X or O
     * @param row the row we want to put in
     * @param col the column we want to put in
     */
    public boolean putMark(Mark mark, int row, int col) {
        if (row < this.Size && row >= 0 && col < this.Size && col >= 0 && mark != Mark.BLANK) {
            if (board[row][col] == Mark.BLANK) {
                board[row][col] = mark;
                return true;
            }
        }
        return false;

    }
    /**
     * a meathod that return the mark that is in the board[row][col]
     * if the request was illegal will return Mark.BLANK
     * @param row the row that we want
     * @param col the column we want
     */
    public Mark getMark(int row, int col) {
        if (row < this.Size && row >= 0 && col < this.Size && col >= 0) {
            return this.board[row][col];
        }
        return Mark.BLANK;
    }
}
