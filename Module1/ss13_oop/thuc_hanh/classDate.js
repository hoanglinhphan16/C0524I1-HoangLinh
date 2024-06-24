// let myDate = function (day, month, year) {
//     this.day = day;
//     this.month = month;
//     this.year = year;

//     this.getDay = function () {
//         return this.day
//     }
//     this.getMonth = function () {
//         return this.month
//     }
//     this.getYear = function () {
//         return this.year
//     }

//     this.setDay = function (day) {
//         this.day = day
//     }
//     this.setMonth = function (month) {
//         this.month = month
//     }
//     this.setYear = function (year) {
//         this.year = year
//     }
// }

// let value = new myDate(1, 2, 3);



class myDate {
    constructor(day, month, year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    getDay() {
        return this.day
    }
    getMonth() {
        return this.month
    }
    getYear() {
        return this.year
    }

    setDay(day) {
        return this.day = day
    }
    setMonth(month) {
        return this.month = month
    }
    setYear(year) {
        return this.year = year
    }
}

let day = new myDate(3, 4, 5);
console.log(day.setYear(2000));
console.log(day);
