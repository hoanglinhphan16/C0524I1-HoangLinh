const pi = Math.PI

average = () => {
    let physicScore = parseInt(document.getElementById('physicGrade').value)
    let chemistryScore = parseInt(document.getElementById('chemistryGrade').value)
    let biologyScore = parseInt(document.getElementById('biologyGrade').value)
    
    const average = (physicScore+chemistryScore+biologyScore)/3

    document.getElementById('result').innerHTML = 'Result = '+average
}

changeToF = () => {
    let celsius = parseInt(document.getElementById('celsius').value)

    let fahrenheit = 9*celsius/5 + 32

    document.getElementById('result1').innerHTML = 'Result = '+fahrenheit
}

perimeter = () => {
    let radius = parseInt(document.getElementById('radius').value)
    let perimeter = 2*pi*radius

    document.getElementById('result2').innerHTML = 'Chu vi = ' + perimeter
}

area = () => {
    let radius = parseInt(document.getElementById('radius').value)
    let area = pi*radius*radius

    document.getElementById('result2').innerHTML = 'Diện tích = ' + area
}

