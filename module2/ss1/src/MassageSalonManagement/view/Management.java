package MassageSalonManagement.view;

import MassageSalonManagement.controller.BookingController;
import MassageSalonManagement.controller.CustomerController;
import MassageSalonManagement.controller.EmployeeController;

import java.util.Scanner;

public class Management {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int choice = -1;

        System.out.println("w   w  eeee  l     cccc  oooo  m   m  eeee      dddd   aaaa  dddd  dddd  y   y\n" +
                "w   w  e     l    c     o    o m m m  e         d   d  a  a  d   d d   d  y y \n" +
                "w w w  eeee  l    c     o    o m m m  eeee      d   d  aaaa  d   d d   d   y\n" +
                "w w w  e     l    c     o    o m m m  e         d   d  a  a  d   d d   d   y\n" +
                " w w   eeee  llll  cccc  oooo  m m m  eeee      dddd   a  a  dddd  dddd    y\n");

        System.out.println("♥ ♥ ♥ ♥ ♥ ♥ ♥ ♥ ♥ ♥ ♥ ♥ ♥ ♥ ♥ ♥ ♥ ♥ ♥ ♥ ♥ ♥ ♥ ♥ ♥ ♥ ♥ ♥ ♥ ♥ ♥ ♥ ♥ ♥ ♥ ♥ ♥");
        System.out.println();

        do {
            System.out.println("1. Customer management\n" +
                    "2. Employee management\n" +
                    "3. Booking management\n" +
                    "4. Exit");
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
