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
   
}
