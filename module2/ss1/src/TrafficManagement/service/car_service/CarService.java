package TrafficManagement.service.car_service;

import TrafficManagement.model.Car;
import TrafficManagement.repository.car_repo.CarRepo;
import TrafficManagement.repository.car_repo.ICarRepo;

import java.util.List;

public class CarService implements ICarService {
    private ICarRepo carRepo = new CarRepo();

    @Override
    public List<Car> getCars() {
        return carRepo.getCars();
    }
}
