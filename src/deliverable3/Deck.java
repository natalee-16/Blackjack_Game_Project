/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deliverable3;

/**
 *
 * @author MayxT
 */
public class Deck extends GroupOfCards{
    //Bulid a BlackJack Card deck
    public Deck () {
        
         for (int i = 0; i < Suit.values().length; i++) {
            for (int x = 0; x < Value.values().length; x++) {
                cards.add(new GamesCards(Suit.values()[i], Value.values()[x]));
            }
        }
        shuffle();
    }

    //Deal cards to the dealer or the players. The number of cards dealed will be depend 
    //on the situaiton including starting the game, hit, stay.
    public void deal (int amount, GroupOfCards hand) {
        //GroupOfCards checkRecipient = new GroupOfCards();
        int high = cards.size() - 1;
        int low = high - amount;
        for (int i = high; i > low; --i) {
            hand.addCard(cards.get(i));
            cards.remove(i);
        }
    }

    //This will return an int representation of the sum of all the cards in the dealer or players hands depending on which is passed in.
    public int handsValue (GroupOfCards hands) {
        int total = 0;
        int[] array = new int[hands.deckSize()];
        for (int i = 0; i < array.length; i++) {
            array[i] = hands.cards.get(i).value.getNumValue();
            total += array[i];
        }      
        int aceBonus = 0;
        for (int i = 0; i < array.length; i++) { 
            if (hands.cards.get(i).value.getNumValue() == 1 && total < 12) {
                aceBonus = 10;
            }
            if (hands.cards.get(i).value.getNumValue() == 1 && total >= 12) {
                aceBonus = 0;
            }
        }
        return total + aceBonus;

    }

}
