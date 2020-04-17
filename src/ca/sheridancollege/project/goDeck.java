package ca.sheridancollege.project;

/**
 * @author Muharrem Kaya, 2020
 * @author Derya Kaya, 2020
 * @author Mostafa Soroush Zadeh, 2020
 */

import java.util.ArrayList;
import java.util.Collections;

public class goDeck
{

    private ArrayList<goCard> allCards;

    /**
     *
     * @return allCards
     * @modifier Muharrem, 2020
     */
    public ArrayList<goCard> getAllCards()
    {
        return allCards;
    }

    /**
     *
     * @param allCards
     * @modifier Muharrem, 2020*
     */
    public void setAllCards(ArrayList<goCard> allCards)
    {
        this.allCards = allCards;
    }

    /**
     * @modifier Muharrem, 2020
     */
    public goDeck()
    {
        allCards = new ArrayList<goCard>();
        String[] symbols =
        {
            "H", "C", "S", "D"
        };
        String[] asymbols =
        {
            "J", "Q", "K"
        };
        String value;

        int id = 0;

        for (int y = 0; y < 4; y++)
        {
            for (Integer i = 1; i < 14; i++)
            {
                id++;
                switch (i)
                {
                    case 1:
                        value = "A";
                        break;
                    case 11:
                        value = asymbols[0];
                        break;
                    case 12:
                        value = asymbols[1];
                        break;
                    case 13:
                        value = asymbols[2];
                        break;
                    default:
                        value = i.toString();
                        break;
                }

                goCard theCard = new goCard(value, symbols[y]);

                allCards.add(theCard);
            }

            Collections.shuffle(allCards);
        }
    }

    /**
     * @return allCards.size()
     * @modifier Muharrem, 2020
     */
    public int size()
    {
        return allCards.size();
    }

    /**
     *
     * @return cardList
     * @modifier Muharrem, 2020
     */
    @Override
    public String toString()
    {
        StringBuilder cardList = new StringBuilder();

        for (goCard i : getAllCards())
        {
            cardList.append(i.toString());
            cardList.append(", ");
        }

        return cardList.toString();
        //@modifier Muharrem, 2020
        //return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return NextCard();
     * @modifier Muharrem, 2020
     */
    public goCard getNewCard()
    {
        goCard nextCard = allCards.get(0);
        // System.out.println(nextCard.toString() + " removed from deck");        
        allCards.remove(0);
        return nextCard;
    }

}
