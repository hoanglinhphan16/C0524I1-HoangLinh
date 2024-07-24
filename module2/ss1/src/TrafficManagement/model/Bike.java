package TrafficManagement.model;

import java.time.LocalDate;

public class Bike extends Transportations{
    private double power;

    public Bike() {}

    public Bike(String owner, LocalDate manufacturingDate, Manufacturer manufacturer, String licensePlate, double power) {
        super(owner, manufacturingDate, manufacturer, licensePlate);
        this.power = power;
    }

    public Bike(double power) {
        this.power = power;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "power=" + power +
                '}';
    }
}
