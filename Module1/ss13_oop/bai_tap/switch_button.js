class ElectricLamp {
    constructor(status) {
        this.status = status;
    }

    getStatus = () => {
        return this.status;
    }
}

class SwitchButton {
    constructor(status, lamp) {
        this.status = status;
        this.lamp = lamp;
    }

    getLamp() {
        return this.lamp;
    }

    setLamp(lamp) {
        this.lamp = lamp;
    }

    connectToLamp = (ElectricLamp) => {
        this.lamp = ElectricLamp;
    }

    switchOn = () => {
        this.lamp.status = true
        this.status = true

    }

    switchOff = () => {
        this.lamp.status = false
        this.status = false

    }
}

let lamp = new ElectricLamp(false);
let switchButton = new SwitchButton(false, lamp);

// switchButton.connectToLamp(lamp);

switchButton.switchOn()
console.log(lamp.getStatus());

switchButton.switchOff()
console.log(lamp.getStatus());