package deliverable3;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author MayxT
 * @author Diep Xuan Nhi Bui
 */
public class Blackjack extends Game {

    //create 2 different hands for 2 players
    GroupOfCards dealerHand = new GroupOfCards();
    GroupOfCards playerHand = new GroupOfCards();
    CurrentPlayer dealer = new CurrentPlayer("Casino dealer", dealerHand);
    CurrentPlayer player = new CurrentPlayer("Casino player", playerHand);
    Deck deck = new Deck();

    public Blackjack(String name) {
        super(name);
    }

    //the game is initialized
    public void run() {
        play(dealer, player, deck);
    }

    @Override
    public void play(CurrentPlayer dealer, CurrentPlayer player, Deck deck) {

        Scanner input = new Scanner(System.in);
        System.out.println("How much do you want to bet?");
        double bet;
        try {
            bet = input.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input for bet amount!");
            return;
        }
        
        input.nextLine();
        this.deck.deal(2, dealerHand);//deal 2 cards to dealer at the beginning of the game
        this.deck.deal(2, playerHand); //deal 2 cards to player at the beginning of the game

        System.out.println("\nPlayer's hands:");
        playerHand.printDeck();

        System.out.println("\nChecking hand value");
        System.out.println("Player hand value: " + this.deck.handsValue(playerHand));

        //To continue the game, player chooses to hit or stay
        while (deck.handsValue(player.getHand()) <= 21) { 

            System.out.println("\nWould you like to 'hit' or 'stay'?");
            String choice = (input.nextLine()); 
            //when player choose hit
            if (choice.equalsIgnoreCase("hit")) {

                System.out.println("*****************************************************");
                deck.deal(1, player.getHand()); 

                //display cards in hand after player chooses to hit
                System.out.println("\nPlayer draw a card, cards in the player's hands after hit: ");
                playerHand.printDeck();

                //check player hand value and dealer hand value
                System.out.println("\nPlayer hand value: " + deck.handsValue(player.getHand()));

                //if player's hand value is 21 or greater than 21, declare the winner
                if (deck.handsValue(player.getHand()) > 21) { 
                    winningResult(dealer);
                    System.out.println("The player lost $" + bet);
                    break; //stop while loop
                } else if (deck.handsValue(player.getHand()) == 21) {
                    winningResult(player);
                    System.out.println("CONGRATS YOU WON $" + bet * 2);
                    break;
                }
            } 
            
            else if (choice.equalsIgnoreCase("stay")) { 
                System.out.println("\nDealer's hands:");
                dealerHand.printDeck();
                System.out.println("Dealer hand value: " + deck.handsValue(dealer.getHand()));
                //when dealer hand value is less than 17, dealer chooses hit automatically
                while (deck.handsValue(dealer.getHand()) < 17) { 

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
                    winningResult(player);
                     System.out.println("CONGRATS YOU WON $" + bet * 2);
                    break;
                } else if (deck.handsValue(player.getHand()) == deck.handsValue(dealer.getHand())) {
                    winningResult(null);
                    break;
                } else {
                    winningResult(dealer);
                    System.out.println("The player lost $" + bet);
                    break;
                }
            } 
        }
    }

    @Override 
    public void winningResult(Player person) {
        if (person == null) {
            System.out.println("Dealer and player are the same! Push!");
        } else {
            System.out.println("\nThe " + person.getName() + " has won the game!");
        }
    }

}
