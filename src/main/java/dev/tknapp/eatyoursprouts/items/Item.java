package dev.tknapp.eatyoursprouts.items;

import java.math.BigDecimal;

public abstract class Item {
    private long id;
    private String code;
    private String name;
    private BigDecimal price;
    private String type;
    
    private int quantity = 50;
    
    public Item(String code, String name, BigDecimal price, String type, int quantity) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.type = type;
        this.quantity = quantity;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", quantity=" + quantity +
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
    
    public void setId(long id) {
        this.id = id;
    }
}
