let valueA = parseInt(prompt("Nhap vao diem giua ky"), 0)
let valueB = parseInt(prompt("Nhap vao diem cuoi ky"), 0)

let average = (valueA + valueB) / 2

if (average >= 8) {
    alert("Hoc sinh gioi")
    
} else if (average >= 6.5) {
    alert("Hoc sinh kha")
} else alert("Hoc sinh trung binh")