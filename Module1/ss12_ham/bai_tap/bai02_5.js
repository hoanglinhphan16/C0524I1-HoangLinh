const minFunc = (a, b, c) => {
    let min = a;
    if (a > b || a > c) {
        if (b > c) {
            min = c;
        } else min = b;
    }

    return min;
}

console.log(minFunc(5, 4, 5));