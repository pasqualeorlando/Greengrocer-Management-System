package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.ConfezionatoDAO;

public class ConfezionatoDAOPostgresImpl implements ConfezionatoDAO{
	
	private Connection connessione;
	
	public ConfezionatoDAOPostgresImpl(Connection conn) {
		connessione = conn;
	}
	
	public void inserisciConfezionato(int codProdotto, String tipoConfezione) throws SQLException {
		
		PreparedStatement statement = connessione.prepareStatement("INSERT INTO confezionato VALUES (?, ?)");
		statement.setString(1, tipoConfezione);
		statement.setInt(2, codProdotto);
		
		statement.executeUpdate();
	}
}
