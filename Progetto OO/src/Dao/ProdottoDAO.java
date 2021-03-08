package Dao;

import java.sql.SQLException;
import java.util.ArrayList;

import Classi.Prodotto;

public interface ProdottoDAO {
	public ArrayList<Prodotto> getProdotti() throws SQLException;
}
