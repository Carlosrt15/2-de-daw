function fecha1(){

let fechaNacimiento1 = new Date ("2001-02-14"); 
let fechaNacimiento2 = new Date(2001,1,14); // febrero = 1
alert("fecha 1 :"+fechaNacimiento1.toLocaleDateString("es-ES"));
alert("fecha 2 :"+fechaNacimiento2.toLocaleDateString("es-ES"));

}

function fecha2(){

    let fechaNacimiento1 = new Date("2001-02-14"); 
    let fechaNacimiento2 = new Date(2001,1,14); // febrero = 1

    let dias = ["Domingo","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"];
    let diaSemanaNacimiento = dias[fechaNacimiento1.getDay()];
    console.log("Dia de la semana la cual naci:"+ diaSemanaNacimiento);

        let fechaAhora = new Date();
        let fechaCumpleEsteAño = new Date(fechaNacimiento1); 
        fechaCumpleEsteAño.setFullYear(fechaAhora.getFullYear());

        console.log("Cumpleaños este año:", fechaCumpleEsteAño.toLocaleDateString());


        let diaSemanaEsteAño = dias[fechaCumpleEsteAño.getDay()];
        console.log("Día de la semana del cumpleaños este año:", diaSemanaEsteAño);



        let diferenciaMs = fechaAhora - fechaNacimiento1; // diferencia en milisegundos
     let diferenciaDias = Math.floor(diferenciaMs / (1000 * 60 * 60 * 24)); // convertir a días
     console.log("Días transcurridos desde nacimiento:", diferenciaDias);
 

}

function fecha3() {
    let creaFecha = new Date(2001,11,31,22,0,0);
    // Nota: los meses van de 0 (enero) a 11 (diciembre)
    let fechaDiaMes = creaFecha.getDate();
    console.log(fechaDiaMes);


    creaFecha.setDate(fechaDiaMes + 1);


    console.log("Nueva fecha:", nochevieja.toLocaleString());


}

function fecha4(){
    let ahora = new Date();

//  Fecha y hora completa
console.log(ahora.toString());

//  Solo fecha
console.log(ahora.toDateString());

//  Solo hora
console.log(ahora.toTimeString());

//  Formato ISO
console.log(ahora.toISOString());

//  Fecha en milisegundos desde 1970
console.log(ahora.getTime());


}

function fecha5(){

    let f1 = new Date(2001,1,14);
    let f2 = new Date(2025,0,1);

    if (f1 > f2) {
        console.log("Tu fecha de nacimiento es mayor que el 1 de enero de este año.");
    } else if (f1 < f2) {
        console.log("Tu fecha de nacimiento es menor que el 1 de enero de este año.");
    } else {
        console.log("Tu fecha de nacimiento es exactamente el 1 de enero de este año.");
    }
}