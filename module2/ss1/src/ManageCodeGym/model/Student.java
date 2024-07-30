package ManageCodeGym.model;

import java.time.LocalDate;

public class Student extends Person {
    private String className;

    public Student(int id, String name, LocalDate birthDate, String email, String phoneNumber, String className) {
        super(id, name, birthDate, email, phoneNumber);
        this.className = className;
    }

    public Student() {
        super();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String toCSVRow() {
        return super.getId()+ "," + super.getName()+ "," + super.getBirthDate()+ "," + super.getEmail()+ "," + super.getPhoneNumber()+ "," + className ;
    }

    public static Student fromCSVRow(String csvRow) {
        String[] data = csvRow.split(",");
        String id = data[0];
        String name = data[1];
        LocalDate birthDate = LocalDate.parse(data[2]);
        String email = data[3];
        String phoneNumber = data[4];
        String className = data[5];
        return new Student(Integer.parseInt(id), name, birthDate, email, phoneNumber, className);
    }

    @Override
    public String toString() {
        return "Student{"
                + "ID='" + super.getId()
                + "' name='" + super.getName()
                + "' birthDay='" + super.getBirthDate()
                + "' email='" + super.getEmail()
                + "' phoneNumber='" + super.getPhoneNumber()
                + "' className='" + className + '\'' +
                '}';
    }
}
