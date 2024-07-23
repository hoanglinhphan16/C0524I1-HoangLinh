package ss12_map_tree.bai_tap;

import java.util.List;
import java.util.Scanner;

public class Main {
    static ProductManager productManage = new ProductManager();

    public static void main(String[] args) {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Product Manage: \n" +
                    "1. Display list \n" +
                    "2. Add new product \n" +
                    "3. Update product \n" +
                    "4. Delete product \n" +
                    "5. Search product \n" +
                    "6. Sort list product \n" +
                    "7. Exit");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    displayProduct();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    updateProduct();
                    break;
                case 4:
                    deleteProduct();
                    break;
                case 5:
                    searchProduct();
                    break;
                case 6:
                    System.out.println("Sort list product\n" +
                            "1. Sort by Id \n" +
                            "2. Sort by name \n" +
                            "3. Back");
                    int choice2 = Integer.parseInt(scanner.nextLine());
                    switch (choice2) {
                        case 1:
                            sortById();
                            break;
                        case 2:
                            sortByName();
                            break;
                        case 3:
                            return;
                    }
                    break;
                case 7:
                    System.exit(0);
            }
        } while (true);
    }

    private static void sortByName() {
        productManage.sortByName();
    }

    private static void sortById() {
        productManage.sortById();
    }

    private static void deleteProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id you want to update");
        int id = Integer.parseInt(scanner.nextLine());
        boolean check = false;

        for (ProductManager product: productManage.findAll()) {
            if (product.getId() == id) {
                productManage.remove(product);
            }
        }
        if (!check) {
            System.out.println("Product not found");
        }
    }

    private static void updateProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id you want to update");
        int id = Integer.parseInt(scanner.nextLine());
        boolean check = false;
        int index = 0;
        for (ProductManager product : productManage.findAll()) {
            if (product.getId() == id) {
                index = productManage.findAll().indexOf(product);
                check = true;
            }
        }

        if (check) {
            System.out.println("Enter product id: ");
            int newId = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter product name: ");
            String newName = scanner.nextLine();
            System.out.println("Enter product price: ");
            long newPrice = Long.parseLong(scanner.nextLine());

            ProductManager newProduct = new ProductManager(newId, newName, newPrice);
            productManage.update(index, newProduct);
        } else System.out.println("Wrong product id");
    }

    private static void addProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter product name: ");
        String name = scanner.nextLine();
        System.out.println("Enter product price: ");
        long price = Long.parseLong(scanner.nextLine());

        ProductManager newProduct =  new ProductManager(id, name, price);
        productManage.add(newProduct);
    }

    private static void displayProduct() {
        List<ProductManager> products = productManage.findAll();
        for (ProductManager product : products) {
            System.out.println(product);
        }
    }

    private static void searchProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product name: ");
        String name = (scanner.nextLine()).toLowerCase();

        productManage.searchProduct(name);
    }
}
