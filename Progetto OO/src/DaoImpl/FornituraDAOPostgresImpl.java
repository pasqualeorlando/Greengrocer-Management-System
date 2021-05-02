package DaoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Classi.Fornitura;
import Dao.FornituraDAO;

public class FornituraDAOPostgresImpl implements FornituraDAO{
	private Connection connessione;
	
	public FornituraDAOPostgresImpl(Connection conn) {
		connessione = conn;
	}
	
	public int getMaxIdFornitura() throws SQLException{
		PreparedStatement statement = connessione.prepareStatement("SELECT last_value FROM nCodFornitura");
		ResultSet risultato = statement.executeQuery();
		risultato.next();
		return risultato.getInt(1);
	}

	public int inserisciFornitura(Fornitura f) throws SQLException {
		int actualID = getMaxIdFornitura();
		
		PreparedStatement statement = connessione.prepareStatement("INSERT INTO fornitura VALUES(?, ?, ?, ?, ?)");
		statement.setInt(1, actualID+1);
		statement.setFloat(2, f.getQuantitaFornita());
		statement.setDate(3, Date.valueOf(f.getDataFornitura()));
		statement.setFloat(4, f.getPrezzoFornitura());
		statement.setString(5, f.getFornitore().getPIva());
		
		statement.executeUpdate();
		
		return (getMaxIdFornitura() == actualID)? 0 : getMaxIdFornitura();
	}
	
	public void cancellaUltimaFornitura() throws SQLException{
		PreparedStatement statement = connessione.prepareStatement("DELETE FROM fornitura WHERE codFornitura = (SELECT last_value FROM nCodFornitura)");
		
		statement.executeUpdate();
	}
	
}
