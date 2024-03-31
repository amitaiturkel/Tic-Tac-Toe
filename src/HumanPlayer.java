
import java.util.Scanner;

/**
 * a class that represent a Genius Player of ticktacktoe that implement player
 * @author amitai turkel
 */
public class HumanPlayer implements Player {
    private static final String FIRSTMESSEGE = "Player ";
    private static final String SECONDMESSEGE = " type coordinates: ";

    public HumanPlayer() {
    }
    /**
     * a method that play the turn of a human player
     * @param mark the mark we want to put
     * @param board the board we put in the mark
     */
    @Override
    public void playTurn(Board board, Mark mark) {
        int size = board.getSize();

        while (true) {
            System.out.print(FIRSTMESSEGE + mark + SECONDMESSEGE);
            int input = KeyboardInput.readInt();
            int row = (int) (input * 0.1);
            int col = input % 10;

            if (row < size && row >= 0 && col < size && col >= 0) {
                if (board.putMark(mark, row, col)) {
                    return; // Valid move, exit the loop
                } else {
                    System.out.println(Constants.OCCUPIED_COORDINATE);


                }
            }
            System.out.println(Constants.INVALID_COORDINATE);
        }
    }
}





