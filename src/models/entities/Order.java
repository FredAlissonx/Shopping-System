package models.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<ShoppingCarItems> products = new ArrayList<>();
    private Costumer costumer;
    private LocalDate orderDate;
    private Double orderTotal;
    public Order(){
    }

    public Order(List<ShoppingCarItems> products, Costumer costumer, LocalDate orderDate, Double orderTotal) {
        this.products = products;
        this.costumer = costumer;
        this.orderDate = orderDate;
        this.orderTotal = orderTotal;
    }

    public List<ShoppingCarItems> getProducts() {
        return products;
    }

    public Costumer getCostumer() {
        return costumer;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public Double getOrderTotal() {
        return orderTotal;
    }
}
