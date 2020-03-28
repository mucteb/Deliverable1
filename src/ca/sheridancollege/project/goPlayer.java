
package ca.sheridancollege.project;

import java.util.ArrayList;


public final class goPlayer extends Player implements Comparable<goPlayer>
{

    protected String name;
    protected ArrayList<goCard> playCards;
    protected int scor;
    protected boolean Right;


    public boolean hasRight()
    {
        return Right;
    }

    public void setRight(boolean playerRight)
    {
        this.Right = playerRight;
    }

    public int getScor()
    {
        return scor;
    }

    public void setScor(int scor)
    {
        this.scor += scor;
    }

    public goPlayer(String name, ArrayList<goCard> pCards)
    {
        super(name);
        setPlayCards(pCards);
        setRight(true);
    }

    public int getCardSize()
    {
        return playCards.size();
    }

    public ArrayList<goCard> getPlayCards()
    {
        return playCards;
    }

    public void setPlayCards(ArrayList<goCard> playCards)
    {
        this.playCards = playCards;
    }

    public StringBuilder getListCards()
    {
        StringBuilder list = new StringBuilder("");
        Integer i = 0;        
        
        playCards.forEach((Card item) ->
        {
            list.append(item.toString());
        });

        return list;
    }

    public void checkSerial()
    {
        for (goCard PlayerCard : getPlayCards())
        {
            ArrayList<Card> serial = new ArrayList<>();

            for (goCard nextCard : getPlayCards())
            {
                if (PlayerCard.getValue().equals(nextCard.getValue()))
                {
                    serial.add(nextCard);
                    if (serial.size() == 4)
                    {
                        setScor(1);
                    }
                }
            }
        }
    }


    @Override
    public void play()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compareTo(goPlayer o)
    {
        return o.getScor() - this.getScor();
    }
}
