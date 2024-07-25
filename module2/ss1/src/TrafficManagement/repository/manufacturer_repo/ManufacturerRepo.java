package TrafficManagement.repository.manufacturer_repo;

import TrafficManagement.model.Manufacturer;

import java.util.ArrayList;
import java.util.List;

public class ManufacturerRepo implements IManufacturerRepo{
    private static List<Manufacturer> manufacturers = new ArrayList<Manufacturer>();
    static {
        manufacturers.add(new Manufacturer("Germany","Porsche101", "Porsche"));
        manufacturers.add(new Manufacturer("Germany","Mer102", "Mercedes"));
        manufacturers.add(new Manufacturer("Italia","Fer103", "Ferrari"));
        manufacturers.add(new Manufacturer("Italia","Lambo104", "Lamborghini"));
        manufacturers.add(new Manufacturer("United States","Ford105", "Ford"));
        manufacturers.add(new Manufacturer("Vietnam","Vin106", "Vinfast"));
    }

    @Override
    public List<Manufacturer> getManufacturers() {
        return manufacturers;
    }
}
