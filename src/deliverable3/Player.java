/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package deliverable3;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @modifier Diep Xuan Nhi Bui 
 */
public abstract class Player {

    private String name; //the unique name for this player
    private GroupOfCards hand;
   
    public Player(String name, GroupOfCards hand) {
        this.name = name;
        this.hand= hand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GroupOfCards getHand()
    {
        return hand;
    }
    
    public void setHand(GroupOfCards hand){
        this.hand = hand;
    }
}
