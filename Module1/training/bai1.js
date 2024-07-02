const checkArray = (arr, check) => {
    for (i = 0; i < arr.length / 2; i++) {
        if (Math.pow(arr[i], 2) == arr[i + (arr.length / 2)]) {
            check = true;
        } else {
            check = false;
            break;
        }
    }

    return check
}
let check = false;
const result = checkArray([1, 2, 3, 4, 5, 6, 1, 0, 9, 16, 25, 36], check);
console.log(result);