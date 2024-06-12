let valueA = parseInt(prompt("Nhap vao so a"), 0)
let valueB = parseInt(prompt("Nhap vao so b"), 0)
let valueC = parseInt(prompt("Nhap vao so c"), 0)

let max = valueA

if (valueA < valueB || valueA < valueC) {
    if (valueB > valueC) {
        max = valueB
    } else max = valueC
}

alert(max + " la so lon nhat")