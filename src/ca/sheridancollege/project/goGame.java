package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class goGame extends Game
{

    goDeck deck;
    int cCount;
    String spCount;
    int pCount;
    boolean gameOver;

    public goGame(String name)
    {
        super(name);
    }

    @Override
    public void play()
    {
        deck = new goDeck();
        cCount = 0;
        pCount = 0;
        gameOver = false;
        boolean check = false;

        do
        {
            pCount = getPlayerCount();

            if (pCount == 1)
            {
                check = false;
                System.out.println("!!!Please enter a valid player number!!!!");
            } else if (pCount == 0)
            {
                System.out.println("-----Game terminated by user----");
                break;
            } else
            {
                check = true;
                players.addAll(getPlayerNames(pCount));
            }
            
            
        } while (!check);

        if (check)
        {
            //Game Starting
            int activePlayerNumber = 0;
            int nextPlayerNumber = 1;

            goPlayer currentPlayer = players.get(activePlayerNumber);
            goPlayer nextPlayer = players.get(nextPlayerNumber);
            
            currentPlayer.checkSerial();

            do
            {
                if (!currentPlayer.hasRight())
                {
                    activePlayerNumber++;
                }

                activePlayerNumber = activePlayerNumber % pCount;
                nextPlayerNumber = (activePlayerNumber + 1) % pCount;

                //Set Current and Next Player     
                currentPlayer = players.get(activePlayerNumber);
                nextPlayer = players.get(nextPlayerNumber);

                //Get current player card  
                System.out.print("\n" + currentPlayer.getPlayerID()
                        + "'s cards are: "
                        + currentPlayer.getListCards());

                int choisen = getPlayerCard(
                        currentPlayer.getPlayerID(),
                        1,
                        currentPlayer.getCardSize());

                if (choisen == 100)
                {
                    System.out.println("---Game is terminated by user---");
                    break;
                }

//
                //Show choisen Card  
                goCard choisedCard = currentPlayer.getPlayCards().get(choisen);

//          Card choisedCard = currentPlayer.getPlayCards().get(0);
                System.out.println("\n" + currentPlayer.getPlayerID()
                        + " choised card is: "
                        + choisedCard.toString());

                int activeCardNumber = 0;

                boolean cardFound = false;
                currentPlayer.setRight(false);
                ArrayList<goCard> RemoveList = new ArrayList<>();

                for (goCard nextPlayerCard : nextPlayer.playCards)
                {
                    //if next player has same value as current player  
                    if (nextPlayerCard.getValue().equals(
                            choisedCard.getValue()))
                    {
                        cardFound = true;
                        System.out.println("Card value found in "
                                + nextPlayer.getPlayerID()
                                + "'s deck "
                                + nextPlayerCard.toString());

                        System.out.println(nextPlayerCard.toString()
                                + " removed from "
                                + nextPlayer.getPlayerID());

                        System.out.println("New card added to "
                                + currentPlayer.getPlayerID()
                                + " " + nextPlayerCard.toString());

                        currentPlayer.getPlayCards().add(nextPlayerCard);

//                      nextPlayer.playCards.remove(
//                                  nextPlayer.playCards.indexOf(nextPlayerCard));
                        RemoveList.add(nextPlayerCard);

                        System.out.println(currentPlayer.getPlayerID()
                                + "'s new card count is: "
                                + currentPlayer.playCards.size());

                        

                        //      break;
                    } //if

                }//for

                if (cardFound)
                {
                    nextPlayer.playCards.removeAll(RemoveList);
                    
                    System.out.println(nextPlayer.getPlayerID()
                                + "'s new card count is: "
                                + nextPlayer.playCards.size());
                    
                    
                    
                    System.out.println(currentPlayer.getPlayerID()
                            + " earned one more time");

                    System.out.println("Deck card count is: "
                                + deck.size());
                    

                    currentPlayer.setRight(true);
                } 
                else if (!cardFound)
                {
                    currentPlayer.setRight(false);
                    System.out.println("\n" + nextPlayer.getPlayerID()
                            + ":!!!Go Fish!!!" + "\n");

                    if (deck.size() != 0)
                    {
                        goCard getCard = deck.getNewCard();
                        System.out.println("Returned Card from deck is: "
                                + getCard.toString());

                        System.out.println(getCard.toString() + " added to "
                                + currentPlayer.getPlayerID());
                        currentPlayer.getPlayCards().add(getCard);

                        System.out.println(currentPlayer.getPlayerID()
                                + "'s new card count is: "
                                + currentPlayer.playCards.size());
                        System.out.println("Rest of cards in the deck: "
                                + deck.size());
                        currentPlayer.setRight(false);

                    } else
                    {
                        gameOver = true;
                    }
                
                }

                currentPlayer.checkSerial();
                
                if (currentPlayer.getCardSize() == 0)
                {
                    if (deck.size() != 0)
                    {
                        goCard newCard = deck.getNewCard();
                        System.out.println(newCard.toString() + " added to "
                                + currentPlayer.getPlayerID());
                        currentPlayer.getPlayCards().add(newCard);
                    } else
                    {
                        gameOver = true;
                    }
                }

            } while (!gameOver);
        }
    }

    public int getPlayerCard(String name, int min, int max)
    {
        boolean check = false;
        boolean isnumeric;
        int intVal = 0;

        while (!check)
        {
            try
            {
                Scanner k = new Scanner(System.in);
                System.out.print("\n" + name
                        + ", please choice a card (between 1-"
                        + max
                        + ") 'q' for exit :");

                String value = k.nextLine();

                if (value.equals("q"))
                {
                    return 100;
                } else
                {
                    intVal = Integer.parseInt(value);
                }

                isnumeric = true;

            } catch (Exception e)
            {
                isnumeric = false;
            }

            if ((intVal >= min) && (intVal <= max) && (isnumeric))
            {
                check = true;
            } else
            {
                System.out.println("!!!Please enter a valid value!!!");
            }

        }
        return intVal - 1;
    }

    public int getPlayerCount()
    {
        int intVal = 0;
        final int MIN = 1;
        final int MAX = 7;

        Scanner k = new Scanner(System.in);
        System.out.print("Please enter how many players want to play (min=" + (MIN + 1)
                + " max=" + (MAX)
                + ") 'q' for exit : ");

        //check entered value
        boolean isnumeric = true;
        try
        {
            spCount = k.nextLine();
            if (spCount.equals("q"))
            {
                return 0;
            }

            intVal = Integer.parseInt(spCount);
        } catch (Exception e)
        {
            isnumeric = false;
        }

        if (!((intVal > MIN) && (intVal < MAX) && (isnumeric)))
        {
            return 1;
        }
        return intVal;
    }

    public ArrayList<goPlayer> getPlayerNames(int pCount)
    {
        ArrayList<goPlayer> tempList = new ArrayList<>();

        for (int i = 0; i < pCount; i++)
        {
            int currentPlayerNumber = i + 1;
            System.out.print("\n Please enter player-"
                    + currentPlayerNumber + " name: ");
            String name = "";

            try
            {
                Scanner m = new Scanner(System.in);

                name = m.nextLine();
            } catch (Exception e)
            {
                System.out.println("name error");
            }

            if (pCount > 4)
            {
                cCount = 5;
            } else
            {
                cCount = 7;
            }

            GroupOfCards pcards = new GroupOfCards(cCount, deck);
            tempList.add(new goPlayer(name, pcards.showCards()));

        }
        return tempList;
    }

    @Override
    public void declareWinner()
    {

        System.out.println("\nGame Over");
        System.out.println("_____________________________________________________");
        System.out.println("Summary");
        System.out.println("_____________________________________________________");

        for (goPlayer i : players)
        {
            System.out.println("\n" + i.getPlayerID() + "'s cards are: "
                    + i.getListCards());

            System.out.println(i.getPlayerID() + "'s cards count is: "
                    + i.getCardSize()
                    + " scor is: " + i.getScor());
        }

        Collections.sort(players);
        
        System.out.println("_____________________________________________________");

        ArrayList<goPlayer> winners = new ArrayList<>();
        
         if (players.get(0).getScor() > 0)
           {     
//            if(players.get(0).getScor() == players.get(1).getScor())
//            System.out.println("\nWinner is: " + players.get(0).getPlayerID());
            for (int i=0; i < players.size()-1; i++)
            {
                if (players.get(i).getScor()==players.get(i+1).getScor())
                {
                   if (winners.indexOf(players.get(i)) == -1)
                       winners.add(players.get(i));
                   if (winners.indexOf(players.get(i+1)) == -1)
                       winners.add(players.get(i+1));
                }    
            }
            
            if (winners.size()>0)
            {
                System.out.println("Winners are: ");
               for (goPlayer i:winners)
                System.out.print(i.getPlayerID()+", ");
                  
            }     
            else
                System.out.println("Champion is : "+players.get(0).getPlayerID()); 
           }   
           else
            System.out.println("I'm sorry this game finished scorless");
        
        System.out.println("_____________________________________________________");

    }

}//class end

