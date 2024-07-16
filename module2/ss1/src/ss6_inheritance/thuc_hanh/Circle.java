package ss6_inheritance.thuc_hanh;

import ss7_abstractClass_interface.bai_tap.Resizeable;

public class Circle extends Geometric implements Resizeable {
    private double radius;

    public Circle() {
        this.radius = 3;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, String filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    public double getDiameter() {
        return 2 * radius;
    }

    public void printCircle() {
        System.out.println("The " + getColor() + " circle is created with the radius is " + radius);
    }

    @Override
    public void resize(double percent) {
        System.out.println("Old area Circle = " + getArea());
        setRadius((radius * 100)/percent);
        System.out.println("New area Circle = "+getArea());
    }
}
