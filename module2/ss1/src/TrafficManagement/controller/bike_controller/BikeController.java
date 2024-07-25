package TrafficManagement.controller.bike_controller;

import TrafficManagement.model.Bike;
import TrafficManagement.service.bike_service.BikeService;
import TrafficManagement.service.bike_service.IBikeService;

import java.util.List;
import java.util.Scanner;

public class BikeController {
    private IBikeService bikeService = new BikeService();
    List<Bike> bikes = bikeService.getBikes();

    public void displayBikes() {
        for (Bike bike : bikes) {
            System.out.println(bike);
        }
    }

    public void displayBikeFunc() {
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Mange bike: \n" +
                    "1. Display list bike \n" +
                    "2. Add new bike \n" +
                    "3. Update bike \n" +
                    "4. Delete bike \n" +
                    "5. Search bike \n" +
                    "6. Sort bike \n" +
                    "7. Exit");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    displayBikes();
                    break;
                case 2:
//                    addBike();
                    break;
                case 3:
//                    updateBike();
                    break;
                case 4:
//                    removeBike();
                    break;
                case 5:
//                    searchBike();
                    break;
                case 6:
                    System.out.println("Sort list bike\n" +
                            "1. By owner \n" +
                            "2. By power \n" +
                            "3. Back");

                    int choice2 = Integer.parseInt(sc.nextLine());
                    switch (choice2) {
                        case 1:
//                            sortByName();
                            break;
                        case 2:
//                            sortById();
                            break;
                        case 3:
                            return;
                    }
                    break;
                case 8:
                    return;
            }
        } while (true);
    }
}
