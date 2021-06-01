package es.iesptocruz.victor.api;
import java.io.Serializable;

public class Usuario implements Serializable {
	private String user, pass;

	public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * Funcion que valida los datos entrantes
     * @param usuario entrante
     * @param password entrante
     * @return true or false
     */
	public boolean validate(String usuario, String password)
	{
		if (usuario.equals(user) && password.equals(pass))
			return true;
		else
			return false;
	}
}

