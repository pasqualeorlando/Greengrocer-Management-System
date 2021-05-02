package Dao;

import java.sql.SQLException;

import Classi.Fornitura;

public interface FornituraDAO {
	public int inserisciFornitura(Fornitura f) throws SQLException;
	public int getMaxIdFornitura() throws SQLException;
	public void cancellaUltimaFornitura() throws SQLException;
}
