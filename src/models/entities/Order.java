package models.entities;

import models.exceptions.DomainException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<ShoppingCartItems> products = new ArrayList<>();
    private Costumer costumer;
    private LocalDate orderDate;
    private Double orderTotal;
    public Order(){
    }

    public Order(List<ShoppingCartItems> products, Costumer costumer, LocalDate orderDate, Double orderTotal) {
        this.products = products;
        this.costumer = costumer;
        this.orderDate = orderDate;
        this.orderTotal = orderTotal;
    }

    public List<ShoppingCartItems> getProducts() {
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
    public boolean paymentValidate(int chose){

        System.out.println("1. Credit Card");
        System.out.println("2. PayPal");
        System.out.println("3. Pix");
        System.out.println("4. Bitcoin");

        System.out.println("Method: ");

            if (chose <= 0 || chose > 4){
                return false;
            }
            return true;
    }
}
