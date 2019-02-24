/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import lab4.Heptalion;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrator
 */
public class Validity {
    
    public Validity() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testtrue(){                             //Tests if the values are equal to 'a' and 'c', and passes the test if so       
        Heptalion hep = new Heptalion();
        assertEquals (true,hep.method(1, 0, 1, 1));
    }
   
    @Test
    public void testfalse(){                           //Tests if the values are not equal and passed the test if so
        Heptalion hep = new Heptalion();
        assertEquals (false,hep.method(0, 0, 2, 2));
    }
    
    @Test
    public void testoutside(){                          //Tests if the values of the cordinates are out of bounds values
        Heptalion hep = new Heptalion();
        assertEquals (false,hep.method(33, 34, 22, 12));
    }
}

