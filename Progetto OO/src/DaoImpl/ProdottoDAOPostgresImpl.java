package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Classi.CittaItaliana;
import Classi.Persona;
import Classi.Prodotto;
import Dao.ProdottoDAO;

public class ProdottoDAOPostgresImpl implements ProdottoDAO {
	private Connection connessione;
	
	public ProdottoDAOPostgresImpl(Connection conn) {
		connessione = conn;
	}
	
	public ArrayList<Prodotto> getProdotti() throws SQLException{
		ArrayList<Prodotto> risultato = new ArrayList<Prodotto>();
		String[] tipi = {"Frutta", "Verdura", "Farinaceo", "Latticino", "Uova", "Confezionato"};
		
		for(String s:tipi) {
			PreparedStatement statement = connessione.prepareStatement("SELECT * FROM prodotto NATURAL JOIN ? ORDER BY nome");
			statement.setString(1, s);
			ResultSet ris = statement.executeQuery();
			while(ris.next()) {
				Prodotto p = new Prodotto(ris.getString("nome"), ris.getString("paesediprovenienza"), ris.getFloat("quantitanegozio"),
										  ris.getFloat("prezzounitario"), ris.getInt("scontopercentuale"), 
										  ris.getFloat("quantitadeposito"), null);
				
				if(s.equals("Frutta")||s.equals("Verdura"))
					p.setDataScadenza(ris.getDate("datascadenza").toLocalDate());
			}
		}
		return risultato;
	}
}
