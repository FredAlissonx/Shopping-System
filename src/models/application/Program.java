package models.application;

import models.entities.Costumer;
import models.entities.Order;
import models.entities.ShoppingCart;
import models.entities.ShoppingCartItems;
import models.entities.categories.Books;
import models.entities.categories.Clothing;
import models.entities.categories.Eletronics;
import models.exceptions.DomainException;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Books book = new Books();
        Clothing clothing = new Clothing();
        Eletronics eletronics = new Eletronics();

        System.out.println("To create a personalized cart for you, we need some information:");

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Shipping address (CEP/ZIP code): ");
        String address = sc.nextLine();

        Costumer costumer = new Costumer(name, email, address, new ShoppingCart());

        System.out.println("Welcome to the Online Shopping System!");


        while (true){

            // menu display and choice
            menu();
            int choice = sc.nextInt();

            sc.nextLine();

            switch (choice){
                // Browse products
                case 1 -> {
                    System.out.println();
                    System.out.println("Available Product Categories:");
                    System.out.println("1. Eletronics");
                    System.out.println("2. Clothing");
                    System.out.println("3. Books");
                    System.out.print("Please choose a category to view its products: ");
                    int productChoose = sc.nextInt();

                    System.out.println();

                    // Verifying option
                    try{
                        if(productChoose == 1){
                            System.out.println("Here are the products in the Electronics category:");

                            //for to prinnt all item according to option
                            for (int i = 0; i < eletronics.getEletronics().size(); i++){
                                System.out.println((i + 1) + ". "+ eletronics.getEletronics().get(i).getName() + " - " + eletronics.getEletronics().get(i).getDescription() + " R$" + eletronics.getEletronics().get(i).getPrice());
                            }
                        }
                        else if(productChoose == 2){
                            System.out.println("Here are the products in the Clothing category:");

                            for (int i = 0; i < clothing.getClothings().size(); i++){
                                System.out.println((i + 1) + ". "+ clothing.getClothings().get(i).getName() + " - " + clothing.getClothings().get(i).getDescription() + " R$" + clothing.getClothings().get(i).getPrice());
                            }
                        }
                        else if(productChoose == 3){
                            System.out.println("Here are the products in the Books category:");

                            for (int i = 0; i < book.getBooks().size(); i++){
                                System.out.println((i + 1) + ". "+ book.getBooks().get(i).getName() + " - " + book.getBooks().get(i).getDescription() + " R$" + book.getBooks().get(i).getPrice());
                            }
                        }
                        //throws our DomainException with a message
                        else{
                            throw new DomainException("Invalid option");
                        }
                    }catch(DomainException e){
                        System.out.println(e.getMessage());
                    }
                }
                //Add to cart
                case 2 -> {
                    System.out.println();
                    System.out.println("From what category:");
                    System.out.println("1. Eletronics");
                    System.out.println("2. Clothing");
                    System.out.println("3. Books");
                    System.out.print("Your choice: ");

                    int addOptionSeeProductsfromCategory = sc.nextInt();

                    System.out.println();

                    try{
                        if(addOptionSeeProductsfromCategory == 1){
                            // show the name of options
                            for (int i = 0; i < eletronics.getEletronics().size(); i++){
                                System.out.println((i + 1) + ". "+ eletronics.getEletronics().get(i).getName());
                            }

                            System.out.print("Your choice to add to cart: ");
                            int optionAddCart = sc.nextInt();

                            System.out.print("Quantity: ");
                            int quantity = sc.nextInt();

                            if(optionAddCart == 1){
                                // add item using composition
                                costumer.addToShoppingCart(eletronics.getEletronics().get(optionAddCart - 1), quantity);
                                System.out.println("Successfully added!");
                                System.out.println();
                            }
                            else if(optionAddCart == 2){
                                costumer.addToShoppingCart(eletronics.getEletronics().get(optionAddCart - 1), quantity);
                                System.out.println("Successfully added!");
                                System.out.println();
                            }
                            else if(optionAddCart == 3){
                                costumer.addToShoppingCart(eletronics.getEletronics().get(optionAddCart - 1), quantity);
                                System.out.println("Successfully added!");
                                System.out.println();
                            }
                            else{
                                System.out.println();
                                throw new DomainException("Invalid option!");
                            }
                        }
                        else if(addOptionSeeProductsfromCategory == 2){

                            for (int i = 0; i < clothing.getClothings().size(); i++){
                                System.out.println((i + 1) + ". "+ clothing.getClothings().get(i).getName());
                            }

                            System.out.print("Your choice to add to cart: ");
                            int optionAddCart = sc.nextInt();

                            System.out.print("Quantity: ");
                            int quantity = sc.nextInt();

                            if(optionAddCart == 1){
                                costumer.addToShoppingCart(clothing.getClothings().get(optionAddCart - 1), quantity);
                                System.out.println("Successfully added!");

                                System.out.println();
                            }
                            else if(optionAddCart == 2){
                                costumer.addToShoppingCart(clothing.getClothings().get(optionAddCart - 1), quantity);
                                System.out.println("Successfully added!");
                                System.out.println();
                            }
                            else if(optionAddCart == 3){
                                costumer.addToShoppingCart(clothing.getClothings().get(optionAddCart - 1), quantity);
                                System.out.println("Successfully added!");
                                System.out.println();
                            }
                            else{
                                System.out.println();
                                throw new DomainException("Invalid option!");
                            }
                        }
                        else if(addOptionSeeProductsfromCategory == 3){

                            for (int i = 0; i < book.getBooks().size(); i++){
                                System.out.println((i + 1) + ". "+ book.getBooks().get(i).getName());
                            }

                            System.out.print("Your choice to add to cart: ");
                            int optionAddCart = sc.nextInt();

                            System.out.print("Quantity: ");
                            int quantity = sc.nextInt();

                            if(optionAddCart == 1){
                                costumer.addToShoppingCart(book.getBooks().get(optionAddCart - 1), quantity);
                                System.out.println("Successfully added!");
                                System.out.println();
                            }
                            else if(optionAddCart == 2){
                                costumer.addToShoppingCart(book.getBooks().get(optionAddCart - 1), quantity);
                                System.out.println("Successfully added!");
                                System.out.println();
                            }
                            else if(optionAddCart == 3){
                                costumer.addToShoppingCart(book.getBooks().get(optionAddCart - 1), quantity);
                                System.out.println("Successfully added!");
                                System.out.println();
                            }
                            else{
                                System.out.println();
                                throw new DomainException("Invalid option!");
                            }
                        }else{
                            throw new DomainException("Invalid option!");
                        }
                    }catch (DomainException e){
                        System.out.println(e.getMessage());
                    }
                }
                // View cart
                case 3 -> {
                    if (costumer.getShoppingCart().getItems().isEmpty()){
                        System.out.println();
                        System.out.println("Your cart is empty!");
                        break;
                    }
                    int totalItems = 0;
                    System.out.println();
                    System.out.println("----- View Cart -----");
                    System.out.println("Your shopping cart:");
                    System.out.println();
                    for (int i = 0; i < costumer.getShoppingCart().getItems().size(); i++) {

                        ShoppingCartItems cartItem = costumer.getShoppingCart().getItems().get(i);
                        int quantity = cartItem.getQuantity();
                        double itemTotalCost = quantity * cartItem.getProduct().getPrice();
                        
                        System.out.println((i + 1) + ". " + cartItem.getProduct().getName() + " (Qty: " + quantity + ") - $" + String.format("%.2f", itemTotalCost));
                        totalItems += quantity;

                    }
                    System.out.println("Total Items: " + totalItems);
                    System.out.println("Total Cost: $" + String.format("%.2f", costumer.getShoppingCart().totalCost()));

                }
                case 4 -> {

                    if(costumer.getShoppingCart().getItems().isEmpty()){
                        System.out.println();
                        System.out.println("Your cart is empty!");
                        break;
                    }

                    System.out.println();
                    System.out.println("----- Removing from cart -----");
                    System.out.println();

                    for (int i = 0; i < costumer.getShoppingCart().getItems().size(); i++){
                        System.out.println((i + 1) + ". " + costumer.getShoppingCart().getItems().get(i).getProduct().getName() + " (Qty: " + costumer.getShoppingCart().getItems().get(i).getQuantity() + ")");
                    }

                    boolean isValid = false;
                    try{
                        do {
                            System.out.print("Item that you want to remove: ");
                            int itemToRemoveFromShoppingCart = sc.nextInt();

                            System.out.print("Quantity to remove: ");
                            int itemQuantityToRemoveFromShoppingCart = sc.nextInt();

                            if(itemToRemoveFromShoppingCart < 0 || itemToRemoveFromShoppingCart > costumer.getShoppingCart().getItems().size() || itemQuantityToRemoveFromShoppingCart > costumer.getShoppingCart().getItems().get(itemToRemoveFromShoppingCart).getQuantity()){
                                throw new DomainException("Invalid option!");
                            }else{
                                isValid = true;
                            }
                        }while (isValid);
                    }catch (DomainException e){
                        System.out.println(e.getMessage());
                    }

                }
                case 5 -> {
//                    Order order = new Order(costumer.getShoppingCart().getItems(), costumer, LocalDate.now(), costumer.getShoppingCart().totalCost());
                }
            }
        }
    }
    public static void menu(){
        System.out.println();
        System.out.println("Main menu:");
        System.out.println("1. Browse Products");
        System.out.println("2. Add to cart");
        System.out.println("3. View cart");
        System.out.println("4. Remove from cart");
        System.out.println("5. Checkout");
        System.out.println("6. Exit");
        System.out.print("Please choose an option: ");

    }
}
