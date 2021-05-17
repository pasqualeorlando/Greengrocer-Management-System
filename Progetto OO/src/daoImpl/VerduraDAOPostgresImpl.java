package daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import dao.VerduraDAO;

public class VerduraDAOPostgresImpl implements VerduraDAO{
	
	private Connection connessione;
	
	public VerduraDAOPostgresImpl(Connection conn) {
		
		connessione = conn;
	}
	
	public void inserisciVerdura(int codProdotto, String dataRaccolta) throws SQLException {
		
		PreparedStatement statement = connessione.prepareStatement("INSERT INTO verdura VALUES (?, ?)");
		statement.setDate(1, Date.valueOf(LocalDate.parse(dataRaccolta, DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ITALIAN))));
		statement.setInt(2, codProdotto);
		
		statement.executeUpdate();
	}
}
