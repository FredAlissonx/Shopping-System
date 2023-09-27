package com.br.onlineshoppingsystem.entities;

import com.br.onlineshoppingsystem.domain.Customer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<ShoppingCartItems> products = new ArrayList<>();
    private Customer customer;
    private LocalDate orderDate;
    private Double orderTotal;
    public Order(){
    }

    public Order(List<ShoppingCartItems> products, Customer customer, LocalDate orderDate, Double orderTotal) {
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

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public boolean paymentValidate(int choose){
        return choose > 0 && choose <= 4;
    }
}
