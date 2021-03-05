package Controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;
import DB.*;
import DaoImpl.*;
import Enum.*;
import Gui.*;
import Classi.*;

public class Controller {
	private LoginFrame Login;
	private HomepageFrame Homepage;
	private ModificaAccountFrame ModificaAccount;
	private PersonaleFrame Personale;
	private PersonaDAOPostgresImpl PersonaDAO;
	private CittaItalianaDAOPostgresImpl CittaItalianaDAO;
	
	public Controller() {
		DBConnection dbconn = null;
        Connection connection = null;

        try{
            dbconn = DBConnection.getInstance();
            connection = dbconn.getConnection();
            PersonaDAO = new PersonaDAOPostgresImpl(connection);
            CittaItalianaDAO = new CittaItalianaDAOPostgresImpl(connection);
            Login = new LoginFrame(this);
            Login.setVisible(true);
        }catch(SQLException e) {
        	//System.out.println("Impossibile connettersi al DB");
        	JOptionPane.showInternalMessageDialog(null, "Impossibile connettersi al Database.\nRiprova più tardi.", "Errore connessione", JOptionPane.ERROR_MESSAGE);
        	System.exit(1);
        } catch (IOException e) {
			//System.out.println("Impossibile trovare il file di configurazione del DB");
			JOptionPane.showInternalMessageDialog(null, "Impossibile trovare il file dbconf.properties.\nVerificare nelle directory del programma.", "File configurazione non trovato", JOptionPane.ERROR_MESSAGE);
			System.exit(2);
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
	public void vaiHomepage(JFrame framePrecedente, Persona p) {
		Homepage = new HomepageFrame(this, p);
		Homepage.setVisible(true);
		framePrecedente.dispose();
	}
	public void vaiModificaAccount(Persona p) {
		ModificaAccount = new ModificaAccountFrame(this, p);
		ModificaAccount.setVisible(true);
		//Homepage.setVisible(false);
		Homepage.dispose();
	}
	public void salvaNuovaMail(String newMail, Persona p) {
		if(newMail.equals(p.getEmail()))
			JOptionPane.showInternalMessageDialog(null, "La nuova mail deve essere diversa da quella attuale", "Errore", JOptionPane.ERROR_MESSAGE);
		else if(!newMail.matches("^(.+)@(.+)$"))
			JOptionPane.showInternalMessageDialog(null, "Inserire una mail valida", "Errore", JOptionPane.ERROR_MESSAGE);
		else {
			try {
				PersonaDAO.aggiornaMail(newMail, p);
				JOptionPane.showInternalMessageDialog(null, "Informazioni salvate con successo", "Aggiornamento riuscito", JOptionPane.INFORMATION_MESSAGE);
				p.setEmail(newMail);
			} catch (SQLException e) {
				JOptionPane.showInternalMessageDialog(null, "Non è stato possibile portare a termine l'operazione", "Aggiornamento fallito", JOptionPane.ERROR_MESSAGE);
			}
			ModificaAccount.dispose();
			Homepage = new HomepageFrame(this, p);
			Homepage.setVisible(true);
		}
	}
	public void vaiPersonale(Persona p) {
		if(p.getRuolo().equals(TRuolo.Dipendente.toString())) {
			JOptionPane.showInternalMessageDialog(null, "Questa operazione non è consentita ai dipendenti", "Accesso non consentito", JOptionPane.ERROR_MESSAGE);
		}else {
			Homepage.dispose();
			Personale = new PersonaleFrame(this, p);
			Personale.setVisible(true);
		}
	}
	
	public Object[][] getPersonale(){
		int i = 0;
		try {
			int len = PersonaDAO.getPersonale().size();
			Object[][] personale = new Object[len][9];
			for(Persona p : PersonaDAO.getPersonale()) {
				personale[i][0]=p.getCF();
				personale[i][1]=p.getNome();
				personale[i][2]=p.getCognome();
				personale[i][3]=p.getDataNascita();
				personale[i][4]=p.getEmail();
				personale[i][5]=p.getSesso();
				personale[i][6]=p.getRuolo();
				personale[i][7]=p.getNatoIn().getDenominazione();
				personale[i][8]=p.getNatoIn().getProvincia();
				i++;
			}
			return personale;
		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Errore durante la ricerca del Personale nel database.\nRiavviare il programma.", "Errore", JOptionPane.ERROR_MESSAGE);
			Personale.dispose();
			Homepage.dispose();
			return null;
		}
	}
	public void aggiornaLabels(String cf) {
		try {
			Persona p = PersonaDAO.getPersonaDaCF(cf);
			String[] aggiornamento = {p.getCF(),p.getNome(),p.getCognome(),p.getDataNascita().toString(),p.getEmail(),p.getSesso().toString(),p.getNatoIn().getDenominazione(), p.getNatoIn().getProvincia()};
			int index;
			
			if(p.getRuolo().equals("Titolare")) index = 0;
			else index = 1;
			Personale.setData(aggiornamento, index);
		} catch (SQLException e) {
			String[] aggiornamento = {"", "", "", "", "", "", "", ""};
			Personale.setData(aggiornamento, -1);
		} catch(ArrayIndexOutOfBoundsException e) {
			JOptionPane.showInternalMessageDialog(null, "Selezionare una persona dalla tabella", "Aggiornamento fallito", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public boolean eliminaPersonaDaCF(String cfPersonaDaEliminare, Persona committente) {
		try {
			if(cfPersonaDaEliminare.equals(committente.getCF())) {
				JOptionPane.showInternalMessageDialog(null, "Non puoi eliminare il profilo corrente", "Eliminazione fallita", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			else{
				PersonaDAO.eliminaPersonaDaCF(cfPersonaDaEliminare);
				JOptionPane.showInternalMessageDialog(null, "Profilo eliminato", "Eliminazione avvenuta", JOptionPane.INFORMATION_MESSAGE);
				return true;
			}
		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Errore durante l'eliminazione", "Eliminazione fallita", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	
	public boolean modificaRuoloDaCF(String nuovoRuolo, Persona committente, String cfPersonaDaModificare) {
		try{
			Persona personaDaModificare = PersonaDAO.getPersonaDaCF(cfPersonaDaModificare);
			if(personaDaModificare.getCF().equals(committente.getCF())) {
				JOptionPane.showInternalMessageDialog(null, "Non puoi modificare il tuo ruolo", "Modifica fallita", JOptionPane.ERROR_MESSAGE);
				return false;
			}else if(personaDaModificare.getRuolo().equals(TRuolo.Titolare.toString())) {
				JOptionPane.showInternalMessageDialog(null, "Non puoi modificare un titolare, puoi solo eliminarlo.", "Modifica fallita", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			else if(nuovoRuolo.equals(personaDaModificare.getRuolo())) {
				JOptionPane.showInternalMessageDialog(null, "Il profilo selezionato ha già questo ruolo", "Modifica fallita", JOptionPane.ERROR_MESSAGE);
				return false;
			}else {
				PersonaDAO.modificaRuolo(nuovoRuolo, personaDaModificare.getCF());
				JOptionPane.showInternalMessageDialog(null, "Profilo modificato", "Modifica avvenuta", JOptionPane.INFORMATION_MESSAGE);
				return true;
			}
		}catch(SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Errore durante la modifica", "Modifica fallita", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	
	public boolean inserisciPersonale(String nuovoNome, String nuovoCognome, String nuovaDataNascita, String nuovaMail, String nuovoSesso, String nuovoRuolo, String nuovaCitta, String nuovaProvincia) {
		try {
			if(nuovoNome.equals("")||nuovoCognome.equals("")||nuovaMail.equals("")
					||nuovoSesso.equals("")||nuovoRuolo.equals("")||nuovaDataNascita.equals("")
					||nuovaCitta.equals("")||nuovaProvincia.equals("")) {
				JOptionPane.showInternalMessageDialog(null, "Compilare tutti i campi del form!", "Inserimento fallito", JOptionPane.ERROR_MESSAGE);
				return false;
			} else {
				Persona p = new Persona(nuovoNome, nuovoCognome, "", nuovaDataNascita, nuovaMail, nuovoSesso, nuovoRuolo, new CittaItaliana(nuovaCitta, nuovaProvincia));
				PersonaDAO.inserirePersonale(p);
				JOptionPane.showInternalMessageDialog(null, "La persona è stata inserita", "Inserimento riuscito", JOptionPane.INFORMATION_MESSAGE);
				return true;
			}
		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Impossibile inserire la persona", "Inserimento fallito", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	
	public ArrayList<String> getProvince() {
		try {
			return CittaItalianaDAO.getProvince();
		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Impossibile caricare le province", "Caricamento fallito", JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}
	
	public ArrayList<String> getCittaFromProvincia(String provincia){
		try {
			return CittaItalianaDAO.getCittaFromProvincia(provincia);
		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Impossibile caricare le città", "Caricamento fallito", JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}
}
