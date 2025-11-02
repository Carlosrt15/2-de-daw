
// Dado un array de números, crea uno nuevo con cada número multiplicado por 2.
function ejercicio1() {
    const numeros = [1, 2, 3, 4, 5];

    let numerosx2 = numeros.map(numero => numero * 2);



    const nombres = ["ana", "juan", "pedro", "maria"];

    let mayus = nombres.map(nombre => nombre.toUpperCase());

    const nombres2 = ["sol", "carmen", "leo", "andres", "luz"];

    let masCuatroLetra = nombres2.filter(nombre => nombre.length > 4);

    alert(mayus);
    alert(masCuatroLetra);
    alert(numerosx2);
}


function ejercicio2() {

    const productos = [
        { nombre: "Camiseta", precio: 50 },
        { nombre: "Zapatillas", precio: 120 },
        { nombre: "Pantalón", precio: 200 },
    ];

    let productosMayor = productos.filter(producto => producto.precio > 100);

    let descuentoAplicado = productosMayor.map(producto => {

        return {
            nombre: producto.nombre,
            precioDescuento: producto.precio * 0.9
        };
    });

    alert(JSON.stringify(descuentoAplicado, null, 2));


    //-----------------------------------------------------------------
    //-----------------------------------------------------------------

    // De volver nombres de mas de 18 años edad
    const personas = [
        { nombre: "Luis", edad: 17 },
        { nombre: "María", edad: 22 },
        { nombre: "Carlos", edad: 15 },
        { nombre: "Laura", edad: 19 },
    ];

    let mayoriaEdad = personas.filter(p => p.edad > 18);
    let mayorEdad = mayoriaEdad.map(p => {
        return {
            nombre: p.nombre
        };
    });

    alert(JSON.stringify(mayorEdad));

    //-----------------------------------------------------------------
    //-----------------------------------------------------------------


    // Crea un nuevo array con los cuadrados de los números impares.
    const numeros = [1, 2, 3, 4, 5, 6, 7, 8, 9];

    let numerosImpares = numeros.filter(numero => numero % 2 !== 0);


    let cuadrado = numerosImpares.map(numero => numero * numero);
    alert(cuadrado);





}



function ejercicio3() {
    // Usa reduce para obtener la suma total de los números.
    const numeros = [10, 20, 30, 40];

    let suma = numeros.reduce((a, n) => a + n, 0);
    alert(suma);

    //-----------------------------------------------------------------
    //-----------------------------------------------------------------

    // Calcula el promedio de edades del grupo.
    const grupo = [
        { nombre: "Ana", edad: 18 },
        { nombre: "Pedro", edad: 22 },
        { nombre: "Lucía", edad: 24 },
        { nombre: "Marta", edad: 20 },
    ];



    let mediaEdad = grupo.reduce((a, n) => a + n.edad, 0);

    let mediaFinal = mediaEdad / grupo.length;
    alert(mediaFinal);


    //-----------------------------------------------------------------
    //-----------------------------------------------------------------

    // Usa find para obtener el producto con nombre "Tablet".
    const productos = [
        { nombre: "Laptop", precio: 1000 },
        { nombre: "Tablet", precio: 500 },
        { nombre: "Celular", precio: 700 },
    ];

    const buscar = "Tablet";

    let busqueda = productos.find(producto => producto.nombre.toLowerCase() === buscar.toLowerCase());
    alert(JSON.stringify(busqueda));

    //-----------------------------------------------------------------
    //-----------------------------------------------------------------

    // Usa some y every:
    // - ¿Hay algún número mayor a 100?
    // - ¿Son todos positivos?
    const numeros2 = [10, 20, 30, 150];

    let algunos = numeros2.some(numero => numero > 100 );
    console.log(algunos);

    if(algunos === true) {

        alert("si, algún numero es > 100")
    }else{
        alert("No hay ningun numero > 100")
        
    }

    let positivos = numeros2.every(numero => numero > 0);

    if(positivos === true) {
        alert("Todos los numeros son > 0 ");
    }


}