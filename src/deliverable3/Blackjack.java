/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deliverable3;

import java.util.Scanner;

/**
 *
 * @author MayxT
 * @modifier Diep Xuan Nhi Bui
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
    public void run() {
        play(dealer, player, deck);
    }
    
    @Override
    public void play (CurrentPlayer dealer, CurrentPlayer player, Deck deck) {

        Scanner input = new Scanner(System.in);
        
        this.deck.deal(2, dealerHand);//deal 2 cards to dealer at the beginning of the game
        this.deck.deal(2, playerHand); //deal 2 cards to player at the beginning of the game

        //Cards in dealerHand and playerHand after dealing 2 cards at the beginning of the game
        System.out.println("\nCards in the player's hands:");
        playerHand.printDeck();
        System.out.println("\nCards in the dealer's hands:");
        dealerHand.printDeck();
        
         //check player hand value after dealing 2 cards at the beginning of the game.
        System.out.println("\nChecking player hand value");
        System.out.println("Player hand value: " + this.deck.handsValue(playerHand));
        System.out.println("Dealer hand value: " + this.deck.handsValue(dealerHand));

        //compare initial hand value and declare winner if there is any.
        if (deck.handsValue(dealer.getHand()) == 21 && deck.handsValue(player.getHand()) == 21) { //If dealer and player hand == 21; declareWinnter: null
            declareWinner(null);
        }
        else if (deck.handsValue(dealer.getHand()) == 21) { //If dealer hand == 21; declareWinner: dealer
            declareWinner(dealer);
        }
        else if (deck.handsValue(player.getHand()) == 21) { //If player hand == 21; declareWinner: player
            declareWinner(player);
        }

        //To continue the game, player chooses to hit or stay
        while (deck.handsValue(player.getHand()) <= 21) { //While player hand < 21

            System.out.println("\nWould you like to 'hit' or 'stay'?");
            String choice = (input.nextLine()); //console input here
            //when player choose hit
            if (choice.equalsIgnoreCase("hit")) { //if choice not case sensitive: 'hit'

                System.out.println("*****************************************************");
                deck.deal(1, player.getHand()); //deal 1 card to player

                //display cards in hand after player chooses to hit
                System.out.println("\nPlayer draw a card, cards in the player's hands after hit: ");
                playerHand.printDeck();//cards in player hand
                System.out.println("Cards in the dealer's hands: ");
                dealerHand.printDeck();//cards in dealer hand

                //check player hand value and dealer hand value
                System.out.println("\nPlayer hand value: " + deck.handsValue(player.getHand()));
                System.out.println("Dealer hand value: " + deck.handsValue(dealer.getHand()));

                //if player's hand value is 21 or greater than 21, declare the winner
                if (deck.handsValue(player.getHand()) > 21) { //If player hand value > 21; declareWinner: dealer
                    declareWinner(dealer);
                    break; //stop while loop
                }
                else if (deck.handsValue(player.getHand()) == 21) { //If player hand == 21; declareWinner: player
                    declareWinner(player);
                    break;
                }
            } //hit ends
            //---------------------------------------------------------------------------
            //when player choose stay
            else if (choice.equalsIgnoreCase("stay")) { //If choice not case sensitive: 'stay'

                //when dealer hand value is less than 17, dealer chooses hit automatically, otherwise exit the loop
                while (deck.handsValue(dealer.getHand()) < 17) { //makes dealer draw if dealer hand value < 17

                    System.out.println("*****************************************************");
                    deck.deal(1, dealer.getHand());

                    //display cards in hand after player hits
                    System.out.println("\nCards in the player's hands: ");
                    playerHand.printDeck();//cards in player hand
                    System.out.println("Dealer draws a card, cards in the dealer's hands after hit: ");
                    dealerHand.printDeck();//cards in dealer hand

                    //check player hand value and dealer hand value
                    System.out.println("\nPlayer hand value: " + deck.handsValue(player.getHand()));
                    System.out.println("Dealer hand value: " + deck.handsValue(dealer.getHand()));
                }

                //both dealer and player does not choose to hit anymore, compare dealer and player's hand values.
                if (((deck.handsValue(dealer.getHand())) > 21) || (deck.handsValue(player.getHand()) > deck.handsValue(dealer.getHand()))) {
                    //if dealer hand value is greater than 21, or if player hand value is greater than dealer hand value; declareWinner: player
                    declareWinner(player);
                    break; //stop while loop               
                }
                else if (deck.handsValue(player.getHand()) == deck.handsValue(dealer.getHand())) { //if player hand value == dealer hand value; declareWinner: null
                    declareWinner(null);  // a tie, no winner
                    break; //stop while loop
                }
                else {
                    declareWinner(dealer);//dealer win
                    break; //stop while loop
                }
            } //stay ends
        } //while loop ends here
    }
    
    
    @Override //Declare the winner of the game
    public void declareWinner (Player person) {
        if (person == null) {
            System.out.println("Dealer and player are the same! Push!");
        }
        else {
            System.out.println("\nThe " + person.getName() + " has won the game!");
        }
    }
    
    
}
