# Tic Tac Toe Tournament

This project implements a Tic Tac Toe tournament where two players compete against each other in multiple rounds. Players can be of different types, including human, clever, genius, or whatever (random), and the game board can be rendered on the console or not displayed at all.

## Files

The project consists of the following files:

- `Board.java`: Represents the game board for Tic Tac Toe.
- `CleverPlayer.java`: Implements a player with a clever strategy for playing Tic Tac Toe.
- `ConsoleRenderer.java`: Renders the game board on the console.
- `Constants.java`: Contains constant values used throughout the project.
- `Game.java`: Manages the gameplay logic for Tic Tac Toe.
- `GeniusPlayer.java`: Implements a player with a genius strategy for playing Tic Tac Toe.
- `HumanPlayer.java`: Represents a human player for Tic Tac Toe.
- `KeyboardInput.java`: Handles keyboard input for human players.
- `Mark.java`: Defines the possible marks (X, O, or empty) on the game board.
- `Player.java`: Represents a generic player for Tic Tac Toe.
- `PlayerFactory.java`: Constructs player objects based on specified strategies.
- `Renderer.java`: Defines the interface for rendering the game board.
- `RendererFactory.java`: Constructs renderer objects based on specified targets.
- `Tournament.java`: Manages the tournament setup, including player configurations and playing multiple rounds.
- `VoidRenderer.java`: Renders the game board without displaying anything (for testing or headless environments).
- `WhateverPlayer.java`: Implements a player with a random (whatever) strategy for playing Tic Tac Toe.

## How to Run

To run the Tic Tac Toe tournament, follow these steps:

1. Make sure you have Java installed on your system.

2. Clone or download the project repository to your local machine.

3. Navigate to the root directory of the project in your terminal or command prompt.

4. Compile the project using the following command:
   ```
   javac *.java
   ```

5. Once the project is compiled successfully, you can run the tournament with the desired configurations using the following command:
   ```
   java Tournament <number_of_rounds> <board_size> <win_streak> <renderer> <player_type1> <player_type2>
   ```

   - `<number_of_rounds>`: The number of rounds to be played in the tournament.
   - `<board_size>`: The size of the game board (e.g., 3 for a 3x3 board).
   - `<win_streak>`: The number of consecutive marks required to win.
   - `<renderer>`: The target for rendering the game board (`console` or `none`).
   - `<player_type1>`: The type of strategy for the first player (e.g., `human`, `clever`, `genius`, `whatever`).
   - `<player_type2>`: The type of strategy for the second player (e.g., `human`, `clever`, `genius`, `whatever`).

6. Example command to run the tournament:
   ```
   java Tournament 10 3 3 console human clever
   ```

7. Enjoy watching the tournament results and analyzing the performance of different player strategies!

## Dependencies

This project does not have any external dependencies. However, it requires Java to be installed on your system.

## Notes

- Ensure that the command-line arguments are provided in the correct order and format as described above.
- Invalid input parameters may result in error messages being displayed.
- Have fun playing and experimenting with different player strategies!
```
