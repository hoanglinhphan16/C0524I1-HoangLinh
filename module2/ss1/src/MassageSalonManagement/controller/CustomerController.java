package MassageSalonManagement.controller;

import MassageSalonManagement.model.Customer;
import MassageSalonManagement.service.customer.CustomerService;
import MassageSalonManagement.util.Validate;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class CustomerController {
    Scanner scanner = new Scanner(System.in);
    private static final Customer customerInstance = new Customer();
    private static CustomerService customerService = new CustomerService();
    private static String PATH = "E:\\Codegym\\module2\\ss1\\src\\MassageSalonManagement\\data\\customers.csv";

    public void displayAllCustomers() {
        List<Customer> listCustomers = customerService.getAllCustomers();
        for (Customer customer : listCustomers) {
            System.out.println(customer);
        }
    }

    public void displayCustomerFunc() {
        int choice = -1;
        do {
            System.out.println("Customer Management: \n" +
                    "1. Display customers \n" +
                    "2. Add\n" +
                    "3. Edit\n" +
                    "4. Delete\n" +
                    "5. Sort \n" +
                    "6. Back to main menu");

            try {
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.println("List customers");
                        displayAllCustomers();
                        break;
                    case 2:
                        System.out.println("Add new customer");
                        addCustomer();
                        break;
                    case 3:
                        updateCustomer();
                        break;
                    case 4:
                        deleteCustomer();
                        break;
                    case 5:
                        System.out.println("Sort list customer\n" +
                                "1. Sort by name\n" +
                                "2. Sort by id\n" +
                                "3. Back");

                        int choice2 = Integer.parseInt(scanner.nextLine());
                        switch (choice2) {
                            case 1:
                                sortByName();
                                break;
                            case 2:
                                sortById();
                                break;
                            case 3:
                                return;
                        }
                        break;
                    case 6:
                        return;
                    default:
                        System.out.println("Invalid selection. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid selection. Please try again.");
            }
        } while (true);
    }

    public void addCustomer() {
        boolean isExist;
        String id;

        do {
            id = Validate.validateId(scanner);
            isExist = findById(id);
            if (isExist) {
                System.out.println("Customer already exists");
            }
        } while (isExist);
        Customer newCustomer = scanInputOfCustomer(id);
        customerService.addCustomer(newCustomer);
    }

    public Customer scanInputOfCustomer(String id) {
        String name = Validate.validateName(scanner);

        LocalDate birthDate = Validate.validateDate(scanner);

        String idCard = Validate.validateIdCard(scanner);

        String email = Validate.validateEmail(scanner);

        String phoneNumber = Validate.validatePhoneNumber(scanner);

        String level = (new Customer()).getLevel();

        return new Customer(id, name, birthDate, idCard, email, phoneNumber, level);
    }

    public boolean findById(String id) {
        if (id == null) {
            System.out.println("Enter ID");
            id = scanner.nextLine();
        }
        List<Customer> customers = customerService.getAllCustomers();
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                System.out.println(customer);
                return true;
            }
        }
        return false;
    }

    public void deleteCustomer() {
        List<Customer> customers = customerService.getAllCustomers();
        boolean isExist;
        String id = Validate.validateId(scanner);
        isExist = findById(id);
        if (isExist) {
            for (Customer customer : customers) {
                if (customer.getId().equals(id)) {
                    customerService.deleteCustomer(customer);
                    break;
                }
            }
        } else System.out.println("Customer not found");
    }

    public void updateCustomer() {
        List<Customer> customers = customerService.getAllCustomers();
        int index = -1;
        boolean isExist;
        String id = Validate.validateId(scanner);
        isExist = findById(id);
        if (isExist) {
            for (Customer customer : customers) {
                if (customer.getId().equals(id)) {
                    index = customers.indexOf(customer);
                    Customer newCustomer = scanInputOfCustomer(id);
                    customerService.updateCustomer(index, newCustomer);
                    break;
                }
            }
        } else System.out.println("Wrong ID");
    }

    public void sortById() {
        List<Customer> customers = customerService.getAllCustomers();
        customers.sort((c1,c2) -> c1.getId().compareTo(c2.getId()));
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    public void sortByName() {
        List<Customer> customers = customerService.getAllCustomers();
        customers.sort((c1,c2) -> c1.getName().compareTo(c2.getName()));
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
}
