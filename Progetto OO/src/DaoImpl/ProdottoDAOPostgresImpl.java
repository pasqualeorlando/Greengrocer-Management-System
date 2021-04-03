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
	
	public Prodotto getProdottoDaNomeMarca(String nome, String marca) throws SQLException{
		PreparedStatement statement = connessione.prepareStatement("SELECT * FROM prodotto WHERE nome = ? AND marca = ?");
		statement.setString(1, nome);
		statement.setString(2, marca);
		ResultSet ris = statement.executeQuery();
		if(ris.next()) {
			Prodotto prod = new Prodotto(ris.getString("nome"), ris.getString("paesediprovenienza"), ris.getFloat("quantitanegozio"),
					  ris.getFloat("prezzounitario"), ris.getInt("scontopercentuale"), 
					  ris.getFloat("quantitadeposito"), null);
			prod.setMarca(ris.getString("marca"));
			try {
				prod.setDataScadenza(ris.getDate("datascadenza").toLocalDate());
			}catch(NullPointerException e) {
				//prod.setDataScadenza(null);
			}
			return prod;
		}
		return null;
	}
	
	public void aggiornaScontoProdotto(Prodotto P, int nuovoSconto) throws SQLException{
		PreparedStatement statement = connessione.prepareStatement("UPDATE prodotto SET scontopercentuale = ? WHERE nome = ? AND marca = ?");
		statement.setInt(1, nuovoSconto);
		statement.setString(2, P.getNome());
		statement.setString(3, P.getMarca());
		statement.executeUpdate();
	}
}
