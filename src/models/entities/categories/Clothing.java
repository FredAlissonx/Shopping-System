package models.entities.categories;

import models.entities.Category;
import models.entities.Products;

import java.util.ArrayList;
import java.util.List;

public class Clothing extends Products{
    private List<Products> clothings = new ArrayList<>();

    public Clothing() {
    }

    public Clothing(String name, String description, Double price, Category category, List<Products> clothings) {
        super(name, description, price, category);
        this.clothings = clothings;
    }

    public List<Products> getClothings() {
        List<Products> set = new ArrayList<>();
        set.add(new Products("Men's Classic T-Shirt", "A comfortable and versatile men's t-shirt made from soft cotton.", 19.99, Category.CLOTHING));
        set.add(new Products("Women's Skinny Jeans", "Stylish and fitted women's jeans with a modern skinny fit.", 39.99, Category.CLOTHING));
        set.add(new Products("Unisex Hooded Sweatshirt", "A cozy and warm unisex sweatshirt with a hood and front pouch pocket.", 29.99, Category.CLOTHING));
        this.clothings = set;
        return clothings;
    }

}
