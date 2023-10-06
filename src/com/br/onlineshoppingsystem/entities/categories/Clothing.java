package com.br.onlineshoppingsystem.entities.categories;

import com.br.onlineshoppingsystem.entities.Category;
import com.br.onlineshoppingsystem.entities.Products;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Clothing extends Products {
    private List<Products> clothings = new ArrayList<>(Arrays.asList(
            new Products("Men's Classic T-Shirt", "A comfortable and versatile men's t-shirt made from soft cotton.", 19.99, Category.CLOTHING),
            new Products("Women's Skinny Jeans", "Stylish and fitted women's jeans with a modern skinny fit.", 39.99, Category.CLOTHING),
            new Products("Unisex Hooded Sweatshirt", "A cozy and warm unisex sweatshirt with a hood and front pouch pocket.", 29.99, Category.CLOTHING)
    ));

    public Clothing() {
    }

    public Clothing(String name, String description, Double price, Category category, List<Products> clothings) {
        super(name, description, price, category);
        this.clothings = clothings;
    }

    public List<Products> getClothings() {
        return clothings;
    }

}
