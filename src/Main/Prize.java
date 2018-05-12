
package Main;

import java.util.ArrayList;

/**
 * . Prize class that holds info about prizes and their methods.
 * @author Thom
 */
public class Prize implements Comparable<Prize>{
    
    //private ArrayList<Prize> prizeList = new ArrayList<Prize>();
    private String name;
    private int value;
    
    Prize(String name, int value){
        
        this.name = name;
        this.value = value;
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Prize comparestu) {
        int compareage=((Prize)comparestu).getValue();
        return this.value-compareage;
    }

    
    
    
}



