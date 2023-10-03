package com.br.onlineshoppingsystem.entities;

import com.br.onlineshoppingsystem.domain.Customer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<ShoppingCartItems> productsShoppingCart;
    private Customer customer;
    private LocalDateTime orderDate;
    private Double orderTotal;

    public Order(List<ShoppingCartItems> productsShoppingCart, Customer customer, LocalDateTime orderDate, Double orderTotal) {

        this.productsShoppingCart = productsShoppingCart;
        this.customer = customer;
        this.orderDate = orderDate;
        this.orderTotal = orderTotal;
    }

    public List<ShoppingCartItems> getProducts() {
        return productsShoppingCart;
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

    public Double getOrderTotal() {
        return orderTotal;
    }
}
