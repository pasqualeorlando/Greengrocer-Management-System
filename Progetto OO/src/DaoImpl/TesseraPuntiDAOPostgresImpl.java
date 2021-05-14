package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Classi.TesseraPunti;
import Dao.TesseraPuntiDAO;

public class TesseraPuntiDAOPostgresImpl implements TesseraPuntiDAO{
	private Connection connessione;
	
	public TesseraPuntiDAOPostgresImpl(Connection conn) {
		connessione = conn;
	}
	
	public TesseraPunti getTesseraPuntiDaCF(String cf) throws SQLException{
		PreparedStatement statement = connessione.prepareStatement("SELECT TP.* FROM persona as P JOIN tesserapunti as TP ON P.codicebarre = TP.codicebarre WHERE cf = ?");
		
		statement.setString(1, cf);
		ResultSet risultato = statement.executeQuery();
		
		if(risultato.next()) {
			TesseraPunti tp = new TesseraPunti(risultato.getString("codicebarre"), risultato.getString("scadenza"), risultato.getInt("puntifrutta"), 
					risultato.getInt("puntiverdura"), risultato.getInt("puntifarinacei"), risultato.getInt("puntilatticini"), 
					risultato.getInt("puntiuova"), risultato.getInt("punticonfezionati"));
			return tp;
		}
		else
			return null;
	}
}
