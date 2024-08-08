package MassageSalonManagement.view;

import MassageSalonManagement.controller.BookingController;
import MassageSalonManagement.controller.CustomerController;
import MassageSalonManagement.controller.EmployeeController;

import java.util.Scanner;

public class Management {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int choice = -1;

        do {
            System.out.println("1. Customer management\n" +
                    "2. Employee management\n" +
                    "3. Booking management\n");
            try {
                choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        new CustomerController().displayCustomerFunc();
                        break;
                    case 2:
                        new EmployeeController().displayEmployeeFunc();
                        break;
                    case 3:
                        new BookingController().displayBookingFunc();
                        break;
                    case 4:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid selection. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid selection.");
            }
        } while (true);
    }
}
