checkMonth = () => {
    let month = parseInt(document.getElementById("month").value)
    let result = document.getElementById("result")
    switch (month) {

        case 1:
        case 3:
        case 5:
        case 7:
        case 9:
        case 11:
            result.innerHTML = `Tháng ${month} có 31 ngày`
            break;
        case 2:
            result.innerHTML = "Tháng 2 có 28 ngày hoặc 29 ngày"
            break;
        case 4:
        case 6:
        case 8:
        case 10:
        case 12:
            result.innerHTML = `Tháng ${month} có 30 ngày`
            break;
        default:
            result.innerHTML = "Bạn chưa nhập dữ liệu hoặc bạn vừa nhập sai tháng"
            break;
    }
}