/**
 * Represents a Tic Tac Toe tournament where a specified number of rounds are played
 * between two players using a provided renderer for displaying the game board.
 */
public class Tournament {
    /**
     * a const that repesent the args number that is the a num of rounds
     */
    private final static int ARGSNUMOFROUND = 0;
    /**
     * Constant representing the index of the size of the game board in the command-line arguments.
     * This is used to retrieve the size of the game board for the tournament.
     */
    private final static int ARGSBOARDSIZE = 1;

    /**
     * Constant representing the index of the win streak in the command-line arguments.
     * This is used to retrieve the number of consecutive marks required to win a round.
     */
    public final static int ARGSWINSTREAK = 2;

    /**
     * Constant representing the index of the render target in the command-line arguments.
     * This is used to retrieve the target for rendering the game board (console or none).
     */
    public final static int ARGSRENDERER = 3;

    /**
     * Constant representing the index of the type of the first player in the command-line arguments.
     * This is used to determine the type of strategy for the first player in the tournament.
     */
    public final static int ARGSPLAYERTYPE1 = 4;

    /**
     * Constant representing the index of the type of the second player in the command-line arguments.
     * This is used to determine the type of strategy for the second player in the tournament.
     */
    public final static int ARGSPLAYERTYPE2 = 5;

    int rounds;
    private Renderer renderer;
    private Player[] players;
    int[] players_winning;
    /**
     * Constructs a Tournament with the specified number of rounds, renderer, and players.
     *
     * @param rounds   The number of rounds to be played in the tournament.
     * @param renderer The renderer used to display the game board during the tournament.
     * @param player1  The first player participating in the tournament.
     * @param player2  The second player participating in the tournament.
     */
    public Tournament(int rounds, Renderer renderer, Player player1,Player player2) {
        this.rounds = rounds;
        this.players = new Player[2];
        this.renderer = renderer;
        this.players[0] = player1;
        this.players[1] = player2;
        this.players_winning = new int[3];
    }
    /**
     * Plays the tournament with the specified board size, win streak, and player names.
     *
     * @param size         The size of the game board.
     * @param winStreak    The number of consecutive marks required to win.
     * @param playerName1 The name of the first player.
     * @param playerName2 The name of the second player.
     */
    void playTournament(int size, int winStreak, String playerName1,String playerName2) {
        Player player1 = this.players[0];
        int x_index = 0;
        Player player2 = this.players[1];
        int O_index = 1;

        for (int i = 0; i < this.rounds; i++) {
            Game game = new Game(player1, player2, winStreak, size, this.renderer);
            Mark win = game.run();
            if (win == Mark.X) {
                this.players_winning[x_index]++;
            } else if (win == Mark.O) {
                this.players_winning[O_index]++;
            } else {
                this.players_winning[2]++;
            }
            x_index = (x_index + 1) % 2;
            O_index = (O_index + 1) % 2;
            Player temp = player1;
            player1 = player2;
            player2 = temp;
        }
        printResults(playerName1,playerName2);
    }
    /**
     * Prints the results of the tournament, including the number of rounds won by each player
     * and the number of tied rounds.
     *
     * @param player1 The name of the first player.
     * @param player2 The name of the second player.
     */
    void printResults(String player1,String player2) {
        String[] players = new String[2];
        players[0] = player1;
        players[1] = player2;
        System.out.println("######### Results #########");
        for (int i = 0; i < players.length; i++) {
            String playerName = players[i]; // Get player name from the provided array
            System.out.printf("Player %s," +" %s won: %d rounds%n",i+1, playerName, players_winning[i]);
        }
        System.out.printf("Ties: %d%n", players_winning[2]);
    }
    /**
     * Checks if a given string is present in an array of strings.
     *
     * @param myString The string to check for.
     * @param myArray  The array of strings to search.
     * @return True if the string is present in the array, false otherwise.
     */
    static boolean isStringInArray(String myString, String[] myArray) {
        for (String element : myArray) {
            if (element.equalsIgnoreCase(myString)) {
                return true;
            }
        }
        return false;
    }
    /**
     * The main method to start the tournament with command-line arguments.
     *
     * @param args Command-line arguments specifying tournament parameters.
     */
    public static void main(String[] args) {
        int numberOfRounds = Integer.parseInt(args[0]);
        int size = Integer.parseInt(args[ARGSBOARDSIZE]);
        int winStreak = Integer.parseInt(args[ARGSWINSTREAK]);
        String renderTarget = args[ARGSRENDERER];
        String playerType1 = args[ARGSPLAYERTYPE1];
        String playerType2 = args[ARGSPLAYERTYPE2];
        String[] legalPlayers = {"whatever", "clever" ,"genius", "human"};
        String[] legalRender = {"console", "none"};
        if(!(isStringInArray(renderTarget,legalRender)))  {
            System.out.println(Constants.UNKNOWN_RENDERER_NAME);
            return;
        }

        if(!(isStringInArray(playerType1,legalPlayers)))  {
            System.out.println(Constants.UNKNOWN_PLAYER_NAME);
            return;
        }
        if(!(isStringInArray(playerType2,legalPlayers)))  {
            System.out.println(Constants.UNKNOWN_PLAYER_NAME);
            return;
        }

        Renderer renderer = RendererFactory.buildRenderer(renderTarget, size);
        Player player1 = PlayerFactory.buildPlayer(playerType1);
        Player player2 = PlayerFactory.buildPlayer(playerType2);

        Tournament tor = new Tournament(numberOfRounds, renderer,player1,player2 );
        tor.playTournament(size, winStreak, playerType1,playerType2);
    }

}
