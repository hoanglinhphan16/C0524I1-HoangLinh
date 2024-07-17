package ManageCodeGym.model;

import java.time.LocalDate;

public class Student extends Person {
    private String className;

    public Student(String name, LocalDate birthDate, String email, String phoneNumber, String className) {
        super(name, birthDate, email, phoneNumber);
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public void talk() {
        System.out.println("Hello i'm a good student");
    }

    @Override
    public String toString() {
        return "Student{"
                + "name='" + super.getName()
                + "' birthDay='" + super.getBirthDate()
                + "' email='" + super.getEmail()
                + "' phoneNumber='" + super.getPhoneNumber()
                + "' className='" + className + '\'' +
                '}';
    }
}
