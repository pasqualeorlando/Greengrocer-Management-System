package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import classi.Fornitura;

public interface FornituraDAO {
	public int inserisciFornitura(Fornitura f) throws SQLException;
	public int getMaxIdFornitura() throws SQLException;
	public ArrayList<Object[]> getFornitureDataInizioDataFine(String dataInizio, String dataFine) throws SQLException;
	public ArrayList<Object[]> getForniture() throws SQLException;
}
