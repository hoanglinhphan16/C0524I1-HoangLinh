package MassageSalonManagement.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee extends Person{
    private String academicLevel;
    private String position;
    private String salary;

    public Employee(String id, String name, LocalDate birthDate, String idCard, String email, String phoneNumber, String academicLevel, String position, String salary) {
        super(id, name, birthDate, idCard, email, phoneNumber);
        this.academicLevel = academicLevel;
        this.position = position;
        this.salary = salary;
    }

    public Employee() {

    }

    public String getAcademicLevel() {
        return academicLevel;
    }

    public void setAcademicLevel(String academicLevel) {
        this.academicLevel = academicLevel;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String toCSVRow() {
        return super.getId() + "," + super.getName()
                + "," + super.getBirthDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + "," + super.getIdCard()
                + "," + super.getEmail() + "," + super.getPhoneNumber()
                + "," + this.academicLevel + "," + this.position
                + "," + this.salary;
    }

    public static Employee fromCSVRow(String csvRow) {
        String[] data = csvRow.split(",");
        String id = data[0];
        String name = data[1];
        LocalDate birthDate = LocalDate.parse(data[2], DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String idCard = data[3];
        String email = data[4];
        String phoneNumber = data[5];
        String academicLevel = data[6];
        String position = data[7];
        String salary = data[8];

        return new Employee(id, name, birthDate, idCard, email, phoneNumber, academicLevel, position, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + super.getId() + "' " +
                "name='" + super.getName() + "' " +
                "birthDay='" + super.getBirthDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + "' " +
                "idCard='" + super.getIdCard() + "' " +
                "email='" + super.getEmail() + "' " +
                "phoneNumber='" + super.getPhoneNumber() + "' " +
                "academicLevel='" + academicLevel + "' " +
                "position='" + position + "' " +
                "salary='" + salary + "' " +
                '}';
    }
}
