package es.iesptocruz.victor;

import excepciones.NumeroExceptions;

public class Calculadora {

    // public static void main(String[] args) {
    //     System.out.println(division(4,0));
    // }

    /**
     * Division de la calculadora
     * 
     * @param dividendo de la operacion
     * @param divisor   de la operacion
     * @return resultado
     * @throws Exceptions si no es posible dividir entre 0
     */
    public int division(int dividendo, int divisor) throws NumeroExceptions {
        int resultado=0;
        if(divisor<=0){
            throw new NumeroExceptions("No se puede dividir entre 0");
        }else{
            resultado = dividendo / divisor;
        }
        return resultado;
    }

}
