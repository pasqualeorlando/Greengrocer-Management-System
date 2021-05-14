package Dao;

import java.sql.SQLException;

import Classi.TesseraPunti;

public interface TesseraPuntiDAO {
	
	public TesseraPunti getTesseraPuntiDaCF(String cf) throws SQLException;
}
