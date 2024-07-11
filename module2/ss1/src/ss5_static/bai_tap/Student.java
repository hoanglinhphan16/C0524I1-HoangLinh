package ss5_static.bai_tap;

public class Student {
    private String name;
    private String classes;

    public Student() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public Student(String name, String classes) {
        this.name = name;
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classes='" + classes + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Student s1 = new Student("Hoang Linh", "S1");

        s1.setClasses("C0524I1");
        s1.setName("Phan Thanh Hoang Linh");
        System.out.println(s1);
    }
}
