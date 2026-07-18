public class PruebaBancoCuentaAhorro {
        // Cuenta de Ahorro 
    public static void main(String[] args) {
        System.out.println("=== CUENTA DE AHORRO ===\n");

        CuentaAhorro ahorro = new CuentaAhorro("jose", 1000, 0.04);
        ahorro.mostrarInformacion();
        
        System.out.println("=== Retiros solo 3 permitidos. ===\n");
        ahorro.retirar(100);  
        ahorro.retirar(100);  
        ahorro.retirar(100);  
        ahorro.retirar(100);  // debe de rechazar el cuarto retiro
        
        System.out.println("\n=== APLICANDO INTERÉS ===");
        ahorro.aplicarInteres();  // Reinicia el contador

        System.out.println("\n=== RETIRO DESPUÉS DEL INTERÉS ===");
        ahorro.retirar(100); 

        System.out.println("\n=== ESTADO FINAL ===");
        ahorro.mostrarInformacion();
    }
}
