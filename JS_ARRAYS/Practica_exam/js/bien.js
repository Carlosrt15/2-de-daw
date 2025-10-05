let carrito = [
    {id: 0, nombre:"Pan", valor:1, interacciones:0, total:0 },
    {id: 1, nombre:"Leche", valor:2, interacciones:0, total:0 },
    {id: 2, nombre:"Queso", valor:3, interacciones:0, total:0 },
    {id: 3, nombre:"Manzana", valor:0.5, interacciones:0, total:0 },
    {id: 4, nombre:"Limón", valor:25, interacciones:0, total:0 },
];

let totalAportaciones = 0;
let totalDinero = 0;

// Vincular botones de añadir producto
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
        totalAportaciones++;
        totalDinero += carr.valor;

        document.getElementById("resultado").innerHTML = " ";
    }
    console.log(carr.nombre+" → "+carr.total+" € en total");
}

// 👉 Función para mostrar el resumen final
function finalizarCompra() {
    let lista = carrito.filter(carr  => carr.interacciones > 0);
    let html = "";

    for (let i = lista.length -1; i >= 0; i--) {
        let carr = lista[i];
        html += carr.nombre + " ("+carr.interacciones+" uds)<br>";
    }

    html += "<br>Precio final: " + totalDinero + " €<br>";
    if (totalAportaciones > 0) {
        let media = (totalDinero / totalAportaciones).toFixed(2);
        html += "Precio medio: " + media + " €/producto";
    }

    document.getElementById("resultado").innerHTML = html;

    // Reiniciar datos
    totalAportaciones = 0;
    totalDinero = 0;
    carrito.forEach(o => {
        o.interacciones = 0;
        o.total = 0;
    });
}

// 👉 Función para mostrar solo productos con total >20€
function filtrarMayores20() {
    let lista = carrito.filter(carr => carr.total > 20);
    let html = "<h3>Productos con total > 20 €</h3>";

    if(lista.length === 0){
        html += "No hay productos con más de 20 € en total.";
    } else {
        lista.forEach(carr => {
            html += carr.nombre + ": " + carr.interacciones + 
                    " x " + carr.valor + "€ = " + carr.total + "€<br>";
        });
    }
    
    document.getElementById("resultado").innerHTML = html;
}

// 👉 Inicializar eventos
function inicializarHtml(){
    let buttonFinalizar = document.getElementById("finalizar");
    let buttonFiltrar = document.getElementById("filtrar20");

    buttonFinalizar.addEventListener("click", finalizarCompra);
    buttonFiltrar.addEventListener("click", filtrarMayores20);
}

inicializarHtml();
