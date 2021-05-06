package Dao;

import java.sql.SQLException;
import java.util.ArrayList;

import Classi.Fornitura;

public interface FornituraDAO {
	public int inserisciFornitura(Fornitura f) throws SQLException;
	public int getMaxIdFornitura() throws SQLException;
	public ArrayList<Object[]> getFornitureDataInizioDataFine(String dataInizio, String dataFine) throws SQLException;
	public ArrayList<Object[]> getForniture() throws SQLException;
}
