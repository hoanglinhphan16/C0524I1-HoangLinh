const changeValue = (a, b) => {
    let tg = a;
    a = b;
    b = tg;

    return {
        a, b
    }
}

const result = changeValue(4, 5)
console.log(result);