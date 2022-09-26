package dev.tknapp.eatyoursprouts.inventory;

import dev.tknapp.eatyoursprouts.items.Items;

import java.io.FileNotFoundException;
import java.util.Map;

public interface InventoryReader {
    
    Map<String, Items> read(String fileName) throws FileNotFoundException;
}
