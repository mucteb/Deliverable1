package ca.sheridancollege.project;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author T440
 */
public class goGameTest
{
    
    public goGameTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of play method, of class goGame.
     */
    @Test
    public void testPlay()
    {
        System.out.println("play");
        goGame instance = null;
        instance.play();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of declareWinner method, of class goGame.
     */
    @Test
    public void testDeclareWinner()
    {
        System.out.println("declareWinner");
        goGame instance = null;
        instance.declareWinner();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlayerNames method, of class goGame.
     */
    @Test
    public void testGetPlayerNames()
    {
        System.out.println("getPlayerNames");
        int pCount = 0;
        goGame instance = null;
        ArrayList<goPlayer> expResult = null;
        ArrayList<goPlayer> result = instance.getPlayerNames(pCount);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
