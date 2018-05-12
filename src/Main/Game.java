/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *This is the parent class for the different mini games within the overall game.
 * It holds methods that the mini games can inherit for basic functions such as choosing a random prize.
 * @author Thom
 */
public class Game {
    
    private ArrayList<aiPlayer> aiPlayersList = new ArrayList<aiPlayer>();
    private ArrayList<Prize> prizeList = new ArrayList<Prize>();
    private Player player;
    Random rand = new Random();
    protected Prize chosenPrize;
    protected Scanner userIn = new Scanner(System.in);
    
    Game(ArrayList<aiPlayer> aiPlayersList, ArrayList<Prize> prizeList, Player player){
    this.aiPlayersList = aiPlayersList;
    this.prizeList = prizeList;
    this.player = player;
    }
    
    
    //Looks at the list of available prizes, returns a randomly selected one and removes it from the available prize list.
    protected Prize genRanPrize()
    {
        int prizeId =  rand.nextInt(prizeList.size())+0;
        chosenPrize = prizeList.get(prizeId);
        prizeList.remove(prizeId);
        return chosenPrize;
         
    }
    
    //Resets the round winner state
    protected void resetWinners()
    {
        for(int i = 0; i<aiPlayersList.size(); i++)
        {
            aiPlayersList.get(i).setRoundwinner(false);
        }
        player.setRoundWinner(false);
        
    }
    //Randomly generated AI based gameplay for simple gamemodes
        protected void genAiGame(int i)
    {
        chosenPrize = genRanPrize();
        Prize temp = genRanPrize();
        int randNo = rand.nextInt((1000 - 0)+1)+0;
        if((randNo%2) == 0)
            {
                 aiPlayersList.get(i).addPrize(chosenPrize);
                 System.out.println(aiPlayersList.get(i).getName() +" has played One Right Price and won " + chosenPrize.getName() +"and " +temp.getName());
            }
        else
            {
                System.out.println(aiPlayersList.get(i).getName() +" has played One Right Price and won didn't win anything");
                prizeList.add(chosenPrize);
                prizeList.add(temp);

            }
    }

        
    //Get and set methods    
        
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

    public Random getRand() {
        return rand;
    }

    public void setRand(Random rand) {
        this.rand = rand;
    }

    public Prize getChosenPrize() {
        return chosenPrize;
    }

    public void setChosenPrize(Prize chosenPrize) {
        this.chosenPrize = chosenPrize;
    }

    public Scanner getUserIn() {
        return userIn;
    }

    public void setUserIn(Scanner userIn) {
        this.userIn = userIn;
    }
        
    
    
}
