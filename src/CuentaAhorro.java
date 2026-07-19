/**
 * Cuenta de ahorro que hereda de {@code CuentaBancaria}.
 *
 * Sobrescribe el comportamiento del retiro y la aplicación de intereses,
 * además de proporcionar métodos para consultar la tasa de interés anual
 * y los retiros restantes.
 */
public class CuentaAhorro extends CuentaBancaria {

    //Atributos privados
    private double tasaInteresAnual;
    private int retirosPermitidos = 3;
    private int retirosRealizados = 0;

    /**
     * Crea una nueva cuenta de ahorro con un titular, un saldo inicial y tasa de interés anual.
     *
     * @param titular Nombre del titular de la cuenta.
     * @param saldoInicial Saldo con el que se crea la cuenta.
     * @param tasaInteresAnual Tasa de interés anual.
     * 
     */
    CuentaAhorro(String titular, double saldoInicial, double tasaInteresAnual) {
        super(titular, saldoInicial);
        this.tasaInteresAnual= tasaInteresAnual;
    }

    /**
     * Sobrescribe el método de retiro para limitar el número de retiros permitidos.
     *
     * @param cantidad Monto a retirar. Debe ser mayor que cero.
     * @return {@code true} si el retiro se realiza correctamente dentro del
     *         límite de retiros permitidos; {@code false} si se excede dicho límite.
     */
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
    /**
     * Sobrescribe el método de aplicación de intereses.
     *
     * Este método calcula el interés mensual, lo deposita en la cuenta
     * y reinicia el contador de retiros realizados.
     */
    @Override
    public void aplicarInteres(){

        double interes = getSaldo() * (tasaInteresAnual / 12);

        System.out.println("Aplicando interes mensual");
        depositar(interes);

        retirosRealizados = 0;
        System.out.println("Contador de retiros reiniciado..");
    }
    
    /**
     * Obtiene los retiros restantes.
     *
     * @return Retiros restantes.
     */
    public int getRetirosRestantes() {
        return retirosPermitidos - retirosRealizados;
    }
    
    /**
     * Obtiene la tasa de interés anual.
     *
     * @return Tasa de interés anual.
     */  
    public double getTasaInteresAnual() {
        return tasaInteresAnual;
    }
}
