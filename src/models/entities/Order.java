package models.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Products> products = new ArrayList<>();
    private Costumer costumer;
    private LocalDate orderDate;
    private Double orderTotal;

    public List<Products> getProducts() {
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
