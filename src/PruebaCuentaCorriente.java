public class PruebaCuentaCorriente {
    
    public static void main(String[] args){
        System.out.println("=== CUENTA CORRIENTE ===");

        CuentaCorriente corriente = new CuentaCorriente("Ignacio Garcia", 1000, 500);
        corriente.mostrarInformacion();

        
        System.out.println("\n=== RETIRO NORMAL ===");
        corriente.retirar(200); 
        
        System.out.println("\n=== RETIRO CON SOBREGIRO ===");
        corriente.retirar(900);  
        
        System.out.println("\n=== RETIRO EXCEDE LIMITE DEL SALDO Y EL SOBREGIRO===");
        corriente.retirar(600);
        
        System.out.println("\n=== APLICANDO INTERÉS (COMISIÓN) ===");
        corriente.aplicarInteres();  
        
        System.out.println("\n=== INFORMACION FINAL ===");
        corriente.mostrarInformacion();

    }
}
