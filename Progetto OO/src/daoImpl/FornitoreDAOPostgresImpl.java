package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import classi.Fornitore;
import dao.FornitoreDAO;

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
	
	public ArrayList<String> getFornitoriPIvaNomeSocieta() throws SQLException{
		ArrayList<String> result = new ArrayList<String>();
		PreparedStatement statement = connessione.prepareStatement("SELECT piva, nomesocieta FROM fornitore");
		ResultSet rs = statement.executeQuery();
		while(rs.next()) {
			result.add(rs.getString("piva") + " - " + rs.getString("nomesocieta"));
		}
		return result;
	}
	
	public void inserisciFornitore(Fornitore f) throws SQLException{
		PreparedStatement statement = connessione.prepareStatement("INSERT INTO fornitore VALUES (?, ?, ?, ?)");
		statement.setString(1, f.getPIva());
		statement.setString(2, f.getNomeSocieta());
		statement.setString(3, f.getNomeTitolare());
		statement.setString(4, f.getCognomeTitolare());
		statement.executeUpdate();
	}
}
