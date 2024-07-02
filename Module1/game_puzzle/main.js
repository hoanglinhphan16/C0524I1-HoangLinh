let rows = 5;
let columns = 5;
let size = 5;

let currTile;
let otherTile;

let turns = 0;
let transArray = [];
let correctArray = [];
let newArray = new Array(5);

for (i = 0; i < newArray.length; i++) {
    newArray[i] = new Array(5);
}

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

            tile.setAttribute('id', `${r}-${c}`)
            tile.addEventListener("dragstart", dragStart); //Bấm vào ảnh để kéo
            tile.addEventListener("dragover", dragOver);   //Kéo ảnh
            tile.addEventListener("dragenter", dragEnter); //Kéo ảnh vào 1 ảnh khác
            tile.addEventListener("dragleave", dragLeave); //Kéo ảnh khỏi 1 ảnh khác
            tile.addEventListener("drop", dragDrop);       //Thả ảnh vào 1 ảnh khác
            tile.addEventListener("dragend", dragEnd);     //Sau khi thả ảnh

            document.getElementById("board").append(tile);
            newArray[r][c] = "";
        }
    }
    let pieces = [];
    for (i = 1; i <= rows * columns; i++) {
        pieces.push(i.toString())
        transArray.push(`${i}.jpg`)
    }

    for (i = 0; i < transArray.length; i += size) {
        correctArray.push(transArray.slice(i, i + size));
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
}

function playNextAudio(currentIndex) {
    currentAudioIndex = (currentIndex + 1) % audioElements.length;
    audioElements[currentAudioIndex].play();
}

function dragStart() {
    currTile = this;   //this gắn với ảnh được click
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
    let arrayId = otherTile.getAttribute('id').split('-')
    newArray[arrayId[0]][arrayId[1]] = currImg.slice(currImg.lastIndexOf('/') + 1);
    console.log(newArray);

    turns++;
    document.getElementById("turns").innerHTML = turns;

    let isCorrect = checkCorrectPosition(newArray, correctArray)

    if (isCorrect) {
        alert("Good job bitch! ♥")
    }
}

function checkCorrectPosition(matrix1, matrix2) {
    // Kiểm tra kích thước của hai mảng
    if (matrix1.length !== matrix2.length || matrix1[0].length !== matrix2[0].length) {
        return false;
    }

    // So sánh từng phần tử
    for (let i = 0; i < matrix1.length; i++) {
        for (let j = 0; j < matrix1[0].length; j++) {
            if (matrix1[i][j] !== matrix2[i][j]) {
                return false;
            }
        }
    }

    return true;
}

