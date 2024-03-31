import java.util.Random;
/**
 * a class that represent a Genius Player of ticktacktoe that implement player
 * @author amitai turkel
 */
public class GeniusPlayer implements Player {
    /**
     * a method that play the turn of the player accurding to his level
     * @param mark the mark we want to put
     * @param board the board we put in the mark
     */
    @Override
    public void playTurn(Board board, Mark mark) {
        Mark otherMark;
        if (mark == Mark.X) {
            otherMark = Mark.O;
        } else {
            otherMark = Mark.X;
        }
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (board.putMark(mark, i, j)){
                    return;
                }
                else if (board.getMark(i, j) == otherMark){
                    break;
                }
            }
        }
        Player whatever = new WhateverPlayer();
        whatever.playTurn(board,mark);



    }
}