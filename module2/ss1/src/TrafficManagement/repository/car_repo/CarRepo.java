package TrafficManagement.repository.car_repo;

import TrafficManagement.model.Car;
import TrafficManagement.model.Manufacturer;
import TrafficManagement.repository.manufacturer_repo.IManufacturerRepo;
import TrafficManagement.repository.manufacturer_repo.ManufacturerRepo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CarRepo implements ICarRepo {
    private static List<Car> cars = new ArrayList<Car>();
    static {
        IManufacturerRepo IManufacturer_repo = new ManufacturerRepo();
        List<Manufacturer> listManufacturers = IManufacturer_repo.getManufacturers();
        cars.add(new Car("Mike", LocalDate.parse("2009-12-12"), listManufacturers.getFirst(), "43F1 525.91", 4, "Sport Car"));
        cars.add(new Car("John", LocalDate.parse("2009-12-12"), listManufacturers.get(1), "43F1 525.52", 4, "Normal Car"));
        cars.add(new Car("Peter", LocalDate.parse("2009-12-12"), listManufacturers.get(2), "43F1 525.25", 4, "Sport Car"));
        cars.add(new Car("Rose", LocalDate.parse("2009-12-12"), listManufacturers.get(3), "43F1 525.99", 4, "Lovely Car"));
        cars.add(new Car("Stephen", LocalDate.parse("2009-12-12"), listManufacturers.get(4), "43F1 525.69", 4, "Super Car"));
    }

    @Override
    public List<Car> getCars() {
        return cars;
    }


    public void checkAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age must be 18 or older");
        }
    }
}
