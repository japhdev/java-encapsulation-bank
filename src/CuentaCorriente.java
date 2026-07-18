// Clase hija CuentaCorriente
public class CuentaCorriente extends CuentaBancaria {

    // Atributos private
    private double limiteSobregiro = 0;
    private double comisionSobregiro = 50;
    private boolean tieneSobregiro = false;

    // Constructor
    CuentaCorriente(String titular, double saldoInicial, double limiteSobregiro) {
        super(titular, saldoInicial);
        this.limiteSobregiro = limiteSobregiro;
    }

    // METODO SOBREESCRITO retirar
    @Override
    public boolean retirar(double cantidad) {

        // calcular saldo disponible con sobregiro
        double saldoDisponible = getSaldo() + limiteSobregiro;

        // validar cantidad
        if (cantidad <= 0) {
            System.out.println("Cantidad invalida");
            return false;
        }

        // validar limite de sobregiro
        if (cantidad > saldoDisponible) {
            System.out.println("Excedes el limite de sobregiro");
            System.out.println("Saldo disponible con sobregiro" + saldoDisponible);
            return false;
        }

        // validar si el retiro tiene sobregiro
        if (cantidad > getSaldo()) {
            tieneSobregiro = true;
            double usadoSobregiro = cantidad - getSaldo();
            System.out.println("Usando SOBREGIRO ! $: " + usadoSobregiro);
        }

        // retiro
        boolean exito = super.retirar(cantidad);

        // Cobro de comision del sobregiro
        if (exito && tieneSobregiro) {
            System.out.println("Comision por sobregiro $: " + comisionSobregiro);
            super.retirar(comisionSobregiro);
        }

        return exito;

    }

    // METODO SOBREESCRITO aplicarInteres
    @Override
    public void aplicarInteres() {
        System.out.println("cuenta corriente, comision mensual: $ 10.0");
        super.retirar(10.00);
    }

    // METODO restablecerSobregiro
    public void restableserSobregiro() {
        if (tieneSobregiro && getSaldo() >= 0) {
            tieneSobregiro = false;
            System.out.println("Sobregiro restablecido");
        }
    }

    public boolean tieneSobregiro() {
        return tieneSobregiro;
    }

    public double getLimiteSobregiro() {
        return limiteSobregiro;
    }

    public double getComisionSobregiro() {
        return comisionSobregiro;
    }
}
