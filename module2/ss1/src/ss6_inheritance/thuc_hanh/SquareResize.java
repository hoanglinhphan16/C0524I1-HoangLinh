package ss6_inheritance.thuc_hanh;

import ss7_abstractClass_interface.bai_tap.Colorable;
import ss7_abstractClass_interface.bai_tap.Resizeable;

public class SquareResize extends Geometric implements Resizeable, Colorable {
    private double side;

    public SquareResize() {
        this.side = 8;
    }

    public SquareResize(double side) {
        this.side = side;
    }

    public SquareResize(String color, String filled, double side) {
        super(color, filled);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getArea() {
        return side * side;
    }

    @Override
    public String toString() {
        return "A Square with side="
                + getSide()
                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public void resize(double percent) {
        System.out.println("Old area Square = " + getArea());
        setSide((side * 100) / percent);
        System.out.println("New area Square = " + getArea());
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides..");
    }
}
