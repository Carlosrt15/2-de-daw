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