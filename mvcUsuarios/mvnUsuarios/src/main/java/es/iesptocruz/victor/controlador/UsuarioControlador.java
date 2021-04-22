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
     * @param usuario a insertar
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
     * Metodo para eliminar todos los usuarios de la lista
     */
    public void eliminar(){
        lista.clear();
    }

    /**
     * Funcion que modifica un usuario
     * @param usuario a buscar
     * @throws UsuarioException error controlado
     */
    public void modificar(Usuario usuario) throws UsuarioException {
        validar(usuario);
        if(lista.containsKey(usuario.getIdentificador())){
            usuario.setNombre("Modificado");
        }else{
            throw new UsuarioException("Usuario no encontrado, nada modificado");
        }
    }

    /**
     * Funcion para buscar un usuario
     * @param usuario a buscar
     * @return true or false
     * @throws UsuarioException error controlado
     */
    public boolean buscar(Usuario usuario) throws UsuarioException {
        boolean bandera=false;
        if (usuario.getIdentificador() == null) {
            throw new UsuarioException("Identificador nulo");
        }else{
            for (String codigo: lista.keySet()) {
                if(lista.containsKey(usuario.getIdentificador())){
                    bandera=true;
                    return bandera;
                }
            }
        }
        return bandera;
    }

    /**
     * Funcion que muestra los datos de un usuario por su ID
     * @param identificador del usuario
     * @return datos del usuario
     * @throws UsuarioException error controlado
     */
    public String mostrar(String identificador) throws UsuarioException {
        String resultado="";
        if (identificador == null) {
            throw new UsuarioException("Identificador nulo");
        }else{
            for (String codigo: lista.keySet()) {
                try{
                    codigo=identificador;
                    String key = codigo;
                    String value = lista.get(codigo).toString();
                    resultado=key+" "+value;
                }catch(Exception ex){
                    resultado="Usuario no encontrado";
                }
            }
        }
        return resultado;
    }

    /**
     * Funcion que muestra todos los usuarios registrados
     * @return lista en String
     */
    public String mostrar() {
        String resultado="";
        for (Usuario usuario : lista.values()) {
            resultado+= usuario.toString();
        }
        // resultado=lista.toString();
        // for (String codigo: lista.keySet()) {
        //     String key = codigo;
        //     String value = lista.get(codigo).toString();
        //     resultado=key+" "+value;
        // }
        return resultado;
    }

    /**
     * Funcion que retorna el numero de usuarios en la lista
     * @return numero de usuarios
     */
    public int numeroUsuarios(){
        return lista.size();
    }
}
