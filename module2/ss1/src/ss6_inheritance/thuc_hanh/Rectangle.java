package ss6_inheritance.thuc_hanh;

import ss7_abstractClass_interface.bai_tap.Colorable;
import ss7_abstractClass_interface.bai_tap.Resizeable;

public class Rectangle extends Geometric implements Resizeable{
    private double width;
    private double height;

    public Rectangle() {
        this.width = 10;
        this.height = 5;
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle(String color, String filled, double width, double height) {
        this.width = width;
        this.height = height;
        setColor(color);
        setFilled(filled);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public void resize(double percent) {
        System.out.println("Old area Rectangle = " + getArea());
        setWidth( (width * 100) / percent);
        setHeight((height * 100) / percent);
        System.out.println("New area Rectangle = " + getArea());
    }


}
