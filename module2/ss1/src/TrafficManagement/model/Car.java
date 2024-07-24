package TrafficManagement.model;

import java.time.LocalDate;

public class Car extends Transportations{
    private int seats;
    private String typeOfCar;

    public Car() {}

    public Car(int seats, String typeOfCar) {
        this.seats = seats;
        this.typeOfCar = typeOfCar;
    }

    public Car(String owner, LocalDate manufacturingDate, Manufacturer manufacturer, String licensePlate, int seats, String typeOfCar) {
        super(owner, manufacturingDate, manufacturer, licensePlate);
        this.seats = seats;
        this.typeOfCar = typeOfCar;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getTypeOfCar() {
        return typeOfCar;
    }

    public void setTypeOfCar(String typeOfCar) {
        this.typeOfCar = typeOfCar;
    }

    @Override
    public String toString() {
        return "Car{" +
                "seats=" + seats +
                ", typeOfCar='" + typeOfCar + '\'' +
                '}';
    }
}
