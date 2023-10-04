function testArray(){
    var grades = [92,23,32,72,84,34];

    document.getElementById("grades").innerHTML = "Your grades are "+ grades;

    var total = 0;

    for(var i = 0; i < grades.length; i ++){
        total += grades[i];
    }
    var average = total / grades.length;

    document.getElementById("average").innerHTML = "Your average is "+ average;
}

function dealCard(){
    var deck = getDeckOfCards();

    var card = deck[Math.floor(Math.random()*deck.length)];

    document.getElementById("card").innerHTML = "Your card is the " + card.rank + " of " + card.suit;
}

function getDeckOfCards() {
    var deck = [];

    for(var rank = 1; rank <= 13; rank++){
        for(var suit = 1; suit <= 4; suit ++){
            var suitText = "";
            if (suit == 1){
                suitText = "Diamonds";
            } else if (suit == 2){
                suitText = "Heart";
            } else if (suit == 3){
                suitText = "Spades";
            } else {
                suitText = "Clubs";
            }
            var card = {'rank': rank, 'suit': suitText};

            deck.push(card);
        }
    }
    return deck;
}