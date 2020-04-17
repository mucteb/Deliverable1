package ca.sheridancollege.project;

/**
 * @author Muharrem Kaya, 2020
 * @author Derya Kaya, 2020
 * @author Mostafa Soroush Zadeh, 2020
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class goGame extends Game
{

    private goDeck deck;
    private int cCount;
    private String spCount;
    private int pCount;
    private boolean gameOver;
    private final int MIN = 2;
    private final int MAX = 6;

    /**
     * @param name
     * @modifier Muharrem, 2020
     */
    public goGame(String name)
    {
        super(name);
    }

    /**
     * @modifier Muharrem, 2020
     */
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

            //GetHow many players    
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
            //set first active player and next player
            int activePlayerNumber = 0;
            int nextPlayerNumber = 1;

            goPlayer currentPlayer = players.get(activePlayerNumber);
            goPlayer nextPlayer = players.get(nextPlayerNumber);

            //check any serial cards in the current player hand
            currentPlayer.checkSerial();
            //if any serial completed by the current player, the player get 1 point

            //set new current player and next player
            do
            {
                if (!currentPlayer.hasRight())
                {
                    //set previous next player as a current player
                    activePlayerNumber = players.indexOf(nextPlayer);
                }

                currentPlayer = players.get(activePlayerNumber);
                nextPlayer = players.get(getNextPlayer(currentPlayer));

                //Get cards for current player card  
                System.out.print("\n" + currentPlayer.getPlayerID()
                        + "'s cards are: "
                        + currentPlayer.getCardsList());

                int choisen = getPlayerCard(
                        currentPlayer.getPlayerID(),
                        1,
                        currentPlayer.getCardSize());

                //exit code 100 -program terminated
                if (choisen == 100)
                {
                    System.out.println("---Game is terminated by user---");
                    break;
                }

                //Show players hand
                goCard choisedCard = currentPlayer.getPlayCards().get(choisen);

                System.out.println("\n" + currentPlayer.getPlayerID()
                        + " choised card is: "
                        + choisedCard.toString());

                int activeCardNumber = 0;

                boolean cardFound = false;
                currentPlayer.setRight(false);
                ArrayList<goCard> RemoveList = new ArrayList<>();

                //compare current players Cards with next player Cards
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

                        RemoveList.add(nextPlayerCard);

                        System.out.println(currentPlayer.getPlayerID()
                                + "'s new card count is: "
                                + currentPlayer.playCards.size());
                        //      break;
                    } //if

                }//for

                //if card found in next player hand all cards with same values passed to current player
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
                } //if no card match in next player hand, curretn player get a card from the deck
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

                //current player changes one more time check for serials
                currentPlayer.checkSerial();
                //if any serial complated current player get 1 point

                //if current player hand is empty he need to get card from the deck
                if (currentPlayer.getCardSize() == 0)
                {

                    //if there is no card in the deck game over
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

    /**
     *
     * @param name
     * @param min
     * @param max
     * @return player Cards
     * @modifier Muharrem, 2020
     *
     */
    private int getPlayerCard(String name, int min, int max)
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

            } catch (NumberFormatException e)
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

    /**
     *
     * @return Player count
     * @modifier Muharrem, 2020
     */
    public int getPlayerCount()
    {
        Scanner k = new Scanner(System.in);
        System.out.print("Please enter how many players want to play (min=" + (MIN)
                + " max=" + (MAX)
                + ") 'q' for exit : ");

        //check entered value
        spCount = k.nextLine();
        int a = checkPlayerCount(spCount);
        System.out.println("Player count is: " + a);

        return a;

        //return checkPlayerCount(spCount);
    }

    /**
     * @param playerNumber
     * @return player count
     * @modifier Muharrem, 2020
     */
    public int checkPlayerCount(String playerNumber)
    {
        int intVal = 0;
        boolean isnumeric = true;

        try
        {
            if (playerNumber.equals("q"))
            {
                return 0;
            }

            intVal = Integer.parseInt(playerNumber);
        } catch (NumberFormatException e)
        {
            isnumeric = false;
        }

        if (!((intVal >= MIN) && (intVal <= MAX) && (isnumeric)))
        {
            return 1;

        }
        return intVal;
    }

    /**
     *
     * @param pCount
     * @return PlayerNames
     * @modifier Muharrem, 2020
     */

    private ArrayList<goPlayer> getPlayerNames(int pCount)
    {
        ArrayList<goPlayer> tempList = new ArrayList<>();

        for (int i = 0; i < pCount; i++)
        {
            int currentPlayerNumber = i + 1;
            String name = "";
            do
            {
                System.out.print("\n Please enter player-"
                        + currentPlayerNumber + " name(at least 5 character): ");

                try
                {
                    Scanner m = new Scanner(System.in);
                    name = m.nextLine();
                } catch (Exception e)
                {
                    System.out.println("name error");
                }
            } while (!checkPlayerName(name));

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

    /**
     *
     * @param name
     * @return player Name
     * @modifier Muharrem, 2020
     */
    public boolean checkPlayerName(String name)
    {
        boolean check = true;
        if (name.length() < 5)
        {
            System.out.println("You entered short name please "
                    + "enter at least 5 character name");
            check = false;
        }

        return check;

    }

    /**
     * @modifier Muharrem, 2020
     */
    @Override
    public void declareWinner()
    {

        System.out.println("\nGame Over");
        System.out.println("______________________________________________________________________________________");
        System.out.println("Summary");
        System.out.println("______________________________________________________________________________________");

        for (goPlayer i : players)
        {
            System.out.println("\n" + i.getPlayerID() + "'s cards are: "
                    + i.getCardsList());

            System.out.println(i.getPlayerID() + "'s cards count is: "
                    + i.getCardSize()
                    + " scor is: " + i.getScore());
        }

        Collections.sort(players);

        System.out.println("______________________________________________________________________________________");

        ArrayList<goPlayer> winners = new ArrayList<>();

        if (players.get(0).getScore() > 0)
        {
//            if(players.get(0).getScor() == players.get(1).getScor())
//            System.out.println("\nWinner is: " + players.get(0).getPlayerID());
            for (int i = 0; i < players.size() - 1; i++)
            {
                if (players.get(i).getScore() == players.get(i + 1).getScore())
                {
                    if (winners.indexOf(players.get(i)) == -1)
                    {
                        winners.add(players.get(i));
                    }
                    if (winners.indexOf(players.get(i + 1)) == -1)
                    {
                        winners.add(players.get(i + 1));
                    }
                }
            }

            if (winners.get(0).getScore() > players.get(0).getScore())
            {
                System.out.println("Winners are: ");
                for (goPlayer i : winners)
                {
                    System.out.print(i.getPlayerID() + ", ");
                }
                System.out.println("");
            } else
            {
                System.out.println("Champion is : " + players.get(0).getPlayerID());
            }
        } else
        {
            System.out.println("I'm sorry this game finished scorless");
        }

        System.out.println("______________________________________________________________________________________");

    }

    /**
     *
     * @param ignoredPlayer
     * @return next Player
     */
    private int getNextPlayer(goPlayer ignoredPlayer)
    {
        boolean check = false;
        int intVal = 0;
        ArrayList<goPlayer> competitors = new ArrayList<>();

        while (!check)
        {

            System.out.print("\n\n");

            competitors.clear();
            for (int i = 0; i < players.size(); i++)
            {
                if (!players.get(i).equals(ignoredPlayer))
                {
                    System.out.print(" (" + i + ")-" + players.get(i).getPlayerID());
                    competitors.add(players.get(i));
                }
            }

            try
            {
                Scanner k = new Scanner(System.in);
                System.out.print("\n" + ignoredPlayer.getPlayerID() + ", please choice a competitor: ");
                String value = k.nextLine();

                intVal = Integer.parseInt(value);

            } catch (Exception e)
            {

            }

            if ((players.size() > intVal)
                    && (competitors.indexOf(players.get(intVal)) != -1))
            {
                check = true;
            } else
            {
                System.out.println("!!!Please enter a valid value!!!");
            }

        }
        System.out.println(ignoredPlayer.getPlayerID() + " choised "
                + players.get(intVal).getPlayerID() + " as a competitior");
        return intVal;
    }

}//class end

