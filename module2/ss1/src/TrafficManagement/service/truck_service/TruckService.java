package TrafficManagement.service.truck_service;

import TrafficManagement.model.Truck;
import TrafficManagement.repository.truck_repo.ITruckRepo;
import TrafficManagement.repository.truck_repo.TruckRepo;

import java.util.List;

public class TruckService implements ITruckService{
    private ITruckRepo truckRepo = new TruckRepo();

    @Override
    public List<Truck> getTrucks() {
        return truckRepo.getTrucks();
    }
}
