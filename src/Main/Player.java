package Main;

import java.util.ArrayList;

/**
 *. Main player class, contains info about the player and get and set methods
 * @author Thom
 */
public class Player {
    
    private String name;
    private ArrayList<Prize> currentPrizes= new ArrayList();
    private int guessAmmount;
    private int guessDistance;
    private boolean underAmount;
    private boolean closest;
    private boolean roundWinner;
    private boolean wonRound = false;

    
    Player(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList getCurrentPrizes() {
        return currentPrizes;
    }

    public void setCurrentPrizes(ArrayList currentPrizes) {
        this.currentPrizes = currentPrizes;
    }
    
    public void addPrize(Prize prize)
    {
        this.currentPrizes.add(prize);
    }

    public int getGuessAmmount() {
        return guessAmmount;
    }

    public void setGuessAmmount(int guessAmmount) {
        this.guessAmmount = guessAmmount;
    }
    
    /**
    *. calculates the distance that the players guess is from a prize
    * @author Thom
    */  
    public void calculateGuessDistance(int prizeValue)
    {
         guessDistance = prizeValue - guessAmmount;
         if(guessDistance >=0){
             underAmount = true;
         }
         else{ underAmount = false;}
    }
    
    public int getGuessDistance() {
        return guessDistance;
    }

    public void setGuessDistance(int guessDistance) {
        this.guessDistance = guessDistance;
    }

    public boolean isUnderAmount() {
        return underAmount;
    }

    public void setUnderAmount(boolean underAmount) {
        this.underAmount = underAmount;
    }

    public boolean isClosest() {
        return closest;
    }

    public void setClosest(boolean closest) {
        this.closest = closest;
    }

    public boolean isRoundWinner() {
        return roundWinner;
    }

    public void setRoundWinner(boolean roundWinner) {
        this.roundWinner = roundWinner;
    }

    public boolean isWonRound() {
        return wonRound;
    }

    public void setWonRound(boolean wonRound) {
        this.wonRound = wonRound;
    }
    
    public String getSpecPrizeName(int i)
   {
       return currentPrizes.get(i).getName();
   }
   
      public int getSpecPrizePrice(int i)
   {
       return currentPrizes.get(i).getValue();
   }
    
    
    
}
