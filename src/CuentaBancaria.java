public class CuentaBancaria {

    // Atributos PRIVATE
    private double saldo;
    private String titular;
    private String numeroCuenta;
    

    // Constructor
    CuentaBancaria( String titular, double saldoInicial) {
        this.numeroCuenta = "CTA-" + (int)(Math.random() * 10000); // Solo para prueba *pendiente de modificar
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    // METODO depositar
    public boolean depositar(double cantidad) {
        if (cantidad > 0) {     
            saldo += cantidad;
            System.out.println("Deposito exitoso: $" + cantidad);
            System.out.println("Nuevo Saldo: $" + saldo);
            return true;
        } else {
            System.out.println("Cantidad invalida para el deposito.");
            return false;
        }
    }

    // METODO retirar 
    public boolean retirar(double cantidad) {
        if(cantidad <= 0) {
            System.out.println("Cantidad invalida para el retiro.");
            return false;
        }

        if (tieneSaldoSuficiente(cantidad)) {
            saldo -= cantidad;
            System.out.println("Retiro exitoso: $" + cantidad);
            System.out.println("Nuevo saldo: $" + saldo);
            return true;
        } else {
            System.out.println("Saldo insuficiente. Saldo actual: " + saldo);
            return false;
        }
    }

    // METODO transferir
    public void transferir(CuentaBancaria destino, double cantidad) {

        if(this.retirar(cantidad )) {
            destino.depositar(cantidad);
            System.out.println("Transferencia exitosa: $" + cantidad);
            System.out.println("De: " + this.getTitular() + " (" + this.getNumeroCuenta() + ")");
            System.out.println("A: " + destino.getTitular() + " (" + destino.getNumeroCuenta() + ")");
        }else{
            System.out.println("No se completo la transferencia");
        }
    }

    // METODO tieneSaldoSuficiente (boolean)
    public boolean tieneSaldoSuficiente(double cantidad) {
        return saldo >= cantidad;
    }
    //METODO mostrarInformacion
    public void mostrarInformacion(){
        System.out.println("==========================");
        System.out.println("=INFORMACION DE LA CUENTA=");
        System.out.println("==========================");
        System.out.println("Titular: " + titular);
        System.out.println("Numero de Cuenta: " + numeroCuenta);
        System.out.println("Saldo: " + saldo);
        System.out.println("==========================");
    }
    
    //METODO aplicarInteres (pendiente)
    public void aplicarInteres(){
        System.out.println("Esta cuenta no genera interes...");
    }

    // METODO consultarSaldo (double)
    public double consultarSaldo() {
        return saldo;
    }

    // METODO getTitular (String)
    public String getTitular() {
        return titular;
    }

    // METODO getNumeroCuenta (String)
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

}
