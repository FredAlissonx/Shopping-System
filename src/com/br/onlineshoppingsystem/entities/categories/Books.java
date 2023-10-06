package com.br.onlineshoppingsystem.entities.categories;

import com.br.onlineshoppingsystem.entities.Category;
import com.br.onlineshoppingsystem.entities.Products;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Books extends Products {

    // Default storage
    private List<Products> books = new ArrayList<>(Arrays.asList(
            new Products("To Kill a Mockingbird by Harper Lee", "A classic novel that addresses issues of racism and moral growth in the American South.", 12.99, Category.BOOKS),
            new Products("The Great Gatsby by F. Scott Fitzgerald", "A novel set in the 1920s, exploring themes of wealth, excess, and the American Dream.", 10.49, Category.BOOKS),
            new Products("Becoming by Michelle Obama", "A memoir by the former First Lady, recounting her personal journey and experiences in the White House.", 18.99, Category.BOOKS)
    ));


    public Books() {
    }

    public Books(String name, String description, Double price, Category category, List<Products> books) {
        super(name, description, price, category);
        this.books = books;
    }

    public List<Products> getBooks() {
        return books;
    }
}
