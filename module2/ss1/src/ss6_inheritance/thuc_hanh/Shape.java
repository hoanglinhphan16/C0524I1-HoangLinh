package ss6_inheritance.thuc_hanh;

public class Shape {
    private String color;
    private boolean filled;

    public Shape() {
        color = "green";
        filled = true;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    @Override
    public String toString() {
        String str1 = "filled";
        String str2 = "not filled";
        return "A Shape with color of" + color + " and " + (filled ? str1 : str2);
    }


}

class CircleExtendsShape extends Shape {
    private double radius;

    public CircleExtendsShape() {
        radius = 1.0;
    }

    public CircleExtendsShape(double radius) {
    }

    public CircleExtendsShape(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void getArea() {
        System.out.println(Math.PI * radius * radius);
    }

    public void getPerimeter() {
        System.out.println(2 * Math.PI * radius);
    }

    @Override
    public String toString() {
        return "A Circle with radius = " + radius + "which is a subclass of " + super.toString();
    }
}

class RectangleExtendsShape extends Shape {
    private double width;
    private double height;

    public RectangleExtendsShape() {
        width = 1.0;
        height = 1.0;
    }

    public RectangleExtendsShape(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public RectangleExtendsShape(double width, double height, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.height = height;
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

    @Override
    public String toString() {
        return "A Rectangle with width="
                + getWidth()
                + " and length="
                + getHeight()
                + ", which is a subclass of "
                + super.toString();
    }
}

class Square extends RectangleExtendsShape {
    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        setWidth(side);
        setHeight(side);
    }

    @Override
    public void setWidth(double width) {
        setSide(width);
    }

    @Override
    public void setHeight(double height) {
        setSide(height);
    }

    @Override
    public String toString() {
        return "A Square with side="
                + getSide()
                + ", which is a subclass of "
                + super.toString();
    }
}


