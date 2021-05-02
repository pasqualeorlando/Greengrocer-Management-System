package Dao;

import java.sql.SQLException;

public interface FarinaceoDAO {
	public void inserisciFarinaceo(int codProdotto, String tipoFarinaceo) throws SQLException;
}
