changeMoney = () => {
    let amount = parseInt(document.getElementById('amount').value)

    let moneyFrom = document.getElementById('moneyFrom')
    let valueFrom = moneyFrom.options[moneyFrom.selectedIndex].text
    
    let moneyTo = document.getElementById('moneyTo')
    let valueTo = moneyTo.options[moneyTo.selectedIndex].text

    if (valueFrom == 'VND' && valueTo == 'USD') {
        result = amount/25000
    } else if (valueFrom == 'USD' && valueTo == 'VND') {
        result = amount*25000
    } else result = amount

    document.getElementById('result').innerHTML = 'Result = ' + result
}