package TrafficManagement.repository.bike_repo;

import TrafficManagement.model.Bike;
import TrafficManagement.model.Manufacturer;
import TrafficManagement.repository.manufacturer_repo.IManufacturerRepo;
import TrafficManagement.repository.manufacturer_repo.ManufacturerRepo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BikeRepo implements IBikeRepo {
    private static List<Bike> bikes = new ArrayList<Bike>();
    static {
        IManufacturerRepo IManufacturerRepo = new ManufacturerRepo();
        List<Manufacturer> manufacturers = IManufacturerRepo.getManufacturers();
        bikes.add(new Bike("James", LocalDate.parse("2024-12-12"), manufacturers.get(0), "92H1 1234.56", 400));
        bikes.add(new Bike("Linh", LocalDate.parse("2024-12-12"), manufacturers.get(1), "92H1 1234.56", 500));
        bikes.add(new Bike("Hieu", LocalDate.parse("2024-12-12"), manufacturers.get(2), "92H1 1234.56", 600));
        bikes.add(new Bike("Man", LocalDate.parse("2024-12-12"), manufacturers.get(3), "92H1 1234.56", 700));
        bikes.add(new Bike("Vy", LocalDate.parse("2024-12-12"), manufacturers.get(4), "92H1 1234.56", 800));
        bikes.add(new Bike("Cong", LocalDate.parse("2024-12-12"), manufacturers.get(5), "92H1 1234.56", 900));
    }


    @Override
    public List<Bike> getBikes() {
        return bikes;
    }
}
