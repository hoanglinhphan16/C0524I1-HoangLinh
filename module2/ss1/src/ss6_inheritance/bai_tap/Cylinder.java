package ss6_inheritance.bai_tap;

public class Cylinder extends Circle{
    private double height;

    public Cylinder() {}

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }



    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return Math.PI * Math.pow(height, 2);
    }

    public double getVolume() {
        return Math.PI * Math.pow(height, 3);
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "height=" + height +
                '}';
    }


}
