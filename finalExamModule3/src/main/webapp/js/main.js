function closePopup() {
    var popup = document.getElementById("popup");
    if (popup) {
        popup.style.display = "none";
    }
}

// Automatically close popup after 3 seconds
setTimeout(function () {
    closePopup();
}, 3000);