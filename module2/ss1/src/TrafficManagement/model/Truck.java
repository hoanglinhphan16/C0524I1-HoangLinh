package TrafficManagement.model;

import java.time.LocalDate;

public class Truck extends Transportations{
    private int weight;

    public Truck() {}

    public Truck(String owner, LocalDate manufacturingDate, Manufacturer manufacturer, String licensePlate, int weight) {
        super(owner, manufacturingDate, manufacturer, licensePlate);
        this.weight = weight;
    }

    public Truck(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "owner" + super.getOwner() +
                ", manufacturingDate" + super.getManufacturingDate() +
                ", manufacturer" + super.getManufacturer() +
                ", licensePlate" + super.getLicensePlate() +
                "weight=" + weight +
                '}';
    }
}
