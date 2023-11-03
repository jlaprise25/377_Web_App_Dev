var DECK = getDeckOfCards();
var PLAYER = []; 
var PLAYERTOT = 0;
var DEALER = [];
var DEALERTOT = 0;
var COUNT = 1;
var DCOUNT = 1;
var MIN_BET = 5;
var START_FUNDS = 50;

var bet = 0;
var funds = START_FUNDS;

function startGame(){
    if (validateBet()) {
        for(var i = 0; i < 4; i++){
            var card = getCard();
            var cardFile = getCardFile(card);
            if(i<2){
                DEALER.push(card);
            } else {
                PLAYER.push(card);
            }
            if(i!=1){
                $("#c" + (i+1)).attr("href", cardFile);
            }   
        }
    } else {
        if (funds < MIN_BET) {
            $("#message").text("You don't have enough money to play");
        } else  {
            $("#message").text("Enter a bet between $" + MIN_BET + " and $" + funds);
        }
    }
    PLAYERTOT += getTot(PLAYER);
    DEALERTOT += getTot(DEALER);
}

function hit(){
    if(COUNT <= 5){
        var card = getCard();
        var cardFile = getCardFile(card);
        PLAYER.push(card);

        $("#hc" + COUNT).attr("href", cardFile);
        $("#hc" + COUNT).css("visibility", "visible");

        COUNT++;
    }
    PLAYERTOT += getTot(PLAYER) - PLAYERTOT;
    if(PLAYERTOT >= 22){
        $("#message").text("Bust");

        var card = getCard();
        var cardFile = getCardFile(card);
        DEALER.push(card);
        $("#c" + 2).attr("href", cardFile);
        $("#c" + 2).css("visibility", "visible");

        endGame(false);
    }
}

function stay(){
    if(DCOUNT == 1){
       dealDealer();
    } else {
        if((PLAYERTOT > DEALERTOT && PLAYERTOT < 22) ||
           (DEALERTOT > 21)){
            endGame(true);
        } else if (PLAYERTOT == DEALERTOT && (PLAYERTOT < 22 && DEALERTOT < 22)){
            endGame("tie");
        } else if (DEALERTOT > 21 || (DEALERTOT > PLAYERTOT && DEALERTOT < 22)){
            endGame(false);
        } 
    }
}

function dealDealer(){
    if(DCOUNT == 1){
        var dc2 = getCardFile(DEALER[1]);

        $("#c" + 2).attr("href", dc2);
        $("#c" + 2).css("visibility", "visible");
        DCOUNT++;
    } 
    while(DEALERTOT < 16){
        if(1< DCOUNT <= 3){
            var card = getCard();
            var cardFile = getCardFile(card);
            DEALER.push(card);
            $("#dhc" + (DCOUNT - 1)).attr("href", getCardFile(card));
            $("#dhc" + (DCOUNT - 1)).css("visibility", "visible");
            DEALERTOT += getTot(DEALER) - DEALERTOT;
            DCOUNT++;
        }
    }
    stay();
}

function getTot(array){
    var total = 0;
    for(var i = 0; i < array.length; i++){
        var card = array[i];
        if (card.rank == "ace"){
            total += 11
        } else if((typeof card.rank == "string" && card.rank != "ace") || card.rank == 10){
            total += 10
        } else {
            total += card.rank;
        }
    }
    return total;
}

function endGame(win){
    if (win == true) {
        $("#message").text("You win!");
        funds += bet;
    } else if (win == false) {
        $("#message").text("You lose!");
        funds -= bet;
    } else {
        $("#message").text("Push");
    }
    $("#funds").text("$" + funds);

    setTimeout(resetGame, 5000)
}

function getDeckOfCards() {
    var deck = [];


    for(var suit = 1; suit <= 4; suit ++){
        var suitText = "";
        if (suit == 1){
            suitText = "Diamonds";
        } else if (suit == 2){
            suitText = "Hearts";
        } else if (suit == 3){
            suitText = "Spades";
        } else {
            suitText = "Clubs";
        }
        for(var rank = 1; rank <= 13; rank++){
            var textRank = "";
            if(rank == 11){
                textRank = "Jack";
            } else if (rank == 12){
                textRank = "Queen"
            } else if (rank == 13){
                textRank = "King"
            } else if (rank == 1){
                textRank = "Ace"
            }
            if(rank > 1 && rank < 11){
                var card = {'rank': rank, 'suit': suitText};
            } else {
                var card = {'rank': textRank, 'suit': suitText};
            }
            deck.push(card);
        }
    }
    return deck;
}

function getCard(){
    randNum = Math.floor(Math.random()*DECK.length);
    card = DECK[randNum];
    DECK.splice(randNum, 1);
    return card;
}

function getCardFile(card){
    cardFile = "cards/" + card.suit + "_" + card.rank + ".svg";
    return cardFile;
}

function validateBet() {
    bet = parseInt($("#bet").val());

    if (isNaN(bet) || bet < MIN_BET || bet > funds) {
        return false;
    } else {
        $("#bet").prop("disabled", true);
        return true;
    }
}

function resetGame(){
    DECK = getDeckOfCards();
    PLAYER = []; 
    PLAYERTOT = 0;
    DEALER = [];
    DEALERTOT = 0;
    COUNT = 1;
    DCOUNT = 1;

    bet = 0;

    $(".hitcard").css("visibility", "hidden");
    $(".ddownCard").attr("href", "backs/blue2.svg");
    $(".pdownCard").attr("href", "backs/red2.svg");
    $("#message").text("");
    $("#funds").val(" ");
}