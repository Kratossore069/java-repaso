package es.iesptocruz.victor.api;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ruta {
    String identificador;
    String nombre;
    Date fecha;
    int turistas;
    int telefono;
    int distancia;

    public Ruta(String identificador, String nombre, Date fecha, int turistas, int telefono, int distancia) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.fecha = fecha;
        this.turistas = turistas;
        this.telefono = telefono;
        this.distancia = distancia;
    }

    

    /**
     * Constrcutor por defecto
     */
    public Ruta() {
    }

    @Override
    public String toString() {
        return "Ruta [distancia=" + distancia + ", fecha=" + fecha + ", identificador=" + identificador + ", nombre="
                + nombre + ", telefono=" + telefono + ", turistas=" + turistas + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + distancia;
        result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
        result = prime * result + ((identificador == null) ? 0 : identificador.hashCode());
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + telefono;
        result = prime * result + turistas;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Ruta other = (Ruta) obj;
        if (distancia != other.distancia)
            return false;
        if (fecha == null) {
            if (other.fecha != null)
                return false;
        } else if (!fecha.equals(other.fecha))
            return false;
        if (identificador == null) {
            if (other.identificador != null)
                return false;
        } else if (!identificador.equals(other.identificador))
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (telefono != other.telefono)
            return false;
        if (turistas != other.turistas)
            return false;
        return true;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getTuristas() {
        return turistas;
    }

    public void setTuristas(int turistas) {
        this.turistas = turistas;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

}
