package es.iesptocruz.victor.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import es.iesptocruz.victor.api.Usuario;

public class BDD {
    private String driver;
    private String conexion;
    private String usuario;
    private String password;
    private Connection con;

    /**
     * Constructor por defecto
     */
    public BDD(String driver, String conexion, String usuario, String password) {
        this.driver = driver;
        this.conexion = conexion;
        this.usuario = usuario;
        this.password = password;
    }

    public Connection getCon() {
        if (con == null) {
            try {
                Class.forName(driver);
                con = DriverManager.getConnection(conexion, usuario, password);
            } catch (SQLException | ClassNotFoundException ex) {
                // Excepcion propia
            }
        }
        return con;
    }

    public Usuario buscar(String identificador) {
        Usuario usuario = null;
        Statement st = null;
        String sql = "select * from usuario where identificador=?";

        st = getCon().prepareStatement(sql);
        st.setString(1, identificador);
        ResultSet result = st.executeQuery();

        if (result.next()) {
            usuario = new Usuario();
            usuario.setIdentificador(identificador);
            usuario.setNombre(result.getString("nombre"));
            usuario.setNombre(result.getString("nombre")); // Apellidos
            usuario.setNombre(result.getString("nombre")); // Edad
        }
        return usuario;
    }

    public void insertar(Usuario usuario) {
        Statement st = null;
        String sql = "insert into cuentas values (?,?,?,?)";

        try{
        st = getCon().prepareStatement(sql);
        st.setString(1, usuario.getIdentificador());
        st.setString(2, usuario.getNombre());
        st.setString(3, usuario.getApellidos());
        st.setString(4, usuario.getEdad());
        st.executeUpdate();
        }catch(Exception ex){

        }finally{
            if(st!=null){
                st.close();
            } //Cerrar todo
        }
    }
}
