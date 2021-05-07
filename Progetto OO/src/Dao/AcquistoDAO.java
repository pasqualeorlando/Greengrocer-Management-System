package Dao;

import java.sql.SQLException;
import java.util.ArrayList;

import Classi.Acquisto;


public interface AcquistoDAO {

	
	public ArrayList<Object[]> getAcquistiDataInizioDataFineCompletati(String dataInizio, String dataFine) throws SQLException;
	public ArrayList<Object[]> getAcquistiCompletati() throws SQLException;
	public int getCodAcquistoDaDataOraCassa(String dataOra, char cassa) throws SQLException;
}
