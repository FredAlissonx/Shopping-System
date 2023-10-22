package com.br.onlineshoppingsystem.domain.shopping;

import com.br.onlineshoppingsystem.domain.customer.Customer;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private List<Purchase> purchases;
    private Customer customer;
    private LocalDateTime orderDate;
    private Double orderTotal;

    public Order(List<Purchase> purchases, Customer customer, LocalDateTime orderDate, Double orderTotal) {

        this.purchases = purchases;
        this.customer = customer;
        this.orderDate = orderDate;
        this.orderTotal = orderTotal;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public Customer getCustomer() {
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
