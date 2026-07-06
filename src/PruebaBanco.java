import java.util.Currency;

public class PruebaBanco {
    public static void main(String[] args){

        // 1. Crear una cuenta
        CuentaBancaria cuenta = new CuentaBancaria("123-313", "Alan Hernandez", 1000.0);

        // 2.Mostras Informacion de la cuenta
        System.out.println("=====INFORMACION DE LA CUENTA=======");
        System.out.println("Titular: " + cuenta.getTitular());
        System.out.println("Numero de Cuenta: " + cuenta.getNumeroCuenta());
        System.out.println("Saldo inicial: $: " + cuenta.consultarSaldo());


        // Deposito de dinero
        System.out.println("\n ===DEPOSITO==");
        cuenta.depositar(500.0);
    }
}
