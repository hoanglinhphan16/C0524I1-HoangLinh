const giaiThua = (value) => {
    if (value == 0) {
        console.log("result = 1");
    } else {
        let result = 1;
        for (i = 1; i <= value; i++) {
            result *= i;
        }
        return result;
    }
}

console.log(giaiThua(5));