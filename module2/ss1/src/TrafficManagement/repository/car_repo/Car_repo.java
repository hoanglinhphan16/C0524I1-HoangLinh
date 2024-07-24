package TrafficManagement.repository.car_repo;

import TrafficManagement.model.Car;

import java.util.ArrayList;
import java.util.List;

public class Car_repo {
    private static List<Car> cars = new ArrayList<Car>();
    static {
        cars.add(new Car("Mike", "2009-12-12", ));
    }
}
