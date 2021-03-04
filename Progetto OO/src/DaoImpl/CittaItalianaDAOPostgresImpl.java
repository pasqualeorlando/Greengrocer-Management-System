package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Dao.*;

public class CittaItalianaDAOPostgresImpl implements CittaItalianaDAO{
	
	private Connection connessione;
	private String selezionaProvince = "SELECT DISTINCT provincia FROM cittaitaliana ORDER BY provincia";
	private String selezionaComuniDaProvincia = "SELECT denominazione FROM cittaitaliana WHERE provincia = ? ORDER BY denominazione";
	
	public CittaItalianaDAOPostgresImpl(Connection conn) {
		connessione = conn;
	}

	public ArrayList<String> getProvince() throws SQLException {
		ArrayList<String> result = new ArrayList<String>();
		PreparedStatement statement = connessione.prepareStatement(selezionaProvince);
		ResultSet rs = statement.executeQuery();
		while(rs.next()) {
			result.add(rs.getString("provincia"));
		}
		return result;
	}
	
	public ArrayList<String> getCittaFromProvincia(String provincia) throws SQLException{
		ArrayList<String> result = new ArrayList<String>();
		PreparedStatement statement = connessione.prepareStatement(selezionaComuniDaProvincia);
		statement.setString(1, provincia);
		ResultSet rs = statement.executeQuery();
		while(rs.next()) {
			result.add(rs.getString("denominazione"));
		}
		return result;
	}

}
