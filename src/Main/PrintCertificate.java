package Main;

import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Thom
 */
public class PrintCertificate {
    
    /**
    *. Prints the players prize list to a text file
    * @author Thom
    */      
public void print(Player player)
{

try{
    PrintWriter writer = new PrintWriter("Certificate.txt", "UTF-8");
   
writer.println("-----------------------------------------------------------------");                                                         
writer.println("|                                                               |");
writer.println("|                                                               |");
writer.println("|                                                               |");
writer.println("|                     Thank you for playing                     |");
writer.println("|                       THE PRICE IS RIGHT                      |");
writer.println("|                         ON TODAYS DATE                        |");
writer.println("|                                                               |");
writer.println("|                  The Prizes you won today are:                |");
writer.println("|                                                               |");

for(int i = 0; i< player.getCurrentPrizes().size(); i++)
{
    writer.print("|");
    String printString = player.getSpecPrizeName(i) + " valued at $" +player.getSpecPrizePrice(i);
    int sLen = 66 - printString.length();
    int halfSLen = (sLen/2);

    for(int n = 0; n< halfSLen; n++){
        writer.print(" ");
    }
    
    writer.print(printString);
        
    for(int n = 0; n< (halfSLen-2); n++){
        writer.print(" ");


    }
    writer.print("|");
    writer.print("\n");
}

writer.println("|                                                               |");
writer.println("|                                                               |");
writer.println("|                                                               |");
writer.println("|                                                               |");
writer.println("|                                                               |");
writer.println("|                                                               |");
writer.println("|                                                               |");
writer.println("|                                                               |");
writer.println("|                                                               |");
writer.println("|                                                               |");
writer.println("|                                                               |");
writer.println("|                                                               |");
writer.println("-----------------------------------------------------------------");
    writer.close();
    
    
} catch (IOException e) {
   // do something
}
}
    
}
