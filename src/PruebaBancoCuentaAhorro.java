public class PruebaBancoCuentaAhorro {
        // Cuenta de Ahorro 
    public static void main(String[] args) {
        CuentaAhorro ahorro = new CuentaAhorro("jose", 1000, 0.04);
        ahorro.mostrarInformacion();
        
        ahorro.retirar(100);  
        ahorro.retirar(100);  
        ahorro.retirar(100);  
        ahorro.retirar(100);  
        
        
    }
}
