/**
 * a interface of a renderer for the game ticktacktoe
 */
public interface Renderer {
    /**
     * a methode that every intance that implement Renderer must have
     * @param board the board we want to present
     */
    void renderBoard(Board board);
}
