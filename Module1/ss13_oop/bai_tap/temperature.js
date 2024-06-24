class Temperature {
    constructor(degree) {
        this.degree = degree
    }

    getDegree() {
        return this.degree;
    }

    setDegree(degree) {
        return this.degree = degree;
    }

    changeToF() {
        return this.degree * 9 / 5 + 32;
    }

    changeToKelvin() {
        return this.degree + 273.15;
    }
}

let newDegree = new Temperature(25);

console.log(newDegree);

console.log(`do F ${newDegree.changeToF()}`);
console.log(`do Kelvin ${newDegree.changeToKelvin()}`);

