/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package deliverable3;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;

/**
 *
 * @author nbui6
 */
public class BlackjackTest {

    /**
     * Test of play method, of class Blackjack.
     */
    /* @Test
public void testPlayGood() {
    Blackjack blackjack = new Blackjack("Blackjack");
    CurrentPlayer dealer = blackjack.dealer;
    CurrentPlayer player = blackjack.player;
    Deck deck = blackjack.deck;

    // Set up the input for the test
    InputStream in = new ByteArrayInputStream("stay".getBytes());
    System.setIn(in);

    blackjack.play(dealer, player, deck);
    assertEquals("Dealer and player are the same! Push!", systemOutRule.getLog());
}


    @Test
    public void testPlayBad() {
        System.out.println("play Bad");
        Blackjack blackjack = new Blackjack("play bad");
        GroupOfCards dealerHand = new GroupOfCards();
        GroupOfCards playerHand = new GroupOfCards();
        Deck deck = new Deck();
        deck.shuffle();
        CurrentPlayer dealer = new CurrentPlayer("dealer", dealerHand);
        CurrentPlayer player = new CurrentPlayer("player", playerHand);
        blackjack.play(dealer, player, deck);
        //TODO assert failure
        fail("The test case is a prototype.");
    }

    @Test
    public void testPlayBoundary() {
        System.out.println("play Boundary");
        Blackjack blackjack = new Blackjack("play boundary");
        GroupOfCards dealerHand = new GroupOfCards();
        dealerHand.addCard(new GamesCards(Suit.CLUBS, Value.KING));
        dealerHand.addCard(new GamesCards(Suit.DIAMONDS, Value.THREE));
        GroupOfCards playerHand = new GroupOfCards();
        playerHand.addCard(new GamesCards(Suit.SPADES, Value.ACE));
        playerHand.addCard(new GamesCards(Suit.HEARTS, Value.SEVEN));
        Deck deck = new Deck();
        deck.shuffle();
        CurrentPlayer dealer = new CurrentPlayer("dealer", dealerHand);
        CurrentPlayer player = new CurrentPlayer("player", playerHand);
        deck.deal(2, dealerHand);
        deck.deal(2, playerHand);
        blackjack.play(dealer, player, deck);
        //TODO assert success
        assertTrue(true);
    }

    /**
     * Test of winningResult method, of class Blackjack.
     */
    @Test
    public void testWinningResultBad() {
        System.out.println("winningResult Bad");
        Player person = null;
        Blackjack instance = new Blackjack("bad");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        instance.winningResult(person);
        String expectedOutput = "Dealer and player are the same! Push!\n";
        assertEquals(expectedOutput.trim(), outContent.toString().trim());
    }

    @Test
    public void testWinningResultGood() {
        System.out.println("winningResult Good");
        Player person = new CurrentPlayer("John", new GroupOfCards());
        Blackjack instance = new Blackjack("good");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        instance.winningResult(person);
        String expectedOutput = "\nThe John has won the game!\n";
        assertEquals(expectedOutput.trim(), outContent.toString().trim());
    }

    @Test
    public void testWinningResultBoundary() {
        System.out.println("winningResult Boundary");
        Player person = new CurrentPlayer("", new GroupOfCards());
        Blackjack instance = new Blackjack("boundary");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        instance.winningResult(person);
        String expectedOutput = "\nThe  has won the game!\n";
        assertEquals(expectedOutput.trim(), outContent.toString().trim());
    }

    /**
     * Test of play method, of class Blackjack.
     */
    @Test
    public void testPlayGood() {
        GroupOfCards dealerHand = new GroupOfCards();
        GroupOfCards playerHand = new GroupOfCards();
        CurrentPlayer dealer = new CurrentPlayer("dealer", dealerHand);
        CurrentPlayer player = new CurrentPlayer("player", playerHand);
        Deck deck = new Deck();
        Blackjack game = new Blackjack("good");
        System.setIn(new ByteArrayInputStream("20".getBytes()));
        game.play(dealer, player, deck);
        //assertion here
        //assert that the game ends with a winner or tie
    }

    @Test
    public void testPlayBad() {
        System.out.println("play bad");
        GroupOfCards dealerHand = new GroupOfCards();
        GroupOfCards playerHand = new GroupOfCards();
        CurrentPlayer dealer = new CurrentPlayer("dealer", dealerHand);
        CurrentPlayer player = new CurrentPlayer("player", playerHand);
        Deck deck = new Deck();
        Blackjack game = new Blackjack("bad");
        //set an invalid input for bet amount
        System.setIn(new ByteArrayInputStream("invalid input".getBytes()));
        game.play(dealer, player, deck);
        
        //assertion here
        //assert that the game does not continue and the error message is displayed
    }

    @Test
public void testPlayBoundary() {
    System.out.println("play boundary");
    GroupOfCards dealerHand = new GroupOfCards();
    GroupOfCards playerHand = new GroupOfCards();
    CurrentPlayer dealer = new CurrentPlayer("dealer", dealerHand);
    CurrentPlayer player = new CurrentPlayer("player", playerHand);
    Deck deck = new Deck();
    Blackjack game = new Blackjack("boundary");
    //set a valid input for bet amount
    System.setIn(new ByteArrayInputStream("10".getBytes()));
    //set the player's hand value to 21
    playerHand.addCard(new GamesCards(Suit.SPADES, Value.ACE));
    playerHand.addCard(new GamesCards(Suit.HEARTS, Value.QUEEN));
    game.play(dealer, player, deck);
    //assertion here
    //assert that the player wins the game with a hand value of 21
}

}
