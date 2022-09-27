package dev.tknapp.eatyoursprouts.inventory;

import dev.tknapp.eatyoursprouts.items.Equipment;
import dev.tknapp.eatyoursprouts.items.Item;
import dev.tknapp.eatyoursprouts.items.Sprouts;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class FileInventoryReader implements InventoryReader{
    
    @Override
    public Map<String, Item> read(String filename) throws FileNotFoundException {
    
        Map<String, Item> inventory = new TreeMap<>();
    
        File file = new File(filename);
    
        try( Scanner inventoryFile = new Scanner(file)) {
            while (inventoryFile.hasNextLine()) {
                String item = inventoryFile.nextLine();
                List<String> parts = new java.util.ArrayList<>(List.of(item.split("\\|")));
            
                String code = parts.get(0);
                String name = parts.get(1);
                BigDecimal price = BigDecimal.valueOf(Double.parseDouble(parts.get(2)));
                String type = parts.get(3);

                Inventory newInventory = new Inventory();
            
                Item newItem = null;
                if (type.equalsIgnoreCase("S")) {
                    newItem = new Sprouts(code, name, price, type, newInventory.getInitialQuantity());
                    System.out.println(newItem.getCode() + " " + newItem.getName() + " " + newItem.getPrice() + " " + newItem.getType() + " " + newItem.getQuantity() );
                }
                if (type.equalsIgnoreCase("E")) {
                    newItem = new Equipment(code, name, price, type, newInventory.getInitialQuantity());
                    System.out.println(newItem.getCode() + " " + newItem.getName() + " " + newItem.getPrice() + " " + newItem.getType() + " " + newItem.getQuantity());
                }
                inventory.put(parts.get(0), newItem);
            }
        } catch (Exception e){
            e.printStackTrace();
            e.getLocalizedMessage();
            System.out.println("Something went wrong");
        }
        return inventory;
    }
    
    public void checkType(String type){
    
    }
}
