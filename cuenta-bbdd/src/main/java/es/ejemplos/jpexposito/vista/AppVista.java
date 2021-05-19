package es.ejemplos.jpexposito.vista;

import java.util.Scanner;

import es.ejemplos.jpexposito.controlador.CuentaControlador;
import es.ejemplos.jpexposito.exception.PersistenciaException;

public class AppVista  {
    
    public static void main( String[] args ){
        CuentaControlador cuentaControlador=new CuentaControlador();
        Scanner sc=new Scanner(System.in);
        int option=9;
        do {
            System.out.println("1: Añadir un alumno");
            System.out.println("2: Eliminar un alumno");
            System.out.println("3: Buscar un alumno");
            System.out.println("4: Modificar un alumno");
            System.out.println("0: Salir");
            option=sc.nextInt();

            if(option!=0){
                switch(option){
                    // case 1:
                    // cuentaControlador.añadirAlumno();
                    // break;
                    default:
                    System.out.println("Solo del 0 al 4");
                    break;
                }
            }
        } while (option!=0);
    }
}
