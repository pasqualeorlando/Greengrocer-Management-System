package Dao;

import java.sql.SQLException;

public interface ConfezionatoDAO {
	public void inserisciConfezionato(int codProdotto, String tipoConfezione) throws SQLException;
}
