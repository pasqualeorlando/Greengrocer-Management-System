package Dao;

import java.sql.SQLException;
import java.util.ArrayList;

import Classi.Prodotto;

public interface ProdottoDAO {
	public ArrayList<Prodotto> getProdotti() throws SQLException;
	public Prodotto getProdottoDaNomeMarca(String nome, String marca) throws SQLException;
	public void aggiornaScontoProdotto(Prodotto P, int nuovoSconto) throws SQLException;
	public void aggiornaQuantita(Prodotto P, double quantitaDaRifornire) throws SQLException;
}
