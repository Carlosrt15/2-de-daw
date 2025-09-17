function ejercicio9() {

    let listaPersonas = [
        { nombre: "Carlos", ciudad: "Salamanca", edad: "24" },

    ];

    for (let i = 0; i < 10; i++) {

        let nombre = prompt("Ingresa un nombre " + i);
        let ciudad = prompt("Añade la ciudad " + i);
        let edad = Number(prompt("añade la edad " + i));


        listaPersonas.push({ nombre: nombre, ciudad: ciudad, edad: edad });
        console.log(listaPersonas);

    }

    const ciudades = listaPersonas.map(persona => persona.ciudad);

    alert(ciudades.join(","));


    let ciudadExco = prompt("Elije una ciudad de la antes mencionada");

    for (let persona of listaPersonas) {
        if (persona.ciudad.toLocaleLowerCase() === ciudadExco.toLocaleLowerCase() && persona.edad > 25) {
            console.log(persona.nombre);
        }
    }




}


function ejercicio6() {

    let pedirNumero = Number(prompt("Elije un numero"));

    for(let i = 0; i <11; i++) {

           let resultado = pedirNumero*i; 
        alert("El resultado de "+pedirNumero+ " *  "+i + " es igual a : "+resultado);

    }
}

function gamePapelTijera() {

    
}