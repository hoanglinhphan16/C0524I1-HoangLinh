package TrafficManagement.repository.truck_repo;

import TrafficManagement.model.Manufacturer;
import TrafficManagement.model.Truck;
import TrafficManagement.repository.manufacturer_repo.IManufacturerRepo;
import TrafficManagement.repository.manufacturer_repo.ManufacturerRepo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TruckRepo implements ITruckRepo{
    private static List<Truck> trucks = new ArrayList<Truck>();

    static {
        IManufacturerRepo IManufacturerRepo = new ManufacturerRepo();
        List<Manufacturer> manufacturers = IManufacturerRepo.getManufacturers();

        trucks.add(new Truck("Peter", LocalDate.parse("2020-08-08"), manufacturers.get(0), "99D1 9876.54", 4000));
        trucks.add(new Truck("Harry", LocalDate.parse("2020-08-08"), manufacturers.get(1), "99D1 9876.54", 3000));
        trucks.add(new Truck("John", LocalDate.parse("2020-08-08"), manufacturers.get(2), "99D1 9876.54", 2000));
        trucks.add(new Truck("Karim", LocalDate.parse("2020-08-08"), manufacturers.get(3), "99D1 9876.54", 1000));
        trucks.add(new Truck("Bard", LocalDate.parse("2020-08-08"), manufacturers.get(4), "99D1 9876.54", 5000));
    }

    @Override
    public List<Truck> getTrucks() {
        return trucks;
    }
}
