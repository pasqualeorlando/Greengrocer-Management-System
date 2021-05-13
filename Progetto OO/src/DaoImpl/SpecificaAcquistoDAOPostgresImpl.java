package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Dao.SpecificaAcquistoDAO;

public class SpecificaAcquistoDAOPostgresImpl implements SpecificaAcquistoDAO {
	
	private Connection connessione;
	
	public SpecificaAcquistoDAOPostgresImpl(Connection c) {
		connessione = c; 
	}
	
	public ArrayList<Object[]> getProdottiDaIdAcquisto(int idAcquisto) throws SQLException{
		PreparedStatement statement = connessione.prepareStatement("SELECT P.nome AS nome, P.marca AS marca, SA.quantitaacquistata AS quantita FROM specificaacquisto AS SA JOIN prodotto AS P ON SA.codProdotto = P.codProdotto WHERE SA.codAcquisto = ?");
		
		statement.setInt(1, idAcquisto);
		
		ResultSet risultato = statement.executeQuery();
		ArrayList<Object[]> daRestituire = new ArrayList<Object[]>();
		
		while(risultato.next()) {
			Object[] temp = new Object[3];
			temp[0] = risultato.getString("nome");
			temp[1] = risultato.getString("marca");
			temp[2] = risultato.getFloat("quantita");
			daRestituire.add(temp);
		}
		
		return daRestituire;
	}
	
	public void inserisciSpecificaAcquisto(int idAcquisto, int codProdotto, float quantitaAcquistata) throws SQLException{
		PreparedStatement statement = connessione.prepareStatement("INSERT INTO specificaacquisto VALUES (?, ?, ?)");
		
		statement.setFloat(1, quantitaAcquistata);
		statement.setInt(2, codProdotto);
		statement.setInt(3, idAcquisto);
		
		statement.executeUpdate();
	}
	
	public void rimuoviProdotto(int idAcquisto, int codProdotto) throws SQLException{
		PreparedStatement statement = connessione.prepareStatement("DELETE FROM specificaacquisto WHERE codacquisto = ? AND codprodotto = ?");
		
		statement.setInt(1, idAcquisto);
		statement.setInt(2, codProdotto);
		
		statement.executeUpdate();
	}

}
