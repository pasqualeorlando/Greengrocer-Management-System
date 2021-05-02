package Dao;

import java.sql.SQLException;

public interface LatticinoDAO {
	public void inserisciLatticino(int codProdotto, String dataMungitura, String dataProduzione) throws SQLException;
}
