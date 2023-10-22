package com.br.onlineshoppingsystem.services;

import com.br.onlineshoppingsystem.domain.customer.Customer;
import com.br.onlineshoppingsystem.domain.shopping.*;
import com.br.onlineshoppingsystem.domain.shopping.Cart;
import com.br.onlineshoppingsystem.enums.*;
import com.br.onlineshoppingsystem.interfaces.Actions;

import com.br.onlineshoppingsystem.interfaces.PaymentService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ShoppingSystemService implements Actions {
    private static Scanner sc = new Scanner(System.in);

    public void run() {

        String name, email, auxAddress;


        while (true) {

            printMenu();

            System.out.print("Name: ");
            name = sc.nextLine();
            if (!validName(name)) throw new RuntimeException("Illegal name!");

            System.out.print("Email (@gmail.com): ");
            email = sc.nextLine();
            if (!validEmail(email)) throw new RuntimeException("Illegal email!");

            System.out.print("Shipping address (CEP/ZIP code - only integers): ");
            auxAddress = sc.nextLine();
            if (!validAdress(auxAddress)) throw new RuntimeException("Illegal adress!");
            Long adress = Long.parseLong(auxAddress);

            Customer customer = new Customer(name, email, adress, new Cart());
            Option choice = getChoice(Option.getOptions().size());

            switch (choice) {
                case BROWSE_PRODUCTS -> browseProducts();
                case ADD_TO_CART -> addToCart(customer);
                case VIEW_CART -> viewCart(customer);
                case REMOVE_FROM_CART -> removePurchaseFromCart(customer);
                case CHECKOUT -> checkout(customer);
                case EXIT -> {
                    exit();
                }

            }
        }
    }

    //To print a menu more separately
    private static void printMenu() {

        System.out.println();
        System.out.println("    ╔═══════════════════════════════╗");
        System.out.println("    ║                               ║");
        System.out.println("    ║   WELCOME TO SHOPPING SYSTEM  ║");
        System.out.println("    ║                               ║");
        System.out.println("    ╚═══════════════════════════════╝");

        System.out.println("\n-- To create a personalized cart for you, we need you sign up --\n");
    }

    private boolean validName(String name) {
        return name.length() > 2;
    }

    private boolean validEmail(String email) {
        return email.endsWith("@gmail.com") && email.length() > 10;
    }

    private boolean validAdress(String adress) {
        return adress.length() == 8;
    }

    private static void printDisplay() {
        System.out.println("\n Main menu:");
        System.out.println("════════════════════════════════════");
        List<Option> options = Option.getOptions();
        options.forEach(e -> System.out.println((options.indexOf(e) + 1) + "." + e));
    }


    private void printOthers(String title, String statement) {

        System.out.println(title);
        List<Category> categories = Category.getCategories();

        System.out.println(statement);
        categories.forEach(c -> System.out.println((categories.indexOf(c) + 1) + "." + c));
        System.out.println("4. Back to menu");
    }

    @Override
    public void browseProducts() {

        String title = "╔════════════════════════════════╗" +
                "       ║  AVAILABLE PRODUCT CATEGORIES  ║" +
                "       ╚════════════════════════════════╝";

        String statement = "Categories";
        printOthers(title, statement);

        System.out.print("Please choose a category to view its products or back to menu: ");
        int choice = sc.nextInt();

        while (!validChoice(choice, Category.getCategories().size())) {
            System.out.println("Invalid!");
            printOthers(title, statement);
            System.out.print("Please choose a category to view its products or back to menu: ");
            choice = sc.nextInt();
        }

        // Verifying option
        List<Product> selectedProducts = new ArrayList<>();
        String categoryName = "";

        switch (choice) {
            case 1 -> {
                selectedProducts = getEletronics();
                categoryName = "Electronics";
            }
            case 2 -> {
                selectedProducts = getClothings();
                categoryName = "Clothing";
            }
            case 3 -> {
                selectedProducts = getBooks();
                categoryName = "Books";
            }
            case 4 -> {
                return;
            }
        }

        System.out.println("Here are the products in the " + categoryName + " category: \n");
        printSelectedProducts(selectedProducts);

    }

    private void printSelectedProducts(List<Product> selectedProducts) {
        selectedProducts.forEach(p -> {
            System.out.println((selectedProducts.indexOf(p) + 1) + ". " + p.getName() + " - " + p.getDescription() + " $" + p.getPrice());
        });
    }


    private List<Product> getEletronics() {
        return Arrays.asList(
                new Product("Men's Classic T-Shirt", "A comfortable and versatile men's t-shirt made from soft cotton.", 19.99, Category.CLOTHINGS),
                new Product("Women's Skinny Jeans", "Stylish and fitted women's jeans with a modern skinny fit.", 39.99, Category.CLOTHINGS),
                new Product("Unisex Hooded Sweatshirt", "A cozy and warm unisex sweatshirt with a hood and front pouch pocket.", 29.99, Category.CLOTHINGS)
        );
    }

    private List<Product> getClothings() {
        return Arrays.asList(
                new Product("Laptop", "High-performance laptop for work and gaming.", 999.99, Category.ELETRONICS),
                new Product("Smartphone", "The latest smartphone with advanced features.", 699.99, Category.ELETRONICS),
                new Product("Headphones", "Noise-canceling headphones for immersive audio.", 149.99, Category.ELETRONICS)
        );
    }

    private List<Product> getBooks() {
        return Arrays.asList(
                new Product("To Kill a Mockingbird by Harper Lee", "A classic novel that addresses issues of racism and moral growth in the American South.", 12.99, Category.BOOKS),
                new Product("The Great Gatsby by F. Scott Fitzgerald", "A novel set in the 1920s, exploring themes of wealth, excess, and the American Dream.", 10.49, Category.BOOKS),
                new Product("Becoming by Michelle Obama", "A memoir by the former First Lady, recounting her personal journey and experiences in the White House.", 18.99, Category.BOOKS)
        );
    }


    @Override
    public void addToCart(Customer customer) {

        String title = "╔════════════════════════════════╗" +
                "       ║          ADD TO CART           ║" +
                "       ╚════════════════════════════════╝";

        String statement = "From what category: ";
        printOthers(title, statement);

        int choice = sc.nextInt();
        List<Product> productsToSelect;

        while (!validChoice(choice, Category.getCategories().size())) {
            System.out.println("Invalid!");
            printOthers(title, statement);
            System.out.println("Your choice: ");
            choice = sc.nextInt();
        }

        switch (choice) {
            case 1 -> {
                productsToSelect = getEletronics();
                System.out.println();

                add(Category.ELETRONICS, customer, productsToSelect);
            }
            case 2 -> {

                productsToSelect = getClothings();
                System.out.println();

                add(Category.CLOTHINGS, customer, productsToSelect);
            }
            case 3 -> {

                productsToSelect = getBooks();
                System.out.println();

                add(Category.BOOKS, customer, productsToSelect);
            }
        }
    }

    private void add(Category category, Customer customer, List<Product> productsToSelect) {

        int quantity;
        int choice;

        while (true) {

            //Print products in simplified format;
            productsToSelect.forEach(p -> {
                System.out.println(((productsToSelect.indexOf(p) + 1) + p.getName() + " - $" + p.getPrice()));
            });
            System.out.println("4. Back");

            System.out.print("Your choice to add to cart: ");
            choice = sc.nextInt();

            if (choice == 4) return;

            while (!validChoice(choice, productsToSelect.size())) {

                System.out.println("Invalid!");

                //Print products in simplified format;
                productsToSelect.forEach(p -> {
                    System.out.println(((productsToSelect.indexOf(p) + 1) + p.getName() + " - $" + p.getPrice()));
                });
                System.out.println("4. Back");

                System.out.print("Your choice to add to cart: ");
                choice = sc.nextInt();
            }

            System.out.print("Quantity: ");
            quantity = sc.nextInt();

            while (quantity <= 0) {
                System.out.println("Invalid!");
                System.out.print("Quantity: ");
                quantity = sc.nextInt();
            }

            boolean sucess = false;

            switch (category) {
                case ELETRONICS:
                    sucess = add(customer, getEletronics().get(choice - 1), quantity);
                    break;
                case BOOKS:
                    sucess = add(customer, getBooks().get(choice - 1), quantity);
                    break;
                case CLOTHINGS:
                    sucess = add(customer, getClothings().get(choice - 1), quantity);
                    break;
            }

            if (!sucess) throw new RuntimeException("Failed addition!");
        }
    }

    private boolean add(Customer customer, Product product, int quantity) {
        return customer.getCart().addPurchase(product, quantity);
    }


    @Override
    public void viewCart(Customer customer) {

        List<Purchase> cartItems = customer.getCart().getPurchases();

        if (cartItems.isEmpty()) {
            System.out.println();
            System.out.println("--- YOUR CAR IS EMPTY! ---");
            return;
        }

        System.out.println();
        System.out.println("╔═══════════════════════════════╗");
        System.out.println("║           VIEW CART           ║");
        System.out.println("╚═══════════════════════════════╝\n");


        //Add stream API code
        int totalItems = cartItems.stream()
                .map(Purchase::getQuantity)
                .mapToInt(Integer::intValue)
                .sum();

        for (int i = 0; i < cartItems.size(); i++) {

            Purchase purchase = cartItems.get(i);
            Product product = purchase.getProduct();
            int quantity = purchase.getQuantity();
            double cost = quantity * product.getPrice();

            System.out.println((i + 1) + ". "
                    + purchase.getProduct().getName()
                    + " (Qty: " + quantity + ") - $"
                    + String.format("%.2f", cost));
        }

        //Use stream API
        double totalCost = customer.getCart().getPurchases()
                .stream()
                .map(Purchase::getProduct)
                .map(Product::getPrice)
                .mapToDouble(Double::doubleValue)
                .sum();

        System.out.println("\nTotal Items: " + totalItems);
        System.out.println("Total Cost: $" + String.format("%.2f", totalCost));

    }

    @Override
    public void removePurchaseFromCart(Customer customer) {

        String title = "╔════════════════════════════════╗" +
                "       ║           REMOVE ITEM          ║ " +
                "       ╚════════════════════════════════╝";

        String statemant = "Removing...";
        printOthers(title, statemant);

        List<Purchase> purchases = customer.getCart().getPurchases();

        // will print the message and return to menu
        if (purchases.isEmpty()) {
            System.out.println("\n--- YOUR CAR IS EMPTY! ---");
            return;
        }

        while (true) {

            // To view all products
            printProducts(purchases);

            System.out.print("Choice to remove: ");
            int choice = sc.nextInt();

            while (!validChoice(choice, purchases.size())) {
                System.out.println("\nInvalid option!\n");
                printProducts(purchases);
                System.out.print("Choice to remove: ");
                choice = sc.nextInt();
            }

            if (choice == purchases.size() + 1) return;

            Purchase purchase = customer.getCart().getPurchases().get(choice - 1);

            System.out.print("Quantity to remove: ");
            int quantity = sc.nextInt();

            if (!validQuantity(quantity, purchase.getQuantity())) {
                throw new RuntimeException("Invalid quantity!");
            }

            if (quantity == purchase.getQuantity()) {
                boolean sucess = customer.getCart().removePurchase(purchase);
                if (!sucess) throw new RuntimeException("Error! ");

            } else {
                //Decrement quantity in cart
                purchase.decrementQuantity(quantity);
            }

        }
    }

    private boolean validQuantity(int quantity, int purchaseQuantity) {
        return (quantity > 0) && (quantity <= purchaseQuantity);
    }

    private void printProducts(List<Purchase> purchases) {
        purchases.forEach(p -> {
            System.out.println((purchases.indexOf(p) + 1) +
                    ". " + p.getProduct().getName() + " (Qty: " + p.getQuantity() + ")");
        });
        System.out.println((purchases.size() + 1) + ". Back to menu");
    }


    @Override
    public void checkout(Customer customer) {

        List<Purchase> purchases = customer.getCart().getPurchases();

        if (purchases.isEmpty()) {
            System.out.println("\n--- YOUR ORDER IS EMPTY! ---");
            return;
        }

        //Add Streams API
        Double costOrder = customer.getCart().getPurchases().stream()
                .map(p -> p.getProduct().getPrice())
                .mapToDouble(Double::doubleValue)
                .sum();

        Order order = new Order(purchases, customer, LocalDateTime.now(), costOrder);
        List<Purchase> costumerPurchases = order.getCustomer().getCart().getPurchases();

        System.out.println("╔═══════════════════════════════╗");
        System.out.println("║            CHECKOUT           ║");
        System.out.println("╚═══════════════════════════════╝");
        System.out.println("\nYour order summary:");

        int totalPurchases = costumerPurchases.stream().
                map(Purchase::getQuantity)
                .mapToInt(Integer::intValue)
                .sum();

        for (int i = 0; i < costumerPurchases.size(); i++) {

            int quantity = costumerPurchases.get(i).getQuantity();
            Double price = costumerPurchases.get(i).getProduct().getPrice();
            Double total = price * quantity;
            String name = costumerPurchases.get(i).getProduct().getName();

            System.out.println((i + 1) + ". " + name + "(Qty: " + quantity + ")" + " - $" + String.format("%.2f", price));
        }


        System.out.println("\nTotal Items: " + totalPurchases);

        String formatDate = order.getOrderDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        System.out.println("Order at: " + formatDate);

        System.out.println("Total Different Purchases: " + costumerPurchases.size());

        System.out.println("Total Cost: $" + String.format("%.2f", order.getOrderTotal()));

        String orderName = order.getCustomer().getName().substring(0, 1).toUpperCase().concat(order.getCustomer().getName().substring(1));
        String orderEmail = order.getCustomer().getEmail();
        long orderShippingAddress = order.getCustomer().getShippingAddress();

        System.out.println("\nShipping address:");
        System.out.println("Name: " + orderName);
        System.out.println("Email: " + orderEmail);
        System.out.println("Shipping address: " + orderShippingAddress);

        System.out.println("\nSelect Payment Method:");
        com.br.onlineshoppingsystem.enums.PaymentType.getOptions().forEach(p -> {
            int id = com.br.onlineshoppingsystem.enums.PaymentType.getOptions().indexOf(p) + 1;
            System.out.println(id + ". " + p);
        });

        int choice = sc.nextInt();
        while (!validChoice(choice, com.br.onlineshoppingsystem.enums.PaymentType.getOptions().size())) {
            System.out.println("Invalid!");

            System.out.println("\nSelect Payment Method:");
            PaymentType.getOptions().forEach(p -> {
                int id = com.br.onlineshoppingsystem.enums.PaymentType.getOptions().indexOf(p) + 1;
                System.out.println(id + ". " + p);
            });
        }

        PaymentType paymentType = com.br.onlineshoppingsystem.enums.PaymentType.getOptions().get(choice - 1);
        PaymentService paymentService = null;


        switch (paymentType) {
            case CREDIT_CARD -> paymentService = new CreditCardService();
            case BANK_TRANSFER -> paymentService = new BankTransferService();
            case PIX -> paymentService = new PixService();
            case BITCOIN -> paymentService = new BitcoinService();
        }

        paymentService.pay(costOrder);
        costumerPurchases.clear();
    }

    @Override
    public void exit() {
        System.out.println();
        System.out.println("    ╔═══════════════════════════════╗");
        System.out.println("    ║                               ║");
        System.out.println("    ║  THANKS FOR USING OUR SYSTEM! ║");
        System.out.println("    ║                               ║");
        System.out.println("    ╚═══════════════════════════════╝");
        System.exit(0);
    }


    public Option getChoice(int total) {

        printDisplay();
        System.out.print("Your choice: ");
        int choice = sc.nextInt();

        while (!validChoice(choice, total)) {
            System.out.println("Invalid!");
            printDisplay();
            System.out.print("Your choice: ");
            choice = sc.nextInt();
        }

        return Option.getOptions().get(choice - 1);
    }

    private boolean validChoice(int choice, int total) {
        return choice > 0 && choice <= total;
    }


}
