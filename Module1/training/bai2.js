const checkStr = (string) => {
    let countUp = 0, countLow = 0; countSpace = 0;
    const result = string.split("")
    // });
    // // for (i = 0; i < result.length; i++) {
    // //     if (result[i].toUpperCase()) {
    // //         countUp += 1;
    // //     } else if (result[i].toLowerCase()) {
    // //         countLow += 1;
    // //     }
    // // }
    for (e of result) {
        if (e === " ") {
            countSpace += 1;
        } else if (e === e.toLowerCase()) {
            countLow += 1;
        } else if (e === e.toUpperCase()) {
            countUp += 1;
        }
    }
    return {
        countUp, countLow, countSpace
    }
}

const result = checkStr("The Quick Brown Fox");
if (result.countLow == result.countUp) {
    console.log(true);
} else console.log(false);
let num = 0;
do {
    num++;
    console.log(num);
} while (num++ < 10)