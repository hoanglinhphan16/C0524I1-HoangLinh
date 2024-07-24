package TrafficManagement.model;

public class Manufacturer {
    private String manufacturerName;
    private String manufacturerCode;
    private String nation;

    public Manufacturer(String nation, String manufacturerCode, String manufacturerName) {
        this.nation = nation;
        this.manufacturerCode = manufacturerCode;
        this.manufacturerName = manufacturerName;
    }

    public Manufacturer() {}

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getManufacturerCode() {
        return manufacturerCode;
    }

    public void setManufacturerCode(String manufacturerCode) {
        this.manufacturerCode = manufacturerCode;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }
}
