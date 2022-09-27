package dev.tknapp.eatyoursprouts.items;

import java.math.BigDecimal;

public abstract class Items {
    
    private final String code;
    private final String name;
    private final BigDecimal price;
    private final String type;
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    private int quantity = 50;
    
    public Items(String code, String name, BigDecimal price, String type, int quantity) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.type = type;
        this.quantity = quantity;
    }
    
    @Override
    public String toString() {
        return "Items{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                '}';
    }
    
    public String getCode() {
        return code;
    }
    
    public String getName() {
        return name;
    }
    
    public BigDecimal getPrice() {
        return price;
    }
    
    public String getType() {
        return type;
    }
}
