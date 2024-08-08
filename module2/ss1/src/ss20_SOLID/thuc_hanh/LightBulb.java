package ss20_SOLID.thuc_hanh;

public class LightBulb implements Switchable{

    @Override
    public void turnOn() {
        System.out.println("LightBulb: Bulb turned ON");
    }

    @Override
    public void turnOff() {
        System.out.println("LightBulb: Bulb turned OFF");
    }
}
