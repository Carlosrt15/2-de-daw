function ejercicio6() {

    let notas = [7,3,4,6,8,6,3,6.3,5,7.5,9,10,3.5,2.5,5.5];
    console.log(notas.length);

    let aprobados = notas.filter(nota => nota >= 5);

    alert(notas);
    alert(aprobados);

    // Buscar la posicion 

    let posicion1 = notas.findIndex(nota => nota == 5.5);
    console.log(posicion1);

    let posicion2 = aprobados.findIndex(aprobado => aprobado == 5.5);
    console.log(posicion2);

    alert(aprobados);

    // Comprobar aprobados

     let comprobarAprobado = notas.every(nota => nota[0] >= 5);
    console.log(comprobarAprobado);

}