let valueA = parseInt(prompt("Nhap vao so phut da goi"), 0)

if (valueA > 20) {
    let money = valueA*1500
    alert("Tien cuoc dien thoai la " + money )
    
} else if (valueA > 3) {
    let money = valueA*3000
    alert("Tien cuoc dien thoai la " + money)
} else {
    let money = valueA*5000
    alert("Tien cuoc dien thoai la " + money)
}