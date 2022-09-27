package dev.tknapp.eatyoursprouts.inventory;

import dev.tknapp.eatyoursprouts.items.Item;

import java.io.FileNotFoundException;
import java.util.Map;

public interface InventoryReader {
    
    Map<String, Item> read(String fileName) throws FileNotFoundException;
}
