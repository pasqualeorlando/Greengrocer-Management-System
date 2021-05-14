package Dao;

import java.sql.SQLException;
import java.util.ArrayList;

import Classi.Acquisto;


public interface AcquistoDAO {

	
	public ArrayList<Object[]> getAcquistiDataInizioDataFineCompletati(String dataInizio, String dataFine) throws SQLException;
	public ArrayList<Object[]> getAcquistiCompletati() throws SQLException;
	public int getCodAcquistoDaDataOraCassa(String dataOra, char cassa) throws SQLException;
	public int inizializzaAcquisto(char cassa, String cf) throws SQLException;
	public void impostaScontoPercentuale(int idAcquisto, int scontoPercentuale) throws SQLException;
	public void impostaCompletato(int idAcquisto) throws SQLException;
	public Acquisto getAcquistoDaCod(int idAcquisto) throws SQLException;
}
