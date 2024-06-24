class Circle {
    constructor(radius, color) {
        this.radius = radius;
        this.color = color;
    }

    getRadius() {
        return this.radius
    }
    getArea() {
        return this.radius * this.radius * Math.PI
    }
}

let value = new Circle(2, "Blue")

console.log(value.getArea());