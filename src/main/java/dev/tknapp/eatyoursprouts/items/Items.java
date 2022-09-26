package dev.tknapp.eatyoursprouts.items;

import java.math.BigDecimal;

public abstract class Items {
    
    private String code;
    private String name;
    private BigDecimal price;
    private String type;
    
    public Items(String code, String name, BigDecimal price, String type) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.type = type;
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
