package Main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

/**
 * One Right Price game mode Class. Contains all methods for playing game mode.
 *
 * @author Thom
 *
 */
public class OneRightPrice extends Game {

    private ArrayList<aiPlayer> aiPlayersList = new ArrayList<aiPlayer>();
    private ArrayList<Prize> prizeList = new ArrayList<Prize>();
    private Player player;
    Random rand = new Random();
    protected Prize chosenPrize;
    protected Scanner userIn = new Scanner(System.in);

    public OneRightPrice(ArrayList<aiPlayer> aiPlayersList, ArrayList<Prize> prizeList, Player player) {
        super(aiPlayersList, prizeList, player);
        this.aiPlayersList = aiPlayersList;
        this.prizeList = prizeList;
        this.player = player;
    }

    /**
     * main controller for playing One Right Price.
     *
     * @author Thom
     */
    public void playOneRightPrice() {
        for (int i = 0; i <= aiPlayersList.size() - 1; i++) {
            if (aiPlayersList.get(i).isRoundwinner() == true) {
                genAiGame(i);
                super.resetWinners();
            }
        }
        if (player.isRoundWinner() == true) {
            genPlayerGame();
            super.resetWinners();
            super.getPlayer().setWonRound(true);

        }

    }

    /**
     * Main method for when the player is playing a round of One Right Price.
     *
     * @author Thom
     */
    protected void genPlayerGame() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("Welcome to One Right Price");
        sleep(1);
        System.out.println("In this game you will be shown two prizes, and price.");
        sleep(1);
        System.out.println("It's your task to look at the prizes and select the prize you think is associated with that value!");
        sleep(1);
        System.out.println("if you guess correctly you will take home with you both prizes!");

        Prize temp1 = super.genRanPrize();
        Prize temp2 = super.genRanPrize();
        int prizeValue = rand.nextInt(2) + 1;

        if (prizeValue == 1) {
            prizeValue = temp1.getValue();
        } else {
            prizeValue = temp2.getValue();
        }
        System.out.println("---------------------------------------------------------------");
        System.out.println("The first prize is: " + temp1.getName());
        sleep(1);
        System.out.println("The seccond prize is " + temp2.getName());
        System.out.println("---------------------------------------------------------------");
        sleep(1);
        System.out.println("The value associated with one of these prizes is: $" + prizeValue);
        System.out.println("Which prize do you think this value is associated with");
        sleep(1);
        System.out.println("(1) the: " + temp1.getName());
        System.out.println("or (2) the: " + temp2.getName());
        int userChoice = 0;
        boolean check = false;
        do {

            while (!userIn.hasNextInt()) {
                System.out.println("Please enter either 1 or 2");
                userIn.next();
            }
            userChoice = userIn.nextInt();

            if (userChoice == 1 || userChoice == 2) {
                check = true;
            } else {
                check = false;
                System.out.println("Please choose either 1 or 2");
            }

        } while (check == false);

        if (userChoice == 1) {
            if (temp1.getValue() == prizeValue) {
                sleep(2);
                System.out.println("CORRECT! The value of " + temp1.getName() + " is $" + prizeValue);
                System.out.println("The price of " + temp2.getName() + " on the other hand is $" + temp2.getValue());
                player.addPrize(temp1);
                player.addPrize(temp2);
            } else if (temp1.getValue() != prizeValue) {
                sleep(2);
                System.out.println("Im Sorry, the value of " + temp1.getName() + "is not $" + prizeValue);
                System.out.println("The price of " + temp2.getName() + " on the other hand is $" + temp2.getValue());
                System.out.println("Better luck next time!");
                sleep(1);
            }
        } else if (userChoice == 2) {
            if (temp2.getValue() == prizeValue) {
                sleep(2);
                System.out.println("CORRECT! The value of " + temp2.getName() + "is " + prizeValue);
                System.out.println("The price of " + temp1.getName() + " on the other hand is $" + temp1.getValue());
                player.addPrize(temp1);
                player.addPrize(temp2);
            } else if (temp2.getValue() != prizeValue) {
                sleep(2);
                System.out.println("Im Sorry, the value of " + temp2.getName() + "is not $" + prizeValue);
                System.out.println("The price of " + temp1.getName() + " on the other hand is $" + temp1.getValue());
                System.out.println("Better luck next time!");
                sleep(1);
            }
        }

    }

    /**
     * Main method for when AI is playing One Right Price
     *
     * @author Thom
     */
    protected void genAiGame(int i) {
        chosenPrize = super.genRanPrize();
        Prize temp = super.genRanPrize();
        int randNo = rand.nextInt((1000 - 0) + 1) + 0;
        super.getAiPlayersList().get(i).setWonRound(true);
        if ((randNo % 2) == 0) {
            aiPlayersList.get(i).addPrize(chosenPrize);
            String t = (aiPlayersList.get(i).getName() + " has played One Right Price and won " + chosenPrize.getName() + "and " + temp.getName());
            JOptionPane.showMessageDialog(null, t, "AI One Right Price game", INFORMATION_MESSAGE);
        } else {
            String t = (aiPlayersList.get(i).getName() + " has played One Right Price and won didn't win anything");
            prizeList.add(chosenPrize);
            prizeList.add(temp);
            JOptionPane.showMessageDialog(null, t, "AI One Right Price game", INFORMATION_MESSAGE);

        }
    }

    //Get and Set Methods
    public int getPrizeListSize() {
        return prizeList.size();
    }

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

    /**
     * Takes in int and sleeps program for that many seconds
     *
     * @author Thom
     */
    public void sleep(long time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

}
