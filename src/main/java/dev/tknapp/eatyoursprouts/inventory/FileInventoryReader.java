package dev.tknapp.eatyoursprouts.inventory;

import dev.tknapp.eatyoursprouts.items.Equipment;
import dev.tknapp.eatyoursprouts.items.Items;
import dev.tknapp.eatyoursprouts.items.Sprouts;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class FileInventoryReader implements InventoryReader{
    
    private final String filename = "C:\\Users\\tyler\\source\\repos\\eat-your-sprouts\\src\\main\\resources\\inventory.csv";
    
    @Override
    public Map<String, Items> read(String filename) throws FileNotFoundException {
        
        Map<String , Items> inventory = new TreeMap<String, Items>();
    
        File file = new File(filename);
    
        try( Scanner inventoryFile = new Scanner(file)) {
            while (inventoryFile.hasNextLine()) {
                String item = inventoryFile.nextLine();
                String[] parts = item.split("\\|");
            
                String code = parts[0];
                String name = parts[1];
                BigDecimal price = BigDecimal.valueOf(Double.parseDouble(parts[2]));
                String type = parts[3];
            
                Items newItems = null;
                if (type.equalsIgnoreCase("S")) {
                    newItems = new Sprouts(code, name, price, type);
                    System.out.println(newItems.getCode() + " " + newItems.getName() + " " + newItems.getPrice() + " " + newItems.getType());
                }
                if (type.equalsIgnoreCase("E")) {
                    newItems = new Equipment(code, name, price, type);
                    System.out.println(newItems.getCode() + " " + newItems.getName() + " " + newItems.getPrice() + " " + newItems.getType());
                }
                inventory.put(parts[0], newItems);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return inventory;
    }
}
