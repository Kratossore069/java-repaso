package es.iesptocruz.victor.api;

import java.util.Objects;

/**
 * Clase usuario que pertenece a la api
 */
public class Usuario {
    String nombre;
    String apellidos;
    int edad;
    String identificador;

    /**
     * Constructor por defecto
     */
    public Usuario() {
    }

    /**
     * Constructor con informacion
     * 
     * @param nombre
     * @param apellidos
     * @param edad
     * @param identificador
     */
    public Usuario(String nombre, String apellidos, int edad, String identificador) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.identificador = identificador;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getIdentificador() {
        return this.identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Usuario)) {
            return false;
        }
        Usuario usuario = (Usuario) o;
        return Objects.equals(nombre, usuario.nombre) && Objects.equals(apellidos, usuario.apellidos)
                && edad == usuario.edad && Objects.equals(identificador, usuario.identificador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellidos, edad, identificador);
    }

    @Override
    public String toString() {
        return "{" + " nombre='" + getNombre() + "'" + ", apellidos='" + getApellidos() + "'" + ", edad='" + getEdad()
                + "'" + ", identificador='" + getIdentificador() + "'" + "}";
    }

}
