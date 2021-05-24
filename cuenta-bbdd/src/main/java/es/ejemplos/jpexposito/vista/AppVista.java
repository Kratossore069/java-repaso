package es.ejemplos.jpexposito.vista;

import java.util.Scanner;

import es.ejemplos.jpexposito.api.Cuenta;
import es.ejemplos.jpexposito.controlador.CuentaControlador;
import es.ejemplos.jpexposito.exception.PersistenciaException;

public class AppVista {
    CuentaControlador cuentaControlador;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws PersistenciaException {
        CuentaControlador controlador = new CuentaControlador();
        System.out.println(
                "Ingrese un número para operar:\n1- Añadir alumno\n2- Eliminar alumno\n3- Buscar alumno\n4- Actualizar alumno\n0- Salir de la aplicación");
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                Cuenta cuentaNueva=pedirDatos();
                controlador.aniadirCuenta(cuentaNueva);
                break;
            case 2:
                Cuenta cuentaEliminar=pedirDatos();
                controlador.eliminarCuenta(cuentaEliminar);
                break;
            case 3:
                Cuenta cuentaBuscar=pedirDatos();
                controlador.buscarCuenta(cuentaBuscar);
                break;
            case 4:
                Cuenta cuentaActualizar=pedirDatos();
                controlador.actualizaCuenta(cuentaActualizar);
                break;
            case 0:
                break;
        }
    }

    /**
     * Funcion que ingresa datos
     * 
     * @return los datos recibidos
     */
    public static Cuenta pedirDatos() {
        System.out.println("Codigo: ");
        String codigo = sc.nextLine();
        System.out.println("Nombre del cliente: ");
        String nombre = sc.nextLine();
        System.out.println("Email: ");
        String email = sc.nextLine();
        System.out.println("Saldo: ");
        double saldo = sc.nextDouble();
        return new Cuenta(codigo, nombre, email, saldo);
    }

    /**
     * Funcion que pide datos para eliminar
     * @return codigo para eliminar de la bbdd
     */
    public static String buscarCodigo(){
        System.out.println("Codigo: ");
        String codigo = sc.nextLine();
        return codigo;
    }
}
