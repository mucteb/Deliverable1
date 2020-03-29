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
        ArrayList<Card> serial = new ArrayList<>();
        for (goCard PlayerCard : getPlayCards())
        {
            serial.clear();
            for (goCard nextCard : getPlayCards())
            {
                if (PlayerCard.getValue().equals(nextCard.getValue()))
                {

                    if ((serial.indexOf(nextCard) == -1))
                    {
                        serial.add(nextCard);
                    }
                }
            }
        }

        if ((serial.size() > 0) && (serial.size() % 4 == 0))
        {
            System.out.println("\n" + getPlayerID()
                    + " completed the serial.");
            for (Card i : serial)
                System.out.print(i.toString() + ", ");

            float mscor = (serial.size() / 4);

            setScor((int) mscor);

            System.out.println("removed from " + getPlayerID() + "'s deck");
            System.out.println(getPlayerID() + " earned " + (int) mscor + " point");
            System.out.println(getPlayerID() + " card count is: " + getCardSize());
            System.out.println(getPlayerID() + " new scor is: " + getScor());

            getPlayCards().removeAll(serial);
            
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
