package MassageSalonManagement.service.customer;

import MassageSalonManagement.model.Booking;
import MassageSalonManagement.model.Customer;
import MassageSalonManagement.repository.customer.CustomerRepo;
import MassageSalonManagement.repository.customer.ICustomerRepo;
import MassageSalonManagement.service.booking.BookingService;
import MassageSalonManagement.util.FileHandler;
import MassageSalonManagement.util.LevelCustomer;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CustomerService implements ICustomerService {
    private static ICustomerRepo iCustomerRepo = new CustomerRepo();
    private static String PATH = "E:\\Codegym\\module2\\ss1\\src\\MassageSalonManagement\\data\\customers.csv";

    @Override
    public List<Customer> getAllCustomers() {
        return iCustomerRepo.getAllCustomers();
    }

    @Override
    public void addCustomer(Customer customer) {
        iCustomerRepo.addCustomer(customer);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        iCustomerRepo.deleteCustomer(customer);
    }

    @Override
    public void updateCustomer(int index, Customer customer) {
        iCustomerRepo.updateCustomer(index, customer);
    }

    public void setLevel() {
        BookingService bookingService = new BookingService();
        List<Booking> bookings = bookingService.getAllBookings();
        List<Customer> customers = getAllCustomers();
        Map<String, Long> bookingsMap = new TreeMap<>();

        customers.forEach(customer -> {
            for (Booking booking : bookings) {
                if (booking.getIdCustomer().equals(customer.getId())) {
                    bookingsMap.put(customer.getId(), bookingsMap.getOrDefault(customer.getId(), 0L) + booking.getPayment());
                }
            }
        });

        for (Map.Entry<String, Long> entry : bookingsMap.entrySet()) {
            String customerId = entry.getKey();
            long totalPayment = entry.getValue();
            String level = "";

            if (totalPayment >= LevelCustomer.LEGEND) {
                level = "legend";
            } else if (totalPayment >= LevelCustomer.DIAMOND) {
                level = "diamond";
            } else if (totalPayment >= LevelCustomer.PLATINUM) {
                level = "platinum";
            } else if (totalPayment >= LevelCustomer.GOLD) {
                level = "gold";
            } else if (totalPayment >= LevelCustomer.SILVER) {
                level = "silver";
            } else if (totalPayment >= LevelCustomer.BRONZE) {
                level = "bronze";
            };

            // Gán cấp độ cho khách hàng
            for (Customer customer : customers) {
                if (customer.getId().equals(customerId)) {
                    customer.setLevel(level);
                    break;
                }
            }
        }
        FileHandler.writeListToFile(customers, PATH, false);
    }
}
