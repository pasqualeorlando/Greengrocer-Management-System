package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Classi.Fornitore;
import Dao.*;

public class FornitoreDAOPostgresImpl implements FornitoreDAO{
private Connection connessione;
	
	public FornitoreDAOPostgresImpl(Connection conn) {
		connessione = conn;
	}

	public Fornitore getFornitoreDaPIva(String pIva) throws SQLException {
		PreparedStatement statement = connessione.prepareStatement("SELECT * FROM Fornitore WHERE piva = ?");
		statement.setString(1, pIva);
		ResultSet risultato = statement.executeQuery();
		risultato.next();
		Fornitore f = new Fornitore(risultato.getString("piva"), risultato.getString("nomesocieta"), risultato.getString("nometitolare"), risultato.getString("cognometitolare"));
		return f;
	}
	
	public ArrayList<String> getFornitori() throws SQLException{
		ArrayList<String> result = new ArrayList<String>();
		PreparedStatement statement = connessione.prepareStatement("SELECT piva FROM fornitore");
		ResultSet rs = statement.executeQuery();
		while(rs.next()) {
			result.add(rs.getString("piva"));
		}
		return result;
	}
}
