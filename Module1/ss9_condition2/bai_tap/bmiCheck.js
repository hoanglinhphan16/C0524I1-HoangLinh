let weight = prompt('Nhập vào cân nặng của bạn')
let height = prompt('Nhập vào chiều cao của bạn')
let bmi = weight/(height*height)

if (bmi < 18.5) {
    alert("Underweight")
} else if (bmi < 25) {
    alert("Normal")
} else if (bmi < 30) {
    alert("Overweight")
} else alert("Obese")