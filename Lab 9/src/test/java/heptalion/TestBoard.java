package heptalion;

import com.sun.javafx.scene.traversal.Direction;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test cases for Heptalion board
 * @author David
 */
public class TestBoard {
    
    Board bd = new Board();
    Domino dom1;
    
    @Before
    public void setUp() {
        dom1 = new Domino(Symbol.CIRCLE, Symbol.DOT);
    }
    
    /**
     * Case where domino should be placed on board
     */
    @Test
    public void canPlace() {
        assertTrue(bd.place(dom1, 1, 4, Direction.DOWN));
    }
    
    /**
     * Case where domino should not be placed
     * because domino does not match
     */
    @Test
    public void doesNotMatch() {
        assertFalse(bd.place(dom1, 1, 4, Direction.RIGHT));
        // board should be unchanged
    }
    
    /**
     * Case where domino should not be placed
     * because coordinates are outside board's boundaries
     */
    @Test
    public void outOfBounds() {
        assertFalse(bd.place(dom1, 1, 4, Direction.LEFT));
        // board should be unchanged
    }
}
