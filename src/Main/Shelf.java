package Main;

import java.util.ArrayList;

/**
 * . Shelf class that holds an array of prizes and infom about each level of the shelf.
 * Contains get and set methods also.
 * @author Thom
 */
public class Shelf implements Comparable<Shelf>{
    
        private Prize item;
        private Boolean high = false;
        private Boolean mid = false;
        private Boolean low = false;
        private int totalValue;
        private int noOfItems;

    public void calculateTotalValue()
    {
        totalValue = noOfItems * item.getValue();
    }
        
    public Prize getItem() {
        return item;
    }

    public void setItem(Prize item) {
        this.item = item;
    }

    public Boolean getHigh() {
        return high;
    }

    public void setHigh(Boolean high) {
        this.high = high;
    }

    public Boolean getMid() {
        return mid;
    }

    public void setMid(Boolean mid) {
        this.mid = mid;
    }

    public Boolean getLow() {
        return low;
    }

    public void setLow(Boolean low) {
        this.low = low;
    }

    public int getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(int totalValue) {
        this.totalValue = totalValue;
    }

    public int getNoOfItems() {
        return noOfItems;
    }

    public void setNoOfItems(int noOfItems) {
        this.noOfItems = noOfItems;
    }
    
    public int getItemValue(){
        return item.getValue();
    }
    
    

    @Override
    public int compareTo(Shelf comparestu) {
        int compareage=((Shelf)comparestu).getItemValue();
        return this.getItemValue()-compareage;
    }
        
        

    
}
