let element = document.getElementById('nobita')
    element.style.position = 'relative'

upArrowPressed = () => {
    element.style.top = parseInt(element.style.top) - 50 + 'px'
}

downArrowPressed = () => {
    element.style.top = parseInt(element.style.top) + 50 + 'px'
}

leftArrowPressed = () => {
    element.style.left = parseInt(element.style.left) - 50 + 'px'
}

rightArrowPressed = () => {
    element.style.left = parseInt(element.style.left) + 50 + 'px'
}

moveSelection = (event) => {
    switch (event.keyCode) {
        case 37:
            leftArrowPressed()
            break;
        case 38:
            upArrowPressed()
            break;
        case 39:
            rightArrowPressed()
            break;
        case 40:
            downArrowPressed()
            break;
        default:
            break;
    }

}

window.addEventListener("keyup", moveSelection)