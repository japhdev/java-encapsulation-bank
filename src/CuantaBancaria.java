public class CuantaBancaria {
    
    // Atributos 
    private String numCuenta;
    private double saldo;
    private String titular;

    // Constructor
    CuantaBancaria(String numCuenta, String titular, double saldo){
        this.numCuenta = numCuenta;
        this.titular = titular;
        saldo = 0;
    }

    // Metodos
    public void depositar(double cantidad){
        if(cantidad > 0){
            saldo += cantidad;
        }

    }
    public void retirar(double cantidad){

        if(cantidad > saldo){
            System.out.println("Saldo insuficiente");
        }
        saldo -= cantidad;
        
    }
    double consultarSaldo(){
        return saldo;
    }

}
