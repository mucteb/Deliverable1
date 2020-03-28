package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @modifier Muharrem Kaya, 03/25/2020
 * @modifier Derya Kaya, 03/25/2020
 * @modifier Mostafa Soroush Zadeh, 03/25/2020
 */
public class goGroupOfCards extends GroupOfCards
{

    //The group of cards, stored in an ArrayList
    private ArrayList<Card> cards;
    private int size;//the size of the grouping

    public goGroupOfCards(int givenSize, Cards newCards)
    {
        super(givenSize);
        Collections.shuffle(newCards.getAllCards());
        cards = new ArrayList<Card>();

        for (int i = 0; i < givenSize; i++)
        {
            cards.add(newCards.getNewCard());
        }

        shuffle();

        for (Card num : cards)
        {
            System.out.print(num.toString() + ", ");
        }
    }

}//end class

