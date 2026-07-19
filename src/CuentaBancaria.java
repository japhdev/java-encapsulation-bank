/**
 * Cuenta bancaria (clase padre) con operaciones básicas como
 * depósito, retiro, transferencia, consulta de saldo y
 * visualización de información.
 *
 * @author Alan Hernández
 * @version 1.1
 */
public class CuentaBancaria {

    // Atributos privados.
    private double saldo;
    private String titular;
    private String numeroCuenta;

    /**
     * Crea una nueva cuenta bancaria con un titular y un saldo inicial.
     *
     * El numero de cuenta se genera automaticamente.
     *
     * @param titular Nombre del titular de la cuenta.
     * @param saldoInicial Saldo con el que se crea la cuenta.
     */
    CuentaBancaria(String titular, double saldoInicial) {
        this.numeroCuenta = "CTA-" + (int) (Math.random() * 10000); // Solo para prueba *pendiente de modificar
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    /**
     * Realiza un deposito de dinero a la cuenta bancaria.
     *
     * @param cantidad Monto a depositar. Debe ser mayor que cero.
     * @return true si el depósito fue exitoso; false si la cantidad es inválida.
     */
    public boolean depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("Numero de Cuenta: " + numeroCuenta);
            System.out.println("Deposito exitoso: $" + cantidad);
            System.out.println("Nuevo Saldo: $" + saldo);
            return true;
        } else {
            System.out.println("Numero de Cuenta: " + numeroCuenta);
            System.out.println("Cantidad invalida para el deposito.");
            return false;
        }
    }

    /**
     * Realiza un retiro de dinero de la cuenta bancaria.
     *
     * @param cantidad Monto a retirar. Debe ser mayor que cero.
     * @return {@code true} si el retiro se realiza correctamente;
     *         {@code false} si el monto es inválido o el saldo es insuficiente.
     */
    public boolean retirar(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("Cantidad invalida para el retiro.");
            return false;
        }

        if (tieneSaldoSuficiente(cantidad)) {
            saldo -= cantidad;
            System.out.println("Numero de Cuenta: " + numeroCuenta);
            System.out.println("Retiro exitoso: $" + cantidad);
            System.out.println("Nuevo saldo: $" + saldo);
            return true;
        } else {
            System.out.println("Numero de Cuenta: " + numeroCuenta);
            System.out.println("Saldo insuficiente. Saldo actual: " + saldo);
            return false;
        }
    }

    /**
     * Transfiere una cantidad de dinero de una cuenta hacia otra cuenta bancaria.
     *
     * La transferencia solo se realiza si la cuenta de destino es diferente
     * y la cuenta de origen dispone de saldo suficiente.
     *
     * @param destino  Cuenta bancaria que recibirá el dinero.
     * @param cantidad Monto a transferir. Debe ser mayor que cero.
     */
    public void transferir(CuentaBancaria destino, double cantidad) {

        if (this == destino) {
            System.out.println("No se puede transferir a la misma cuenta!");
            return;
        }

        if (this.retirar(cantidad)) {
            destino.depositar(cantidad);
            System.out.println("==========================");
            System.out.println("Transferencia exitosa: $" + cantidad);
            System.out.println("De: " + this.getTitular() + " (" + this.getNumeroCuenta() + ")");
            System.out.println("A: " + destino.getTitular() + " (" + destino.getNumeroCuenta() + ")");
        } else {
            System.out.println("No se completo la transferencia");
        }
    }

    /**
     * Verifica si la cuenta tiene saldo suficiente para una operacion.
     *
     * @param cantidad Monto que se desea validar.
     * @return {@code true} si el saldo es mayor o igual al monto indicado;
     *         {@code false} en caso contrario.
     */
    public boolean tieneSaldoSuficiente(double cantidad) {
        return saldo >= cantidad;
    }

    /**
     * Muestra en la consola la información de la cuenta bancaria,
     * incluyendo el titular, el número de cuenta y el saldo actual.
     */
    public void mostrarInformacion() {
        System.out.println("==========================");
        System.out.println("=INFORMACION DE LA CUENTA=");
        System.out.println("==========================");
        System.out.println("Titular: " + titular);
        System.out.println("Numero de Cuenta: " + numeroCuenta);
        System.out.println("Saldo: " + saldo);
        System.out.println("==========================");
    }

    /**
     * Aplica intereses al saldo de la cuenta.
     *
     * Este metodo esta pensado para ser sobrescrito por las clases hijas.
     */
    public void aplicarInteres() {
        System.out.println("Esta cuenta no genera interes...");
    }

    /**
     * Obtiene el nombre del titular de la cuenta.
     *
     * @return Nombre del titular.
     */
    public String getTitular() {
        return titular;
    }

    /**
     * Obtiene el numero de cuenta bancaria.
     *
     * @return Numero de cuenta.
     */
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     * Obtiene el valor del atributo saldo.
     *
     * @return Saldo actual de la cuenta.
     */
    public double getSaldo() {
        return saldo;
    }

}
