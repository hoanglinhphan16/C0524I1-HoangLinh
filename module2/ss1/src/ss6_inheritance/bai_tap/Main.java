package ss6_inheritance.bai_tap;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        Circle circle = new Circle(7);
//        System.out.println(circle.getArea());
//
//        Cylinder cylinder = new Cylinder(circle.getRadius(), 8);
//        System.out.println(cylinder.getVolume());

        Point point = new Point(12,13);
        point.setXY(7,8);
        System.out.println(Arrays.toString(point.getXY()));

        MovablePoint movablePoint = new MovablePoint();
        movablePoint.setXY(7,8);
        System.out.println(Arrays.toString(movablePoint.getXY()));
        movablePoint.move(15,20);
        System.out.println(movablePoint.getX());
        System.out.println(movablePoint.getY());

    }
}
