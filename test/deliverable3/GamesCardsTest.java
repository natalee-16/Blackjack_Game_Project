/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package deliverable3;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Diep Xuan Nhi Bui
 */
public class GamesCardsTest {

    /**
     * Test of toString method, of class GamesCards.
     */
    @Test
    public void testToStringGood() {
        System.out.println("toString Good");
        GamesCards instance = new GamesCards(Suit.CLUBS, Value.ACE);
        String expResult = "ACE of CLUBS";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    @Test
    public void testToStringBad() {
        System.out.println("toString Bad");
        GamesCards instance = null;
        String expResult = null;
        String result = null;
        try {
            result = instance.toString();
        } catch (NullPointerException e) {
            assertNull(instance);
        }
        assertEquals(expResult, result);
    }

    @Test
    public void testToStringBoundary() {
        System.out.println("toString Boundary");
        GamesCards instance = new GamesCards(Suit.SPADES, Value.KING);
        String expResult = "KING of SPADES";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

}
