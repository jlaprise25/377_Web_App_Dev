function calculatepH(){
    var concentration = document.getElementById('concentration').value;
    var sigFigs = document.getElementById('pHsigfig').value;

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

function specificHeat(){
    var m = document.getElementById('mass').value;
    var c = document.getElementById('heatCapacity').value;
    var tI = document.getElementById('ti').value;
    var tF = document.getElementById('tf').value;

    var dT = tF - tI;
    var heat = m*c*dT;
    document.getElementById("heat").innerHTML = heat;
}

function convertTemp(){
    var c = document.getElementById('celcius');
    var k = c + 273.15;
    document.getElementById("kelvin").innerHTML = k;
}