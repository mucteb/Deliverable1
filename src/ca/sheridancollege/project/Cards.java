
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;


public class Cards {
    
    private ArrayList<Card> allCards; 

    public ArrayList<Card> getAllCards()
    {
        return allCards;
    }

    public void setAllCards(ArrayList<Card> allCards)
    {
        this.allCards = allCards;
    }
    
    public Cards()
    {
      allCards = new ArrayList<Card>();   
      String [] symbols={"H","C","S","D"};
      String [] asymbols={"J","Q","K"};
      String value;  
        
      int id=0;
      
      for(int y =0; y<4; y++){ 
         for (Integer i = 1; i <14; i++){
             id++;
             switch (i)
             {
                 case 1:
                     value="A";
                     break;
                 case 11:
                     value=asymbols[0];
                     break;
                 case 12:
                     value=asymbols[1]; 
                     break;
                 case 13:
                     value=asymbols[2];
                     break;
                 default:
                     value=i.toString();
                     break;
             }

             goCard theCard = new goCard(value,symbols[y]);
             
             allCards.add(theCard);
         }
         
       Collections.shuffle(allCards);
    }  
    }
    
    
    public int size()
    {
        return allCards.size();
    }

    @Override
    public String toString()
    {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Card getNewCard()
    {
        Card nextCard=allCards.get(0);
       // System.out.println(nextCard.toString() + " removed from deck");        
        allCards.remove(0);
        return nextCard;
    }


}
