package com.br.onlineshoppingsystem.services;

import com.br.onlineshoppingsystem.domain.shopping.Product;
import com.br.onlineshoppingsystem.enums.Category;

import java.util.Arrays;
import java.util.List;

public class ProductProviderService {

    protected List<Product> getEletronics() {
        return Arrays.asList(
                new Product("Men's Classic T-Shirt", "A comfortable and versatile men's t-shirt made from soft cotton.", 19.99, Category.CLOTHINGS),
                new Product("Women's Skinny Jeans", "Stylish and fitted women's jeans with a modern skinny fit.", 39.99, Category.CLOTHINGS),
                new Product("Unisex Hooded Sweatshirt", "A cozy and warm unisex sweatshirt with a hood and front pouch pocket.", 29.99, Category.CLOTHINGS)
        );
    }

    protected List<Product> getClothings() {
        return Arrays.asList(
                new Product("Laptop", "High-performance laptop for work and gaming.", 999.99, Category.ELETRONICS),
                new Product("Smartphone", "The latest smartphone with advanced features.", 699.99, Category.ELETRONICS),
                new Product("Headphones", "Noise-canceling headphones for immersive audio.", 149.99, Category.ELETRONICS)
        );
    }

    protected List<Product> getBooks() {
        return Arrays.asList(
                new Product("To Kill a Mockingbird by Harper Lee", "A classic novel that addresses issues of racism and moral growth in the American South.", 12.99d, Category.BOOKS),
                new Product("The Great Gatsby by F. Scott Fitzgerald", "A novel set in the 1920s, exploring themes of wealth, excess, and the American Dream.", 10.49d, Category.BOOKS),
                new Product("Becoming by Michelle Obama", "A memoir by the former First Lady, recounting her personal journey and experiences in the White House.", 18.99d, Category.BOOKS)
        );
    }

}
