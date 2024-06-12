let valueInput = document.getElementById("valueInput")

function inputValue(value) {
    valueInput.value += value
}
function result() {
    let result = eval(valueInput.value)
    valueInput.value = result
}
function deleteValue() {
    valueInput.value=""
}