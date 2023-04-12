/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package deliverable3;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you
 * might want to subclass this more than once. The group of cards has a maximum
 * size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @modifier MayxTran
 */
public class GroupOfCards {

    //The group of cards, stored in an ArrayList
    protected ArrayList<Card> cards;

    //New ArrayList creation
    public GroupOfCards() {
        cards = new ArrayList<>();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    //add cards to the ArrayList
    public void addCard(Card c) {
        cards.add(c);
    }

    //shuffle the cards
    public void shuffle() {
        Collections.shuffle(cards);
    }

    //print all the cards
    public void printDeck() {
        int index = 0;
        for (Card c : cards) {
            index++;
            System.out.println(index + "  " + c);
        }
    }

    public int deckSize() {
        return cards.size();
    }

}//end class
