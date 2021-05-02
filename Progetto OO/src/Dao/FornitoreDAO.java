package Dao;

import java.sql.SQLException;
import java.util.ArrayList;

import Classi.Fornitore;

public interface FornitoreDAO {
	public Fornitore getFornitoreDaPIva(String pIva) throws SQLException;
	public ArrayList<String> getFornitori() throws SQLException;
}
