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
		PreparedStatement statement = connessione.prepareStatement("SELECT P.nome AS nome, SA.quantitaacquistata AS quantita FROM specificaacquisto AS SA JOIN prodotto AS P ON SA.codProdotto = P.codProdotto WHERE SA.codAcquisto = ?");
		
		statement.setInt(1, idAcquisto);
		
		ResultSet risultato = statement.executeQuery();
		ArrayList<Object[]> daRestituire = new ArrayList<Object[]>();
		
		while(risultato.next()) {
			Object[] temp = new Object[2];
			temp[0] = risultato.getString("nome");
			temp[1] = risultato.getFloat("quantita");
			daRestituire.add(temp);
		}
		
		return daRestituire;
	}
	
	public void inserisciSpecificaAcquisto(int idAcquisto, int codProdotto) throws SQLException{
		
	}

}
