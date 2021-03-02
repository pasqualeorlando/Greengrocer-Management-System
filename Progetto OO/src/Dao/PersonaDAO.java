package Dao;

import java.sql.SQLException;

public interface PersonaDAO {
	
	public boolean controlloCredenzialiDipendente(String user, String password) throws SQLException;
}
