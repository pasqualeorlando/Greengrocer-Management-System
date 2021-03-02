package Controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.*;
import DB.*;
import DaoImpl.*;
import Gui.*;
import Classi.*;

public class Controller {
	private LoginFrame Login;
	private HomepageFrame Homepage;
	private PersonaDAOPostgresImpl PersonaDAO;
	
	public Controller() {
		DBConnection dbconn = null;
        Connection connection = null;

        try{
            dbconn = DBConnection.getInstance();
            connection = dbconn.getConnection();
            PersonaDAO = new PersonaDAOPostgresImpl(connection);
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
			try {
				if(PersonaDAO.controlloCredenzialiDipendente(user, password)) {
					//JOptionPane.showInternalMessageDialog(null, "Login effettuato con successo", "Login", JOptionPane.INFORMATION_MESSAGE);
					Login.setVisible(false);
					Persona p = PersonaDAO.getPersonaDaEmail(user);
					Homepage = new HomepageFrame(this, p);
					Homepage.setVisible(true);
				}else {
					JOptionPane.showInternalMessageDialog(null, "Credenziali errate", "Errore", JOptionPane.ERROR_MESSAGE);
				}
			} catch (SQLException e) {
				JOptionPane.showInternalMessageDialog(null, "Non è possibile eseguire l'accesso. Controllare la connessione al database", "Errore connessione", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public void exit() {
		//Homepage.setVisible(false);
		Homepage.dispose();
		Login.setVisible(true);
	}
}
