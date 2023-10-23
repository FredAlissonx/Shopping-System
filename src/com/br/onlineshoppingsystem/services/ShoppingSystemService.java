package com.br.onlineshoppingsystem.services;

import com.br.onlineshoppingsystem.domain.customer.Customer;
import com.br.onlineshoppingsystem.domain.shopping.*;
import com.br.onlineshoppingsystem.enums.*;

import com.br.onlineshoppingsystem.interfaces.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ShoppingSystemService implements Validatable {

    private ProductProviderService productProviderService = new ProductProviderService();
    private static Scanner sc = new Scanner(System.in);

    public ShoppingSystemService() {
    }

    public void run() {

        System.out.print("Name: ");
        String name = sc.nextLine();
        if (!validName(name)) throw new RuntimeException("Illegal name!");

        System.out.print("Email (@gmail.com): ");
        String email = sc.nextLine();
        if (!validEmail(email)) throw new RuntimeException("Illegal email!");

        System.out.print("Shipping address (CEP/ZIP code - only integers): ");
        long adress = sc.nextLong();
        if (!validAdress(adress)) throw new RuntimeException("Illegal adress!");

        Customer customer = new Customer(name, email, adress, new Cart());

        loop:
        while (true) {

            PrinterService.printMenu();

            System.out.println("\n Main menu:");
            System.out.println("════════════════════════════════════");

            Option option = getChoice(Option.class);

            switch (option) {
                case BROWSE_PRODUCTS -> browseProducts();
                case ADD_TO_CART -> addToCart(customer);
                case VIEW_CART -> viewCart(customer);
                case REMOVE_FROM_CART -> removeFromCart(customer);
                case CHECKOUT -> checkout(customer);
                case EXIT -> {
                    exit();
                    break loop;
                }
            }
        }
    }

    //Receives enum class and total enum list size, returns element in index choice - 1
    private <T extends Enum<T>> T getChoice(Class<T> enumClass) {

        T[] elements = enumClass.getEnumConstants();
        PrinterService.print(elements);

        System.out.print("Your choice: ");
        int choice = sc.nextInt();

        while (!validChoice(choice, elements.length)) {
            System.out.println();
            System.out.println("Invalid!");
            PrinterService.print(elements);
            System.out.print("Your choice: ");
            choice = sc.nextInt();
        }

        return elements[choice - 1];
    }


    private void browseProducts() {
        System.out.println();

        String title = "╔════════════════════════════════╗" +
                "       ║  AVAILABLE PRODUCT CATEGORIES  ║" +
                "       ╚════════════════════════════════╝";

        String statement = "Categories";
        PrinterService.printTitle(title, statement);
        Category category = getChoice(Category.class);

        // Verifying option
        List<Product> products;
        String categoryName;

        switch (category) {
            case ELETRONICS -> {
                products = productProviderService.getEletronics();
                categoryName = "Electronics";
            }
            case CLOTHINGS -> {
                products = productProviderService.getClothings();
                categoryName = "Clothing";
            }
            case BOOKS -> {
                products = productProviderService.getBooks();
                categoryName = "Books";
            }
            default -> {
                return;
            }
        }

        System.out.println("Here are the products in the " + categoryName + " category: \n");
        PrinterService.printProducts(products);

    }

    private void addToCart(Customer customer) {

        String title = "╔════════════════════════════════╗" +
                "       ║          ADD TO CART           ║" +
                "       ╚════════════════════════════════╝";

        String statement = "From what category: ";

        PrinterService.printTitle(title, statement);

        Category category = getChoice(Category.class);
        List<Product> products;

        switch (category) {
            case BOOKS -> products = productProviderService.getBooks();
            case CLOTHINGS -> products = productProviderService.getClothings();
            case ELETRONICS -> products = productProviderService.getEletronics();
            default -> {
                return;
            }
        }

        add(category, customer, products);

    }

    private void add(Category category, Customer customer, List<Product> products) {

        PrinterService.printProducts(products);
        System.out.println("4. Back");

        System.out.print("Your choice to add to cart: ");
        int choice = sc.nextInt();

        if (choice == 4) return;

        while (!validChoice(choice, products.size())) {

            System.out.println("Invalid!");

            //Print products in simplified format;
            products.forEach(p -> System.out.println(((products.indexOf(p) + 1) + p.getName() + " - $" + p.getPrice())));
            System.out.println("4. Back");

            System.out.print("Your choice to add to cart: ");
            choice = sc.nextInt();
        }

        Product product = null;
        switch (category) {
            case ELETRONICS -> product = productProviderService.getEletronics().get(choice - 1);
            case BOOKS -> product = productProviderService.getBooks().get(choice - 1);
            case CLOTHINGS -> product = productProviderService.getClothings().get(choice - 1);
        }

        System.out.print("Quantity: ");
        int quantity = sc.nextInt();

        while (quantity <= 0) {
            System.out.println("Invalid!");
            System.out.print("Quantity: ");
            quantity = sc.nextInt();
        }

        Purchase purchase = new Purchase(product, quantity);
        final int finalQuantity = quantity;

        System.out.println();

        if (customer.getCart().getPurchases().contains(purchase)) {

            //Increment
            customer.getCart().getPurchases().stream()
                    .filter(p -> p.equals(purchase))
                    .findFirst()
                    .ifPresent(pp -> pp.incrementQuantity(finalQuantity));

            System.out.println("More " + quantity + " for the " + purchase.getProduct().getName() + " !");

        } else {

            //Add
            boolean sucess = customer.getCart().addPurchase(purchase);
            if (!sucess) throw new RuntimeException("Failed to add new purchase!");

            System.out.println("New purchase in cart: " + product.getName() + " with " + quantity + " units!");
        }

        System.out.println();
    }


    private void viewCart(Customer customer) {

        List<Purchase> purchases = customer.getCart().getPurchases();

        if (purchases.isEmpty()) {
            System.out.println();
            System.out.println("--- YOUR CAR IS EMPTY! ---");
            return;
        }

        String title = "╔════════════════════════════════╗" +
                "       ║            VIEW CART           ║ " +
                "       ╚════════════════════════════════╝";

        String statement = "Looking at the cart";
        PrinterService.printTitle(title, statement);

        for (Purchase purchase : purchases) {

            Product product = purchase.getProduct();
            int quantity = purchase.getQuantity();
            Double cost = quantity * product.getPrice();

            System.out.println((purchases.indexOf(purchase) + 1) + ". "
                    + purchase.getProduct().getName()
                    + " (Qty: " + quantity + ") - $"
                    + String.format("%.2f", cost));
        }

        //Add stream API code
        int totalItems = purchases.stream()
                .map(Purchase::getQuantity)
                .mapToInt(Integer::intValue)
                .sum();

        Double totalCost = purchases.stream()
                .map(Purchase::getProduct)
                .map(Product::getPrice)
                .mapToDouble(Double::doubleValue)
                .sum();

        System.out.println("\nTotal products: " + totalItems);
        System.out.println("Total Cost: $" + String.format("%.2f", totalCost));

    }


    private void removeFromCart(Customer customer) {

        String title = "╔════════════════════════════════╗" +
                "       ║           REMOVE ITEM          ║ " +
                "       ╚════════════════════════════════╝";

        String statement = "Removing...";
        PrinterService.printTitle(title, statement);

        List<Purchase> purchases = customer.getCart().getPurchases();

        // will print the message and return to menu
        if (purchases.isEmpty()) {
            System.out.println();
            System.out.println("\n--- YOUR CAR IS EMPTY! ---");
            return;
        }

        while (true) {

            // To view all products
            PrinterService.printPurchases(purchases);

            System.out.print("Choice to remove: ");
            int choice = sc.nextInt();

            if (choice == purchases.size() + 1) return;

            while (!validChoice(choice, purchases.size())) {
                System.out.println("\nInvalid option!\n");
                PrinterService.printPurchases(purchases);
                System.out.print("Choice to remove: ");
                choice = sc.nextInt();
            }

            Purchase purchase = customer.getCart().getPurchases().get(choice - 1);

            System.out.print("Quantity to remove: ");
            int quantity = sc.nextInt();
            if (!validQuantity(quantity, purchase.getQuantity())) throw new RuntimeException("Invalid quantity!");


            if (quantity == purchase.getQuantity()) {
                //Remove
                boolean sucess = customer.getCart().removePurchase(purchase);
                if (!sucess) throw new RuntimeException("Error! ");

            } else {
                //Decrement quantity in cart
                purchase.decrementQuantity(quantity);
            }


            //If have removed all purchases
            if (purchases.isEmpty()) {
                System.out.println("Cart is empty!");
                return;
            }
        }
    }

    private void checkout(Customer customer) {

        List<Purchase> purchases = customer.getCart().getPurchases();

        if (purchases.isEmpty()) {
            System.out.println("\n--- YOUR ORDER IS EMPTY! ---");
            return;
        }

        //Add Streams API
        Double costOrder = purchases.stream()
                .map(Purchase::getProduct)
                .mapToDouble(Product::getPrice)
                .sum();

        System.out.println("╔═══════════════════════════════╗");
        System.out.println("║            CHECKOUT           ║");
        System.out.println("╚═══════════════════════════════╝");
        System.out.println("\nYour order summary:");

        for (Purchase purchase : purchases) {

            int quantity = purchase.getQuantity();
            Double price = purchase.getProduct().getPrice();
            String name = purchase.getProduct().getName();

            System.out.println((purchases.indexOf(purchase) + 1) + ". "
                    + name + "(Qty: " + quantity + ")"
                    + " - $" + String.format("%.2f", price));
        }


        int totalPurchases = purchases.stream().
                map(Purchase::getQuantity)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("\nTotal Purchases: " + totalPurchases);

        String formatDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        System.out.println("Order at: " + formatDate);

        System.out.println("Total Different Purchases: " + purchases.size());


        Double cost = purchases.stream()
                .mapToDouble(p -> p.getProduct().getPrice())
                .sum();

        System.out.println("Total Cost: $" + String.format("%.2f", cost));

        System.out.println("\nShipping address:");

        String customerNameFormat = customer.getName().toUpperCase().substring(0, 1)
                .concat(customer.getName().toLowerCase().substring(1));
        System.out.println("Name: " + customerNameFormat);

        String customerEmail = customer.getEmail();
        System.out.println("Email: " + customerEmail);

        long customerAdress = customer.getAdress();
        System.out.println("Shipping address: " + customerAdress);

        System.out.println("\nSelect Payment Method:");
        PaymentType paymentType = getChoice(PaymentType.class);

        PaymentService paymentService = null;
        switch (paymentType) {
            case CREDIT_CARD -> paymentService = new CreditCardService();
            case BANK_TRANSFER -> paymentService = new BankTransferService();
            case PIX -> paymentService = new PixService();
            case BITCOIN -> paymentService = new BitcoinService();
        }

        paymentService.pay(costOrder);

        //Clear purchases in the cart
        purchases.clear();
        System.out.println(customerNameFormat + "'s cart is empty :)");
    }

    public void exit() {
        System.out.println();
        System.out.println("    ╔═══════════════════════════════╗");
        System.out.println("    ║                               ║");
        System.out.println("    ║  THANKS FOR USING OUR SYSTEM! ║");
        System.out.println("    ║                               ║");
        System.out.println("    ╚═══════════════════════════════╝");
    }

}
