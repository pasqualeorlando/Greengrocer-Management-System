package Dao;

import java.sql.SQLException;
import Classi.*;

public interface PersonaDAO {
	
	public boolean controlloCredenzialiDipendente(String user, String password) throws SQLException;
	public Persona getPersonaDaEmail(String email) throws SQLException;
}
