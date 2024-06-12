getValue = () => {
    let valueA = parseInt(document.getElementById('valueA').value)
    let valueB = parseInt(document.getElementById('valueB').value)

    return {
        a: valueA,
        b: valueB
    }
}

addition = () => {
    let value = getValue()
    let result = value.a + value.b

    document.getElementById('result').innerHTML = 'Result = ' + result
}

subtraction = () => {
    let value = getValue()
    let result = value.a - value.b
    document.getElementById('result').innerHTML = 'Result = ' + result
}

multiplication = () => {
    let value = getValue()
    let result = value.a * value.b
    document.getElementById('result').innerHTML = 'Result = ' + result
}

division = () => {
    let value = getValue()
    let result = value.a / value.b
    document.getElementById('result').innerHTML = 'Result = ' + result
}