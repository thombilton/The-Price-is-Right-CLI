package Main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *  One Bid game mode Class. Allows the user to play the minigame. Takes in an ArrayLists and Players
 * @author Thom
 */
public class OneBid extends Game{
    private ArrayList<aiPlayer> aiPlayersList;
    private ArrayList<Prize> prizeList;
    private Player player;
    Random rand = new Random();
    protected Scanner userIn = new Scanner(System.in);

    public OneBid(ArrayList<aiPlayer> aiPlayersList, ArrayList<Prize> prizeList, Player player) {
        super(aiPlayersList, prizeList, player);
            this.aiPlayersList = aiPlayersList;
            this.prizeList = prizeList;
            this.player = player;
    }
    
    
    /**
    * Controller method that calls other methods to play game
    * @author Thom
    */  
    public void playOneBid(){
        
        gameExplain();
        playerGuess();
        
        for(int i=0; i<= getAiPlayersList().size()-1; i++ ){
        genPriceGuess(i);  
        }
        calculateClosest();
        //return objReturn;
    }
    
    /**
    * prints to console how to play the game
    * @author Thom
    */  
    private void gameExplain(){
        System.out.println("---------------------------------------------------------------");
        System.out.println("Host: Alight, lets play One Bid, we'll be playing this game twice tonight");
        sleep();
        System.out.println("Host: In this game you will be shown an object. It is up to you then to guess the value of that object.");
        sleep();
        System.out.println("Host: If you guess over the vaule of the object you will be eliminated.");
        sleep();
        System.out.println("Host: The player with the closest bid will go through to the next game."); 
        sleep();
        System.out.println("Host: Players are you ready?");
        sleep();
        System.out.print("Host: Your first item is ");
        chosenPrize = super.genRanPrize();
        System.out.println(chosenPrize.getName());
        sleep();
        System.out.println("Host: Place your guess as to what the price of this product is now!");
    }
   
    /**
    * calculates the AI players guess price for the prize
    * @author Thom
    */  
    private void genPriceGuess(int playerNo){
        int max = (int) chosenPrize.getValue();
        int min = (int) (chosenPrize.getValue()-(chosenPrize.getValue()/getAiPlayersList().get(playerNo).getDificulty())+1);
        int guessAmount = rand.nextInt((max - min)+1)+min;
        while(guessAmount<0){
            guessAmount = rand.nextInt((max - min)+1)+min;
        }
        getAiPlayersList().get(playerNo).setGuessAmmount(guessAmount);
        System.out.println("Host: " +getAiPlayersList().get(playerNo).getName() +", what do you think " + chosenPrize.getName() +" is worth:");
        sleep();
        System.out.println("HostName, I think that the " +chosenPrize.getName() +" is worth $"+getAiPlayersList().get(playerNo).getGuessAmmount());

    }
    
    /**
    * allows for input of the players guess
    * @author Thom
    */  
    private void playerGuess(){
        System.out.println(player.getName() +", what do you think " + chosenPrize.getName() +" is worth:");
        sleep();
        System.out.print("HostName, I think that the " +chosenPrize.getName() +" is worth $");
        
        while(!userIn.hasNextInt())
        {
            userIn.next();
            System.out.println("Please enter an integer value");
        }
        player.setGuessAmmount(userIn.nextInt());
        
    }
    
    /**
    * calculates who's guess is closest to the value of the prize by calculating distance from value.
    * @author Thom
    */  
    private void calculateClosest(){
        
        aiPlayer nearZero;
        int nearZeroValue = 0;
        aiPlayer temp1 = aiPlayersList.get(0);
        aiPlayer temp2 = aiPlayersList.get(0);
        
        
        for(int i = 0; i<= aiPlayersList.size()-1; i++)
        {
        aiPlayersList.get(i).calculateGuessDistance((int) chosenPrize.getValue());
        aiPlayersList.get(i).getGuessDistance();
//        System.out.println(aiPlayersList.get(i).getName());
//        System.out.println(aiPlayersList.get(i).getGuessDistance());
        }
        player.calculateGuessDistance((int) chosenPrize.getValue());
//        System.out.println(player.getGuessDistance());
        
        for(int i = 0; i <= aiPlayersList.size() -1; i++)
        {
            temp1 = (aiPlayersList.get(i));
            nearZero = temp2;
            if(aiPlayersList.get(i).getGuessDistance() >=0)
            {
//                temp2 = aiPlayersList.get(i);
                    if(temp1.getGuessDistance() <= temp2.getGuessDistance())
                    {
                    temp1.setGuessAmmount(Math.abs(temp1.getGuessAmmount()));
                    temp2 = temp1;
//                    System.out.println(temp2.getName());
                    nearZero = aiPlayersList.get(i);
                    nearZeroValue = i;
//                    System.out.println(aiPlayersList.get(nearZeroValue).getName());
                    }
            }
            
        }
        
        if(player.getGuessDistance() < 0)
        {
            System.out.println(aiPlayersList.get(nearZeroValue).getName() + "'s guess of $"+aiPlayersList.get(nearZeroValue).getGuessAmmount() +" is closest to the value of " +chosenPrize.getName() +" priced at $" +chosenPrize.getValue());
            aiPlayersList.get(nearZeroValue).setRoundwinner(true);
        }
        if(player.getGuessDistance() == 0)
        {
            System.out.println(player.getName() +" has guessed the correct price of " +chosenPrize.getName() +" valued at $" +chosenPrize.getValue());
            player.setRoundWinner(true);
            player.addPrize(chosenPrize);
        }
        else if(aiPlayersList.get(nearZeroValue).getGuessDistance() == 0)
        {
            System.out.println(aiPlayersList.get(nearZeroValue).getName() +" has guessed the correct price of " +chosenPrize.getName() +" valued at $" +chosenPrize.getValue());
            System.out.println("This also means they score themselves an extra $500");
            aiPlayersList.get(nearZeroValue).addPrize(new Prize("Cash", 500));
            aiPlayersList.get(nearZeroValue).setRoundwinner(true);
            aiPlayersList.get(nearZeroValue).addPrize(chosenPrize);
        }
        else if(aiPlayersList.get(nearZeroValue).getGuessDistance() < player.getGuessDistance())
        {
            System.out.println(aiPlayersList.get(nearZeroValue).getName() + "'s guess of $"+aiPlayersList.get(nearZeroValue).getGuessAmmount() +" is closest to the value of " +chosenPrize.getName() +" priced at $" +chosenPrize.getValue());
            aiPlayersList.get(nearZeroValue).setRoundwinner(true);
            aiPlayersList.get(nearZeroValue).addPrize(chosenPrize);

        }
        else if(player.getGuessDistance() < aiPlayersList.get(nearZeroValue).getGuessDistance() && player.getGuessDistance()> 0)
        {
            System.out.println(player.getName() + "'s guess of $"+player.getGuessAmmount() +" is closest to the value of " +chosenPrize.getName() +" priced at $" +chosenPrize.getValue());
            player.setRoundWinner(true);
            player.addPrize(chosenPrize);
        }       
        
        sleep();
        sleep();
        sleep();
    }
    
    
    //Set and Get Methods
    public ArrayList<aiPlayer> getAiPlayersList() {
        return aiPlayersList;
    }
    
    public int getPrizeListSize(){
        return prizeList.size();
    }

    public ArrayList<Prize> getPrizeList() {
        return prizeList;
    
    }
    
    
    /**
    * Takes in int and sleeps game for that number of seconds
    * @author Thom
    */  
    public void sleep()
    {
        try        
        {
        Thread.sleep(1000);
        } 
        catch(InterruptedException ex) 
        {
        Thread.currentThread().interrupt();
        }
    }
    
    
    
    
    
    
    
}
