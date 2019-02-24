/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heptalion;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dell
 */
public class TestDeck {
    
    Deck deck = new Deck();
    
    @Test
    public void testDrawUnshuffled() {
        Domino dom = deck.draw();
        assertEquals(dom.getSymbol1(), Symbol.CIRCLE);
        assertEquals(dom.getSymbol2(), Symbol.CIRCLE);
    }
    
}
