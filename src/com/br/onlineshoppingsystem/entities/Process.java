package com.br.onlineshoppingsystem.entities;

import com.br.onlineshoppingsystem.categories.Books;
import com.br.onlineshoppingsystem.categories.Clothing;
import com.br.onlineshoppingsystem.categories.Eletronics;
import com.br.onlineshoppingsystem.exceptions.DomainException;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Process {


    Scanner sc = new Scanner(System.in);
    public void viewProducts(Eletronics eletronics, Books book, Clothing clothing) {

        System.out.println("\nAvailable Product Categories:");
        System.out.println("1. Eletronics");
        System.out.println("2. Clothing");
        System.out.println("3. Books");
        System.out.print("Please choose a category to view its products: ");
        int productChoose = sc.nextInt();
        System.out.println();

        // Verifying option
        try {
            List<Products> selectedProducts = null;
            String categoryName = "";

            switch (productChoose) {
                case 1:
                    selectedProducts = eletronics.getEletronics();
                    categoryName = "Electronics";
                    break;
                case 2:
                    selectedProducts = clothing.getClothings();
                    categoryName = "Clothing";
                    break;
                case 3:
                    selectedProducts = book.getBooks();
                    categoryName = "Books";
                    break;
                default:
                    throw new DomainException("Invalid option!");
            }

            System.out.println("Here are the products in the " + categoryName + " category:\n");

            for (int i = 0; i < selectedProducts.size(); i++) {

                Products product = selectedProducts.get(i);
                System.out.println((i + 1) + ". " + product.getName() + " - " + product.getDescription() + " R$" + product.getPrice());

            }
        } catch (DomainException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addToCart(Eletronics eletronics, Books book, Clothing clothing, Costumer costumer) {

        System.out.println("\nFrom what category:");
        System.out.println("1. Eletronics");
        System.out.println("2. Clothing");
        System.out.println("3. Books");
        System.out.print("Your choice: ");
        int addOptionSeeProductsfromCategory = sc.nextInt();

        System.out.println();

        try {
            if (addOptionSeeProductsfromCategory == 1) {
                // show the name of options
                for (int i = 0; i < eletronics.getEletronics().size(); i++) {
                    System.out.println((i + 1) + ". " + eletronics.getEletronics().get(i).getName());
                }

                System.out.print("Your choice to add to cart: ");
                int optionAddCart = sc.nextInt();

                System.out.print("Quantity: ");
                int quantity = sc.nextInt();


                if (optionAddCart == 1) {
                    // add item using composition
                    costumer.addToShoppingCart(eletronics.getEletronics().get(optionAddCart - 1), quantity);
                    System.out.println("Successfully added!");
                    System.out.println();
                } else if (optionAddCart == 2) {
                    costumer.addToShoppingCart(eletronics.getEletronics().get(optionAddCart - 1), quantity);
                    System.out.println("Successfully added!");
                    System.out.println();
                } else if (optionAddCart == 3) {
                    costumer.addToShoppingCart(eletronics.getEletronics().get(optionAddCart - 1), quantity);
                    System.out.println("Successfully added!");
                    System.out.println();
                } else {
                    System.out.println();
                    throw new DomainException("Invalid option!");
                }
            } else if (addOptionSeeProductsfromCategory == 2) {

                for (int i = 0; i < clothing.getClothings().size(); i++) {
                    System.out.println((i + 1) + ". " + clothing.getClothings().get(i).getName());
                }

                System.out.print("Your choice to add to cart: ");
                int optionAddCart = sc.nextInt();

                System.out.print("Quantity: ");
                int quantity = sc.nextInt();

                if (optionAddCart == 1) {
                    costumer.addToShoppingCart(clothing.getClothings().get(optionAddCart - 1), quantity);
                    System.out.println("Successfully added!");

                    System.out.println();
                } else if (optionAddCart == 2) {
                    costumer.addToShoppingCart(clothing.getClothings().get(optionAddCart - 1), quantity);
                    System.out.println("Successfully added!");
                    System.out.println();
                } else if (optionAddCart == 3) {
                    costumer.addToShoppingCart(clothing.getClothings().get(optionAddCart - 1), quantity);
                    System.out.println("Successfully added!");
                    System.out.println();
                } else {
                    System.out.println();
                    throw new DomainException("Invalid option!");
                }
            } else if (addOptionSeeProductsfromCategory == 3) {

                for (int i = 0; i < book.getBooks().size(); i++) {
                    System.out.println((i + 1) + ". " + book.getBooks().get(i).getName());
                }

                System.out.print("Your choice to add to cart: ");
                int optionAddCart = sc.nextInt();

                System.out.print("Quantity: ");
                int quantity = sc.nextInt();

                if (optionAddCart == 1) {
                    costumer.addToShoppingCart(book.getBooks().get(optionAddCart - 1), quantity);
                    System.out.println("Successfully added!");
                    System.out.println();
                } else if (optionAddCart == 2) {
                    costumer.addToShoppingCart(book.getBooks().get(optionAddCart - 1), quantity);
                    System.out.println("Successfully added!");
                    System.out.println();
                } else if (optionAddCart == 3) {
                    costumer.addToShoppingCart(book.getBooks().get(optionAddCart - 1), quantity);
                    System.out.println("Successfully added!");
                    System.out.println();
                } else {
                    System.out.println();
                    throw new DomainException("Invalid option!");
                }
            } else {
                throw new DomainException("Invalid option!");
            }
        } catch (DomainException e) {
            System.out.println(e.getMessage());
        }
    }

    public void viewCart(Costumer costumer) {
        if (costumer.getShoppingCart().getItems().isEmpty()) {
            System.out.println();
            System.out.println("Your cart is empty!");
            return;
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


    public void removeItemFromCart(Eletronics eletronics, Books book, Clothing clothing, Costumer costumer) {

        if (costumer.getShoppingCart().getItems().isEmpty()) {
            System.out.println();
            System.out.println("Your cart is empty!");
            return;
        }

        System.out.println();
        System.out.println("----- Removing from cart -----");
        System.out.println();

        for (int i = 0; i < costumer.getShoppingCart().getItems().size(); i++) {
            System.out.println((i + 1) + ". " + costumer.getShoppingCart().getItems().get(i).getProduct().getName() + " (Qty: " + costumer.getShoppingCart().getItems().get(i).getQuantity() + ")");
        }
        try {

            System.out.print("Item to remove: ");
            int itemToRemoveByIndex = sc.nextInt();

            System.out.print("Quantity to remove: ");
            int quantityToRemove = sc.nextInt();

            if (itemToRemoveByIndex <= 0 || itemToRemoveByIndex > costumer.getShoppingCart().getItems().size() || quantityToRemove < 0 || quantityToRemove > costumer.getShoppingCart().getItems().get(itemToRemoveByIndex - 1).getQuantity()) {
                throw new DomainException("Invalid Option!");
            }

            ShoppingCartItems itemToRemove = costumer.getShoppingCart().getItems().get(itemToRemoveByIndex - 1);

            itemToRemove.decrementQuantity(quantityToRemove);

            if (itemToRemove.getQuantity() == 0) {
                costumer.getShoppingCart().removeEntireProduct(itemToRemove);
            }
        } catch (DomainException e) {
            System.out.println(e.getMessage());
        }
    }
    public void checkout(Costumer costumer) {
        Order order = new Order(costumer.getShoppingCart().getItems(), costumer, LocalDate.now(), costumer.getShoppingCart().totalCost());

        List<ShoppingCartItems> orderCostumerItems = order.getCostumer().getShoppingCart().getItems();
        int totalItems = 0;
        System.out.println("----- Checkout -----");
        System.out.println();
        System.out.println("Your order summary:");
        for (int i = 0; i < orderCostumerItems.size(); i++) {
            System.out.println((i + 1) + ". " + orderCostumerItems.get(i).getProduct().getName() + "(Qty: " + orderCostumerItems.get(i).getQuantity() + ")" + " - $" + String.format("%.2f", orderCostumerItems.get(i).getProduct().getPrice() * orderCostumerItems.get(i).getQuantity()));
            totalItems++;
        }
        System.out.println("Total Items:" + totalItems);
        System.out.println("Order at " + order.getOrderDate());
        System.out.println("Total Different Items: " + orderCostumerItems.size());
        System.out.println("Total Cost: $" + String.format("%.2f", costumer.getShoppingCart().totalCost()));

        System.out.println("Shipping address:");
        System.out.println(order.getCostumer().getName());
        System.out.println(order.getCostumer().getEmail());
        System.out.println(order.getCostumer().getShippingAddress());

        System.out.println("Select Payment Method:");

        System.out.println("1. Credit Card");
        System.out.println("2. PayPal");
        System.out.println("3. Pix");
        System.out.println("4. Bitcoin");
        System.out.println("Method: ");
        int paymentMethod = sc.nextInt();

        if (order.paymentValidate(paymentMethod)) {
            System.out.println("Payment Successful!");
            System.out.println();
            System.out.println("Your order has been placed. Thank you for shopping with us!");
        } else {
            System.out.println("Invalid payment method!");
            order.paymentValidate(sc.nextInt());
        }
    }
    public void exit(){
        System.out.println();
        System.out.println("Thanks for using our Online Shopping System!");
    }

    public void menu() {
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
