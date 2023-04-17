/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deliverable3;

import java.util.NoSuchElementException;

/**
 *
 * @author MayxT
 * @modifier Diep Xuan Nhi Bui
 */
public class Deck extends GroupOfCards {

    //Bulid a BlackJack Card deck
    public Deck() {

        for (int i = 0; i < Suit.values().length; i++) {
            for (int x = 0; x < Value.values().length; x++) {
                cards.add(new GamesCards(Suit.values()[i], Value.values()[x]));
            }
        }
        shuffle();
    }

    //Deal cards to the dealer or the players. The number of cards dealed will be depend 
    //on the situaiton including starting the game, hit, stay.
    public void deal(int amount, GroupOfCards hand) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
         if (cards.isEmpty()) {
        throw new NoSuchElementException("Deck is empty");
    }
        int lastIndex = cards.size() - 1;
        int start = lastIndex - amount;
        for (int i = lastIndex; i > start; --i) {
            hand.addCard(cards.get(i));
            cards.remove(i);
        }
    }

    //method is used to calculate the total hand value of each player
    public int handsValue(GroupOfCards hands) {
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
