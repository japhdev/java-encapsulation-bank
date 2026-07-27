/**
 * Representa una cuenta de inversion que hereda de {@code CuentaBancaria}.
 * 
 * @author Josue Alan Pablo Hernandez
 * @version 1.0
 */
public class CuentaInversion extends CuentaBancaria{

    // atributos privados
    private double tasaInteresAnual = 0;
    private int plazoDias = 0;
    private int diasTranscurridos = 0;
    private boolean activa = true;

        /**
     * Crea una nueva cuenta de inversion con un titular, un saldo inicial, tasa de interés anual y un plazo de días
     * de inversion.
     *
     * @param titular           Nombre del titular de la cuenta.
     * @param saldoInicial      Saldo con el que se crea la cuenta.
     * @param tasaInteresAnual  Tasa de interés anual
     * @param plazoDias         Plazo de días
     * 
     */
    public CuentaInversion(String titular, double saldoInicial, double tasaInteresAnual, int plazoDias){

        super(titular, saldoInicial);
        this.tasaInteresAnual = tasaInteresAnual;
        this.plazoDias = plazoDias;
    }



}
