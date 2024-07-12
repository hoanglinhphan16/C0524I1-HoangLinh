package ss6_inheritance.thuc_hanh;

public class Faculty extends Employee {
    public Faculty() {
        System.out.println("Faculty performing its task");
    }

    public static void main(String[] args) {

        Faculty f = new Faculty();
        f.sayHello();
    }
}

class Employee extends Person {
    public Employee() {
        this("Employee overloading its task");
        System.out.println("Employee performing its task");
    }

    public Employee(String s) {
        System.out.println(s);
    }

    public void sayHello() {
        super.sayHello();
        System.out.println("Hi");
    }
}

class Person {
    public Person() {
        System.out.println("Person performing its task");
    }

    public void sayHello() {
        System.out.println("Hello");
    }
}
