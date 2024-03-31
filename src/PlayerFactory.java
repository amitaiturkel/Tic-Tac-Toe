/**
 * a class that implements a factory of different classed that implements player of the game ticktacktoe
 */
public class PlayerFactory {
    /**
    * a static method that create a class that implement player according the string its gets
     * @param type a stirng that tell which class to create
     */
    public static Player buildPlayer(String type) {
        Player player = null;
        switch (type.toLowerCase()) {
            case "human":
                player = new HumanPlayer();
                break;
            case "whatever":
                player = new WhateverPlayer();
                break;
            case "clever":
                player = new CleverPlayer();
                break;
            case "genius":
                player = new GeniusPlayer();
                break;
            default:
                System.out.println("Invalid player type: " + type);
                break;
        }
        return player;
    }
}
