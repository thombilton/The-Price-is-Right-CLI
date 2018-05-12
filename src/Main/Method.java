package Main;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *Method creates and runs the main part of the game. Contains all the methods for running and calling other classes and their methods within the game.
 * @author Thom
 */
public class Method {
    
    int dificulty;
    Scanner userIn;
    private ArrayList<aiPlayer> aiPlayersList = new ArrayList<aiPlayer>();
    private ArrayList<Prize> prizeList = new ArrayList<Prize>();
    Player player;
    protected Object[] objReturn;

//method that squencially runs the game and calls other classes.    
    public void setup() throws IOException{
        ReadInPrizes();
        this.userIn = new Scanner(System.in);
        System.out.println("Please enter your playername");
        String playerName = userIn.nextLine();
        this.player = new Player(playerName);
        
        System.out.println("Welcome " + player.getName() + " to the price is right!");
//        makePrizes();
        makeAI();
        printAiNames();
        playOneBid();
//        System.out.println("Onebid Done");
        playOneRightPrice();
//        System.out.println("One Right Price Done");
        playOneBid();
//        System.out.println("Onebid Round 2 Done");
        playVendoPrice();
        playTheFinalRound();
        PrintCert();
        endGame();
        sleep(2);
        Desktop.getDesktop().open(new File("Certificate.txt"));

    }

    /**
    *Creates new instance of the PrintCertificate class
    * @author Thom
    */    
    public void PrintCert()
    {
        PrintCertificate print = new PrintCertificate();
        print.print(player);
    }
    
    /**
    *Creates instance of ReadInPrizes that allows for file IO
    * @author Thom
    */  
    public void ReadInPrizes() throws IOException
    {
        ReadInPrizes read = new ReadInPrizes();
        read.ReadIn(prizeList);
    }
    
    /**
    *Creates new AI instances and adds them to the AI Players List
    * @author Thom
    */  
    public void makeAI(){
       aiPlayersList.add(new aiPlayer("Cindy", 1, 21));
       aiPlayersList.add(new aiPlayer("Matt", 1, 36));
       aiPlayersList.add(new aiPlayer("George", 1, 54));
    }
    
    /**
    *Prints to console the AI players details
    * @author Thom
    */  
    public void printAiNames(){
        System.out.print("Today your opponents will be " + aiPlayersList.get(0).getName());
        System.out.print(", " +aiPlayersList.get(1).getName());
        System.out.println(" and " +aiPlayersList.get(2).getName());        
    }
    
    /**
    *Creates a new instance of the OneBid game Class.
    * @author Thom
    */  
    private void playOneBid(){
    
    OneBid playOneBid = new OneBid(aiPlayersList, prizeList, player);
    playOneBid.playOneBid();
    
    }
    
    /**
    *Creates a new instance of the OneRightPrice game Class
    * @author Thom
    */  
    public void playOneRightPrice(){
        OneRightPrice playOneRightPrice = new OneRightPrice(aiPlayersList, prizeList, player);
        playOneRightPrice.playOneRightPrice();
    }
    
    /**
    *Creates a new instance of the VendoPrice game Class
    * @author Thom
    */  
    public void playVendoPrice(){
        VendoPrice playVendoPrice = new VendoPrice(aiPlayersList, prizeList, player);
        playVendoPrice.playVendoPrice();
        
    }
    
    /**
    *Creates a new instance of the Final Round game Class
    * @author Thom
    */  
    private void playTheFinalRound() {
        TheFinalRound playFinalRound = new TheFinalRound(aiPlayersList, prizeList, player);
        playFinalRound.playFinalRound();
    }
    
    
    /**
    *Processes what will happen at the end of the game.
    * @author Thom
    */  
    private void endGame() throws IOException
    {
        sleep(2);
        System.out.println("---------------------------------------------------------------");

        System.out.println("Thats the end of the game folks! Lets see how our contenstants got on!");
        
        for(int i = 0; i< aiPlayersList.size(); i++)
        {
            if(aiPlayersList.get(i).getCurrentPrizes().isEmpty() == false)
            {
                {
                    sleep(1);
                    System.out.println(aiPlayersList.get(i).getName() +" has won an: ");
                    for(int n = 0; n <aiPlayersList.get(i).getCurrentPrizes().size(); n++)
                    {
                        System.out.println(aiPlayersList.get(i).getSpecPrizeName(n) +" worth $" +aiPlayersList.get(i).getSpecPrizePrice(n));
                    }
                }
            }
        }
        
        if(player.isWonRound() == true)
        {
            sleep(1);
            System.out.println(player.getName() +" has won an: ");
                    for(int n = 0; n <player.getCurrentPrizes().size(); n++)
                    {
                        System.out.println(player.getSpecPrizeName(n) +" worth $" +player.getSpecPrizePrice(n));
                    }
        }
        

    }

    //Get and Set Methods
    
    public ArrayList<aiPlayer> getAiPlayersList() {
        return aiPlayersList;
    }

    public void setAiPlayersList(ArrayList<aiPlayer> aiPlayersList) {
        this.aiPlayersList = aiPlayersList;
    }

    public ArrayList<Prize> getPrizeList() {
        return prizeList;
    }

    public void setPrizeList(ArrayList<Prize> prizeList) {
        this.prizeList = prizeList;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    
    /**
    *Takes in an integer that represents seconds and sleeps the thread for (x) seconds
    * @author Thom
    */  
    public void sleep(int len)
    {
        try        
        {
        Thread.sleep(len*1000);
        } 
        catch(InterruptedException ex) 
        {
        Thread.currentThread().interrupt();
        }
    }
}
