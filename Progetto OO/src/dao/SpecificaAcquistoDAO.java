package dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SpecificaAcquistoDAO {

	public ArrayList<Object[]> getProdottiDaIdAcquisto(int idAcquisto) throws SQLException;
	public void inserisciSpecificaAcquisto(int idAcquisto, int codProdotto, float quantitaAcquistata) throws SQLException;
	public void rimuoviProdotto(int idAcquisto, int codProdotto) throws SQLException;
}
