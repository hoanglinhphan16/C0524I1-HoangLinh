package TrafficManagement.view;

import TrafficManagement.controller.bike_controller.BikeController;
import TrafficManagement.controller.car_controller.CarController;
import TrafficManagement.controller.truck_controller.TruckController;

import java.util.Scanner;

public class ManageTransportations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        BikeController bikeController = new BikeController();
        CarController carController = new CarController();
        TruckController truckController = new TruckController();

        do {
            System.out.println("Transportations Management: \n" +
                    "1. Manage bike \n" +
                    "2. Manage car \n" +
                    "3. Manage truck");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    bikeController.displayBikeFunc();
                case 2:
//                    carController.displayCarFunc();
                case 3:
//                    truckController.displayTruckFunc();
            }
        } while (true);
    }
}
