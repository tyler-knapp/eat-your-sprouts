package dev.tknapp.eatyoursprouts.inventory;

import dev.tknapp.eatyoursprouts.items.Items;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Set;

public class Inventory {
    
    private Map<String, Items> foodItems;
    private int initialQuantity = 50;
    
    public int getInitialQuantity() {
        return initialQuantity;
    }
    
    public Inventory(){
    }
    
    public Map<String, Items> getFoodItems() {
        return foodItems;
    }

}
