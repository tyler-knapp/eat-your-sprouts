package dev.tknapp.eatyoursprouts.inventory;

import dev.tknapp.eatyoursprouts.items.Item;

import java.util.Map;

public class Inventory {
    
    private Map<String, Item> foodItems;
    private int initialQuantity = 50;
    
    public int getInitialQuantity() {
        return initialQuantity;
    }
    
    public Inventory(){
    }
    
    public Map<String, Item> getFoodItems() {
        return foodItems;
    }

}
