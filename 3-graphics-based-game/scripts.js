var DECK = getDeckOfCards();
var DEALT = []; 

function startGame(){
    var cardFile = "";
    var card = "";
    
    for(var i = 0; i < 4; i++){
        randNum = Math.floor(Math.random()*DECK.length);
        DEALT.push(randNum);
        card = DECK[randNum];
        cardFile = "cards/" + card.suit + "_" + card.rank + ".svg";
        
        $("#c" + (i+1)).attr("href", cardFile);

        console.log(cardFile);
        DECK.splice(randNum, 1);
    }
}

function dealCard(){
    // var deck = getDeckOfCards();
    
    

    // $("card").attr("href", cardFile);
    
    // console.log(DECK.length);
    // console.log(DECK);

    // $("#card").text("Your card is the " + card.rank + " of " + card.suit + ". Card number: " + randNum);
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