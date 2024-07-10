package ss4_OOP.thuc_hanh;

import java.time.LocalDate;

public class Student {
    String name;
    LocalDate dayBorn;
    String email;

    public Student() {

    }

    // alt + insert create fastest constructor

    public Student(String name, LocalDate dayBorn, String email) {
        this.name = name;
        this.dayBorn = dayBorn;
        this.email = email;
    }

    public void learnSubject(String subject) {
        System.out.println(subject);
    }

    public void showInfo() {
        System.out.println("Name: " + name);
        System.out.println("Day Born: " + dayBorn);
        System.out.println("Email: " + email);
    }

    public static void main(String[] args) {

        Student student = new Student("Hoang Linh",LocalDate.parse("1999-06-01"), "hoanglinhphan16@gmail.com");
        student.learnSubject("Java");
        student.showInfo();
    }
}
