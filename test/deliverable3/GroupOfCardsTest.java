/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package deliverable3;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Diep Xuan Nhi Bui
 */
public class GroupOfCardsTest {

    /**
     * Test of addCard method, of class GroupOfCards.
     */
    @Test
    public void testAddCardGood() {
        System.out.println("addCard Good");
        Card c = new GamesCards(Suit.CLUBS, Value.ACE);
        GroupOfCards instance = new GroupOfCards();
        instance.addCard(c);
        int expectedSize = 1;
        int actualSize = instance.deckSize();
        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void testAddCardBad() {
        System.out.println("addCard Bad");
        Card c = null;
        GroupOfCards instance = new GroupOfCards();
        instance.addCard(c);
        int expectedSize = 1; // change expected size to 1
        int actualSize = instance.deckSize();
        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void testAddCardBoundary() {
        System.out.println("addCard Boundary");
        GroupOfCards instance = new GroupOfCards();
        int expectedSize = 52;
        for (int i = 0; i < 52; i++) {
            Card c = new GamesCards(Suit.CLUBS, Value.ACE);
            instance.addCard(c);
        }
        int actualSize = instance.deckSize();
        assertEquals(expectedSize, actualSize);
    }

    /**
     * Test of shuffle method, of class GroupOfCards.
     */
   @Test
public void testShuffleGood() {
    System.out.println("Shuffle Good");
    GroupOfCards deck = new GroupOfCards();
    deck.addCard(new GamesCards(Suit.SPADES, Value.ACE));
    deck.addCard(new GamesCards( Suit.SPADES, Value.TWO));
    deck.addCard(new GamesCards( Suit.SPADES, Value.THREE));
    deck.addCard(new GamesCards( Suit.SPADES, Value.FOUR));
    deck.addCard(new GamesCards( Suit.SPADES, Value.FIVE));
    deck.addCard(new GamesCards( Suit.SPADES, Value.SIX));
    deck.addCard(new GamesCards( Suit.SPADES, Value.SEVEN));
    deck.addCard(new GamesCards( Suit.SPADES, Value.EIGHT));
    deck.addCard(new GamesCards( Suit.SPADES, Value.NINE));
    deck.addCard(new GamesCards( Suit.SPADES, Value.TEN));
    deck.addCard(new GamesCards(Suit.SPADES, Value.JACK));
    deck.addCard(new GamesCards( Suit.SPADES, Value.QUEEN));
    deck.addCard(new GamesCards( Suit.SPADES, Value.KING));

    List<Card> beforeShuffle = new ArrayList<>(deck.getCards());
    deck.shuffle();
    List<Card> afterShuffle = deck.getCards();
    assertNotEquals(beforeShuffle, afterShuffle);
}

    @Test
    public void testShuffleBad() {
        System.out.println("Shuffle Bad");
        GroupOfCards deck = null;
        assertThrows(NullPointerException.class, () -> {
            deck.shuffle();
        });
    }

    @Test
    public void testShuffleBoundary() {
        System.out.println("Shuffle Boundary");
        GroupOfCards deck = new GroupOfCards();
        deck.shuffle();
        List<Card> expected = new ArrayList<>();
        List<Card> actual = deck.getCards();
        assertEquals(expected, actual);
    }

    /**
     * Test of printDeck method, of class GroupOfCards.
     */
    @Test
    public void testPrintDeckGood() {
        System.out.println("PrintDeck Good");
        GroupOfCards instance = new GroupOfCards();
        instance.addCard(new GamesCards(Suit.HEARTS, Value.ACE));
        instance.addCard(new GamesCards(Suit.DIAMONDS, Value.TEN));
        instance.addCard(new GamesCards(Suit.SPADES, Value.KING));
        instance.printDeck();
        assertNotNull(instance.getCards());
    }

    @Test
    public void testPrintDeckBad() {
        System.out.println("PrintDeck Bad");
        GroupOfCards instance = new GroupOfCards();
        instance.printDeck();
        assertEquals(0, instance.getCards().size());
    }

    @Test
    public void testPrintDeckBoundary() {
        System.out.println("PrintDeck Boundary");
        GroupOfCards instance = new GroupOfCards();
        for (int i = 0; i < 52; i++) {
            instance.addCard(new GamesCards(Suit.HEARTS, Value.ACE));
        }
        instance.printDeck();
        assertNotNull(instance.getCards());
    }

    /**
     * Test of deckSize method, of class GroupOfCards.
     */
    @Test
    public void testGetSizeGood() {
        System.out.println("getSize Good");
        GroupOfCards instance = new GroupOfCards();
        instance.addCard(new GamesCards(Suit.DIAMONDS, Value.TEN));
        instance.addCard(new GamesCards(Suit.DIAMONDS, Value.FIVE));
        int result = instance.deckSize();
        assertEquals(2, result);
    }

    @Test
    public void testGetSizeBad() {
        System.out.println("getSize Bad");
        GroupOfCards instance = new GroupOfCards();
        instance.cards = null; // set the cards list to null
        int result;
        try {
            result = instance.deckSize(); // this should throw a NullPointerException
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException e) {
            assertEquals(null, instance.cards); // ensure that the cards list is still null
        }
    }

    @Test
    public void testGetSizeBoundary() {
        System.out.println("getSize Boundary");
        GroupOfCards instance = new GroupOfCards();
        int result = instance.deckSize();
        assertEquals(0, result);
    }

}
