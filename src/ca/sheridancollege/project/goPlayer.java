package ca.sheridancollege.project;

import java.util.ArrayList;

public final class goPlayer extends Player implements Comparable<goPlayer>
{

    private ArrayList<goCard> playCards;
    private int score;
    private boolean right;
    private int type;

    public int getType()
    {
        return type;
    }

    public void setType(int type)
    {
        this.type = type;
    }

    public boolean hasRight()
    {
        return right;
    }

    public void setRight(boolean playerRight)
    {
        this.right = playerRight;
    }

    public int getScore()
    {
        return score;
    }

    public void setScore(int scor)
    {
        this.score += scor;
    }

    public goPlayer(String name, ArrayList<goCard> pCards, int type)
    {
        super(name);
        setPlayCards(pCards);
        setRight(true);
        setType(type);
    }

    public int getCardSize()
    {
        return getPlayCards().size();
    }

    public ArrayList<goCard> getPlayCards()
    {
        return playCards;
    }

    public void setPlayCards(ArrayList<goCard> playCards)
    {
        this.playCards = playCards;
    }

    public String getCardsList()
    {
        StringBuilder list = new StringBuilder("");
        Integer i = 0;

        getPlayCards().forEach((Card item) ->
        {
            list.append(item.toString());
        });
        
        return list.toString();
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
                    if ((serial.indexOf(nextCard) == -1))
                        serial.add(nextCard);
            }
        }

        if ((serial.size() > 0) && (serial.size() % 4 == 0))
        {
            System.out.println("\n" + getPlayerID()
                    + " completed the serial.");
            for (Card i : serial)
                System.out.print(i.toString() + ", ");

            float mscor = (serial.size() / 4);

            setScore((int) mscor);

            System.out.println("removed from " + getPlayerID() + "'s deck");
            System.out.println(getPlayerID() + " earned " + (int) mscor + " point");
            System.out.println(getPlayerID() + "'s card count is: " + getCardSize());
            System.out.println(getPlayerID() + "'s new score is: " + getScore());

            getPlayCards().removeAll(serial);
            
        }

    }

    @Override
    public void play()
    {
       //@modifier Muharrem KAYA 
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int compareTo(goPlayer o)
    {
        return o.getScore() - this.getScore();
    }

    public boolean equals(Object obj)
    {
        return this == obj;
    }
    
    
    
    
}
