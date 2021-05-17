package dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CittaItalianaDAO {
	public ArrayList<String> getProvince() throws SQLException;
	public ArrayList<String> getCittaFromProvincia(String provincia) throws SQLException;
}
