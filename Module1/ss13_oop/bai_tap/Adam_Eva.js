class Apple {
    constructor(weight) {
        this.weight = weight;
    }

    setWeight = (weight) => {
        return this.weight = weight;
    }

    getWeight = () => {
        return this.weight;
    }

    decrease = () => {
        if (this.weight) {
            return this.weight--;
        } else return console.log("No more apple");
    }
}

class Human {
    constructor(name, gender, weight) {
        this.name = name;
        this.gender = gender;
        this.weight = weight;
    }

    setWeight = (weight) => {
        return this.weight = weight
    }

    getWeight = () => {
        return this.weight
    }

    say = (value) => {
        return `${name} say ${value}`
    }

    eat = (apple) => {
        if (apple.getWeight() > 0) {
            apple.decrease();
            this.weight++;
        } else console.log("No more apple");
    }

    checkApple = (apple) => {
        return apple.getWeight();
    }

    setGender = (gender) => {
        return this.gender = gender;
    }

    getGender = () => {
        return this.gender;
    }

    setName = (name) => {
        return this.name = name;
    }

    getName = () => {
        return this.name;
    }

    getAllInfo = () => {
        return `Name: ${this.name}, Gender: ${this.gender}, Weight: ${this.weight} `
    }
}


let apple = new Apple(1);
let adam = new Human("Adam", "male", 75);
let eva = new Human("Eva", "female", 55);

adam.eat(apple)
console.log(apple.getWeight());
console.log("Adam weight " + adam.getWeight());

console.log(apple.getWeight());
eva.eat(apple)
console.log("Eva weight " + eva.getWeight());

console.log(adam.getAllInfo());
console.log(eva.getAllInfo());

