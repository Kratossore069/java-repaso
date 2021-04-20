package es.iesptocruz.victor.controlador;

import java.util.HashMap;

import es.iesptocruz.victor.api.Usuario;
import es.iesptocruz.victor.exceptions.UsuarioException;
import es.iesptocruz.victor.modelo.UsuarioModelo;

public class UsuarioControlador {
    UsuarioModelo userModelo;
    HashMap<String, Usuario> lista;

    /**
     * Constructor por defecto
     */
    public UsuarioControlador() {
        userModelo = new UsuarioModelo();
        lista=new HashMap<>();
    }

    /**
     * Valida los parametros de entrada
     * @param usuario
     * @throws UsuarioException error controlado
     */
    public void validar(Usuario usuario) throws UsuarioException{
        String mensaje="";

        if(usuario==null){
            mensaje="Usuario nulo";
            throw new UsuarioException(mensaje);
        }
        if(usuario.getIdentificador()==null){
            mensaje="Identificador vacio ";
        }
        if(usuario.getNombre().isEmpty()){
            mensaje+="El nombre es nulo o vacio ";
        }
        if(usuario.getEdad()<18){
            mensaje+="No se admiten menores de edad ";
        }
        if(!mensaje.isEmpty()){
            throw new UsuarioException(mensaje);
        }
    }

    /**
     * Insertar un usuario
     * 
     * @param usuario a insertar
     * @throws UsuarioException error controlado
     */
    public void insertar(Usuario usuario) throws UsuarioException {
        validar(usuario);
        lista.put(usuario.getIdentificador(), usuario);
    }

    /**
     * Eliminar un usuario
     * 
     * @param usuario a eliminar
     * @throws UsuarioException error controlado
     */
    public void eliminar(Usuario usuario) throws UsuarioException {
        validar(usuario);
        lista.remove(usuario.getIdentificador(), usuario);
    }

    /**
     * Modificar un usuario
     * 
     * @param usuario a modificar
     * @throws UsuarioException error controlado
     */
    public void modificar(Usuario usuario) throws UsuarioException {
        validar(usuario);
    }

    /**
     * Buscar un usuario
     * 
     * @param usuario a buscar
     * @throws UsuarioException error controlado
     */
    public void buscar(Usuario usuario) throws UsuarioException {
        if (usuario.getIdentificador() == null) {
            throw new UsuarioException("Identificador nulo");
        }
    }

    /**
     * Mostrar un usuario
     * 
     * @param usuario a mostrar
     * @throws UsuarioException error controlado
     */
    public void mostrar(Usuario usuario) throws UsuarioException {
        if (usuario.getIdentificador() == null) {
            throw new UsuarioException("Identificador nulo");
        }
    }

    /**
     * Funcion que muestra todos los usuarios registrados
     * @return lista en String
     */
    public String mostrarTodo() {
        String resultado="";
        for (String codigo: lista.keySet()) {
            String key = codigo;
            String value = lista.get(codigo).toString();
            resultado=key+" "+value;
        }
        return resultado;
    }

    /**
     * Metodo para eliminar todos los usuarios de la lista
     */
    public void eliminarTodo(){
        lista.clear();
    }

    /**
     * Funcion que retorna el numero de usuarios en la lista
     * @return numero de usuarios
     */
    public int numeroTotal(){
        return lista.size();
    }
}
