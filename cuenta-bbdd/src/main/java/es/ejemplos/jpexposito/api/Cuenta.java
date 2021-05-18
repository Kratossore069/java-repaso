package es.ejemplos.jpexposito.api;

public class Cuenta {
   String codigo;
   String cliente;
   String email;
   double saldo;

   /**
    * Constructor por defecto
    */
   public Cuenta () {}

   /**
    * Constructor con parametros
    * @param codigo de la cuenta
    * @param cliente de la cuenta
    * @param email de la cuenta
    * @param saldo de la cuenta
    */
   public Cuenta(String codigo, String cliente, String email, double saldo) {
      this.codigo = codigo;
      this.cliente = cliente;
      this.email = email;
      this.saldo = saldo;
   }

   public String getCodigo() {
      return this.codigo;
   }

   public void setCodigo(String codigo) {
      this.codigo = codigo;
   }

   public String getCliente() {
      return this.cliente;
   }

   public void setCliente(String cliente) {
      this.cliente = cliente;
   }

   public String getEmail() {
      return this.email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public double getSaldo() {
      return this.saldo;
   }

   public void setSaldo(double saldo) {
      this.saldo = saldo;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
      result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
      result = prime * result + ((email == null) ? 0 : email.hashCode());
      long temp;
      temp = Double.doubleToLongBits(saldo);
      result = prime * result + (int) (temp ^ (temp >>> 32));
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
      Cuenta other = (Cuenta) obj;
      if (cliente == null) {
         if (other.cliente != null)
            return false;
      } else if (!cliente.equals(other.cliente))
         return false;
      if (codigo == null) {
         if (other.codigo != null)
            return false;
      } else if (!codigo.equals(other.codigo))
         return false;
      if (email == null) {
         if (other.email != null)
            return false;
      } else if (!email.equals(other.email))
         return false;
      if (Double.doubleToLongBits(saldo) != Double.doubleToLongBits(other.saldo))
         return false;
      return true;
   }

   @Override
   public String toString() {
      return "Cuenta [cliente=" + cliente + ", codigo=" + codigo + ", email=" + email + ", saldo=" + saldo + "]";
   }
}
