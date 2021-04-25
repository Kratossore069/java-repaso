package es.iesptocruz.victor;

public class Main {

    public static void main(String[] args) {

        System.out.println(gestionCuenta());
        
    }

    /**
     * Funcion que gestiona una cuenta para hacer una prueba
     * @return informacion de los resultados de la operacion
     */
    public static String gestionCuenta(){
        String informacion=null;
        Cuenta cuenta;
        double saldoActual;

        cuenta = new Cuenta("Antonio López","1000-2365-85-1230456789",2500,0);
        saldoActual = cuenta.estado();
        informacion="El saldo actual es"+ saldoActual;

        try {
            cuenta.retirar(2300);
        } catch (Exception e) {
            informacion="Fallo al retirar";
        }
        try {
            informacion="Ingreso en cuenta";
            cuenta.ingresar(695);
        } catch (Exception e) {
            informacion="Fallo al ingresar";
        }
        return informacion;
    }
}
