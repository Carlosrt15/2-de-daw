
import java.util.ArrayList;
import java.util.List;


class CuentaCorriente {
    double saldo = 0.0;

}


class CuentaAhorro {
    double saldo = 0.0;
}

public class Banco {
    public static void main(String[] args) {
        List<Object> cuentas = new ArrayList<>();
            
        cuentas.add( new CuentaCorriente());
        cuentas.add( new CuentaAhorro());


    }
}
