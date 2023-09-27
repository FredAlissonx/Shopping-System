package com.br.onlineshoppingsystem.entities;

import com.br.onlineshoppingsystem.categories.Books;
import com.br.onlineshoppingsystem.categories.Clothing;
import com.br.onlineshoppingsystem.categories.Eletronics;
import com.br.onlineshoppingsystem.domain.Customer;
import com.br.onlineshoppingsystem.exceptions.DomainException;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ShoppingSystem implements IProcess {
    Scanner sc = new Scanner(System.in);

    @Override
    public void run(){

        System.out.println();
        System.out.println("╔═══════════════════════════════╗");
        System.out.println("║                               ║");
        System.out.println("║   WELCOME TO SHOPPING SYSTEM  ║");
        System.out.println("║                               ║");
        System.out.println("╚═══════════════════════════════╝");

        System.out.println("\n-- To create a personalized cart for you, we need you sign up --\n");

        String name, email, addressInput;
        long address;

        while (true) {
            System.out.print("Name: ");
            name = sc.nextLine();

            System.out.print("Email (@gmail.com): ");
            email = sc.nextLine();  // Change to nextLine() to read the whole line

            System.out.print("Shipping address (CEP/ZIP code): ");
            addressInput = sc.nextLine();  // Change to nextLine() to read the whole line

            if (isEmailAndNameValidPersonalized(name, email)) {
                try {
                    address = Long.parseLong(addressInput);  // Try to parse the input as a long
                    break;  // Break the loop if a valid address is obtained
                } catch (NumberFormatException e) {
                    System.out.println("\nInvalid information. Please enter valid values!");
                }
            } else {
                System.out.println("\nInvalid information. Please enter valid values!");
            }
        }

        Customer customer = new Customer(name, email, address, new ShoppingCart());

        while (true) {

            menuDisplay();

            MenuOption choiceFromMenuOptions = getMenuChoice();

            sc.nextLine();

            switch (choiceFromMenuOptions) {
                case BROWSE_PRODUCTS -> browseProducts(new Eletronics(), new Books(), new Clothing());
                case ADD_TO_CART -> addToCart(new Eletronics(), new Books(), new Clothing(), customer);
                case VIEW_CART -> viewCart(customer);
                case REMOVE_FROM_CART -> removeItemFromCart(new Eletronics(), new Books(), new Clothing(), customer);
                case CHECKOUT -> checkout(customer);
                case EXIT -> exit();
                default -> System.out.println("\nInvalid option. Please try again.");
            }
        }
    }

    @Override
    public void browseProducts(Eletronics eletronics, Books book, Clothing clothing) {

        System.out.println();
        System.out.println("╔════════════════════════════════╗");
        System.out.println("║  AVAILABLE PRODUCT CATEGORIES  ║");
        System.out.println("╚════════════════════════════════╝");

        System.out.println("\n1. Electronics");
        System.out.println("2. Clothing");
        System.out.println("3. Books");
        System.out.println("4. Back to menu");
        System.out.print("Please choose a category to view its products or back to menu: ");

        String productChoose = sc.next();

        while (!containsChoice(Arrays.asList("1", "2", "3", "4"), productChoose)) {

            System.out.println("\n1. Electronics");
            System.out.println("2. Clothing");
            System.out.println("3. Books");
            System.out.println("4. Back to menu");
            System.out.print("Choose a valid option: ");
            productChoose = sc.next();

        }

        System.out.println();

        // Verifying option
        List<Products> selectedProducts = null;
        String categoryName = "";

        switch (productChoose) {
            case "1" -> {
                selectedProducts = eletronics.getEletronics();
                categoryName = "Electronics";
            }
            case "2" -> {
                selectedProducts = clothing.getClothings();
                categoryName = "Clothing";
            }
            case "3" -> {
                selectedProducts = book.getBooks();
                categoryName = "Books";
            }
            case "4" -> {
                return;
            }
            default -> System.out.println("\nPlease a valid option!");
        }

        System.out.println("Here are the products in the " + categoryName + " category:\n");

        for (int i = 0; i < selectedProducts.size(); i++) {
            Products product = selectedProducts.get(i);
            System.out.println((i + 1) + ". " + product.getName() + " - " + product.getDescription() + " R$" + product.getPrice());
        }

    }

    @Override
    public void addToCart(Eletronics eletronics, Books book, Clothing clothing, Customer customer) {

        System.out.println();
        System.out.println("╔═══════════════════════════════╗");
        System.out.println("║          ADD TO CART          ║");
        System.out.println("╚═══════════════════════════════╝");
        System.out.println("\nFrom what category:");
        System.out.println("1. Electronics");
        System.out.println("2. Clothing");
        System.out.println("3. Books");
        System.out.println("4. Back to menu");
        System.out.print("Your choice: ");
        String addOptionProductsfromCategory = sc.next();

        List<Products> productsToSelect;


        while (!containsChoice(Arrays.asList("1", "2", "3", "4"), addOptionProductsfromCategory)) {

            System.out.println("\n1. Electronics");
            System.out.println("2. Clothing");
            System.out.println("3. Books");
            System.out.println("4. Back to menu");
            System.out.print("Please a valid choice: ");
            addOptionProductsfromCategory = sc.next();

        }
        switch (addOptionProductsfromCategory) {
            case "1" -> {

                productsToSelect = eletronics.getEletronics();
                System.out.println();

                defaultFunctionalityAddToCart(Category.ELETRONICS, customer, eletronics, book, clothing, productsToSelect);
            }
            case "2" -> {

                productsToSelect = clothing.getClothings();
                System.out.println();

                defaultFunctionalityAddToCart(Category.CLOTHING, customer, eletronics, book, clothing, productsToSelect);
            }
            case "3" -> {

                productsToSelect = book.getBooks();
                System.out.println();

                defaultFunctionalityAddToCart(Category.BOOKS, customer, eletronics, book, clothing, productsToSelect);
            }
            default -> System.out.println("Invalid option!");
        }
    }

    private void defaultFunctionalityAddToCart(Category productToAdd, Customer customer, Eletronics eletronics, Books book, Clothing clothing, List<Products> productsToSelect) {

        int quantity;
        String optionAddCart;

        while (true) {

            simplifiedViewProducts(productsToSelect);

            System.out.print("Your choice to add to cart: ");
            optionAddCart = sc.next();

            if (optionAddCart.equals("4")) return;

            System.out.print("Quantity: ");
            String quantityInput = sc.next();


            if (containsChoice(Arrays.asList("1", "2", "3"), optionAddCart)) {
                try {

                    quantity = Integer.parseInt(quantityInput);
                    if (quantity > 0) break;
                    else throw new NumberFormatException();

                } catch (NumberFormatException e) {
                    System.out.println("\nPlease enter valid values!");
                }
            } else {
                System.out.println("\nPlease enter valid values!");
            }
        }

        if (productToAdd == Category.ELETRONICS)
            customer.addToShoppingCart(eletronics.getEletronics().get(Integer.parseInt(optionAddCart) - 1), quantity);
        else if (productToAdd == Category.CLOTHING)
            customer.addToShoppingCart(clothing.getClothings().get(Integer.parseInt(optionAddCart) - 1), quantity);
        else if (productToAdd == Category.BOOKS)
            customer.addToShoppingCart(book.getBooks().get(Integer.parseInt(optionAddCart) - 1), quantity);

        System.out.println("\nSuccessfully added!");

    }
    public void simplifiedViewProducts(List<Products> productsToSelect){

        for (int i = 0; i < productsToSelect.size(); i++) {
            Products product = productsToSelect.get(i);
            System.out.println((i + 1) + ". " + product.getName() + " - R$" + product.getPrice());
        }
        System.out.println("4. Back to menu");
    }

    @Override
    public void viewCart(Customer customer) {
        int totalItems = 0;

        System.out.println();
        System.out.println("╔═══════════════════════════════╗");
        System.out.println("║           VIEW CART           ║");
        System.out.println("╚═══════════════════════════════╝");

        List<ShoppingCartItems> cartItems = customer.getShoppingCart().getItems();

        if (cartItems.isEmpty()) {
            System.out.println();
            System.out.println("--- YOUR CAR IS EMPTY! ---");
            return;
        }

        for (int i = 0; i < customer.getShoppingCart().getItems().size(); i++) {

            ShoppingCartItems cartItem = customer.getShoppingCart().getItems().get(i);

            int quantity = cartItem.getQuantity();
            double itemTotalCost = quantity * cartItem.getProduct().getPrice();

            System.out.println((i + 1) + ". " + cartItem.getProduct().getName() + " (Qty: " + quantity + ") - $" + String.format("%.2f", itemTotalCost));
            totalItems += quantity;

        }

        double totalCost = customer.getShoppingCart().totalCost();

        System.out.println("\nTotal Items: " + totalItems);
        System.out.println("Total Cost: $" + String.format("%.2f", totalCost));

    }


    @Override
    public void removeItemFromCart(Eletronics eletronics, Books book, Clothing clothing, Customer customer) {

        if (customer.getShoppingCart().getItems().isEmpty()) {
            System.out.println();
            System.out.println("Your cart is empty!");
            return;
        }

        System.out.println();
        System.out.println("----- Removing from cart -----");
        System.out.println();

        for (int i = 0; i < customer.getShoppingCart().getItems().size(); i++) {
            System.out.println((i + 1) + ". " + customer.getShoppingCart().getItems().get(i).getProduct().getName() + " (Qty: " + customer.getShoppingCart().getItems().get(i).getQuantity() + ")");
        }
        try {

            System.out.print("Item to remove: ");
            int itemToRemoveByIndex = sc.nextInt();

            System.out.print("Quantity to remove: ");
            int quantityToRemove = sc.nextInt();

            if (itemToRemoveByIndex <= 0 || itemToRemoveByIndex > customer.getShoppingCart().getItems().size() || quantityToRemove < 0 || quantityToRemove > customer.getShoppingCart().getItems().get(itemToRemoveByIndex - 1).getQuantity()) {
                throw new DomainException("Invalid Option!");
            }

            ShoppingCartItems itemToRemove = customer.getShoppingCart().getItems().get(itemToRemoveByIndex - 1);

            itemToRemove.decrementQuantity(quantityToRemove);

            if (itemToRemove.getQuantity() == 0) {
                customer.getShoppingCart().removeEntireProduct(itemToRemove);
            }
        } catch (DomainException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void checkout(Customer customer) {
        Order order = new Order(customer.getShoppingCart().getItems(), customer, LocalDate.now(), customer.getShoppingCart().totalCost());

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
        System.out.println("Total Cost: $" + String.format("%.2f", customer.getShoppingCart().totalCost()));

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

    @Override
    public void exit() {
        System.out.println("\nThanks for using our Online Shopping System!");
        System.exit(0);
    }

    @Override
    public void menuDisplay() {
        System.out.println("════════════════════════════════════");
        System.out.println("Main menu:");
        System.out.println("1. Browse Products");
        System.out.println("2. Add to cart");
        System.out.println("3. View cart");
        System.out.println("4. Remove from cart");
        System.out.println("5. Checkout");
        System.out.println("6. Exit");

    }

    public MenuOption getMenuChoice() {

        System.out.print("Please choose an option: ");
        String choice = sc.next();

        if (!containsChoice(Arrays.asList("1", "2", "3", "4", "5", "6"), choice)) return MenuOption.EXCEPTIONS;

        // if "choice" in options
        return MenuOption.values()[Integer.parseInt(choice) - 1];
    }

    public boolean containsChoice(List<String> options, String choice) {
        return options.contains(choice);
    }

    @Override
    public boolean isEmailAndNameValidPersonalized(String name, String email) {
        return name.length() > 2 && email.endsWith("@gmail.com") && email.length() > 10;
    }
}
