package DaoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Classi.*;
import Dao.*;

public class PersonaDAOPostgresImpl implements PersonaDAO{
	
	private Connection connessione;
	private String queryCredenzialiDip = "SELECT * FROM persona WHERE email = ? AND cf = ? AND Tipo = 'Personale'";
	private String queryPersonaCF = "SELECT * FROM persona WHERE cf = ?";
	private String queryPersonaEmail = "SELECT * FROM persona WHERE email = ?";
	private String queryModificaMail = "UPDATE persona SET email = ? WHERE email = ?";
	private String queryGetPersonale = "SELECT * FROM persona WHERE Tipo = 'Personale' ORDER BY cognome";
	private String eliminaPersona = "DELETE FROM persona WHERE cf = ?";
	private String modificaRuolo = "UPDATE persona SET ruolo = ? WHERE cf = ?";
	private String inserirePersonale = "INSERT INTO persona VALUES('', ?, ?, ?, ?, 'Personale', ?, ?, null, ?, ?)";
	
	public PersonaDAOPostgresImpl(Connection conn) {
		connessione = conn;
	}
	
	public boolean controlloCredenzialiDipendente(String user, String password) throws SQLException {
		PreparedStatement statement = connessione.prepareStatement(queryCredenzialiDip);
		statement.setString(1, user);
		statement.setString(2, password);
		
		ResultSet risultato = statement.executeQuery();
		return risultato.next();
	}
	
	public Persona getPersonaDaCF(String CF) throws SQLException{
		PreparedStatement statement = connessione.prepareStatement(queryPersonaCF);
		statement.setString(1, CF);
		
		ResultSet risultato = statement.executeQuery();
		risultato.next();
		Persona p = new Persona(risultato.getString("nome"), risultato.getString("cognome"), risultato.getString("cf"), 
								risultato.getDate("datanascita").toLocalDate(), risultato.getString("email"), risultato.getString("sesso"), 
								risultato.getString("ruolo"), risultato.getString("tipo"), null, risultato.getString("codicebarre"),
								new CittaItaliana(risultato.getString("denominazione"), risultato.getString("provincia")));
		return p;
	}
	
	public Persona getPersonaDaEmail(String email) throws SQLException{
		PreparedStatement statement = connessione.prepareStatement(queryPersonaEmail);
		statement.setString(1, email);
		
		ResultSet risultato = statement.executeQuery();
		risultato.next();
		Persona p = new Persona(risultato.getString("nome"), risultato.getString("cognome"), risultato.getString("cf"), 
								risultato.getDate("datanascita").toLocalDate(), risultato.getString("email"), risultato.getString("sesso"), 
								risultato.getString("ruolo"), risultato.getString("tipo"), null, risultato.getString("codicebarre"),
								new CittaItaliana(risultato.getString("denominazione"), risultato.getString("provincia")));
		return p;
	}
	
	public void aggiornaMail(String nuovaMail, Persona p) throws SQLException{
		PreparedStatement statement = connessione.prepareStatement(queryModificaMail);
		statement.setString(1, nuovaMail);
		statement.setString(2, p.getEmail());
		statement.executeUpdate();
	}
	
	public ArrayList<Persona> getPersonale() throws SQLException{
		PreparedStatement statement = connessione.prepareStatement(queryGetPersonale);
		ResultSet risultato = statement.executeQuery();
		ArrayList<Persona> ret = new ArrayList<Persona>();
		while(risultato.next()) {
			Persona p = new Persona(risultato.getString("nome"), risultato.getString("cognome"), risultato.getString("cf"), 
								risultato.getDate("datanascita").toLocalDate(), risultato.getString("email"), risultato.getString("sesso"), 
								risultato.getString("ruolo"),
								new CittaItaliana(risultato.getString("denominazione"), risultato.getString("provincia")));
			ret.add(p);
		}
		return ret;
	}
	
	public void eliminaPersonaDaCF(String CF) throws SQLException{
		PreparedStatement statement = connessione.prepareStatement(eliminaPersona);
		statement.setString(1, CF);
		statement.executeUpdate();
	}
	
	public void modificaRuolo(String nuovoRuolo, String CF) throws SQLException{
		PreparedStatement statement = connessione.prepareStatement(modificaRuolo);
		statement.setString(1, nuovoRuolo);
		statement.setString(2, CF);
		statement.executeUpdate();
	}
	public void inserirePersonale(Persona p) throws SQLException{
		PreparedStatement statement = connessione.prepareStatement(inserirePersonale);
		statement.setString(1, p.getNome());
		statement.setString(2, p.getCognome());
		statement.setString(3, p.getDataNascita().toString());
		statement.setString(4, p.getEmail());
		statement.setString(5, p.getRuolo());
		statement.setString(6, p.getSesso().toString());
		statement.setString(7, p.getNatoIn().getDenominazione());
		statement.setString(8, p.getNatoIn().getProvincia());
		System.out.println(statement);
		statement.execute();
	}
}
