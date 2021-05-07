package DaoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

import Classi.Acquisto;
import Dao.AcquistoDAO;

public class AcquistoDAOPostgresImpl implements AcquistoDAO {
	
	private Connection connessione;
	
	public AcquistoDAOPostgresImpl(Connection conn) {
		connessione = conn;
	}
	
	public ArrayList<Object[]> getAcquistiDataInizioDataFineCompletati(String dataInizio, String dataFine) throws SQLException{
		PreparedStatement statement = connessione.prepareStatement("SELECT * FROM acquisto WHERE dataora>=? AND dataora<=? AND completato = true");
		statement.setDate(1, Date.valueOf(LocalDate.parse(dataInizio, DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ITALIAN))));
		statement.setDate(2, Date.valueOf(LocalDate.parse(dataFine, DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ITALIAN))));
		
		
		ResultSet risultato = statement.executeQuery();
		ArrayList<Object[]> daRestituire = new ArrayList<Object[]>();
		while(risultato.next()) {
			Object[] temp = new Object[5];
			temp[0] = risultato.getString("dataora");
			temp[1] = risultato.getString("cassa").charAt(0);
			temp[2] = risultato.getInt("scontopercentuale");
			temp[3] = risultato.getFloat("totale");
			temp[4] = risultato.getString("cf");
			daRestituire.add(temp);
		}
		
		return daRestituire;
	}
	
	public ArrayList<Object[]> getAcquistiCompletati() throws SQLException{
		PreparedStatement statement = connessione.prepareStatement("SELECT * FROM acquisto WHERE completato = true");
		
		ResultSet risultato = statement.executeQuery();
		ArrayList<Object[]> daRestituire = new ArrayList<Object[]>();
		while(risultato.next()) {
			Object[] temp = new Object[5];
			temp[0] = risultato.getString("dataora");
			temp[1] = risultato.getString("cassa").charAt(0);
			temp[2] = risultato.getInt("scontopercentuale");
			temp[3] = risultato.getFloat("totale");
			temp[4] = risultato.getString("cf");
			daRestituire.add(temp);
		}
		
		return daRestituire;
	}
	
	public int getCodAcquistoDaDataOraCassa(String dataOra, char cassa) throws SQLException{
		PreparedStatement statement = connessione.prepareStatement("SELECT * FROM acquisto WHERE dataOra=? AND cassa=? AND completato = true");
		
		statement.setTimestamp(1, Timestamp.valueOf(dataOra));
		statement.setString(2, new Character(cassa).toString());
		
		ResultSet risultato = statement.executeQuery();
		if(risultato.next())
			return risultato.getInt("codAcquisto");
		else {
			throw new SQLException("L'acquisto non è stato trovato nel database.");
		}
	}
}
