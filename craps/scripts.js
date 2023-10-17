$(document).ready(function () {
    rollDice();
});


function rollDice(){
    $('.pip').css("visibility", "hidden");

    rollDie(1);
    rollDie(2);
}

function rollDie(dieNum){
    var roll = Math.floor(Math.random() * 6 + 1); 
    console.log(roll);
    
    

    if (roll == 1){
        $('#d' + dieNum + 'p4').css("visibility", "visible");
    } else if (roll == 2){
        $('#d' + dieNum + 'p3').css("visibility", "visible");
        $('#d' + dieNum + 'p5').css("visibility", "visible");
    } else if (roll == 3){
        $('#d' + dieNum + 'p3').css("visibility", "visible");
        $('#d' + dieNum + 'p4').css("visibility", "visible");
        $('#d' + dieNum + 'p5').css("visibility", "visible");
    } else if (roll == 4){
        $('#d' + dieNum + 'p1').css("visibility", "visible");
        $('#d' + dieNum + 'p3').css("visibility", "visible");
        $('#d' + dieNum + 'p5').css("visibility", "visible");
        $('#d' + dieNum + 'p7').css("visibility", "visible");
    } else if (roll == 5){
        $('#d' + dieNum + 'p1').css("visibility", "visible");
        $('#d' + dieNum + 'p3').css("visibility", "visible");
        $('#d' + dieNum + 'p4').css("visibility", "visible");
        $('#d' + dieNum + 'p5').css("visibility", "visible");
        $('#d' + dieNum + 'p7').css("visibility", "visible");
    } else {
        $('#d' + dieNum + 'p1').css("visibility", "visible");
        $('#d' + dieNum + 'p2').css("visibility", "visible");
        $('#d' + dieNum + 'p3').css("visibility", "visible");
        $('#d' + dieNum + 'p5').css("visibility", "visible");
        $('#d' + dieNum + 'p6').css("visibility", "visible");
        $('#d' + dieNum + 'p7').css("visibility", "visible");
    }
}