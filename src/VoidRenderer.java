/**
 * A simple implementation of the {@link Renderer} interface that does not perform any rendering.
 * It provides an empty implementation of the renderBoard method.
 */
public class VoidRenderer implements Renderer {
    /**
     * Does nothing as this renderer does not display or render the game board.
     *
     * @param board The board parameter is ignored in this implementation.
     */
    @Override
    public void renderBoard(Board board) {
        // Do nothing (empty implementation)
    }
}
