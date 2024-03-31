/**
 * a class that handle the game tictaktoe logic
 */
public class Game {
    Player playerX;
    Player playerO;
    Renderer renderer;
    Board board;
    int winStreak;
    int size;
    int placed;
    int maxTurns;
    /**
     * the defult winstreack
     */
    private static final int WINSTREAKDEFULT =  3;
    /**
     * the defult size
     */
    private static final int SIZEDEFULT =  4;
    /**
     * the number of mark that we placed so far
     */
    private static final int MARKPLACED =  0;
    /**
     * the class constructor  with defult winstreak and size
     * @param PlayerX the player the play the O mark
     * @param PlayerO the player that play the X mark
     * @param renderer the renderer we use to represent the game
     */
    public Game(Player PlayerX, Player PlayerO, Renderer renderer){
        this.playerX = PlayerX;
        this.playerO = PlayerO;
        this.renderer = renderer;
        this.winStreak = WINSTREAKDEFULT;
        this.size = SIZEDEFULT;
        this.board = new Board(this.size);
        this.placed = MARKPLACED;
        this.maxTurns = this.size *this.size;

    }
    /**
     * the class constructor
     *
     * @param PlayerX   the player the play the O mark
     * @param PlayerO   the player that play the X mark
     * @param winStreak the winstreak the player need to win
     * @param size      the size of the board
     * @param renderer  the renderer we use to represent the game
     */
    Game(Player PlayerX, Player PlayerO,int winStreak,int size, Renderer renderer){
        this.playerX = PlayerX;
        this.playerO = PlayerO;
        this.renderer = renderer;
        this.winStreak = winStreak;
        if (winStreak <0 || winStreak > size){
            this.winStreak = size;
        }
        this.size = size;
        this.board = new Board(this.size);
        this.placed = 0;
        this.maxTurns = this.size *this.size;
}
    /**
     * a method that return the size of the board
     */
    public int getBoardSize(){
        return this.size;
    }
    /**
     * a method that return the length of the WinStreak
     */
    public int getWinStreak(){
        return this.winStreak;
    }
    /**
     * a method that run one turn of the game and return how won represent by its mark
     */
    public Mark run() {
        boolean notfirstplay = false;
        while (placed < this.maxTurns) {
            if (notfirstplay == true) {
                this.renderer.renderBoard(this.board);
            }
            notfirstplay = true;
            if (playAndCheck(playerX, Mark.X)) {
                this.renderer.renderBoard(this.board);
                return Mark.X;
            }
            this.renderer.renderBoard(this.board);
            if (this.maxTurns == placed ){
                continue;
            }
            if (playAndCheck(playerO, Mark.O)) {
                this.renderer.renderBoard(this.board);
                return Mark.O;
            }

        }
        return Mark.BLANK;
    }
    /**
     * a method that play the player turn and return true if he won
     * @param player the player that play this turn
     * @param mark the player mark
     */
    private boolean playAndCheck(Player player, Mark mark) {
        player.playTurn(board, mark);
        placed++;
        return only_check_winning(board, mark);
    }
    /**
     * a method that check all the board if the player won, return true if he did
     * @param board the board we checking
     * @param mark the mark we check if won
     */
    private boolean only_check_winning(Board board, Mark mark) {
        int size = board.getSize();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (only_check_win(i, j, board, mark)) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * a method that check if the player won by using this a board[row][col] , return true if he did
     * @param row the row number
     * @param col the column number
     * @param board the board we checking
     * @param mark the mark we check if won
     */
    private boolean only_check_win(int row, int col, Board board, Mark mark) {
        int win = this.winStreak;
        int size = this.size;
        int verticalUp = 0;
        int verticalDown = 0;
        int horizontalLeft = 0;
        int horizontalRight = 0;
        int diagonalDownLeft = 0;
        int diagonalUpLeft = 0;
        int diagonalUPRight = 0;
        int diagonalDownRight = 0;

        // Check vertically (up and down)
        for (int i = 0; i < win; i++) {
            if (row + i < size && board.getMark(row + i, col) == mark) {
                verticalDown++;
            } else {
                break;
            }
        }

        for (int i = 0; i < win; i++) {
            if (row - i >= 0 && board.getMark(row - i, col) == mark) {
                verticalUp++;
            } else {
                break;
            }
        }
        if(verticalDown + verticalUp - 1 == win){
            return true;
        }

        // Check horizontally (left and right)
        for (int j = 0; j < win; j++) {
            if (col + j < size && board.getMark(row, col + j) == mark) {
                horizontalRight++;
            } else {
                break;
            }
        }

        for (int j = 0; j < win; j++) {
            if (col - j >= 0 && board.getMark(row, col - j) == mark) {
                horizontalLeft++;
            } else {
                break;
            }
        }
        if (horizontalLeft+horizontalRight -1 == win) {
            return true;
        }


        // Check diagonal (top-left to bottom-right)
        for (int i = 0, j = 0; i < win; i++, j++) {
            if (row + i < size && col + j < size && board.getMark(row + i, col + j) == mark) {
                diagonalDownRight++;
            } else {
                break;
            }
        }
        // Check diagonal (top-right to bottom-left)
        for (int i = 0, j = 0; i < win; i++, j++) {
            if (row - i >= 0 && col - j >= 0 && board.getMark(row - i, col - j) == mark) {
                diagonalUpLeft++;
            } else {
                break;
            }
        }
        if (diagonalUpLeft + diagonalDownRight -1 == win){
            return true;
        }

        // Check diagonal (top-right to bottom-left)
        for (int i = 0, j = 0; i < win; i++, j++) {
            if (row - i >= 0 && col + j < size && board.getMark(row - i, col + j) == mark) {
                diagonalUPRight++;
            } else {
                break;
            }
        }


        // Check diagonal (top-left to bottom-right)
        for (int i = 0, j = 0; i < win; i++, j++) {
            if (row + i < size && col - j < size && board.getMark(row + i, col - j) == mark) {
                diagonalDownLeft++;
            } else {
                break;
            }
        }

        if (diagonalDownLeft+diagonalUPRight -1 == win){
            return true;
        }
        return false;
    }
}
