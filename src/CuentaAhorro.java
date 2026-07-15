// Clase hija
public class CuentaAhorro extends CuentaBancaria {

    private double tasaInteresAnual;
    private int retirosPermitidos = 3;
    private int retirosRealizados = 0;

    CuentaAhorro(String titular, double saldoInicial, double tasaInteresAnual) {
        super(titular, saldoInicial);
    }

    @Override
    public boolean retirar(double cantidad){
        if (retirosRealizados < retirosPermitidos) {
            super.retirar(cantidad);
            retirosRealizados += 1;
            return true;
        }else{ 
            System.out.println("Excediste el numero de intentos permitido");
            return false;
        }
    }



    
}
