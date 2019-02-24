package Method;

import Method.Board;
import Method.Domino;
import Method.Player;
import Method.Deck;
import consoleView.hold;
import java.util.Scanner;

/**
 * Heptalion main game class
 * @author David
 */
public class Game {
    hold mybeer;
    Board board;
    Player[] players;
    Deck deck;
    private Scanner stdin = new Scanner(System.in);
    static final int NUM_PLAYERS = 2;
     
    /**
     * Initialize board, deck, players
     */
    public Game(int _numPlayers) {
        board = new Board();
        deck = new Deck();
        mybeer.intro();
        initPlayers();
    }
    
    /**
     * Play the game, announcing the winner at the end.
     */
    public void play() {
        int nextPlayer = 0;
        while (true) {
            if (!players[nextPlayer].playDomino()) {
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

    // Announce winning player's name
    private void announceWinner(Player winningPlayer) {
        System.out.println(winningPlayer.getName() + " has won!");
    }

    // Initialize players with their dominoes
    private void initPlayers() {
        players = new Player[NUM_PLAYERS];
        String name;
        deck.shuffle();
        
        for (int playerIndex = 0; playerIndex < NUM_PLAYERS;
                playerIndex++) {
            System.out.print("Please enter the name of player " + playerIndex + ": ");
            name = stdin.next();
            players[playerIndex] = new Player(name, board);
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
}
