function openDoor(code){
    userCode = prompt("What is the Code?")
    if(userCode == code){
        alert("Thats the correct code")
    } else {
        alert("Thats incorrect")
    }
}

function makeSodoku(){
    for(var i = 0; i < 81; i++){
        
    }
}

function lock(num){
    var intValue = parseInt($("#lotx" + num).text())
    // console.log(intValue + 1.toString())
    if(intValue < 9){
        intValue++
        $("#lotx" + num).text(intValue.toString());
    } else if (intValue = 9){
        $("#lotx" + num).text("0");
    }
    
    // console.log("New value: " + $("#lotx" + num).text());
}