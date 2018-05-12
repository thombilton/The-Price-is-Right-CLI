package Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


/**
 *
 * @author Thom
 */
public class VendoPrice extends Game{
    
    ArrayList<Prize> prizePoolLow = new ArrayList<Prize>();
    ArrayList<Prize> prizePoolMid = new ArrayList<Prize>();
    ArrayList<Prize> prizePoolHigh = new ArrayList<Prize>();
    ArrayList<Shelf> Vendor = new ArrayList<Shelf>();
    Random rand = new Random(System.currentTimeMillis());
    
    int[] shelfCount = new int[3];
    protected int userLow;
    protected int userMid;
    protected int userHigh;
    
    Prize winPrize = super.genRanPrize();
    
    public VendoPrice(ArrayList<aiPlayer> aiPlayersList, ArrayList<Prize> prizeList, Player player) {
        super(aiPlayersList, prizeList, player);
    }
    
    public void playVendoPrice()
    {
        buildCabnet();
        stockCabnet();
        
        for(int i = 0; i <= super.getAiPlayersList().size() -1; i++)
        {
            if(super.getAiPlayersList().get(i).isRoundwinner() == true)
            {
                genAiGame(i);
                super.resetWinners();
            }
        }
        if(super.getPlayer().isRoundWinner() == true)
        {
            PlayerGame();
            super.resetWinners();
        }
        
        
    }
    
    protected void PlayerGame()
    {

        Explain();
        for(int i = 0; i< Vendor.size(); i++)
        {
        System.out.println("---------------------------------------------------------------");
        System.out.println("On shelf " +(i+1) +" we have " +Vendor.get(i).getNoOfItems() +" " +Vendor.get(i).getItem().getName());
        sleep(1);
        }
        System.out.println("---------------------------------------------------------------");

        System.out.println("I'll remind you now that a single item on the top shelf is worth the least and the bottom the most");
        
        System.out.println("Which shelf (1,2,3) do you is worth the least");
        boolean test = false;
        do{
            while(!super.userIn.hasNextInt())
            {
                super.userIn.next();
                System.out.println("Please choose either 1, 2 or 3");
            }
            userLow = super.userIn.nextInt();
            
            if(userLow == 1 || userLow ==2 || userLow ==3)
            {
                test = true;
            }
            
        }while(test == false);
        System.out.println("Which shelf (1,2,3) do you is worth the most");
        test = false;
        do{
            while(!super.userIn.hasNextInt())
            {
                super.userIn.next();
                System.out.println("Please choose either 1, 2 or 3");
            }
            userHigh = super.userIn.nextInt();
            
            if(userHigh == 1 || userHigh ==2 || userHigh ==3)
            {
                test = true;
            }
            
        }while(test == false);
        System.out.println("and in the middle");
        test = false;
        do{
            while(!super.userIn.hasNextInt())
            {
                super.userIn.next();
                System.out.println("Please choose either 1, 2 or 3");
            }
            userMid = super.userIn.nextInt();
            
            if(userMid == 1 || userMid ==2 || userMid ==3)
            {
                test = true;
            }
            
        }while(test == false);
        
        int win = checkAnswers();
        super.getPlayer().setWonRound(true);
        awardPrize(win);

        
    }
    
    protected void Explain()
    {
        System.out.println("Today you will be player Vendo Price for a " +winPrize.getName() +" worth $" +winPrize.getValue());
        sleep(1);
        System.out.println("The aim of ths game is to guess, in order, the total value of each shelf.");
        sleep(1);
        System.out.println("What I can tell you is, the top shelf item is worth the least and the bottom shelf item is worth the most.");
        sleep(1);
        System.out.println("Lets see how this goes!");

    }
    
    protected void awardPrize(int win)
    {
        if(win ==1)
        {
            System.out.println("Congratulations! You have won a" +winPrize.getName() +"worth $" +winPrize.getValue());
            super.getPlayer().addPrize(winPrize);
        }
        else if(win == 0)
        {
            System.out.println("You dont win anything this round, sorry!");
        }
        else
        {
            System.out.println("SOMETHINGS GONE WRONG!");
        }
    }
    
    protected int checkAnswers()
    {
                if(Vendor.get(userLow-1).getLow() == true)
                {
                    System.out.println("Lets start with the lowest shelf");
                    sleep(2);
                    System.out.println("You guessed correctly!");
                    System.out.println("Shelf " +(userLow) +" the " +Vendor.get(userLow-1).getItem().getName() +"'s were worth $" +Vendor.get(userLow-1).getTotalValue());
                }
                
                
                if(Vendor.get(userHigh-1).getHigh() == true)
                {
                    System.out.println("Next the highest value shelf");
                    sleep(2);
                    System.out.println("You guessed correctly!");
                    System.out.println("Shelf " +(userHigh) +" the " +Vendor.get(userHigh-1).getItem().getName() +"'s were worth $" +Vendor.get(userHigh-1).getTotalValue());
                    System.out.println("Which means the mid value shelf is shelf " +(userMid-1) +" the " +Vendor.get(userMid-1).getItem().getName() +" worth $" +Vendor.get(userMid-1).getTotalValue());
                    return 1;
                }
                
                if(Vendor.get(userLow-1).getLow() != true)
                {
                    System.out.println("Lets start with the lowest shelf");
                    sleep(2);
                    System.out.println("You guessed incorrectly!");
                    System.out.print("Shelf " +(userLow-1) +" the " +Vendor.get(userLow-1).getItem().getName() +"'s");
                    checkPos(userLow);
                    System.out.print("worth $" +Vendor.get(userLow-1).getTotalValue());
                    
                    return 0;

                }
                if(Vendor.get(userHigh-1).getHigh() != true)
                {
                    System.out.println("and the highest");
                    sleep(2);
                    System.out.println("You guessed incorrectly!");
                    System.out.print("Shelf " +(userHigh-1) +" the " +Vendor.get(userHigh-1).getItem().getName() +"'s");
                    checkPos(userHigh);
                    System.out.print("worth $" +Vendor.get(userHigh-1).getTotalValue());
                    
                    return 0;
                }

                
                
               return 2; 

    }
    
    protected void checkPos(int toCheck)
    {
        if(Vendor.get(toCheck-1).getHigh() == true)
        {
            System.out.print(" the highest value ");
        }
        else if(Vendor.get(toCheck-1).getMid() == true)
        {
            System.out.print(" the middle value ");

        }
        else
        {
            System.out.print(" the lowest value ");

        }
    }
    
    protected void setupVendoPrice()
    {
        
    }
    protected void buildCabnet()
    {
        prizePoolLow.add(new Prize("Delmaine - Baked Beans", 2));
        prizePoolHigh.add(new Prize("Delmaine - Pitted Cherries", 9));
        prizePoolMid.add(new Prize("Salisbury - Corned Beef Can", 6));
        prizePoolLow.add(new Prize("Mars Chocolate Bar 53g", 3));
        prizePoolMid.add(new Prize("Salted Penuts 400g", 5));
        prizePoolHigh.add(new Prize("Freedom Foods Muesli Bar", 7));
        
        Vendor.add(new Shelf());
        Vendor.add(new Shelf());
        Vendor.add(new Shelf());

        for(int i = 0; i<Vendor.size(); i++)
        {
            if(i ==0 )
            {
            int n = rand.nextInt(prizePoolLow.size());
            Vendor.get(i).setNoOfItems(rand.nextInt(7)+3);
            Vendor.get(i).setItem(prizePoolLow.get(n));
            prizePoolLow.remove(n);
            }
            else if(i ==1 )
            {
            int n = rand.nextInt(prizePoolMid.size());
            Vendor.get(i).setNoOfItems(rand.nextInt(7)+3);
            Vendor.get(i).setItem(prizePoolMid.get(n));
            prizePoolMid.remove(n);
            }
            else if(i ==2 )
            {
            int n = rand.nextInt(prizePoolHigh.size());
            Vendor.get(i).setNoOfItems(rand.nextInt(7)+3);
            Vendor.get(i).setItem(prizePoolHigh.get(n));
            prizePoolHigh.remove(n);
            }
            Vendor.get(i).calculateTotalValue();
        }
        
    }
    
    protected void stockCabnet()
    {
        
        for(int i = 0; i<Vendor.size(); i++)
        {
                    if(Vendor.get(i).getTotalValue() > Vendor.get(1).getTotalValue() && Vendor.get(i).getTotalValue() > Vendor.get(2).getTotalValue())
        {
            Vendor.get(i).setHigh(Boolean.TRUE);
        }
        else if(Vendor.get(i).getTotalValue() > Vendor.get(0).getTotalValue() && Vendor.get(i).getTotalValue() > Vendor.get(2).getTotalValue())
        {
            Vendor.get(i).setHigh(Boolean.TRUE);
        }
        else if(Vendor.get(i).getTotalValue() > Vendor.get(0).getTotalValue() && Vendor.get(i).getTotalValue() > Vendor.get(1).getTotalValue())
        {
            Vendor.get(i).setHigh(Boolean.TRUE);
        }
        else if(Vendor.get(i).getTotalValue() < Vendor.get(1).getTotalValue() && Vendor.get(i).getTotalValue() < Vendor.get(2).getTotalValue())
        {
            Vendor.get(i).setLow(Boolean.TRUE);
        }
        else if(Vendor.get(i).getTotalValue() < Vendor.get(0).getTotalValue() && Vendor.get(i).getTotalValue() < Vendor.get(2).getTotalValue())
        {
            Vendor.get(i).setLow(Boolean.TRUE);
        }
        else if(Vendor.get(i).getTotalValue() < Vendor.get(0).getTotalValue() && Vendor.get(i).getTotalValue() < Vendor.get(1).getTotalValue())
        {
            Vendor.get(i).setLow(Boolean.TRUE);
        }
        else
        {
            Vendor.get(i).setMid(Boolean.TRUE);
        }
        }
        

    }
    
    protected void genAiGame(int i)
    {
        chosenPrize = super.genRanPrize();
        Prize temp = super.genRanPrize();
        int randNo = rand.nextInt((1000 - 0)+1)+0;
        if((randNo%2) == 0)
            {
                 super.getAiPlayersList().get(i).addPrize(winPrize);
                 sleep(2);
                 System.out.println(super.getAiPlayersList().get(i).getName() +" has played Vendo Price and won " + winPrize.getName());
                 sleep(2);
                 super.getAiPlayersList().get(i).setWonRound(true);
            }
        else
            {
                System.out.println(super.getAiPlayersList().get(i).getName() +" has played Vendo Price and won didn't win anything");
                sleep(2);
                super.getPrizeList().add(winPrize);
                super.getPrizeList().add(temp);
                super.getAiPlayersList().get(i).setWonRound(true);


            }
    }
    
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


