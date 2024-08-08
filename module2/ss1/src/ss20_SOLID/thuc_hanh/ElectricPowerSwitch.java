package ss20_SOLID.thuc_hanh;

public class ElectricPowerSwitch implements Switch{
    public Switchable client;

    public boolean on;

    public ElectricPowerSwitch(Switchable client) {
        this.client = client;
        on = false;
    }

    @Override
    public boolean isOn() {
        return on;
    }

    @Override
    public void press() {
        boolean checkOn = isOn();
        if (checkOn) {
            client.turnOff();
            this.on = false;
        } else {
            client.turnOn();
            this.on = true;
        }
    }
}
