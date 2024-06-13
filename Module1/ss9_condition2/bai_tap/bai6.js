let valueA = parseInt(prompt("Nhap vao doanh so da ban duoc"), 0)
let money = 0

if (valueA >= 1000000) {
    money = valueA * 15 / 100
    alert("Hoa hong dc nhan la 15%. So tien nhan dc la " + money)
} else if (average >= 500000) {
    money = valueA * 7 / 100
    alert("Hoa hong dc nhan la 7%. So tien nhan dc la " + money)
} else alert("Eo' co hoa hong :D")