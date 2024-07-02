let rows = 5;
let columns = 5;

let currTile;
let otherTile;

let turns = 0;

const startGame = () => {

    document.getElementById("startButton").style.display = 'none'; // Hide the start button
    document.getElementById("content").style.visibility = 'visible';
    audioElements = [
        document.getElementById("audio1"),
        document.getElementById("audio2"),
        document.getElementById("audio3"),
        document.getElementById("audio4"),
        document.getElementById("audio5"),
        document.getElementById("audio6")
    ];

    // Add event listeners to handle the end of each audio track
    audioElements.forEach((audio, index) => {
        audio.addEventListener('ended', () => playNextAudio(index));
    });

    // Start the first audio
    playNextAudio(-1);

    for (r = 0; r < rows; r++) {
        for (c = 0; c < columns; c++) {
            let tile = document.createElement("img");
            tile.src = "./images/blank.jpg"

            tile.addEventListener("dragstart", dragStart); //Bấm vào ảnh để kéo
            tile.addEventListener("dragover", dragOver);   //Kéo ảnh
            tile.addEventListener("dragenter", dragEnter); //Kéo ảnh vào 1 ảnh khác
            tile.addEventListener("dragleave", dragLeave); //Kéo ảnh khỏi 1 ảnh khác
            tile.addEventListener("drop", dragDrop);       //Thả ảnh vào 1 ảnh khác
            tile.addEventListener("dragend", dragEnd);     //Sau khi thả ảnh

            document.getElementById("board").append(tile)
        }
    }

    let pieces = [];
    for (i = 1; i <= rows * columns; i++) {
        pieces.push(i.toString())
    }
    pieces.reverse()

    for (i = 0; i < pieces.length; i++) {
        let j = Math.floor(Math.random() * pieces.length)

        let tmp = pieces[i];
        pieces[i] = pieces[j];
        pieces[j] = tmp;
    }

    for (i = 0; i < pieces.length; i++) {
        let tile = document.createElement("img");
        tile.src = "./images/" + pieces[i] + ".jpg";

        tile.addEventListener("dragstart", dragStart); //Bấm vào ảnh để kéo
        tile.addEventListener("dragover", dragOver);   //Kéo ảnh
        tile.addEventListener("dragenter", dragEnter); //Kéo ảnh vào 1 ảnh khác
        tile.addEventListener("dragleave", dragLeave); //Kéo ảnh khỏi 1 ảnh khác
        tile.addEventListener("drop", dragDrop);       //Thả ảnh vào 1 ảnh khác
        tile.addEventListener("dragend", dragEnd);     //Sau khi thả ảnh

        document.getElementById("pieces").append(tile);
    }

    const check = document.getElementById("board")
    console.log(check)

}



function playNextAudio(currentIndex) {
    currentAudioIndex = (currentIndex + 1) % audioElements.length;
    console.log(currentIndex);
    var mybag
    audioElements[currentAudioIndex].play();
}

function dragStart() {
    currTile = this;   //this gắn với ảnh được click
    console.log(this);
}
function dragOver(e) {
    e.preventDefault();
}
function dragEnter(e) {
    e.preventDefault();
}
function dragLeave(e) {
    e.preventDefault();
}
function dragDrop() {
    otherTile = this; // this gắn với ảnh ở vị trí thả
}
function dragEnd() {
    if (currTile.src.includes("blank")) {
        return;
    }

    let currImg = currTile.src;
    let otherImg = otherTile.src;
    currTile.src = otherImg;
    otherTile.src = currImg;
    console.log(currImg);

    turns++;
    document.getElementById("turns").innerHTML = turns;
}

