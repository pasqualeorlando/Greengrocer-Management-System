package dao;

import java.sql.SQLException;

import enumerazioni.TAllevamento;

public interface UovaDAO {
	public void inserisciUova(int codProdotto, TAllevamento tipoAllevamento) throws SQLException;
}
