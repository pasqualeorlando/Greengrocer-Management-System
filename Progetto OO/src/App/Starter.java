package App;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import DB.*;

public class Starter {

	public static void main(String[] args) {
		DBConnection dbconn = null;
        Connection connection = null;

        try{
            dbconn = DBConnection.getInstance();
            connection = dbconn.getConnection();
        }catch(SQLException e) {
        	System.out.println("Impossibile connettersi al DB");
        } catch (IOException e) {
			System.out.println("Impossibile trovare il file di configurazione del DB");
		}

	}

}
