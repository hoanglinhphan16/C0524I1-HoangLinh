package MassageSalonManagement.repository.customer;

import MassageSalonManagement.model.Customer;
import MassageSalonManagement.util.FileHandler;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepo implements ICustomerRepo {
    private static List<Customer> customers = new ArrayList<>();
    private static final Customer customerInstance = new Customer();
    private static String PATH = "E:\\Codegym\\module2\\ss1\\src\\MassageSalonManagement\\data\\customers.csv";

    static {
        customers = FileHandler.readFile(customerInstance, PATH);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customers;
    }

    @Override
    public void addCustomer(Customer customer) {
        customers.add(customer);
        FileHandler.writeFile(customer, PATH, true);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        customers.remove(customer);
        FileHandler.writeListToFile(customers, PATH, false);
    }

    @Override
    public void updateCustomer(int index, Customer customer) {
        customers.set(index, customer);
        FileHandler.writeListToFile(customers, PATH, false);
    }
}
