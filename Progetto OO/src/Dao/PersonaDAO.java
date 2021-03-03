package Dao;

import java.sql.SQLException;
import java.util.ArrayList;

import Classi.*;

public interface PersonaDAO {
	
	public boolean controlloCredenzialiDipendente(String user, String password) throws SQLException;
	public Persona getPersonaDaEmail(String email) throws SQLException;
	public void aggiornaMail(String nuovaMail, Persona p) throws SQLException;
	public ArrayList<Persona>getPersonale() throws SQLException;
}
