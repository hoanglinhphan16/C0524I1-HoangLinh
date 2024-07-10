package ss4_OOP.bai_tap;

public class Fan {
    int SLOW = 1;
    int MEDIUM = 2;
    int FAST = 3;
    int speed = this.SLOW;
    boolean status = false;
    double radius = 5.0;
    String color = "blue";

    public Fan() {}

    public Fan(int speed, boolean status, String color, double radius) {
        this.speed = speed;
        this.status = status;
        this.color = color;
        this.radius = radius;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return status;
    }

    public void setstatus(boolean status) {
        this.status = status;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        if (status) {
            return "Fan{" + "speed = " + speed + ", radius = " + radius + " , color = " + color + " ----- fan is on" + '}';
        } else return "color = " + color + " radius = " + radius + " ----- fan is off" + '}';
//        return "Fan{" +
//                "speed=" + speed +
//                ", on=" + on +
//                ", radius=" + radius +
//                ", color='" + color + '\'' +
//                '}';
    }

    public static void main(String[] args) {
        Fan myFan = new Fan();
        myFan.setSpeed(5);
        myFan.setstatus(true);
        myFan.setRadius(5);
        myFan.setColor("yellow");
        System.out.println(myFan);
    }
}
