public class CuentaBancaria {
    
    // Atributos PRIVATE
    private String numeroCuenta;
    private double saldo;
    private String titular;

    // Constructor
    CuentaBancaria(String numeroCuenta, String titular, double saldo){
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldo;

    }

    // METODO depositar
    public void depositar(double cantidad){
        if(cantidad <= 0){
            System.out.println("deposita minimo $1");
        }
        saldo += cantidad;
            System.out.println("Tu saldo actual es: $" + saldo);

    }

    // METODO retirar (void)
    public void retirar(double cantidad){

        if(tieneSaldoSuficiente(cantidad)){
            saldo -= cantidad;
            System.out.println("Tu saldo actual es: $" + saldo);

            
        }else{System.out.println("Saldo insuficiente. Saldo actual: " + saldo);
            
        }
        
        
        
    }

    // METODO consultarSaldo (double)
    public double consultarSaldo(){
        return saldo;
    }

    // METODO getTitular (String)
    public String getTitular(){
        return titular;
    }

    // METODO getNumeroCuenta (String)
    public String getNumeroCuenta(){
        return numeroCuenta;
    }

    // METODO tieneSaldoSuficiente (boolean)
    public boolean tieneSaldoSuficiente(double cantidad){
        if(saldo >= cantidad){
            return true;
        }
        else{
            return false;
        }
            
    }


}
