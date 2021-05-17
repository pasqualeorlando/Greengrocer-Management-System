package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.UovaDAO;
import enumerazioni.TAllevamento;

public class UovaDAOPostgresImpl implements UovaDAO{
	
	private Connection connessione;
	
	public UovaDAOPostgresImpl(Connection conn) {
		connessione = conn;
	}
	
	public void inserisciUova(int codProdotto, TAllevamento tipoAllevamento) throws SQLException {
		
		PreparedStatement statement = connessione.prepareStatement("INSERT INTO uova VALUES (?, ?)");
		
		statement.setInt(1, tipoAllevamento.getNumber());
		statement.setInt(2, codProdotto);

		statement.executeUpdate();
	}
}
