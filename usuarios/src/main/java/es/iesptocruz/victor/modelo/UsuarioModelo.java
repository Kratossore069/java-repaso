package es.iesptocruz.victor.modelo;

import java.sql.SQLException;

import es.iesptocruz.victor.exception.PersistenciaException;

public class UsuarioModelo{

   DdBbSqLite persistencia;
   private static final String TABLA  = "Usuarios";
   private static final String CLAVE  = "Nombre";
   
   public UsuarioModelo() throws PersistenciaException {
      persistencia = new DdBbSqLite(TABLA, CLAVE, null, null);
   }

   public void insertar(Cuenta cuenta) throws PersistenciaException {
      String sql = "INSERT INTO "+TABLA+" (codigo, cliente, email, saldo)"+
      " VALUES ('"+cuenta.getCodigo()+"','"+cuenta.getCliente()+"','"
      +cuenta.getEmail()+"',"+cuenta.getSaldo()+");";
      persistencia.update(sql);
   }

   public void eliminar(Cuenta cuenta) throws PersistenciaException {
      String sql = "DELETE FROM "+TABLA+" WHERE "+CLAVE+" = '" + cuenta.getCodigo() + "'";
      persistencia.update(sql);
   }

   public Cuenta buscar(String codigo) throws PersistenciaException {
      return (Cuenta) persistencia.buscarElemento(codigo);
   }

   public void actualizar(Cuenta cuenta) throws PersistenciaException {
      String sql = "UPDATE cuenta set cliente = '" + cuenta.getCliente() + "',  email = '" + cuenta.getEmail()
            + "',  saldo = '" + cuenta.getSaldo() +"' " + " WHERE codigo = '" + cuenta.getCodigo()+"'";
            persistencia.update(sql);
   }

   /**
    * Metodo que muestra todos los campos de la bbdd
    * @throws PersistenciaException
    * @throws SQLException
    */
   public String mostrar() throws PersistenciaException, SQLException {
      String sql = "SELECT * FROM " + TABLA ;
      return persistencia.mostrar(sql);
   }
   
}
