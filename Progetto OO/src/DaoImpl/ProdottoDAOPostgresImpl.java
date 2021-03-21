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
		String[] queries = {
				"SELECT * FROM prodotto NATURAL JOIN Frutta ORDER BY nome",
				"SELECT * FROM prodotto NATURAL JOIN Verdura ORDER BY nome",
				"SELECT * FROM prodotto NATURAL JOIN Farinaceo ORDER BY nome",
				"SELECT * FROM prodotto NATURAL JOIN Latticino ORDER BY nome",
				"SELECT * FROM prodotto NATURAL JOIN Uova ORDER BY nome",
				"SELECT * FROM prodotto NATURAL JOIN Confezionato ORDER BY nome"
		};
		
		for(int i=0; i<6; i++) {
			PreparedStatement statement = connessione.prepareStatement(queries[i]);
			ResultSet ris = statement.executeQuery();
			while(ris.next()) {
				Prodotto p = new Prodotto(ris.getString("nome"), ris.getString("paesediprovenienza"), ris.getFloat("quantitanegozio"),
										  ris.getFloat("prezzounitario"), ris.getInt("scontopercentuale"), 
										  ris.getFloat("quantitadeposito"), null);
				p.setMarca(ris.getString("marca"));
				
				if(i>1)
					p.setDataScadenza(ris.getDate("datascadenza").toLocalDate());
				risultato.add(p);
			}
		}
		return risultato;
	}
}
