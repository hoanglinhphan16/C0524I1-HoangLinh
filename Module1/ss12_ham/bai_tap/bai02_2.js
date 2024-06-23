const perimeter = (value) => {
    const result = 2 * Math.PI * value;
    return result
}

const area = (value) => {
    const result = Math.PI * Math.pow(value, 2);
    return result
}

console.log(perimeter(4));
console.log(area(4));