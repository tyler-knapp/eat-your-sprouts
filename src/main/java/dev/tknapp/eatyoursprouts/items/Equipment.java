package dev.tknapp.eatyoursprouts.items;

import java.math.BigDecimal;

public class Equipment extends Item {
    
    public Equipment(String code, String name, BigDecimal price, String type, int quantity) {
        super(code, name, price, type, quantity);
    }
}
