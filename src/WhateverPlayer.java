import java.util.Random;
public class WhateverPlayer implements Player {

    @Override
    public void playTurn(Board board, Mark mark) {
        Random random = new Random();
        while (true) {
            int size = board.getSize();
            int random_row = random.nextInt(size);
            int random_col = random.nextInt(size);
            boolean placed = board.putMark(mark, random_row, random_col);
            if (placed) {
                return;
            }
        }
    }
}
