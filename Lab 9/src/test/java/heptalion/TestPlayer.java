/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heptalion;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author villa
 */
public class TestPlayer {
    // Name should be at least Player.MIN_NAME_LENGTH long
    @Test(expected=NameTooShort.class)
    public void SingleLetterName () throws NameTooShort {
        Player.makePlayer("A", null);
    }
    
    // Quick check that we do not throw an exception when the name
    // is long enough
    @Test
    public void okLengthName() throws NameTooShort {
        Player player = Player.makePlayer("Li", null); 
        // This is as much to confirm the code did create a Player
        // as checking the name
        assertEquals("Li", player.getName());
    }
    
}
