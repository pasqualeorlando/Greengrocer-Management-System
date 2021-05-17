package dao;

import java.sql.SQLException;

public interface VerduraDAO {
	public void inserisciVerdura(int codProdotto, String dataRaccolta) throws SQLException;
}
