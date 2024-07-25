package TrafficManagement.service.bike_service;

import TrafficManagement.model.Bike;
import TrafficManagement.repository.bike_repo.BikeRepo;
import TrafficManagement.repository.bike_repo.IBikeRepo;

import java.util.List;

public class BikeService  implements IBikeService{
    private IBikeRepo bikeRepo = new BikeRepo();

    @Override
    public List<Bike> getBikes() {
        return bikeRepo.getBikes();
    }
}
