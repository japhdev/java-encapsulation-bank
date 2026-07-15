import java.util.Currency;

// Main
public class PruebaBanco {
    public static void main(String[] args){

        // 1. Creacion de 2 cuentas
        CuentaBancaria cuenta1 = new CuentaBancaria("Alan Pablo", 1000);
        CuentaBancaria cuenta2 = new CuentaBancaria("Josue Hernandez", 500);


        // 2.Mostras informacion inicial
        cuenta1.mostrarInformacion();
        cuenta2.mostrarInformacion();

        // 3.Deposito de dinero
        System.out.println("\n ===DEPOSITO===");
        cuenta1.depositar(500.0);

        // 4. Retiro de dinero
        System.out.println("\n ===RETIRO===");
        cuenta1.retirar(400.0);

        // 5. Intento de retiro mayor al saldo disponible 
        System.out.println("\n ===RETIRO EXCESIVO===");
        cuenta1.retirar(2000.0);

        // 6. Transferir    
        System.out.println("\n===TRANSFERENCIA===");
        cuenta1.transferir(cuenta2, 300);


        // 7. Mostrar estado final
        System.out.println("\n=== ESTADO FINAL ===");
        cuenta1.mostrarInformacion();
        cuenta2.mostrarInformacion();
    }
}
