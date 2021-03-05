package DaoImpl;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Classi.*;
import Dao.*;

public class PersonaDAOPostgresImpl implements PersonaDAO{
	
	private Connection connessione;
	
	public PersonaDAOPostgresImpl(Connection conn) {
		connessione = conn;
	}
	
	public boolean controlloCredenzialiDipendente(String user, String password) throws SQLException {
		PreparedStatement statement = connessione.prepareStatement("SELECT * FROM persona WHERE email = ? AND cf = ? AND Tipo = 'Personale'");
		statement.setString(1, user);
		statement.setString(2, password);
		ResultSet risultato = statement.executeQuery();
		return risultato.next();
	}
	
	public Persona getPersonaDaCF(String CF) throws SQLException{
		PreparedStatement statement = connessione.prepareStatement("SELECT * FROM persona WHERE cf = ?");
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
		PreparedStatement statement = connessione.prepareStatement("SELECT * FROM persona WHERE email = ?");
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
		PreparedStatement statement = connessione.prepareStatement("UPDATE persona SET email = ? WHERE email = ?");
		statement.setString(1, nuovaMail);
		statement.setString(2, p.getEmail());
		statement.executeUpdate();
	}
	
	public ArrayList<Persona> getPersonale() throws SQLException{
		PreparedStatement statement = connessione.prepareStatement("SELECT * FROM persona WHERE Tipo = 'Personale' ORDER BY cf");
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
		PreparedStatement statement = connessione.prepareStatement("DELETE FROM persona WHERE cf = ?");
		statement.setString(1, CF);
		statement.executeUpdate();
	}
	
	public void modificaRuolo(String nuovoRuolo, String CF) throws SQLException{
		PreparedStatement statement = connessione.prepareStatement("UPDATE persona SET ruolo = ? WHERE cf = ?");
		statement.setString(1, nuovoRuolo);
		statement.setString(2, CF);
		statement.executeUpdate();
	}
	
	public void inserirePersona(Persona p) throws SQLException{
		PreparedStatement statement = connessione.prepareStatement("INSERT INTO persona VALUES(' ', ?, ?, ?, ?, ?, ?, ?, null, ?, ?)");
		statement.setString(1, p.getNome());
		statement.setString(2, p.getCognome());
		statement.setDate(3, Date.valueOf(p.getDataNascita()));
		statement.setString(4, p.getEmail());
		if(p.getRuolo().equals("")) {
			statement.setString(5, "Cliente");
			statement.setNull(6, java.sql.Types.VARCHAR);
		}
		else {
			statement.setString(5, "Personale");
			statement.setString(6, p.getRuolo());
		}
		statement.setString(7, p.getSesso().toString());
		statement.setString(8, p.getNatoIn().getDenominazione());
		statement.setString(9, p.getNatoIn().getProvincia());
		//System.out.println(statement);
		statement.execute();
	}
	
	public ArrayList<Persona> getClienti() throws SQLException{
		PreparedStatement statement = connessione.prepareStatement("SELECT * FROM persona WHERE Tipo = 'Cliente' ORDER BY cf");
		ResultSet risultato = statement.executeQuery();
		ArrayList<Persona> ret = new ArrayList<Persona>();
		while(risultato.next()) {
			Persona p = new Persona(risultato.getString("nome"), risultato.getString("cognome"), risultato.getString("cf"), 
								risultato.getDate("datanascita").toLocalDate(), risultato.getString("email"), risultato.getString("sesso"),"",
								new CittaItaliana(risultato.getString("denominazione"), risultato.getString("provincia")));
			ret.add(p);
		}
		return ret;
	}
}
