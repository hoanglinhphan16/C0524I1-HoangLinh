package MassageSalonManagement.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Customer extends Person{
    private String level = "member";

    public Customer(String id, String name, LocalDate birthDate, String idCard, String email, String phoneNumber, String level) {
        super(id, name, birthDate, idCard, email, phoneNumber);
        this.level = level;
    }

    public Customer() {
        super();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String toCSVRow() {
        return super.getId() + "," + super.getName()
                + "," + super.getBirthDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + "," + super.getIdCard()
                + "," + super.getEmail() + "," + super.getPhoneNumber()
                + "," + this.level;
    }

    public static Customer fromCSVRow(String csvRow) {
        String[] data = csvRow.split(",");
        String id = data[0];
        String name = data[1];
        LocalDate birthDate = LocalDate.parse(data[2], DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String idCard = data[3];
        String email = data[4];
        String phoneNumber = data[5];
        String level = data[6];

        return new Customer(id, name, birthDate, idCard, email, phoneNumber, level);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + super.getId() + "' " +
                "name='" + super.getName() + "' " +
                "birthDay='" + super.getBirthDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + "' " +
                "idCard='" + super.getIdCard() + "' " +
                "email='" + super.getEmail() + "' " +
                "phoneNumber='" + super.getPhoneNumber() + "' " +
                "level='" + getLevel() + "'" +
                '}';
    }
}
