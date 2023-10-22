package com.br.onlineshoppingsystem.domain.shopping;

import com.br.onlineshoppingsystem.enums.Category;

public class Product {
    private String name;
    private String description;
    private Double price;

    public Product(String name, String description, Double price, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

}
