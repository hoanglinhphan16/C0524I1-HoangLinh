package TrafficManagement.model;

import java.time.LocalDate;

public abstract class Transportations {
    private String licensePlate;
    private Manufacturer manufacturer;
    private LocalDate manufacturingDate;
    private String owner;

    public Transportations(String owner, LocalDate manufacturingDate, Manufacturer manufacturer, String licensePlate) {
        this.owner = owner;
        this.manufacturingDate = manufacturingDate;
        this.manufacturer = manufacturer;
        this.licensePlate = licensePlate;
    }

    public Transportations() {}

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getManufacturer() {
        return manufacturer.getManufacturerName();
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
