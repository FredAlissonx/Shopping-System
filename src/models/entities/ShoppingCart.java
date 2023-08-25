package models.entities;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Products> items = new ArrayList<>();
    public ShoppingCart(){
    }

    public ShoppingCart(List<Products> items) {
        this.items = items;
    }

    public List<Products> getItems() {
        return items;
    }

    public void addItem(Products products){
        items.add(products);
    }
    public void removeItem(Products products){
        items.remove(products);
    }
    public double totalCost(){
        return 0;
    }
}
