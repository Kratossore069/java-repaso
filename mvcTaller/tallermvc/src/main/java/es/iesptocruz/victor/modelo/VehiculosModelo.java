package es.iesptocruz.victor.modelo;

public class VehiculosModelo{

    Sqlitebbdd persistencia;

    public VehiculosModelo(){
        persistencia=new Sqlitebbdd("bbdd.db", null, null, "jdbc:sqlite");
    }
    
}
