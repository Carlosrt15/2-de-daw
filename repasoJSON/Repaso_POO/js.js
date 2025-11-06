class contador {
    constructor(valorInicial = 0) {
        this._valor = valorInicial;

    }

    incrementar() {
        this._valor++;
    }

    decrementar() {
        this._valor--;
    }
    set valor(nuevoValor) {
        this._valor = nuevoValor;
    }

    get valor() {
        return this._valor;
    }


}

// Ejercicio 2


class Cuenta {
    constructor(ingreso = 0, reintegro = 0, transferencia = 0) {
        this._ingreso = ingreso;
        this._reintegro = reintegro;
        this._transferencia = transferencia;
    }


    get ingreso() {
        return this._ingreso;
    }

    get reintegro() {
        return this._reintegro;
    }

    get transferencia() {
        return this._transferencia;
    }

    //  Setters
    set ingreso(valor) {
        this._ingreso = valor;
    }

    set reintegro(valor) {
        this._reintegro = valor;
    }

    set transferencia(valor) {
        this._transferencia = valor;
    }
}


let miCuenta = new Cuenta();


function ejercicio2() {
    let input = prompt("Ingresa una cantidad");
    let cantidad = Number(input);

    if (isNaN(cantidad)) {
        alert("Eso no es un número válido");

    }


    let confirmar = confirm("La cantidad es para ingresar(Aceptar), transeferencia(Cancelar)");

    

    if (confirmar === true) {

        miCuenta.ingreso = cantidad;
        miCuenta._reintegro += cantidad;
    } else {


        miCuenta._transferencia = cantidad
        miCuenta.reintegro -= cantidad;

    }

    alert(miCuenta._ingreso);
    alert(miCuenta._reintegro);
    alert(miCuenta._transferencia);


}