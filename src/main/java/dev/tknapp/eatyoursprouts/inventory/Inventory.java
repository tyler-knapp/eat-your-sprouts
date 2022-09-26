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
    
    public Inventory() throws FileNotFoundException {
        FileInventoryReader reader = new FileInventoryReader();
        String filename = "C:\\Users\\Student\\source\\repos\\team7-java-blue-week04-pair-exercises\\m1-capstone-java-cateringsystem\\cateringsystem.csv";
        foodItems = reader.read(filename);
        
        Set<String> keys = foodItems.keySet();
    }
    
    public Map<String, Items> getFoodItems() {
        return foodItems;
    }

}
