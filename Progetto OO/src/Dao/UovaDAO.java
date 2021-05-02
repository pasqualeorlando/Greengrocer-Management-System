package Dao;

import java.sql.SQLException;

import Enum.TAllevamento;

public interface UovaDAO {
	public void inserisciUova(int codProdotto, TAllevamento tipoAllevamento) throws SQLException;
}
