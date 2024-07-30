package ManageCodeGym.model;

import java.time.LocalDate;

public class Teacher extends Person {
    private String level;

    public Teacher(int id, String name, LocalDate birthDate, String email, String phoneNumber, String level) {
        super(id, name, birthDate, email, phoneNumber);
        this.level = level;
    }

    public Teacher() {

    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String toCSVRow() {
        return super.getId()+ "," + super.getName()+ "," + super.getBirthDate()+ "," + super.getEmail()+ "," + super.getPhoneNumber()+ "," + level ;
    }

    @Override
    public String toString() {
        return "Teacher{"
                + "ID='" + super.getId()
                + "' name='" + super.getName()
                + "' birthDay='" + super.getBirthDate()
                + "' email='" + super.getEmail()
                + "' phoneNumber='" + super.getPhoneNumber()
                + "' level='" + level + '\'' +
                '}';
    }

    public static Teacher fromCSVRow(String csvRow) {
        String[] data = csvRow.split(",");
        String id = data[0];
        String name = data[1];
        LocalDate birthDate = LocalDate.parse(data[2]);
        String email = data[3];
        String phoneNumber = data[4];
        String level = data[5];
        return new Teacher(Integer.parseInt(id), name, birthDate, email, phoneNumber, level);
    }
}
