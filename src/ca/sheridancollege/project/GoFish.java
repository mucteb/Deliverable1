package ca.sheridancollege.project;

/*
@author Muharrem KAYA
@author Derya Kaya
@author Mostafa Soroush Zadeh
*/

public class GoFish
{
    public static void main(String[] args)
    {
       goGame game = new goGame("GoFish"); 
       game.play();
       try
       {    
           game.declareWinner();
       }
       catch (Exception e)
       {

       }   
               
    }
}
