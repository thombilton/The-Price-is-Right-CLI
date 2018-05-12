package Main;

import java.util.ArrayList;

/**
 *
 * @author Thom
 */
public class aiPlayer {

    private int dificulty;
    private String name;
    private int age;
    private ArrayList<Prize> currentPrizes= new ArrayList();
    private int guessAmmount;
    private int guessDistance;
    private boolean underAmount;
    private boolean closest;
    private boolean Roundwinner;
    private boolean wonRound = false;
    
    
    aiPlayer(String name, int dificulty, int age){
        this.dificulty = dificulty;
        this.name = name;
        this.age = age;
    }

    public int getDificulty() {
        return dificulty;
    }

    public void setDificulty(int dificulty) {
        this.dificulty = dificulty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

   public String getSpecPrizeName(int i)
   {
       return currentPrizes.get(i).getName();
   }
   
      public int getSpecPrizePrice(int i)
   {
       return currentPrizes.get(i).getValue();
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

    public boolean isRoundwinner() {
        return Roundwinner;
    }

    public void setRoundwinner(boolean Roundwinner) {
        this.Roundwinner = Roundwinner;
    }

    public boolean isWonRound() {
        return wonRound;
    }

    public void setWonRound(boolean wonRound) {
        this.wonRound = wonRound;
    }
    
    
}
