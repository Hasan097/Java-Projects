package Method;

import Method.Board;
import Method.Domino;
import com.sun.javafx.scene.traversal.Direction;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Heptalion Player class -- for human players
 * @author David
 */
public class Player {
    private String name;
    List<Domino> hand;
    private static Scanner stdin = new Scanner(System.in);
    Board board;
    private static final int MAX_TRIES = 3;
    private static final String QUIT = "Q";
    
    /**
     * Initialize Player information
     * @param _name name of player
     * @param _board Heptalion board to support prompting user for a move
     */
    public Player(String _name, Board _board) {
        name = _name;
        board = _board;
        hand = new ArrayList<>();
    }
    
    /**
     * Add domino to the player's "hand" of dominoes
     * @param dealt the domino to add
     */
    public void addDomino(Domino dealt) {
        hand.add(dealt);
    }
    
    /**
     * Get player to place a domino on the board
     * @return true if the player successfully makes a play, false if not
     */
    public boolean playDomino() {
        int domToPlay;
        String quit;
        int row, col;
        Direction dir;
        int tries = MAX_TRIES;
        boolean successful = false;
        while (tries > 0) {
            System.out.println(board);
            System.out.println(this);
            System.out.print("Enter " + QUIT + " to quit, any other nonblank to continue: ");
            quit = stdin.next().toUpperCase();
            if (quit.equals(QUIT))
                return false;
            domToPlay = getValidIndex(0, hand.size());
            System.out.print("Please pick row to place (left end of) domino: ");
            row = stdin.nextInt();
            System.out.print("Please pick column to place (left end of) domino: ");
            col = stdin.nextInt();
            System.out.print("Please pick direction to place domino (LEFT, UP, RIGHT, DOWN): ");
            dir = getValidDirection();
            if (board.place(hand.get(domToPlay), row, col, dir)) {
                hand.remove(domToPlay);
                return true;
            }
            // To get more helpful error messages, using an exception
            // would be convenient
            System.out.println("Not a legal move. Attempts left = " + --tries);
        }
        return false;
    }
    
    /**
     * String representing both Player and player's dominoes
     * @return the representation
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(name);
        result.append('\n');
        int domIndex = 0;
        for (Domino dom : hand) {
            result.append(domIndex++);
            result.append(". ");
            result.append(dom);
            result.append(' ');
        }
        result.append('\n');
        return result.toString();
        
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
            System.out.print("Please choose the index of the domino you wish to play: ");
            domToPlay = stdin.nextInt();
            valid = low <= domToPlay && domToPlay < high;
        }
        return domToPlay;
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
     * Added function: get name of player
     * @return the player's name
     */
    public String getName() {
        return name;
    }
    
}
