
package ca.sheridancollege.project;

import java.util.Collections;
import java.util.Scanner;


public class goGame extends Game {

    public goGame(String name)
    {
        super(name);
    }

    @Override
    public void play()
    {
        Cards deck = new Cards();
        //ArrayList<goPlayer> players = new ArrayList<>();
        int cCount = 0;
        String spCount;
        int pCount = 0;
        boolean gameOver = false;
        boolean check = false;

        do
        {
            Scanner k = new Scanner(System.in);
            System.out.print("Please enter players count (min=3 max=7): ");
            spCount = k.nextLine();

            //check enter value
            boolean numeric = true;

            try
            {
                pCount = Integer.parseInt(spCount);
            } catch (NumberFormatException e)
            {
                numeric = false;
            }
            
           

            if (!((pCount > 2) && (pCount < 8) && (numeric)))
            {
                check = false;
                System.out.println("   Please enter a valid player count");
            } 
            else{
                check = true;
                for (int i = 0; i < pCount; i++)
                {
                    Scanner m = new Scanner(System.in);
                    int currentPlayerNumber = i + 1;
                    System.out.print("\n Please enter player-" + currentPlayerNumber + " name: ");
                    String name = m.nextLine();

                    if (pCount > 4) cCount = 5;
                    else cCount = 7;
                    
                    GroupOfCards pcards = new goGroupOfCards(cCount, deck);
                    
                    players.add(new goPlayer(name, pcards.showCards()));
                }
            }
        } while (!check);

        //Game Starting
        int activePlayerNumber = 0;
        int nextPlayerNumber = 1;

        goPlayer currentPlayer = players.get(activePlayerNumber);
        goPlayer nextPlayer = players.get(nextPlayerNumber);

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
            Scanner k = new Scanner(System.in);
            System.out.print("\n"+currentPlayer.name+" Cards Are: " + currentPlayer.getListCards());            
            System.out.print("\n"+currentPlayer.name+" Please choice a card (between 1-" + currentPlayer.getCardSize() + "): ");

            int choisen = k.nextInt()-1;
//
            //Show choisen Card  
            goCard choisedCard = currentPlayer.getPlayCards().get(choisen);

//          Card choisedCard = currentPlayer.getPlayCards().get(0);
            System.out.println("\n" + currentPlayer.name + " choised card is: " + choisedCard.toString());

            int activeCardNumber = 0;

            boolean cardFound = false;

            for (goCard nextPlayerCard : nextPlayer.playCards)
            {
                //if next player has same value as current player  
                if (nextPlayerCard.getValue().equals(choisedCard.getValue()))
                {
                    cardFound = true;
                    System.out.println("Card value found in " + nextPlayer.name + " deck " + nextPlayerCard.toString());
                    System.out.println(nextPlayerCard.toString() + " removed from " + nextPlayer.name);
                    System.out.println("New card added to " + currentPlayer.name + " " + nextPlayerCard.toString());
                    currentPlayer.getPlayCards().add(nextPlayerCard);
                    nextPlayer.playCards.remove(nextPlayer.playCards.indexOf(nextPlayerCard));

                    System.out.println(currentPlayer.name + " new card count is: " + currentPlayer.playCards.size());
                    System.out.println(nextPlayer.name + " new card count is: " + nextPlayer.playCards.size());

                    System.out.println(currentPlayer.name + " earned one more time");
                    currentPlayer.setRight(true);
                    break;
                } else
                {
//                    System.out.println(choisedCard.toString() + " value not found in " + nextPlayer.name + " deck");
                    currentPlayer.setRight(false);
                }
            }

            if (!cardFound)
            {
                System.out.println(nextPlayer.name + " says: Go Fish!!!");

                if (deck.size() != 0)
                {
                    goCard getCard = deck.getNewCard();
                    System.out.println("Returned Card is: " + getCard.toString() + "\n");

                    System.out.println(getCard.toString() + " added to " + currentPlayer.name);
                    currentPlayer.getPlayCards().add(getCard);

                    System.out.println(currentPlayer.name + " new card count is: " + currentPlayer.playCards.size());
                    System.out.println("Rest of card in the deck: " + deck.size());
                    currentPlayer.setRight(false);

                } else
                {
                    gameOver = true;
                }

            }

            if (currentPlayer.getCardSize() == 0)
            {
                if (deck.size() != 0)
                {
                    goCard newCard = deck.getNewCard();
                    System.out.println(newCard.toString() + " added to " + currentPlayer.name);
                    currentPlayer.getPlayCards().add(newCard);
                } else
                {
                    gameOver = true;
                }
            }

        } while (!gameOver);
        
    }

    @Override
    public void declareWinner()
    {
        System.out.println("_____________________________________________________");
        System.out.println("\nGame Over");
        System.out.println("_____________________________________________________");
        System.out.println("Summary");

        for (goPlayer i : players)
        {
            i.checkSerial();
            System.out.println(i.name + " cards are: " + i.getListCards());
            System.out.println(i.name + " cards count is: " + i.getCardSize() + " scor is: " + (int) i.wincount / 4);
        }

        Collections.sort(players);
        System.out.println("_____________________________________________________");
        System.out.println("\nWinner is: " + players.get(0).getPlayerID());
        System.out.println("_____________________________________________________");
        
    }

}//class end

