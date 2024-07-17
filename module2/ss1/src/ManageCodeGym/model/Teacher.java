package ManageCodeGym.model;

import java.time.LocalDate;

public class Teacher extends Person {
    private String level;

    public Teacher(String name, LocalDate birthDate, String email, String phoneNumber, String level) {
        super(name, birthDate, email, phoneNumber);
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public void talk() {
        System.out.println("Hello i'm your teacher in this year");
    }

    @Override
    public String toString() {
        return "Teacher{"
                + "name='" + super.getName()
                + "' birthDay='" + super.getBirthDate()
                + "' email='" + super.getEmail()
                + "' phoneNumber='" + super.getPhoneNumber()
                + "' level='" + level + '\'' +
                '}';
    }
}
