
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
         return{
            nombre: p.nombre
         };
    });

    alert(JSON.stringify(mayorEdad));







}