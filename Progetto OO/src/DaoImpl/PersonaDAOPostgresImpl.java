package DaoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Classi.Persona;
import Dao.*;

public class PersonaDAOPostgresImpl implements PersonaDAO{
	
	private Connection connessione;
	private String queryCredenzialiDip = "SELECT * FROM persona WHERE email = ? AND cf = ? AND Tipo = 'Personale'";
	private String queryPersona = "SELECT * FROM persona WHERE email = ?";
	
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
	
	public Persona getPersonaDaEmail(String email) throws SQLException{
		PreparedStatement statement = connessione.prepareStatement(queryPersona);
		statement.setString(1, email);
		
		ResultSet risultato = statement.executeQuery();
		risultato.next();
		Persona p = new Persona(risultato.getString("nome"), risultato.getString("cognome"), risultato.getString("cf"), 
								risultato.getDate("datanascita"), risultato.getString("email"), risultato.getString("sesso"), 
								risultato.getString("ruolo"), risultato.getString("tipo"), null, risultato.getString("codicebarre"), null);
		return p;
	}
}
