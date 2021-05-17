package daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

import classi.Fornitura;
import dao.FornituraDAO;

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
	
	public ArrayList<Object[]> getFornitureDataInizioDataFine(String dataInizio, String dataFine) throws SQLException{
		PreparedStatement statement = connessione.prepareStatement("SELECT * FROM fornitura AS f LEFT JOIN prodotto AS p ON f.codFornitura = p.codFornitura WHERE datafornitura>=? AND datafornitura<=?");
		statement.setDate(1, Date.valueOf(LocalDate.parse(dataInizio, DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ITALIAN))));
		statement.setDate(2, Date.valueOf(LocalDate.parse(dataFine, DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ITALIAN))));
		
		ResultSet risultato = statement.executeQuery();
		ArrayList<Object[]> daRestituire = new ArrayList<Object[]>();
		while(risultato.next()) {
			Object[] temp = new Object[5];
			temp[0] = risultato.getString("pIva");
			temp[1] = risultato.getString("datafornitura");
			temp[2] = risultato.getString("prezzofornitura");
			temp[3] = risultato.getString("quantitafornita");
			temp[4] = risultato.getString("nome");
			daRestituire.add(temp);
		}
		
		return daRestituire;
	}
	
	public ArrayList<Object[]> getForniture() throws SQLException{
		PreparedStatement statement = connessione.prepareStatement("SELECT * FROM fornitura AS f LEFT JOIN prodotto AS p ON f.codfornitura = p.codfornitura ORDER BY f.codFornitura");
		
		ResultSet risultato = statement.executeQuery();
		ArrayList<Object[]> daRestituire = new ArrayList<Object[]>();
		while(risultato.next()) {
			Object[] temp = new Object[5];
			temp[0] = risultato.getString("pIva");
			temp[1] = risultato.getString("datafornitura");
			temp[2] = risultato.getString("prezzofornitura");
			temp[3] = risultato.getString("quantitafornita");
			temp[4] = risultato.getString("nome");
			daRestituire.add(temp);
			/*for(Object[] p : daRestituire) {
				System.out.println(p[0] + " " + p[1] + " " + p[2] + " " + p[3] + " " + p[4]);
			}
			System.out.println();*/
		}
		
		return daRestituire;
	}
	
}
