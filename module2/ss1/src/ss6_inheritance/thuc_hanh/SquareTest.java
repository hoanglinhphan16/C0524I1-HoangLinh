package ss6_inheritance.thuc_hanh;

public class SquareTest {
    public static void main(String[] args) {
        Square s = new Square();
        System.out.println(s);

        s = new Square(2.3);
        System.out.println("2 " + s);

        s = new Square(5.8, "yellow", true);
        System.out.println(s);
    }
}
