package es.iesptocruz.victor.vista;

import java.util.InputMismatchException;
import java.util.Scanner;

import es.iesptocruz.victor.api.Usuario;
import es.iesptocruz.victor.controlador.UsuarioControlador;
import es.iesptocruz.victor.exceptions.UsuarioException;

public class AppVista {

    /**
     * Atributos que utilizara la clase main
     */
    static UsuarioControlador usuarioControlador;
    static Usuario nuevoUsuario;
    static String nombre = null;
    static String apellido = null;
    static int edad = 0;
    static String identificador = null;
    static Scanner sn;

    /**
     * Constructor por defecto de la clase
     */
    public AppVista() {
        usuarioControlador = new UsuarioControlador();
        sn = new Scanner(System.in);
    }

    public static void main(String[] args) throws UsuarioException {

        System.out.println("Introduzca una opcion para trabajar: ");
        sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        while (!salir) {

            System.out.println("1. Crear un usuario");
            System.out.println("2. Eliminar usuario");
            System.out.println("3. Buscar usuario");
            System.out.println("4. Mostrar usuario");

            try {

                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        introducirDatos();
                        usuarioControlador.insertar(introducirDatos());
                        break;
                    case 2:
                        introducirDatos();
                        usuarioControlador.eliminar(introducirDatos());
                        break;
                    case 3:
                        introducirDatos();
                        usuarioControlador.buscar(introducirDatos());
                        break;
                    case 4:
                        System.out.println("Introduzca el identificador del usuario: ");
                        String id = sn.nextLine();
                        usuarioControlador.mostrar(id);
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

    /**
     * Funcion que retorna un usuario creado
     * 
     * @return usuario creado
     */
    public static Usuario introducirDatos() {
        
        System.out.println("Nombre: ");
        nombre = sn.nextLine();sn.nextInt();
        System.out.println("Apellido: ");
        apellido = sn.nextLine();sn.nextInt();
        System.out.println("Edad: ");
        edad = sn.nextInt();
        System.out.println("Identificador: (texto)");
        identificador = sn.nextLine();sn.nextInt();

        return new Usuario(nombre, apellido, edad, identificador);
    }
}
