/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deliverable3;

/**
 *
 * @author MayxT
 */
public class Blackjack extends Game{
    
    //create 2 different hands for 2 players
    GroupOfCards dealerHand = new GroupOfCards();
    GroupOfCards playerHand = new GroupOfCards();
    CurrentPlayer dealer = new CurrentPlayer("Casino dealer", dealerHand);
    CurrentPlayer player = new CurrentPlayer("Casino player", playerHand);
    Deck deck = new Deck();
    
    public Blackjack(String name)
    {
        super(name);
    }
    
    //the game is initialized
    public void run () {
        play(dealer, player, deck);
    }
    
    //@Override
    
    
    
}
