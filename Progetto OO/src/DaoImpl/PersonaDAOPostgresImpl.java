package DaoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dao.*;

public class PersonaDAOPostgresImpl implements PersonaDAO{
	
	private Connection connessione;
	private String queryCredenzialiDip = "SELECT * FROM persona WHERE email = ? AND cf = ? AND Tipo = 'Personale'";
	
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
}
