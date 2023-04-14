/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package deliverable3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author nbui6
 */
public class DeckTest {

    /**
     * Test of deal method, of class Deck.
     */
    @Test
    public void testDealGood() {
        System.out.println("deal good");
        int amount = 2;
        GroupOfCards hand = new GroupOfCards();
        Deck instance = new Deck();
        instance.deal(amount, hand);
        assertEquals(amount, hand.deckSize());
    }

    @Test
    public void testDealBad() {
        System.out.println("deal bad");
        int amount = -1;
        GroupOfCards hand = new GroupOfCards();
        Deck instance = new Deck();
        assertThrows(IllegalArgumentException.class, () -> {
            instance.deal(amount, hand);
        });
    }

    @Test
    public void testDealBoundary() {
        System.out.println("deal boundary");
        int amount = 52;
        GroupOfCards hand = new GroupOfCards();
        Deck instance = new Deck();
        instance.deal(amount, hand);
        assertEquals(amount, hand.deckSize());
    }

    /**
     * Test of handsValue method, of class Deck.
     *
     * //@Test public void testHandsValue() { System.out.println("handsValue");
     * GroupOfCards hands = null; Deck instance = new Deck(); int expResult = 0;
     * int result = instance.handsValue(hands); assertEquals(expResult, result);
     * // TODO review the generated test code and remove the default call to
     * fail. fail("The test case is a prototype.");
    }
     */
}
