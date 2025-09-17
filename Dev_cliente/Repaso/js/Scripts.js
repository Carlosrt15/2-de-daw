function comprobarNumeros() {
    let numero = Number(prompt("Introduce un número"));

    if (numero < 0) {
        alert("El número es negativo");
    } else if (numero === 0) {
        alert("El número es nulo");
    } else {
        alert("El número es positivo");
    }
}

function conversorEuros() {
    const eurosInput = document.getElementById('euros').value;
    const euros = Number(eurosInput);
    const resultado = document.getElementById('resultado');

    if (isNaN(euros) || eurosInput === "") {
        resultado.textContent = "Por favor, introduce un número.";
    } else {
        const dolares = euros * 1.18;
        resultado.textContent = euros + " euros son " + dolares.toFixed(2) + " dólares.";
    }
}

// Esperamos a que el DOM esté cargado para añadir el evento
document.addEventListener('DOMContentLoaded', () => {
    const boton = document.getElementById('convertirBtn');
    boton.onclick = conversorEuros;
});


// Ejercicio 3

function calcularPrimos() {
    let pedirNumero = Number(prompt("Introduce un numero entre 1 y 99"));


    for (let i = 2; i < pedirNumero; i++) {
        if (pedirNumero % i === 0) {
            alert(pedirNumero + " no es primo");
            return;
        }
    }
    alert(pedirNumero + " es primo");


}