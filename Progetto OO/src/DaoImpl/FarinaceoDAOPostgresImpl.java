package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Dao.FarinaceoDAO;

public class FarinaceoDAOPostgresImpl implements FarinaceoDAO {
	private Connection connessione;
	
	public FarinaceoDAOPostgresImpl(Connection conn) {
		connessione = conn;
	}
	
	public void inserisciFarinaceo(int codProdotto, String tipoFarinaceo) throws SQLException {
		PreparedStatement statement = connessione.prepareStatement("INSERT INTO farinaceo VALUES (?, ?)");
		statement.setString(1, tipoFarinaceo);
		statement.setInt(2, codProdotto);
		
		statement.executeUpdate();
	}
}
