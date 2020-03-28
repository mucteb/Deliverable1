/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game.
 * HINT, you might want to subclass this more than once.
 * The group of cards has a maximum size attribute which is flexible for reuse.
 * @modifier Muharrem Kaya, 03/25/2020
 * @modifier Derya Kaya, 03/25/2020
 * @modifier Mostafa Soroush Zadeh, 03/25/2020
 */
public class GroupOfCards 
{
   
    //The group of cards, stored in an ArrayList
    private ArrayList <goCard> cards;
    private int size;//the size of the grouping
    
    public GroupOfCards(int givenSize)
    {
        size = givenSize;
        
        
    }
    
    public GroupOfCards(int givenSize, goDeck newCards)
    {
         size = givenSize;
      
        Collections.shuffle(newCards.getAllCards());
        
        
        cards  = new ArrayList<goCard>();

        
        
        for (int i = 0; i < givenSize; i++)
        {
            cards.add(newCards.getNewCard());
        }


        
        shuffle();
        

        for (goCard num : cards)
        {
            System.out.print(num.toString() + ", ");
        }
        
    }        
    
    
    public ArrayList<goCard> showCards()
    {
        return cards;
    }
    
    public void shuffle()
    {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param givenSize the max size for the group of cards
     */
    public void setSize(int givenSize) {
        size = givenSize;
    }
    
}//end class
