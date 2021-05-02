package Dao;

import java.sql.SQLException;

public interface FruttaDAO {
	public void inserisciFrutta(int codProdotto, String dataRaccolta) throws SQLException;
}
