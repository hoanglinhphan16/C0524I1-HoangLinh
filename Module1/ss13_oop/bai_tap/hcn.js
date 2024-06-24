class HCN {
    constructor(width, height) {
        this.width = width;
        this.height = height;
    }

    getWidth() {
        return this.width;
    }

    getHeight() {
        return this.height;
    }

    setWidth(width) {
        this.width = width;
    }

    setHeight(height) {
        this.height = height;
    }

    getArea() {
        return this.width * this.height;
    }

    getPerimeter() {
        return (this.width + this.height) * 2;
    }
}

let myHCN = new HCN(100, 50);
console.log(myHCN);

let canvas = document.getElementById("myCanvas");
let ctx = canvas.getContext('2d');
ctx.fillStyle = '#fa4b2a';
ctx.fillRect(10, 10, myHCN.width, myHCN.height)