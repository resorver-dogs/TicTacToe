window.onload=function(){
  $.getJSON("/startgame", function(result){
    startGame(result)
  });
  
  board = new Array();
}

function setBoard(row, col) {
   board.push(row);
   board.push(col);
   console.log("Supsup");
}

var cells = {
  "1": [0,0],
  "2": [0,1],
  "3": [0,2],
  "4": [1,0],
  "5": [1,1],
  "6": [1,2],
  "7": [2,0],
  "8": [2,1],
  "9": [2,2],
}
