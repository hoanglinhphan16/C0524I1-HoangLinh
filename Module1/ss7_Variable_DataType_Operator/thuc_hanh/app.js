let i = 10
let f = 20.5
let b = true
let s = "Hà Nội"

document.writeln('i = ' + i)
document.write('<br/>')
document.writeln('f = ' + f)
document.write('<br/>')
document.writeln('b = ' + b)
document.write('<br/>')
document.writeln('s = ' + s)
document.write('<br/>')

let width = 10
let height = 20

let result = width*height

document.writeln('result = ' + result)

kiemTra = () => {
    let a = prompt('Nhập vào giá trị a')
    let b = prompt('Nhập vào giá trị b')

    if (a%b === 0) {
        alert('a là bội số của b')
    } alert('a không phải là bội số b')
}
