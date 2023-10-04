function calculatepH(){
    var concentration = document.getElementById('concentration').value;
    var sigFigs = document.getElementById('sigfig').value;

    var pH = 0 - Math.log10(concentration);

    if(pH > 0){
        sigFigs -= 1;
    } else if(pH >= 10){
        sigFigs -= 2;
    }

    if(sigFigs < 0){
        sigFigs = 0;
    }

    pH = pH.toFixed(sigFigs);
    document.getElementById("pH").innerHTML = pH;
}

function idealGas(){
    var unknown = document.getElementById('variable').value;
    
}