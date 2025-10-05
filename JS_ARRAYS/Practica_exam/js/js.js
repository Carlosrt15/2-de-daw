let carrito = [
    {id: 0, nombre:"Pan", valor:1, interacciones:0, total:0 },
    {id: 1, nombre:"Leche", valor:2, interacciones:0, total:0 },
    {id: 2, nombre:"Queso", valor:3, interacciones:0, total:0 },
    {id: 3, nombre:"Manzana", valor:0.5, interacciones:0, total:0.5 },

];

let totalAportaciones = 0;
let totalDinero = 0;

carrito.forEach(carr => {
    let boton = document.getElementById(String(carr.id));

    if(boton) {
        boton.addEventListener("click", () => contarPulsar(carr.id));
    }

});

function contarPulsar(id) {
    let carr = carrito.find(o => o.id === id);

    if(carr) {
        carr.interacciones++;
        carr.total = carr.valor * carr.interacciones;

        totalAportaciones = totalAportaciones + 1;
        totalDinero = totalDinero + carr.valor;

        document.getElementById("resultado").innerHTML = " ";
    }
    console.log(carr.nombre+" el nombre"+carr.total+" : en total");

}



function inicializarHtml(){

    let button = document.getElementById("finalizar");
    
        
    button.addEventListener("click", () =>  {

        let lista = carrito.filter(carr  => carr.interacciones > 0);

            
        
        
        let html = "";

        for (let i = lista.length -1; i >= 0; i--) {
            let carr = lista[i];
            html += carr.nombre + "  " + "<br>";
        }

        html += "<br>Precio final: " + totalDinero + " €<br>";
        if (totalAportaciones > 0) {
            let media = (totalDinero / totalAportaciones).toFixed(2);
            html += "Precio medio: " + media + " €/producto";
        }

        document.getElementById("resultado").innerHTML = html;

        totalAportaciones = 0;
        totalDinero = 0;
        carrito.forEach(o => {
                o.interacciones = 0;
                o.total = 0;
        });

});
        

}
       

inicializarHtml();


