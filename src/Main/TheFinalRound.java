package Main;

import java.util.ArrayList;

/**
 * . creates an instance of the Final Round game mode. Extends Game.
 * @author Thom
 */
public class TheFinalRound extends Game{
    
    protected int[] wheel = new int[20];
    
    public TheFinalRound(ArrayList<aiPlayer> aiPlayersList, ArrayList<Prize> prizeList, Player player) {
        super(aiPlayersList, prizeList, player);
    }
    
    public void playFinalRound()
    {
        genWheel();
        if(super.getPlayer().isWonRound() == true)
        {
            System.out.println("---------------------------------------------------------------");
            System.out.println("Welcome to the final round.\nYou'll have two goes to spin for a cash prize, \nNo matter what you spin for you'll walk away with! \nLets Go!");
            playerGame();
        }
        else
        {
            aiGame();
        }
        
    }
    
    /**
    *. Contians all steps needed for each time an AI plays the game.
    * @author Thom
    */  
    protected void aiGame()
    {
        for(int i =0; i < super.getAiPlayersList().size(); i++)
        {
            if(super.getAiPlayersList().get(i).isWonRound() == true)
            {
                int aiAmount = aiSpin() + aiSpin();
                super.getAiPlayersList().get(i).addPrize(new Prize("And in the final round a cash prize", aiAmount));

                
            }
        }
    }    
    
    /**
    *. Contains all code needed for when the player interacts with the final round.
    * @author Thom
    */  
    protected void playerGame()
    {
        int storeOne = spinWheel();
        sleep(2);
        System.out.println("You've scored yourself $" +storeOne +" lets see how your second spin goes");
        int storeTwo = spinWheel();
        int playerTotal = storeOne + storeTwo;
        super.getPlayer().addPrize(new Prize("And in the final round a cash prize", playerTotal));
        System.out.println("Your second spin score you a further $" +storeTwo +" that brings your total to: $" +playerTotal);
        System.out.println("Lets see how the others get on!");
        
        for(int i =0; i < super.getAiPlayersList().size(); i++)
        {
            if(super.getAiPlayersList().get(i).isWonRound() == true)
            {
                int aiAmount = aiSpin() + aiSpin();
                super.getAiPlayersList().get(i).addPrize(new Prize("And in the final round a cash prize", aiAmount));
                sleep(2);
                System.out.println(getAiPlayersList().get(i).getName() + " has won $" +aiAmount);
            }
        }
        

    }
    
    /**
    *. Methods for spinning wheel, user enters spin strength and random number is generated.
    * @author Thom
    */  
    protected int spinWheel()
    {
        int storeOne = 0;
        double inSpinPower;
        int spinPower;
        boolean test = false;
        
        do
        {
            System.out.println("How hard would you like to spin the wheel? (1-10)");
            while(!userIn.hasNextDouble())
            {
                System.out.println("Please enter a number between 1 and 10");
                userIn.next();
            }
            inSpinPower = super.userIn.nextDouble();

            spinPower = (int) inSpinPower;
            
            if(spinPower >=1 && spinPower<=10)
            {
                test = true;
            }
        
        }while(test == false);
        
        
        for(int i = 0; i< spinPower; i++)
        {
            storeOne = wheel[super.rand.nextInt(20)];
        }
        
        return storeOne;
    }
    
    /**
    *. Method for when AI spins wheel
    * @author Thom
    */  
    protected int aiSpin()
    {
        int aiRand = super.rand.nextInt(20);
        int aiTotal = wheel[aiRand];
        
        return aiTotal;
    }
    
    /**
    *. Method that generates the spinable wheel.
    * @author Thom
    */  
    protected void genWheel()
    {
        for(int i = 0; i< wheel.length; i++)
        {
            if(i == 1 || i== 6 || i ==11)
            {
                wheel[i] = 1;
            }
            else if(i == 2 ||i==7 || i==12)
            {
                wheel[i] = 5;
            }
            else if(i == 3 || i == 8|| i== 13)
            {
                wheel[i] = 15;
            }
            else if(i == 4 || i == 9|| i== 14)
            {
                wheel[i] = 50;
            }
            else if(i == 5|| i== 10 || i ==15)
            {
                wheel[i] = 75;
            }
            else if(i == 16 || i==19)
            {
                wheel[i] = 100;
            }
            else if(i == 17)
            {
                wheel[i] = 200;
            }
            else
            {
                wheel[i] = 300;
            }
        }
    }
        
    /**
    *. Takes in Int and sleeps thread for that many seconds
    * @author Thom
    */  
    public void sleep(long time)
    {
        try        
        {
        Thread.sleep(time*1000);
        } 
        catch(InterruptedException ex) 
        {
        Thread.currentThread().interrupt();
        }
    }
}


