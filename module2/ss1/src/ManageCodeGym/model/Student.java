package ManageCodeGym.model;

import java.time.LocalDate;

public class Student extends Person {
    private String className;

    public Student(int id, String name, LocalDate birthDate, String email, String phoneNumber, String className) {
        super(id, name, birthDate, email, phoneNumber);
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
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
