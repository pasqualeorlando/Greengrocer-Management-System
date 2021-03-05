package Dao;

import java.sql.SQLException;
import java.util.ArrayList;

import Classi.*;

public interface PersonaDAO {
	
	public boolean controlloCredenzialiDipendente(String user, String password) throws SQLException;
	public Persona getPersonaDaCF(String CF) throws SQLException;
	public Persona getPersonaDaEmail(String email) throws SQLException;
	public void aggiornaMail(String nuovaMail, Persona p) throws SQLException;
	public ArrayList<Persona> getPersonale() throws SQLException;
	public void eliminaPersonaDaCF(String CF) throws SQLException;
	public void modificaRuolo(String nuovoRuolo, String CF) throws SQLException;
	public void inserirePersona(Persona p) throws SQLException;
	public ArrayList<Persona> getClienti() throws SQLException;
}
