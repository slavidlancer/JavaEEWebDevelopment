package com.jeewd.web_store.dto.product;

public class ProductSearch {
    private String name;
    private String type;
    private String price;
    private String quantity;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getPrice() {
        return price;
    }
    
    public void setPrice(String price) {
        this.price = price;
    }
    
    public String getQuantity() {
        return quantity;
    }
    
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    
    public boolean isEmpty() {
        if (this.getName().isEmpty() && this.getPrice().isEmpty() &&
                this.getQuantity().isEmpty() && this.getType().isEmpty()) {
            return true;
        }
        
        return false;
    }
}
