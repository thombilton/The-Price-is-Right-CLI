package Main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * . Class that contains methods for reading in CSV files.
 * @author Thom
 */
public class ReadInPrizes {
    
    
    public void ReadIn(ArrayList Prizes) throws FileNotFoundException, IOException
    {
        FileReader file = new FileReader ("Prizes.txt");
        BufferedReader br= new BufferedReader(file);
        
        String line = null;
        while((line=br.readLine())!=null)
        {
            StringTokenizer token = new StringTokenizer(line, ",");
            String name = token.nextToken();
//            System.out.println(name);
            Integer value = Integer.valueOf(token.nextToken());
//            System.out.println(value);
            
            Prizes.add(new Prize(name, value));

        }
        
        
    }
    
}
