/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deliverable3;

/**
 *
 * @author Diep Xuan Nhi Bui
 */
public class GamesCards extends Card{
    public GamesCards(Suit suit, Value value)
    {
        super(suit,value);
    }
    
    @Override
    public String toString(){
        return getValue() + " of " + getSuit();
    }
}
