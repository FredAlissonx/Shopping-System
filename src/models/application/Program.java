package models.application;

import models.entities.Costumer;
import models.entities.ShoppingCart;
import models.entities.categories.Books;
import models.entities.categories.Clothing;
import models.entities.categories.Eletronics;
import models.exceptions.DomainException;

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
                    System.out.println("Here are the products in the Electronics category:");

                    // Verifying option
                    try{
                        if(productChoose == 1){

                            //for to prinnt all item according to option
                            for (int i = 0; i < eletronics.getEletronics().size(); i++){
                                System.out.println((i + 1) + ". "+ eletronics.getEletronics().get(i).getName() + " - " + eletronics.getEletronics().get(i).getDescription() + " R$" + eletronics.getEletronics().get(i).getPrice());
                            }
                        }
                        else if(productChoose == 2){
                            for (int i = 0; i < clothing.getClothings().size(); i++){
                                System.out.println((i + 1) + ". "+ clothing.getClothings().get(i).getName() + " - " + clothing.getClothings().get(i).getDescription() + " R$" + clothing.getClothings().get(i).getPrice());
                            }
                        }
                        else if(productChoose == 3){
                            for (int i = 0; i < clothing.getClothings().size(); i++){
                                System.out.println((i + 1) + ". "+ book.getBooks().get(i).getName() + " - " + book.getBooks().get(i).getDescription() + " R$" + book.getBooks().get(i).getPrice());
                            }
                        }
                        //throws our DomainException wihta message
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

                            if(optionAddCart == 1){
                                // add item using composition
                                costumer.getShoppingCart().addItem((eletronics.getEletronics().get(optionAddCart - 1)));
                                System.out.println("Successfully added!");
                                System.out.println();
                            }
                            else if(optionAddCart == 2){
                                costumer.getShoppingCart().addItem((eletronics.getEletronics().get(optionAddCart - 1)));
                                System.out.println("Successfully added!");
                                System.out.println();
                            }
                            else if(optionAddCart == 3){
                                costumer.getShoppingCart().addItem((eletronics.getEletronics().get(optionAddCart - 1)));
                                System.out.println("Successfully added!");
                                System.out.println();
                            }
                            else{
                                throw new DomainException("Invalid option");
                            }
                        }
                        else if(addOptionSeeProductsfromCategory == 2){
                            for (int i = 0; i < clothing.getClothings().size(); i++){
                                System.out.println((i + 1) + ". "+ clothing.getClothings().get(i).getName());
                            }

                            System.out.print("Your choice to add to cart: ");
                            int optionAddCart = sc.nextInt();

                            if(optionAddCart == 1){
                                costumer.addToShoppingCart(clothing.getClothings().get(optionAddCart - 1));
                                System.out.println("Successfully added!");
                                System.out.println();
                            }
                            else if(optionAddCart == 2){
                                costumer.addToShoppingCart(clothing.getClothings().get(optionAddCart - 1));
                                System.out.println("Successfully added!");
                                System.out.println();
                            }
                            else if(optionAddCart == 3){
                                costumer.addToShoppingCart(clothing.getClothings().get(optionAddCart - 1));
                                System.out.println("Successfully added!");
                                System.out.println();
                            }
                            else{
                                throw new DomainException("Invalid option");
                            }
                        }
                        else if(addOptionSeeProductsfromCategory == 3){
                            for (int i = 0; i < book.getBooks().size(); i++){
                                System.out.println((i + 1) + ". "+ book.getBooks().get(i).getName());
                            }

                            System.out.print("Your choice to add to cart: ");
                            int optionAddCart = sc.nextInt();

                            if(optionAddCart == 1){
                                costumer.addToShoppingCart(book.getBooks().get(optionAddCart - 1));
                                System.out.println("Successfully added!");
                                System.out.println();
                            }
                            else if(optionAddCart == 2){
                                costumer.addToShoppingCart(book.getBooks().get(optionAddCart - 1));
                                System.out.println("Successfully added!");
                                System.out.println();
                            }
                            else if(optionAddCart == 3){
                                costumer.addToShoppingCart(book.getBooks().get(optionAddCart - 1));
                                System.out.println("Successfully added!");
                                System.out.println();
                            }
                            else{
                                throw new DomainException("Invalid option");
                            }
                        }
                    }catch (DomainException e){
                        System.out.println(e.getMessage());
                    }
                }
                // Remove from cart
                case 3 -> {
                    for (int i = 0; i < costumer.getShoppingCart().getItems().size(); i++){
                        System.out.println((i + 1) + ". " + costumer.getShoppingCart().getItems().get(i).getName());
                    }
                }
            }
        }
    }
    public static void menu(){
        System.out.println();
        System.out.println("Main menu:");
        System.out.println("1. Browse Products");
        System.out.println("2. Add to cart");
        System.out.println("3. Remove from cart");
        System.out.println("4. View Cart");
        System.out.println("5. Checkout");
        System.out.println("6. Exit");
        System.out.print("Please choose an option: ");

    }
}
