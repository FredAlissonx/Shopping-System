package models.entities.categories;

import models.entities.Category;
import models.entities.Products;

import java.util.ArrayList;
import java.util.List;

public class Eletronics extends Products{
    private List<Products> eletronics = new ArrayList<>();
    public Eletronics() {
    }

    public Eletronics(String name, String description, Double price, Category category, List<Products> eletronics) {
        super(name, description, price, category);
        this.eletronics = eletronics;
    }
    public List<Products> getEletronics() {
        // default values
        List<Products> set = new ArrayList<>();

        set.add(new Products("Laptop", "High-performance laptop for work and gaming.", 999.99, Category.ELETRONICS));
        set.add(new Products("Smartphone", "The latest smartphone with advanced features.", 699.99, Category.ELETRONICS));
        set.add(new Products("Headphones", "Noise-canceling headphones for immersive audio.", 149.99, Category.ELETRONICS));

        this.eletronics = set;
        return eletronics;
    }

}
