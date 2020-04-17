package ca.sheridancollege.project;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

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
    @Ignore
    public void testPlay()
    {
        System.out.println("play");
        goGame instance = null;
        instance.play();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPlayerCount method, of class goGame.
     */
    @Ignore
    public void testGetPlayerCount()
    {
        System.out.println("getPlayerCount");
        goGame instance = null;
        int expResult = 0;
        int result = instance.getPlayerCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkPlayerCount method, of class goGame.
     */
    @Test
    public void testCheckPlayerCountGood()
    {
        System.out.println("checkPlayerCount for Good Test");
        String playerNumber = "2";
        goGame instance = new goGame("GoFish");
        int expResult = 2;
        int result = instance.checkPlayerCount(playerNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void testCheckPlayerCountBad()
    {
        System.out.println("checkPlayerCount for Bad Test");
        String playerNumber = "1";
        goGame instance = new goGame("GoFish");
        int expResult = 1;
        int result = instance.checkPlayerCount(playerNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void testCheckPlayerCountBoundry()
    {
        System.out.println("checkPlayerCount for Boundry Test");
        String playerNumber = "6";
        goGame instance = new goGame("GoFish");
        int expResult = 6;
        int result = instance.checkPlayerCount(playerNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    
    /**
     * Test of checkPlayerName method, of class goGame.
     */
    @Test
    public void testCheckPlayerNameGood()
    {
        System.out.println("checkPlayerName for Good Test");
        String name = "Muharrem";
        goGame instance = new goGame("GoFish");
        boolean expResult = true;
        boolean result = instance.checkPlayerName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testCheckPlayerNameBad()
    {
        System.out.println("checkPlayerName for Bad Test");
        String name = "Ali";
        goGame instance = new goGame("GoFish");
        boolean expResult = false;
        boolean result = instance.checkPlayerName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void testCheckPlayerNameBoundry()
    {
        System.out.println("checkPlayerName for Boundry Test");
        String name = "Caner";
        goGame instance = new goGame("GoFish");
        boolean expResult = true;
        boolean result = instance.checkPlayerName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    
    
    
    

    /**
     * Test of declareWinner method, of class goGame.
     */
    @Ignore
    public void testDeclareWinner()
    {
        System.out.println("declareWinner");
        goGame instance = null;
        instance.declareWinner();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
