package MassageSalonManagement.repository.customer;

import MassageSalonManagement.model.Customer;

import java.util.List;

public interface ICustomerRepo {
    List<Customer> getAllCustomers();
    void addCustomer(Customer customer);
    void deleteCustomer(Customer customer);
    void updateCustomer(int index, Customer customer);
}
