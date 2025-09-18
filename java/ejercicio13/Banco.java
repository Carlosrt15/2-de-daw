import java.util.ArrayList;
import java.util.List;

// Clase base
class Cuenta {
    private double saldo;
    private int numeroCuenta;

    public Cuenta(int numeroCuenta) {
        this.saldo = 0.0;
        this.numeroCuenta = numeroCuenta;
    }

    public void ingresarDinero(double sum) {
        if (sum > 0)
            saldo += sum;
    }

    public void sacarDinero(double sum) {
        if (sum > 0)
            saldo -= sum;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    @Override
    public String toString() {
        return "Numero de cuenta " + numeroCuenta + ": saldo = " + saldo;
    }
}

// CuentaCorriente permite saldo negativo
class CuentaCorriente extends Cuenta {
    public CuentaCorriente(int numero) {
        super(numero);
    }

    @Override
    public void sacarDinero(double sum) {
        if (sum > 0)
            setSaldo(getSaldo() - sum);
    }
}

// CuentaAhorro no permite saldo negativo
class CuentaAhorro extends Cuenta {
    public CuentaAhorro(int numero) {
        super(numero);
    }

    @Override
    public void sacarDinero(double sum) {
        if (sum > 0 && getSaldo() >= sum)
            setSaldo(getSaldo() - sum);
    }
}

// Clase principal
public class Banco {
    public static void main(String[] args) {
        List<Cuenta> cuentas = new ArrayList<>();

        cuentas.add(new CuentaCorriente(1));
        cuentas.add(new CuentaCorriente(2));
        cuentas.add(new CuentaAhorro(3));
        cuentas.add(new CuentaAhorro(4));

        for (Cuenta c : cuentas) {
            c.ingresarDinero(100); // ingresar dinero inicial
        }

        for (Cuenta c : cuentas) {
            c.sacarDinero(150); // intentar retirar dinero
            System.out.println(c);
        }
    }
}
