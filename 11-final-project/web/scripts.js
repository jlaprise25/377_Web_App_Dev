var puzzle = [];
var puzzleAnswer = generatePuzzle();

function generateSudoku() {

    puzzle = generatePuzzle();
    var cellWidth = 360 / 9;
    var cellHeight = 360 / 9;

    for (var i = 0; i < 4; i++) {
        var x = i * cellWidth * 3;
        var y = i * cellHeight * 3;
        var lineX = document.createElementNS('http://www.w3.org/2000/svg', 'line');
        var lineY = document.createElementNS('http://www.w3.org/2000/svg', 'line');
        lineX.setAttribute('x1', '-2');
        lineX.setAttribute('y1', y);
        lineX.setAttribute('x2', '362');
        lineX.setAttribute('y2', y);
        lineX.setAttribute('stroke', 'black');
        lineX.setAttribute('stroke-width', '4');
        lineY.setAttribute('x1', x);
        lineY.setAttribute('y1', '-2');
        lineY.setAttribute('x2', x);
        lineY.setAttribute('y2', '362');
        lineY.setAttribute('stroke', 'black');
        lineY.setAttribute('stroke-width', '4');
        $("#svgcontent").append(lineX);
        $("#svgcontent").append(lineY);
    }

    for (var i = 0; i < 9; i++) {
        for (var j = 0; j < 9; j++) {
            const rect = document.createElementNS('http://www.w3.org/2000/svg', 'rect');
            rect.setAttribute('x', j * cellWidth);
            rect.setAttribute('y', i * cellHeight);
            rect.setAttribute('width', cellWidth);
            rect.setAttribute('height', cellHeight);
            rect.setAttribute('stroke', 'black');
            rect.setAttribute('stroke-width', '1');
            rect.setAttribute('fill', 'none');
            // rect.setAttribute('onclick', 'changeSquare(' + (i + 1)   + ',' + (j + 1) + ')');
            if(puzzle[i][j] == 0){
                rect.setAttribute('onclick', 'changeSquare(' + i + ',' + j + ')');
            }
            $("#svgcontent").append(rect);

            var text = document.createElementNS('http://www.w3.org/2000/svg', 'text');
            text.setAttribute('id', 'r' + i + 'c' + j)
            text.setAttribute('x', j * cellWidth + cellWidth / 2);
            text.setAttribute('y', i * cellHeight + cellHeight / 2 + 8);
            text.setAttribute('font-size', '20');
            text.setAttribute('text-anchor', 'middle');
            

            if (puzzle[i][j] !== 0) {
                text.textContent = puzzle[i][j];
            } else {
                text.setAttribute('onclick', 'changeSquare(' + i + ',' + j + ')');
            }
            // console.log(text.getAttribute('onclick'))
            $("#svgcontent").append(text);
            
        }
    }
    $('#generate-btn').attr('visibility', 'hidden');
}

// changeSquare(3)


function changeSquare(row, col) {
    var value = prompt('Enter a number (1-9 or 0 for blank):');
    if (value !== null) {
        var intValue = parseInt(value);
        if (!isNaN(intValue) && intValue >= 1 && intValue <= 9) {
            puzzle[row][col] = intValue;
            document.getElementById('r' + row + 'c' + col).textContent = intValue;
        } else {
            alert('Please enter a valid number between 0 and 9.');
        }
    }
}
    
    



function generatePuzzle() {
    return [
        [5, 3, 0, 0, 7, 0, 0, 0, 0],
        [6, 0, 0, 1, 9, 5, 0, 0, 0],
        [0, 9, 8, 0, 0, 0, 0, 6, 0],
        [8, 0, 0, 0, 6, 0, 0, 0, 3],
        [4, 0, 0, 8, 0, 3, 0, 0, 1],
        [7, 0, 0, 0, 2, 0, 0, 0, 6],
        [0, 6, 0, 0, 0, 0, 2, 8, 0],
        [0, 0, 0, 4, 1, 9, 0, 0, 5],
        [0, 0, 0, 0, 8, 0, 0, 7, 9]
    ];
}

function toScoreboard(){
    window.location.href = "index.php"
}
