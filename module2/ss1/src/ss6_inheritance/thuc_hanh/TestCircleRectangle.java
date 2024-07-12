package ss6_inheritance.thuc_hanh;


public class TestCircleRectangle {
    public static void main(String[] args) {
        Circle circle = new Circle(1);
        circle.setFilled("red");

        System.out.println("A circle" + circle.toString());


        Rectangle rectangle = new Rectangle(2,4);
        rectangle.setFilled("yellow");
        System.out.println("Get filled" + rectangle.getFilled());
        System.out.println("-------------------------");

        System.out.println("Circle" + circle);
        System.out.println("Rectangle" + rectangle);
    }
}
