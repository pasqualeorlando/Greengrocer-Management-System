package dao;

import java.sql.SQLException;

import classi.TesseraPunti;

public interface TesseraPuntiDAO {
	
	public TesseraPunti getTesseraPuntiDaCF(String cf) throws SQLException;
}
