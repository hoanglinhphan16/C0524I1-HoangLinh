// let year = +prompt('Nhập vào năm bất kỳ')
// let isLeapYear = false

// if (year % 4 == 0) {
//     if (year % 100 == 0) {
//         if (year % 400 == 0) {
//             isLeapYear = true
//         }
//     } else isLeapYear = true
// }

// if (isLeapYear) {
//     document.getElementById('result').innerHTML = year + ' là năm nhuận'
// } else {
//     document.getElementById('result').innerHTML = year + ' không phải là năm nhuận'
// }

// let isDivisibleBy4 = year % 4 == 0;
// if (isDivisibleBy4) {
//   let isDivisibleBy100 = year % 100 == 0;
//   if (isDivisibleBy100) {
//     let isDivisibleBy400 = year % 400 == 0;
//     if (isDivisibleBy400) {
//       isLeapYear = true;
//     }
//   } else {
//     isLeapYear = true;
//   }
// }

// let ask = prompt('What is the “official” name of JavaScript?')

// if (ask == "ECMAScript") {
//     alert("Right")
// } else alert(`Didn’t know? ECMAScript!`)

// let nameCheck = prompt("Nhập vào tên người dùng", "")

// if (nameCheck == "Admin") {
//     let passwordCheck = prompt("Nhập vào password", "")
//     if (passwordCheck == "TheMaster") {
//         alert("Welcome")
//     } else if (passwordCheck == null) {
//         alert("Canceled")
//     } else alert("Wrong password")
// } else if (nameCheck == null) {
//     alert("Canceled")
// } else alert("I don't know you")

// let browser = prompt("Enter your browser")

// switch (browser) {
//     case 'Edge':
//         alert("You've got the Edge!")
//         break;
//     case 'Chrome':
//     case 'Firefox':
//     case 'Safari':
//     case 'Opera':
//         alert('Okay we support these browsers too')
//     default:
//         alert('We hope that this page looks ok!');
//         break;
// }

// let a = +prompt('a?', '') 
// console.log(a);
// switch (a) {
//     case 0:
//         alert(0)
//         break;
//     case 1:
//         alert(1)
//         break
//     case 2:
//     case 3:
//         alert('2,3')
//     default:
//         break;
// }

// let value = +prompt("Nhập vào 1 số", 0)

// if (value>0) {
//     alert(1)
// } else if (value < 0) {
//     alert(-1)
// } else alert(0)

// let a = +prompt("Nhap vao a", 0);
// let b = +prompt("Nhap vao b", 0);

// (a + b < 4) ? alert("Below") : alert("Over");

let login = prompt("Nhập vào tên chức vụ", "Employee")

let message = (login == 'Employee') ? "hello" :
    (login == 'Director') ? 'Greetings' : 
    (login == "") ? 'No login' : ''

alert(message)