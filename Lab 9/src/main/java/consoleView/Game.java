package consoleView;

import com.sun.javafx.scene.traversal.Direction;
import heptalion.Board;
import heptalion.Deck;
import heptalion.Domino;
import heptalion.Player;
import heptalion.NameTooShort;
import java.util.Scanner;

/**
 * Heptalion main game class
 * @author David
 */
public class Game {
    Board board;
    Player[] players;
    Deck deck;
    private Scanner stdin = new Scanner(System.in);
    static final int NUM_PLAYERS = 2;
    private static final int MAX_TRIES = 3;
    private static final String QUIT = "Q";
    

     
    /**
     * Initialize board, deck, players
     */
    public Game(int _numPlayers) {
        board = new Board();
        deck = new Deck();
        intro();
        initPlayers();
    }
    
    /**
     * Play the game, announcing the winner at the end.
     */
    public void play() {
        int nextPlayer = 0;
        while (true) {
            if (!playDomino(players[nextPlayer])) {
                announceWinner(players[otherPlayer(nextPlayer)]);
                return;
            }
            nextPlayer = otherPlayer(nextPlayer);
        }
    }

    // Return index of other player
    // only works for 2 players
    private int otherPlayer(int nextPlayer) {
        return 1 - nextPlayer;
    }
    
    /**
     * Get player to place a domino on the board
     * @return true if the player successfully makes a play, false if not
     */
    boolean playDomino(Player player) {
        int domToPlay;
        String quit;
        int row, col;
        Direction dir;
        int tries = MAX_TRIES;
        boolean successful = false;
        while (tries > 0) {
            System.out.println(board);
            System.out.println(player);
            System.out.println("Enter " + QUIT + " to quit, any other nonblank to continue: ");
            quit = stdin.next().toUpperCase();
            if (quit.equals(QUIT))
                return false;
            domToPlay = getValidIndex(0, player.getHandSize());
            System.out.println("Please pick row to place (left end of) domino: ");
            row = stdin.nextInt();
            System.out.println("Please pick column to place (left end of) domino: ");
            col = stdin.nextInt();
            System.out.println("Please pick direction to place domino (LEFT, UP, RIGHT, DOWN): ");
            dir = getValidDirection();
            if (board.place(player.get(domToPlay), row, col, dir)) {
                player.remove(domToPlay);
                return true;
            }
            // To get more helpful error messages, using an exception
            // would be convenient
            System.out.println("Not a legal move. Attempts left = " + --tries);
        }
        return false;
    }

        /**
     * Get a valid direction from the user
     * @return the direction
     */
    private Direction getValidDirection() {
        boolean valid = false;
        Direction result = Direction.DOWN;
        
        while (!valid) {
            try {
                result = Direction.valueOf(stdin.next());
                valid = true;
            }
            catch(IllegalArgumentException exc) {
                System.out.println("Valid directions are: LEFT, UP, RIGHT, DOWN");
            }
        }
        return result;
    }
    
    /**
     * Get a valid index from the user
     * @param low   minimum valid value
     * @param high  1 more than the maximum valid value
     * @return index of domino chosen
     */
    private int getValidIndex(int low, int high) {
        int domToPlay = -1;
        boolean valid = false;

        while (!valid) {
            System.out.println("Please choose the index of the domino you wish to play: ");
            domToPlay = stdin.nextInt();
            valid = low <= domToPlay && domToPlay < high;
        }
        return domToPlay;
    }

    // Announce winning player's name
    private void announceWinner(Player winningPlayer) {
        System.out.println(winningPlayer.getName() + " has won!");
    }

    // Display welcome message
    private void intro() {
        System.out.println("This is a console-based version of Néstor Romeral Andrés's Heptalion");
        System.out.println();
        System.out.println("For each turn, a player tries to place one of his/her dominoes on the board");
        System.out.println("The last player to make a legal move wins");
        System.out.println("Unlike the real game, a player loses when they either quit");
        System.out.println("  or attempt 3 consecutive illegal moves");
        System.out.println();
    }

    // Initialize players with their dominoes
    private void initPlayers() {
        players = new Player[NUM_PLAYERS];
        String name;
        deck.shuffle();
        
        for (int playerIndex = 0; playerIndex < NUM_PLAYERS;
                playerIndex++) {
            boolean done = false;
            while (!done) 
                try {
                    System.out.println("Please enter the name of player " + playerIndex + ": ");
                    name = stdin.next();
                    players[playerIndex] = Player.makePlayer(name, board);
                    done = true;
                    
                } catch (NameTooShort exc) {
                    System.err.println("Name cannot be less than " + Player.MIN_NAME_LENGTH + " characters");
                }
        }
        dealDominoes();

    }

    // Assign dominoes to each player
    private void dealDominoes() {
        Domino nextDom = deck.draw();
        int nextPlayer = 0;
        while (nextDom != null) {
            players[nextPlayer].addDomino(nextDom);
            nextPlayer = otherPlayer(nextPlayer);
            nextDom = deck.draw();
        }
        
    }
    
    /**
     * Start up game
     * @param args command line args are not used
     */
    public static void main(String[] args) {
        Game heptalion = new Game(NUM_PLAYERS);
        heptalion.play();
    }

    private Exception NameTooShort(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
