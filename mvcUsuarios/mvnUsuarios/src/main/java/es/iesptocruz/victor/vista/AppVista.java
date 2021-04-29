package es.iesptocruz.victor.vista;

import java.util.Scanner;

import es.iesptocruz.victor.api.Usuario;
import es.iesptocruz.victor.controlador.UsuarioControlador;

/**
 * Clase encargada de realizar la tarea encargada
 */
public class AppVista {
    static UsuarioControlador usuarioControlador;
    static Usuario nuevoUsuario;

    public AppVista() {
        usuarioControlador = new UsuarioControlador();
    }

    public static void main(String[] args) {
        System.out.println("Introduzca una opcion para trabajar: ");
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        while (!salir) {

            System.out.println("1. Crear un usuario");
            System.out.println("2. Opcion 2");
            System.out.println("3. Opcion 3");
            System.out.println("4. Salir");

            try {

                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();

                switch (opcion) {
                case 1:
                    System.out.println("Nombre: ");
                    String nombre = sn.nextLine();
                    System.out.println("Apellido: ");
                    String apellido = sn.nextLine();
                    System.out.println("Edad: ");
                    int edad = sn.nextInt();
                    System.out.println("Identificador: (texto)");
                    String identificador = sn.nextLine();
                    nuevoUsuario = new Usuario(nombre, apellido, edad, identificador);
                    usuarioControlador.insertar(nuevoUsuario);
                    break;
                case 2:
                    System.out.println("Has seleccionado la opcion 2");
                    break;
                case 3:
                    System.out.println("Has seleccionado la opcion 3");
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Solo números entre 1 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
    }
}
