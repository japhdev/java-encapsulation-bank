/**
 * Representa una cuenta corriente que hereda de {@code CuentaBancaria}.
 *
 * Sobrescribe el comportamiento del retiro y la aplicación de intereses,
 * además de proporcionar operaciones relacionadas con el manejo del
 * sobregiro.
 * 
 * @author Josue Alan Pablo Hernandez
 * @version 1.0
 */
public class CuentaCorriente extends CuentaBancaria {

    // Atributos privados
    private double limiteSobregiro = 0;
    private double comisionSobregiro = 50;
    private boolean tieneSobregiro = false;

    /**
     * Crea una nueva cuenta corriente con un titular, un saldo inicial y un limite
     * de sobregiro.
     *
     * @param titular         Nombre del titular de la cuenta.
     * @param saldoInicial    Saldo con el que se crea la cuenta.
     * @param limiteSobregiro Limite de sobregiro permitido.
     * 
     */
    CuentaCorriente(String titular, double saldoInicial, double limiteSobregiro) {
        super(titular, saldoInicial);
        this.limiteSobregiro = limiteSobregiro;
    }

    /**
     * Sobrescribe el método de retiro para validar el limite de sobregiro.
     * 
     * Si el saldo es insuficiente, utiliza el sobregiro hasta el limite permitido y
     * aplica una comision cuando corresponde.
     *
     * @param cantidad Monto a retirar. Debe ser mayor que cero.
     * @return {@code true} si el retiro se realiza correctamente;
     *         {@code false} si el monto es invalido o excede el limite de
     *         sobregiro.
     */
    @Override
    public boolean retirar(double cantidad) {

        double saldoDisponible = getSaldo() + limiteSobregiro;
        if (cantidad <= 0) {
            System.out.println("Cantidad invalida");
            return false;
        }

        if (cantidad > saldoDisponible) {
            System.out.println("Excedes el limite de sobregiro");
            System.out.println("Saldo disponible con sobregiro" + saldoDisponible);
            return false;
        }

        if (cantidad > getSaldo()) {
            tieneSobregiro = true;
            double usadoSobregiro = cantidad - getSaldo();
            System.out.println("Usando SOBREGIRO ! $: " + usadoSobregiro);
        }

        boolean exito = super.retirar(cantidad);

        if (exito && tieneSobregiro) {
            System.out.println("Comision por sobregiro $: " + comisionSobregiro);
            super.retirar(comisionSobregiro);
        }

        return exito;

    }

    /**
     * Sobrescribe el método de aplicación de intereses.
     *
     * Se aplica una comision fija en una cuenta corriente.
     */
    @Override
    public void aplicarInteres() {
        System.out.println("cuenta corriente, comision mensual: $ 10.0");
        super.retirar(10.00);
    }

    /**
     * Restablece el sobregiro de la cuenta.
     */
    public void restablecerSobregiro() {
        if (tieneSobregiro && getSaldo() >= 0) {
            tieneSobregiro = false;
            System.out.println("Sobregiro restablecido");
        }
    }

    /**
     * Indica si la cuenta está utilizando el sobregiro.
     *
     * @return {@code true} si la cuenta tiene un sobregiro activo;
     *         {@code false} en caso contrario.
     */
    public boolean tieneSobregiro() {
        return tieneSobregiro;
    }

    /**
     * Obtiene el limite de sobregiro de la cuenta.
     *
     * @return Limite de sobregiro.
     */
    public double getLimiteSobregiro() {
        return limiteSobregiro;
    }

    /**
     * Obtiene la comision aplicada por el uso del sobregiro.
     *
     * @return Comision de sobregiro.
     */
    public double getComisionSobregiro() {
        return comisionSobregiro;
    }
}
