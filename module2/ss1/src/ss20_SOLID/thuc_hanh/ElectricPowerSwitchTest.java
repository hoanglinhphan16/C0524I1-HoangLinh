package ss20_SOLID.thuc_hanh;

public class ElectricPowerSwitchTest {
    public static void main(String[] args) {
        Switchable switchableBulb = new LightBulb();
        Switch bulbPowerSwitch = new ElectricPowerSwitch(switchableBulb);

        bulbPowerSwitch.press();
        bulbPowerSwitch.press();

    }
}
