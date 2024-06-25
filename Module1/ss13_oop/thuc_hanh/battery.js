class Battery {
    constructor(e) {
        this.energy = e;
    }

    getEnergy = () => {
        return this.energy;
    }

    setEnergy = (energy) => {
        return this.energy = energy
    }

    decreaseEnergy = () => {
        if (this.energy > 0) {
            this.energy--;
        }
    }
}

class FlashLamp {
    constructor() {
        this.battery = null;
    }

    setBattery = (battery) => {
        return this.battery = battery;
    }

    getBatteryInfo = () => {
        return this.battery.getEnergy();
    }

    light = () => {
        if (this.status) {
            return alert("Lighting")
        } else return aler("Not lighting")
    }

    turnOn = () => {
        return this.status = true;
    }

    turnOff = () => {
        return this.status = false;
    }
}

let battery = new Battery(10);
battery.setEnergy(100);

let flashLamp = new FlashLamp();
flashLamp.setBattery(battery);

console.log(battery);

console.log(flashLamp.getBatteryInfo());