package MassageSalonManagement.controller;

import MassageSalonManagement.model.Booking;
import MassageSalonManagement.model.Customer;
import MassageSalonManagement.service.booking.BookingService;
import MassageSalonManagement.service.customer.CustomerService;
import MassageSalonManagement.util.Validate;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class BookingController {
    Scanner scanner = new Scanner(System.in);
    private static final Booking bookingInstance = new Booking();
    private static BookingService bookingService = new BookingService();

    public void displayAllBookings() {
        List<Booking> bookings = bookingService.getAllBookings();
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }

    public void displayBookingFunc() {
        int choice = -1;
        do {
            System.out.println("Booking Management: \n" +
                    "1. Display booking list \n" +
                    "2. Come with me daddy ♥\n" +
                    "3. Edit\n" +
                    "4. Delete\n" +
                    "5. Sort \n" +
                    "6. Back to main menu");

            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("List Booking");
                        displayAllBookings();
                        break;
                    case 2:
                        System.out.println("Booking beauty gớ");
                        addBooking();
                        break;
                    case 3:
                        updateBooking();
                        break;
                    case 4:
                        deleteBooking();
                        break;
                    case 5:
                        System.out.println("Sort list customer\n" +
                                "1. Sort by name\n" +
                                "2. Sort by id\n" +
                                "3. Back");

                        int choice2 = Integer.parseInt(scanner.nextLine());
                        switch (choice2) {
                            case 1:
                                sortByPayment();
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
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid selection.");
            }
        } while (true);
    }

    public static Booking scanInputOfBooking(String id) {
        Scanner scanner = new Scanner(System.in);
        List<Customer> customers = (new CustomerService()).getAllCustomers();
        LocalDate bookingDate = Validate.validateDate(scanner);

        boolean isExisting;
        String idCustomer;
        do {
            isExisting = false;
            customers.forEach(customer -> System.out.println(customer.getId()));
            System.out.println("Enter id of customer: ");
            idCustomer = scanner.nextLine();
            for (Customer customer : customers) {
                if (customer.getId().equals(idCustomer)) {
                    isExisting = true;
                    idCustomer = customer.getId();
                    break;
                }
            }
        } while (!isExisting);

        System.out.println("Please choose service that you want\n" +
                "1. Normal ticket 300$\n" +
                "2. Good ticket 500$\n" +
                "3. Vip ticket 800$\n" +
                "4. Super vip ticket 5000$ (a-ááááá)");
        long payment = 0;

        try {
            int choice = -1;
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    payment = 300;
                    break;
                case 2:
                    payment = 500;
                    break;
                case 3:
                    payment = 800;
                    break;
                case 4:
                    System.out.println("Siêu mẫu số đo 3 vòng cực khủng đang đợi daddy ạ ♥");
                    payment = 5000;
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid selection.");
        }

        return new Booking(id, bookingDate, idCustomer, payment);
    }

    public boolean findById(String id) {
        if (id == null) {
            System.out.println("Enter ID");
            id = scanner.nextLine();
        }
        List<Booking> bookingList = bookingService.getAllBookings();
        for (Booking booking : bookingList) {
            if (booking.getIdBooking().equals(id)) {
                System.out.println(booking);
                return true;
            }
        }
        return false;
    }

    public void addBooking() {
        boolean isExist;
        String id;

        do {
            id = Validate.validateId(scanner);
            isExist = findById(id);
            if (isExist) {
                System.out.println("Booking already exists");
            }
        } while (isExist);
        Booking newBooking = scanInputOfBooking(id);
        bookingService.addBooking(newBooking);
        (new CustomerService()).setLevel();
    }

    public void deleteBooking() {
        List<Booking> bookingList = bookingService.getAllBookings();
        boolean isExist;
        String id = Validate.validateId(scanner);
        isExist = findById(id);
        if (isExist) {
            for (Booking booking : bookingList) {
                if (booking.getIdBooking().equals(id)) {
                    bookingService.deleteBooking(booking);
                    break;
                }
            }
        } else System.out.println("Booking not found");
    }

    public void updateBooking() {
        List<Booking> bookingList = bookingService.getAllBookings();
        int index = -1;
        boolean isExist;
        String id = Validate.validateId(scanner);
        isExist = findById(id);
        if (isExist) {
            for (Booking booking : bookingList) {
                if (booking.getIdBooking().equals(id)) {
                    index = bookingList.indexOf(booking);
                    Booking newBooking = scanInputOfBooking(id);
                    bookingService.updateBooking(index, newBooking);
                    break;
                }
            }
        } else System.out.println("Wrong ID");
    }

    public void sortById() {
        List<Booking> bookingList = bookingService.getAllBookings();
        bookingList.sort((c1, c2) -> c1.getIdBooking().compareTo(c2.getIdBooking()));
        for (Booking booking : bookingList) {
            System.out.println(booking);
        }
    }

    public void sortByPayment() {
        List<Booking> bookingList = bookingService.getAllBookings();
        bookingList.sort((b1, b2) -> Long.compare(b1.getPayment(), b2.getPayment()));
        for (Booking booking : bookingList) {
            System.out.println(booking);
        }
    }
}
