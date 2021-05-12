package DaoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

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
		//PreparedStatement statement = connessione.prepareStatement("SELECT * FROM acquisto WHERE dataOra=? AND cassa=? AND completato = true");
		PreparedStatement statement = connessione.prepareStatement("SELECT * FROM acquisto WHERE dataOra=? AND cassa=?");
		statement.setTimestamp(1, Timestamp.valueOf(dataOra));
		statement.setString(2, new Character(cassa).toString());
		
		ResultSet risultato = statement.executeQuery();
		if(risultato.next())
			return risultato.getInt("codAcquisto");
		else {
			throw new SQLException("L'acquisto non � stato trovato nel database.");
		}
	}
	
	public int inizializzaAcquisto(char cassa, String cf) throws SQLException{
		PreparedStatement statement = connessione.prepareStatement("INSERT INTO acquisto(dataora, cassa, scontopercentuale, totale, cf, completato) VALUES (?, ?, ?, ?, ?, ?)");
		
		
		Timestamp dataOra = Timestamp.valueOf(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		/*System.out.println(dataOra);
		return -1;*/
		statement.setTimestamp(1, dataOra);
		statement.setString(2, String.valueOf(cassa));
		statement.setInt(3, 0);
		statement.setFloat(4, 0.0F);
		if(cf != null || !cf.equals(""))
			statement.setString(5, cf);
		statement.setBoolean(6, false);
		
		statement.executeUpdate();
		
		//System.out.println(dataOra.toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).toString());
		return getCodAcquistoDaDataOraCassa(dataOra.toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).toString(), cassa);
	}
}
