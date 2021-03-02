package Controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.*;
import DB.*;
import Gui.*;
import Classi.*;

public class Controller {
	private LoginFrame Login;
	
	public Controller() {
		DBConnection dbconn = null;
        Connection connection = null;

        try{
            dbconn = DBConnection.getInstance();
            connection = dbconn.getConnection();
            Login = new LoginFrame(this);
            Login.setVisible(true);
        }catch(SQLException e) {
        	System.out.println("Impossibile connettersi al DB");
        } catch (IOException e) {
			System.out.println("Impossibile trovare il file di configurazione del DB");
		}
	}
	
	public void validaCredenziali(String user, String password) {
		if(user.length() == 0 || password.length() == 0) {
			JOptionPane.showInternalMessageDialog(null, "Inserire entrambe le informazioni!", "Errore durante l'accesso", JOptionPane.ERROR_MESSAGE);
		}else {
			JOptionPane.showInternalMessageDialog(null, "Hai inserito: "+user+","+password, "Credenziali inserite", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
