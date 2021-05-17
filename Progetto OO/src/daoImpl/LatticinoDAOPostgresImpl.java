package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.LatticinoDAO;

public class LatticinoDAOPostgresImpl implements LatticinoDAO {
	
	private Connection connessione;
	
	public LatticinoDAOPostgresImpl(Connection conn) {
		connessione = conn;
	}
	
	public void inserisciLatticino(int codProdotto, String dataMungitura, String dataProduzione) throws SQLException {
		
		PreparedStatement statement = connessione.prepareStatement("INSERT INTO latticino VALUES (?, ?, ?)");
		statement.setString(1, dataProduzione);
		statement.setString(2, dataMungitura);
		statement.setInt(3, codProdotto);
		
		statement.executeUpdate();
	}
}
