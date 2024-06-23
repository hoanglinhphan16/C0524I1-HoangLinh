const checkValue = (value) => {
    if (value) {
        if (parseInt(value) > 0) {
            return true;
        } else return false
    } return false
}

console.log(checkValue("1"));