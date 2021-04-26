package es.iesptocruz.victor;

import excepciones.CuentaExcepcion;

public class Cuenta {

    private String nombre;
    private String cuenta;
    private int saldo;
    private double tipoInteres;

    /**
     * Constructor por defecto
     */
    public Cuenta(){

    }

    /**
     * Constructor con parametros
     * @param nom nombre
     * @param cue cuenta
     * @param sal saldo
     * @param tipo tpo de interes
     */
    public Cuenta(String nom, String cue, int sal, double tipo){
        nombre =nom;
        cuenta=cue;
        saldo=sal;
        tipoInteres=tipo;
    }

    /**
     * Metodo que ingresa dinero en la cuenta
     * @param cantidad a ingresar
     * @throws CuentaExcepcion controlado
     */
    public void ingresar(int cantidad) throws CuentaExcepcion {
        if (cantidad < 0)
            throw new CuentaExcepcion("No se puede ingresar una cantidad negativa");
        saldo = saldo + cantidad;
    }

    /**
     * Metodo que retira dinero de la cuenta
     * @param cantidad a extraer
     * @throws CuentaExcepcion controlado
     */
    public void retirar(int cantidad) throws CuentaExcepcion {
        if (cantidad <= 0)
            throw new CuentaExcepcion("No se puede retirar una cantidad negativa");
        if (estado() < cantidad)
            throw new CuentaExcepcion("No se hay suficiente saldo");
        saldo = saldo - cantidad;
    }

    /**
     * Funcion para resolver el saldo de la cuenta
     * @return saldo de la cuenta
     */
    public int estado(){
        return saldo;
    }


    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCuenta() {
        return this.cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public int getSaldo() {
        return this.saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public double getTipoInteres() {
        return this.tipoInteres;
    }

    public void setTipoInteres(double tipoInteres) {
        this.tipoInteres = tipoInteres;
    }

}
