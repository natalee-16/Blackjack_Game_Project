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
 * @author Diep Xuan Nhi Bui
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
     */
    @Test
    public void testHandsValueGood() {
        System.out.println("HandsValue Good");
        GroupOfCards hands = new GroupOfCards();
        hands.addCard(new GamesCards(Suit.HEARTS, Value.JACK));
        hands.addCard(new GamesCards(Suit.DIAMONDS, Value.TEN));
        hands.addCard(new GamesCards(Suit.CLUBS, Value.THREE));
        Deck deck = new Deck();
        int expectedValue = 23;
        int actualValue = deck.handsValue(hands);
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testHandsValueBad() {
        System.out.println("HandsValue Bad");
        GroupOfCards hands = new GroupOfCards();
        Deck deck = new Deck();
        int expectedValue = 0;
        int actualValue = deck.handsValue(hands);
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testHandsValueBoundary() {
        System.out.println("HandsValue Boundary");
        GroupOfCards hands = new GroupOfCards();
        hands.addCard(new GamesCards(Suit.HEARTS, Value.ACE));
        hands.addCard(new GamesCards(Suit.DIAMONDS, Value.TEN));
        Deck deck = new Deck();
        int expectedValue = 21;
        int actualValue = deck.handsValue(hands);
        assertEquals(expectedValue, actualValue);
    }

}
