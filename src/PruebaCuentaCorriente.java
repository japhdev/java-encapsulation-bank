public class PruebaCuentaCorriente {
    
    public static void main(String[] args){
        System.out.println("=== CUENTA CORRIENTE ===");

        CuentaCorriente corriente = new CuentaCorriente("Ignacio Garcia", 1000, 300);
        corriente.mostrarInformacion();

        System.out.println("\n=== DEPOSITO NORMAL ===");
        corriente.depositar(300);

        System.out.println("\n=== RETIRO NORMAL ===");
        corriente.retirar(200); 
        
        System.out.println("\n=== RETIRO QUE ACTIVA SOBREGIRO ===");
        corriente.retirar(1300);  
        
        System.out.println("\n=== RETIRO EXCEDE LIMITE DEL SALDO Y EL SOBREGIRO ===");
        corriente.retirar(500);

        System.out.println("\n=== CANTIDAD INVALIDA ===");
        corriente.retirar(-50);

        System.out.println("\n === DEPOSITO QUE CUBRE EL SOBREGIRO POR COMPLETO ===");
        corriente.depositar(400);
        corriente.restablecerSobregiro();
        System.out.println("¿Tiene sobregiro activo?: " + corriente.tieneSobregiro());

        System.out.println("\n=== RETIRO NORMAL DESPUES DE CUBRIR SOBREGIRO ===");
        corriente.retirar(50);

        System.out.println("=== TRANSFENCIA ENTRE CUENTAS ===");
        CuentaCorriente destino = new CuentaCorriente("Pablo Hernandez", 500, 100);
        corriente.transferir(destino, 60);
        
        System.out.println("\n=== APLICANDO INTERÉS (COMISIÓN) ===");
        corriente.aplicarInteres();  
        
        System.out.println("\n=== INFORMACION FINAL DE LAS DOS CUENTAS ===");
        corriente.mostrarInformacion();
        destino.mostrarInformacion();

    }
}
