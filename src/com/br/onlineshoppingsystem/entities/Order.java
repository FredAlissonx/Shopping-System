package com.br.onlineshoppingsystem.entities;

import com.br.onlineshoppingsystem.domain.Customer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<ShoppingCartItems> products = new ArrayList<>();
    private Customer customer;
    private LocalDateTime orderDate;
    private Double orderTotal;
    public Order(){
    }

    public Order(List<ShoppingCartItems> products, Customer customer, LocalDateTime orderDate, Double orderTotal) {

        this.products = products;
        this.customer = customer;
        this.orderDate = orderDate;
        this.orderTotal = orderTotal;
    }

    public List<ShoppingCartItems> getProducts() {
        return products;
    }

    public Customer getCostumer() {
        return customer;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public boolean paymentValidate(int choose){
        return choose > 0 && choose <= 4;
    }
}
