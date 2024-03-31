import java.util.Random;
/**
 * a class that handle the logic of a cleverplayer, that implements Player
 * Mark
 * @author amitai turkel
 */
public class CleverPlayer implements Player {
    /**
     * the probability factor we need so it will win by 55% to whatever player
     * and will lose by 55% to genuis player
     */
    private static final double PROBABILITYFACTOR = 0.75;
    /**
     * a method that play the turn of the player accurding to his level
     * @param mark the mark we want to put
     * @param board the board we put in the mark
     */
    @Override
    public void playTurn(Board board, Mark mark) {
        Random random = new Random();
        double probability = PROBABILITYFACTOR;
        if (random.nextDouble() < probability) {
            Player player = new GeniusPlayer();
            player.playTurn(board, mark);
        } else {
            Player player = new WhateverPlayer();
            player.playTurn(board, mark);
            }
    }
}