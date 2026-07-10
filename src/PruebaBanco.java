import java.util.Currency;

// Main
public class PruebaBanco {
    public static void main(String[] args){

        // 1. Crear una cuenta
        CuentaBancaria cuenta = new CuentaBancaria("Alan Pablo", 1200);

        // 2.Mostras Informacion de la cuenta
        System.out.println("=====INFORMACION DE LA CUENTA=======");
        System.out.println("Titular: " + cuenta.getTitular());
        System.out.println("Numero de Cuenta: " + cuenta.getNumeroCuenta());
        System.out.println("Saldo inicial: $: " + cuenta.consultarSaldo());

        // 3.Deposito de dinero
        System.out.println("\n ===DEPOSITO===");
        cuenta.depositar(500.0);

        // 4. Retiro de dinero
        System.out.println("\n ===RETIRO===");
        cuenta.retirar(400.0);

        // 5. Intento de retiro mayor al saldo disponible 
        System.out.println("\n ===RETIRO EXCESIVO===");
        cuenta.retirar(2000.0);

        // 6. Mostrar saldo final
        System.out.println("\n=== SALDO FINAL ===");
        System.out.println("Saldo actual: $" + cuenta.consultarSaldo());
    }
}
