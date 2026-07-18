// Clase hija CuentaAhorro
public class CuentaAhorro extends CuentaBancaria {

    private double tasaInteresAnual;
    private int retirosPermitidos = 3;
    private int retirosRealizados = 0;

    CuentaAhorro(String titular, double saldoInicial, double tasaInteresAnual) {
        super(titular, saldoInicial);
        this.tasaInteresAnual= tasaInteresAnual;
    }

    @Override
    public boolean retirar(double cantidad) {
        if (retirosRealizados < retirosPermitidos) {
            super.retirar(cantidad);
            retirosRealizados += 1;
            return true;
        } else {
            System.out.println("Excediste el numero de intentos permitido");
            return false;
        }
    }

    @Override
    public void aplicarInteres(){

        //Calcular interes mensual
        double interes = getSaldo() * (tasaInteresAnual / 12);

        // Deposito del interes
        System.out.println("Aplicando interes mensual");
        depositar(interes);

        // Reinicio de contasdor de retiros 
        retirosRealizados = 0;
        System.out.println("Contador de retiros reiniciado..");
    }
    
    public int getRetirosRestantes() {
        return retirosPermitidos - retirosRealizados;
    }
    
    
    public double getTasaInteresAnual() {
        return tasaInteresAnual;
    }
}
