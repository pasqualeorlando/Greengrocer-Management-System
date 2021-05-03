package Controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import javax.swing.*;
import DB.*;
import DaoImpl.*;
import Enum.*;
import Gui.*;
import Classi.*;

public class Controller {
	private Connection connection;
	private LoginFrame login;
	private HomepageFrame homepage;
	private ModificaAccountFrame modificaAccount;
	private PersonaleFrame personale;
	private ClientiFrame clienti;
	private PersonaDAOPostgresImpl personaDAO;
	private CittaItalianaDAOPostgresImpl cittaItalianaDAO;
	private ProdottiFrame prodotti;
	private ProdottoDAOPostgresImpl prodottoDAO;
	private RifornimentoFrame rifornimento;
	private NuovaFornituraFrame nuovaFornitura;
	private FornitoreDAOPostgresImpl fornitoreDAO;
	private FornituraDAOPostgresImpl fornituraDAO;
	private FruttaDAOPostgresImpl fruttaDAO;
	private VerduraDAOPostgresImpl verduraDAO;
	private FarinaceoDAOPostgresImpl farinaceoDAO;
	private LatticinoDAOPostgresImpl latticinoDAO;
	private UovaDAOPostgresImpl uovaDAO;
	private ConfezionatoDAOPostgresImpl confezionatoDAO;
	private NuovoFornitoreFrame nuovoFornitore;
	
	
	public Controller() {
		
		DBConnection dbconn = null;
        connection = null;

        try{
            dbconn = DBConnection.getInstance();
            connection = dbconn.getConnection();
            personaDAO = new PersonaDAOPostgresImpl(connection);
            cittaItalianaDAO = new CittaItalianaDAOPostgresImpl(connection);
            prodottoDAO = new ProdottoDAOPostgresImpl(connection);
            fornitoreDAO = new FornitoreDAOPostgresImpl(connection);
            fornituraDAO = new FornituraDAOPostgresImpl(connection);
            fruttaDAO = new FruttaDAOPostgresImpl(connection);
            verduraDAO = new VerduraDAOPostgresImpl(connection);
            farinaceoDAO = new FarinaceoDAOPostgresImpl(connection);
            latticinoDAO = new LatticinoDAOPostgresImpl(connection);
            uovaDAO = new UovaDAOPostgresImpl(connection);
            confezionatoDAO = new ConfezionatoDAOPostgresImpl(connection);
            login = new LoginFrame(this);
            login.setVisible(true);
        }catch(SQLException e) {
        	//System.out.println("Impossibile connettersi al DB");
        	JOptionPane.showInternalMessageDialog(null, "Impossibile connettersi al Database.\nRiprova pi� tardi.", "Errore connessione", JOptionPane.ERROR_MESSAGE);
        	System.exit(-1);
        } catch (IOException e) {
			//System.out.println("Impossibile trovare il file di configurazione del DB");
			JOptionPane.showInternalMessageDialog(null, "Impossibile trovare il file dbconf.properties.\nVerificare nelle directory del programma.", "File configurazione non trovato", JOptionPane.ERROR_MESSAGE);
			System.exit(-1);
        }
	}
	
	public void validaCredenziali(String user, String password) {
		
		if(user.length() == 0 || password.length() == 0) {
			JOptionPane.showInternalMessageDialog(null, "Inserire entrambe le informazioni!", "Errore durante l'accesso", JOptionPane.ERROR_MESSAGE);
		}else {
			try {
				if(personaDAO.controlloCredenzialiDipendente(user, password)) {
					//JOptionPane.showInternalMessageDialog(null, "Login effettuato con successo", "Login", JOptionPane.INFORMATION_MESSAGE);
					login.setVisible(false);
					Persona p = personaDAO.getPersonaDaEmail(user);
					homepage = new HomepageFrame(this, p);
					homepage.setVisible(true);
				}else {
					JOptionPane.showInternalMessageDialog(null, "Credenziali errate", "Errore", JOptionPane.ERROR_MESSAGE);
				}
			} catch (SQLException e) {
				JOptionPane.showInternalMessageDialog(null, "Non � possibile eseguire l'accesso. Controllare la connessione al database", "Errore connessione", JOptionPane.ERROR_MESSAGE);
				System.exit(-1);
			}
		}
	}
	
	public void exit() {
		
		//Homepage.setVisible(false);
		homepage.dispose();
		login.setVisible(true);
	}
	
	public void vaiHomepage(JFrame framePrecedente, Persona p) {
		
		homepage = new HomepageFrame(this, p);
		homepage.setVisible(true);
		framePrecedente.dispose();
	}
	
	public void vaiModificaAccount(JFrame provenienza, Persona committente, String CFPersonaDaModificare) {
	
		try {
			Persona daModificare = personaDAO.getPersonaDaCF(CFPersonaDaModificare);
			modificaAccount = new ModificaAccountFrame(this, daModificare, committente);
			modificaAccount.setVisible(true);
			provenienza.dispose();
		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Impossibile trovare la persona selezionata.\nRiavviare l'applicazione e verificare la connessione", "Errore", JOptionPane.ERROR_MESSAGE);
			System.exit(-1);
		}
	}
	
	
	public void salvaNuovaMail(String newMail, Persona daModificare, Persona committente) {
		
		if(newMail.equals(daModificare.getEmail()))
			JOptionPane.showInternalMessageDialog(null, "La nuova mail deve essere diversa da quella attuale", "Errore", JOptionPane.ERROR_MESSAGE);
		else if(!newMail.matches("^(.+)@(.+)$"))
			JOptionPane.showInternalMessageDialog(null, "Inserire una mail valida", "Errore", JOptionPane.ERROR_MESSAGE);
		else {
			try {
				personaDAO.aggiornaMail(newMail, daModificare);
				JOptionPane.showInternalMessageDialog(null, "Informazioni salvate con successo", "Aggiornamento riuscito", JOptionPane.INFORMATION_MESSAGE);
				daModificare.setEmail(newMail);
			} catch (SQLException e) {
				JOptionPane.showInternalMessageDialog(null, "Non � stato possibile portare a termine l'operazione. Riavviare l'applicazione e verificare la connessione", "Aggiornamento fallito", JOptionPane.ERROR_MESSAGE);
				System.exit(-1);
			}
			if(daModificare.getCF().equals(committente.getCF())) {
				modificaAccount.dispose();
				homepage = new HomepageFrame(this, committente);
				homepage.setVisible(true);
			}
			else {
				modificaAccount.dispose();
				clienti = new ClientiFrame(this, committente);
				clienti.setVisible(true);
			}
		}
	}
	
	public void vaiPersonale(Persona p) {
		
		if(p.getRuolo().equals(TRuolo.Dipendente.toString())) {
			JOptionPane.showInternalMessageDialog(null, "Questa operazione non � consentita ai dipendenti", "Accesso non consentito", JOptionPane.ERROR_MESSAGE);
		}else {
			homepage.dispose();
			personale = new PersonaleFrame(this, p);
			personale.setVisible(true);
		}
	}
	
	public Object[][] getPersonale(){
		
		int i = 0;
		try {
			int len = personaDAO.getPersonale().size();
			Object[][] personale = new Object[len][9];
			for(Persona p : personaDAO.getPersonale()) {
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
			//Personale.dispose();
			//Homepage.dispose();
			System.exit(-1);
			return null;
		}
	}
	
	public void aggiornaLabels(String cf, String finestra) { 
		//aggiorna le labels nelle finestre di gestione del personale e dei clienti
		try {
			Persona p = personaDAO.getPersonaDaCF(cf);
			String[] aggiornamento = {p.getCF(),p.getNome(),p.getCognome(),p.getDataNascita().toString(),p.getEmail(),p.getSesso().toString(),p.getNatoIn().getDenominazione(), p.getNatoIn().getProvincia()};
			if(p.getTipo().equals("Personale")) {
				if(p.getRuolo().equals("Titolare")) personale.setData(aggiornamento, 0);
				else personale.setData(aggiornamento, 1);
			} else
				clienti.setData(aggiornamento);
		} catch (SQLException e) {
			String[] aggiornamento = {"", "", "", "", "", "", "", ""};
			if(finestra.equals("Personale"))
				personale.setData(aggiornamento, -1);
			else
				clienti.setData(aggiornamento);
		} catch(ArrayIndexOutOfBoundsException e) {
			JOptionPane.showInternalMessageDialog(null, "Selezionare una persona dalla tabella", "Aggiornamento fallito", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void aggiornaLabelsProdotti(String nome, String marca) { 
		//aggiorna le labels nella finestra dei prodotti
		try {
			Prodotto prod = prodottoDAO.getProdottoDaNomeMarca(nome, marca);
			Object[] aggiornamento = {prod.getNome(), prod.getPaeseDiProvenienza(), prod.getMarca(), prod.getDataScadenza(),
									  prod.getQuantitaNegozio(), prod.getPrezzoUnitario(), prod.getScontoPercentuale(), prod.getQuantitaDeposito()};
			prodotti.setData(aggiornamento);
		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Errore durante la connessione al database.\nRiavviare il programma e controllare la connessione", "Errore", JOptionPane.ERROR_MESSAGE);
		} catch(NullPointerException e) {
			
		}
	}
	
	public boolean eliminaPersonaDaCF(String cfPersonaDaEliminare, Persona committente) {
		
		try {
			if(cfPersonaDaEliminare.equals(committente.getCF())) {
				JOptionPane.showInternalMessageDialog(null, "Non puoi eliminare il profilo corrente", "Eliminazione fallita", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			else{
				personaDAO.eliminaPersonaDaCF(cfPersonaDaEliminare);
				JOptionPane.showInternalMessageDialog(null, "Profilo eliminato", "Eliminazione avvenuta", JOptionPane.INFORMATION_MESSAGE);
				return true;
			}
		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Errore durante l'eliminazione.\nRiavviare l'applicazione e verificare la connessione.", "Eliminazione fallita", JOptionPane.ERROR_MESSAGE);
			System.exit(-1);
			return false;
		}
	}
	
	public boolean modificaRuoloDaCF(String nuovoRuolo, Persona committente, String cfPersonaDaModificare) {
		
		try{
			Persona personaDaModificare = personaDAO.getPersonaDaCF(cfPersonaDaModificare);
			if(personaDaModificare.getCF().equals(committente.getCF())) {
				JOptionPane.showInternalMessageDialog(null, "Non puoi modificare il tuo ruolo", "Modifica fallita", JOptionPane.ERROR_MESSAGE);
				return false;
			}else if(personaDaModificare.getRuolo().equals(TRuolo.Titolare.toString())) {
				JOptionPane.showInternalMessageDialog(null, "Non puoi modificare un titolare, puoi solo eliminarlo.", "Modifica fallita", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			else if(nuovoRuolo.equals(personaDaModificare.getRuolo())) {
				JOptionPane.showInternalMessageDialog(null, "Il profilo selezionato ha gi� questo ruolo", "Modifica fallita", JOptionPane.ERROR_MESSAGE);
				return false;
			}else {
				personaDAO.modificaRuolo(nuovoRuolo, personaDaModificare.getCF());
				JOptionPane.showInternalMessageDialog(null, "Profilo modificato", "Modifica avvenuta", JOptionPane.INFORMATION_MESSAGE);
				return true;
			}
		}catch(SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Errore durante la modifica.\nRiavviare l'applicazione e controllare la connessione", "Modifica fallita", JOptionPane.ERROR_MESSAGE);
			System.exit(-1);
			return false;
		}
	}
	
	public boolean inserisciPersona(String nuovoNome, String nuovoCognome, String nuovaDataNascita, String nuovaMail, String nuovoSesso, String nuovoRuolo, String Tipo, String nuovaCitta, String nuovaProvincia) {
		
		try {
			if(Tipo.equals(TPersona.Personale.toString())) {
				if(nuovoNome.equals("")||nuovoCognome.equals("")||nuovaMail.equals("")
						||nuovoSesso.equals("")||nuovoRuolo.equals("")||nuovaDataNascita.equals("")
						||nuovaCitta.equals("")||nuovaProvincia.equals("")) {
					JOptionPane.showInternalMessageDialog(null, "Compilare tutti i campi del form!", "Inserimento fallito", JOptionPane.ERROR_MESSAGE);
					return false;
				} else {
					Persona p = new Persona(nuovoNome, nuovoCognome, "", nuovaDataNascita, nuovaMail, nuovoSesso, nuovoRuolo, new CittaItaliana(nuovaCitta, nuovaProvincia));
					personaDAO.inserirePersona(p);
					JOptionPane.showInternalMessageDialog(null, "La persona � stata inserita", "Inserimento riuscito", JOptionPane.INFORMATION_MESSAGE);
					return true;
				}
			} else {
				if(nuovoNome.equals("")||nuovoCognome.equals("")||nuovaMail.equals("")
						||nuovoSesso.equals("")||nuovaDataNascita.equals("")
						||nuovaCitta.equals("")||nuovaProvincia.equals("")) {
					JOptionPane.showInternalMessageDialog(null, "Compilare tutti i campi del form!", "Inserimento fallito", JOptionPane.ERROR_MESSAGE);
					return false;
				} else {
					Persona p = new Persona(nuovoNome, nuovoCognome, "", nuovaDataNascita, nuovaMail, nuovoSesso, "", new CittaItaliana(nuovaCitta, nuovaProvincia));
					personaDAO.inserirePersona(p);
					JOptionPane.showInternalMessageDialog(null, "La persona � stata inserita", "Inserimento riuscito", JOptionPane.INFORMATION_MESSAGE);
					return true;
				}
			}

		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Impossibile inserire la persona.\nRiavviare l'applicazione e verificare la connessione.", "Inserimento fallito", JOptionPane.ERROR_MESSAGE);
			System.exit(-1);
			return false;
		}
	}
	
	public ArrayList<String> getProvince() {
		
		try {
			return cittaItalianaDAO.getProvince();
		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Impossibile caricare le province.\nVerificare la connessione e riavviare il programma!", "Caricamento fallito", JOptionPane.ERROR_MESSAGE);
			System.exit(-1);
			return null;
		}
	}
	
	public ArrayList<String> getCittaFromProvincia(String provincia){
		
		try {
			return cittaItalianaDAO.getCittaFromProvincia(provincia);
		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Impossibile caricare le citt�.\nVerificare la connessione e riavviare il programma!", "Caricamento fallito", JOptionPane.ERROR_MESSAGE);
			System.exit(-1);
			return null;
		}
	}
	
	public Object[][] getClienti(){
		
		int i = 0;
		try {
			int len = personaDAO.getClienti().size();
			Object[][] clienti = new Object[len][8];
			for(Persona p : personaDAO.getClienti()) {
				clienti[i][0]=p.getCF();
				clienti[i][1]=p.getNome();
				clienti[i][2]=p.getCognome();
				clienti[i][3]=p.getDataNascita();
				clienti[i][4]=p.getEmail();
				clienti[i][5]=p.getSesso();
				clienti[i][6]=p.getNatoIn().getDenominazione();
				clienti[i][7]=p.getNatoIn().getProvincia();
				i++;
			}
			return clienti;
		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Errore durante la ricerca dei Clienti nel database.\nRiavviare il programma.", "Errore", JOptionPane.ERROR_MESSAGE);
			clienti.dispose();
			homepage.dispose();
			return null;
		}
	}
	
	public void vaiClienti(Persona p) {
		
		homepage.dispose();
		clienti = new ClientiFrame(this, p);
		clienti.setVisible(true);
	}
	
	public void vaiProdotti(Persona p, JFrame framePrecedente) {
		
		framePrecedente.dispose();
		prodotti = new ProdottiFrame(this, p);
		prodotti.setVisible(true);
	}
	
	public Object[][] getProdotti(){
		
		int i = 0;
		try {
			int len = prodottoDAO.getProdotti().size();
			Object[][] prodotti = new Object[len][8];
			for(Prodotto p : prodottoDAO.getProdotti()) {
				prodotti[i][0]=p.getNome();
				prodotti[i][1]=p.getPaeseDiProvenienza();
				prodotti[i][2]=p.getMarca();
				prodotti[i][3]=p.getDataScadenza();
				prodotti[i][4]=p.getQuantitaNegozio();
				prodotti[i][5]=p.getPrezzoUnitario();
				prodotti[i][6]=p.getScontoPercentuale();
				prodotti[i][7]=p.getQuantitaDeposito();
				i++;
			}
			return prodotti;
		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Errore durante la ricerca dei Prodotti nel database.\nRiavviare il programma e controllare la connessione.", "Errore", JOptionPane.ERROR_MESSAGE);
			System.exit(-1);
			return null;
		}
	}
	
	public void aggiornaScontoProdotto(String nomeProdotto, String marcaProdotto, int nuovoSconto) {
		
		try {
			Prodotto prodottoDaAggiornare = prodottoDAO.getProdottoDaNomeMarca(nomeProdotto, marcaProdotto);
			if(prodottoDaAggiornare.getScontoPercentuale() == nuovoSconto)
				JOptionPane.showInternalMessageDialog(null, "Il prodotto ha gi� questo sconto.\nRiprovare con una nuova percentuale", "Errore", JOptionPane.ERROR_MESSAGE);
			else {
				prodottoDAO.aggiornaScontoProdotto(prodottoDaAggiornare, nuovoSconto);
				JOptionPane.showInternalMessageDialog(null, "Lo sconto � stato aggiornato", "Aggiornamento riuscito", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Errore durante la connessione al database.\nRiavviare il programma.", "Errore", JOptionPane.ERROR_MESSAGE);
			System.exit(-1);
		}
	}
	
	public void vaiRifornimento(String nomeProdotto, String marcaProdotto, Persona committente) {
		
		try {
			Prodotto p = prodottoDAO.getProdottoDaNomeMarca(nomeProdotto, marcaProdotto);
			rifornimento = new RifornimentoFrame(this, p, committente);
			rifornimento.setVisible(true);
			prodotti.dispose();
		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Errore durante la ricerca dei Prodotti nel database.\nRiavviare il programma e controllare la connessione.", "Errore", JOptionPane.ERROR_MESSAGE);
			System.exit(-1);
		}
		
	}
	
	public void rifornisciProdotto(Prodotto p, double quantitaDaRifornire, Persona committente) {
		
		if(quantitaDaRifornire == 0)
			JOptionPane.showInternalMessageDialog(null, "Non puoi rifornire di 0 unit�.", "Errore", JOptionPane.ERROR_MESSAGE);
		else {
			try {
				prodottoDAO.aggiornaQuantita(p, quantitaDaRifornire);
				rifornimento.dispose();
				JOptionPane.showInternalMessageDialog(null, "Le quantit� sono state aggiornate.", "Aggiornamento riuscito", JOptionPane.INFORMATION_MESSAGE);
				prodotti = new ProdottiFrame(this, committente);
				prodotti.setVisible(true);
			} catch (SQLException e) {
				JOptionPane.showInternalMessageDialog(null, "Impossibile aggiornare le quantit�.\nRiavviare il programma e verificare la connessione.", "Errore", JOptionPane.ERROR_MESSAGE);
				System.exit(-1);
			}
		}
	}
	
	public void vaiNuovaFornitura(Persona p) {
		
		homepage.dispose();
		nuovaFornitura = new NuovaFornituraFrame(this, p);
		nuovaFornitura.setVisible(true);
	}
	
	public ArrayList<String> getFornitoriPIvaNomeSocieta(){
		
		try {
			return fornitoreDAO.getFornitoriPIvaNomeSocieta();
		} catch (SQLException e) {
			JOptionPane.showInternalMessageDialog(null, "Impossibile recuperare i fornitori dal database", "Errore", JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}
	
	public void inserisciProdotto(String pIvaFornitore, float prezzoFornitura, String dataFornitura, String tipoProdotto, String nomeProdotto, String dataScadenza, String marca, String paese, float quantitaNegozio, float quantitaDeposito, float prezzo, String jolly1, String jolly2, Object jolly3) {
		
		pIvaFornitore = pIvaFornitore.substring(0, 11);
		if(pIvaFornitore.equals("") || prezzoFornitura == 0 || dataFornitura.equals(""))
			JOptionPane.showInternalMessageDialog(null, "Compilare tutti i campi relativi alla fornitura", "Errore", JOptionPane.ERROR_MESSAGE);
		else if(nomeProdotto.equals("") || paese.equals("") || quantitaNegozio == 0 || quantitaDeposito == 0 || prezzo == 0)
			JOptionPane.showInternalMessageDialog(null, "Compilare tutti i campi base del prodotto", "Errore", JOptionPane.ERROR_MESSAGE);
		else {
			Fornitura forn = new Fornitura(quantitaNegozio + quantitaDeposito, dataFornitura, prezzoFornitura, new Fornitore(pIvaFornitore, "", "", ""));
			if(tipoProdotto.equals("Frutta") || tipoProdotto.equals("Verdura")) {
				if(jolly1.equals(""))
					JOptionPane.showInternalMessageDialog(null, "Compilare la data di raccolta del prodotto", "Errore", JOptionPane.ERROR_MESSAGE);
				else {
					//Inserire prodotto frutta o verdura
					try {
						Frutta f = new Frutta(nomeProdotto, paese, quantitaNegozio, prezzo, 0, quantitaDeposito, forn, jolly1);
						Verdura v = new Verdura(nomeProdotto, paese, quantitaNegozio, prezzo, 0, quantitaDeposito, forn, jolly1);
						if(!marca.equals(""))
							f.setMarca(marca);
						
						connection.setAutoCommit(false);
						int idFornitura = fornituraDAO.inserisciFornitura(forn);
						prodottoDAO.inserisciProdotto(f, tipoProdotto, idFornitura);
						int codProdotto = prodottoDAO.getUltimoCodiceProdotto();
						if(tipoProdotto.equals("Frutta"))
							fruttaDAO.inserisciFrutta(codProdotto, f.getDataRaccolta().toString());
							
						else 
							verduraDAO.inserisciVerdura(codProdotto, v.getDataRaccolta().toString());
						
						connection.commit();
						connection.setAutoCommit(true);
						JOptionPane.showInternalMessageDialog(null, "Il prodotto � stato inserito con successo.", "Inserimento riuscito", JOptionPane.INFORMATION_MESSAGE);
					}catch(DateTimeParseException e) {
						JOptionPane.showInternalMessageDialog(null, "Inserire delle date valide!", "Errore", JOptionPane.ERROR_MESSAGE);
						try {
							connection.setAutoCommit(true);
						} catch (SQLException e1) {
							JOptionPane.showInternalMessageDialog(null, "Errore connessione. Uscita dal programma\n", "Errore", JOptionPane.ERROR_MESSAGE);
							System.exit(-1);
						}
					}catch (SQLException e) {
						JOptionPane.showInternalMessageDialog(null, e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
						try {
							connection.setAutoCommit(true);
						} catch (SQLException e1) {
							JOptionPane.showInternalMessageDialog(null, "Errore connessione. Uscita dal programma\n", "Errore", JOptionPane.ERROR_MESSAGE);
							System.exit(-1);
						}
					}
				}
			} else if(tipoProdotto.equals("Farinaceo")) {
				if(jolly3 == null)
					JOptionPane.showInternalMessageDialog(null, "Scegliere il tipo del farinaceo", "Errore", JOptionPane.ERROR_MESSAGE);
				else {
					//Inserire prodotto farinaceo
					try {
						Farinaceo f = new Farinaceo(nomeProdotto, paese, quantitaNegozio, prezzo, 0, quantitaDeposito, forn, dataScadenza, jolly3.toString());
						if(!marca.equals(""))
							f.setMarca(marca);
						
						connection.setAutoCommit(false);
						
						int idFornitura = fornituraDAO.inserisciFornitura(forn);
						prodottoDAO.inserisciProdotto(f, "Farinaceo", idFornitura);
						int codProdotto = prodottoDAO.getUltimoCodiceProdotto();
						farinaceoDAO.inserisciFarinaceo(codProdotto, f.getTipoFarinaceo().toString());
						connection.commit();
						connection.setAutoCommit(true);
						JOptionPane.showInternalMessageDialog(null, "Il prodotto � stato inserito con successo.", "Inserimento riuscito", JOptionPane.INFORMATION_MESSAGE);
					} catch (SQLException e) {
						JOptionPane.showInternalMessageDialog(null, e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
						try {
							connection.setAutoCommit(true);
						} catch (SQLException e1) {
							JOptionPane.showInternalMessageDialog(null, "Errore connessione. Uscita dal programma\n", "Errore", JOptionPane.ERROR_MESSAGE);
							System.exit(-1);
						}
					} catch(DateTimeParseException e) {
						JOptionPane.showInternalMessageDialog(null, "Inserire delle date valide\n", "Errore", JOptionPane.ERROR_MESSAGE);
						try {
							connection.setAutoCommit(true);
						} catch (SQLException e1) {
							JOptionPane.showInternalMessageDialog(null, "Errore connessione. Uscita dal programma\n", "Errore", JOptionPane.ERROR_MESSAGE);
							System.exit(-1);
						}
					}
					
				}
			} else if(tipoProdotto.equals("Latticino")) {
				if(jolly1.equals("") || jolly2.equals(""))
					JOptionPane.showInternalMessageDialog(null, "Compilare i dati aggiuntivi del prodotto latticino", "Errore", JOptionPane.ERROR_MESSAGE);
				else {
					//Inserire prodotto latticino
					try {
						Latticino l = new Latticino(nomeProdotto, paese, quantitaNegozio, prezzo, 0, quantitaDeposito, forn, dataScadenza, jolly1.toString(), jolly2.toString());
					
						if(!marca.equals(""))
							l.setMarca(marca);
					
						connection.setAutoCommit(false);
					
						int idFornitura = fornituraDAO.inserisciFornitura(forn);
						prodottoDAO.inserisciProdotto(l, "Latticino", idFornitura);
						int codProdotto = prodottoDAO.getUltimoCodiceProdotto();
						latticinoDAO.inserisciLatticino(codProdotto, l.getDataMungitura().toString(), l.getDataProduzione().toString());
						connection.commit();
						connection.setAutoCommit(true);
						JOptionPane.showInternalMessageDialog(null, "Il prodotto � stato inserito con successo.", "Inserimento riuscito", JOptionPane.INFORMATION_MESSAGE);
					} catch (SQLException e) {
						JOptionPane.showInternalMessageDialog(null, e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
						try {
							connection.setAutoCommit(true);
						} catch (SQLException e1) {
							JOptionPane.showInternalMessageDialog(null, "Errore connessione. Uscita dal programma\n", "Errore", JOptionPane.ERROR_MESSAGE);
							System.exit(-1);
						}
					} catch(DateTimeParseException e) {
						JOptionPane.showInternalMessageDialog(null, "Inserire delle date valide\n", "Errore", JOptionPane.ERROR_MESSAGE);
						try {
							connection.setAutoCommit(true);
						} catch (SQLException e1) {
							JOptionPane.showInternalMessageDialog(null, "Errore connessione. Uscita dal programma\n", "Errore", JOptionPane.ERROR_MESSAGE);
							System.exit(-1);
						}
					}
				}
			} else if(tipoProdotto.equals("Uova")) {
				if(jolly3 == null)
					JOptionPane.showInternalMessageDialog(null, "Compilare il tipo di allevamento delle uova", "Errore", JOptionPane.ERROR_MESSAGE);
				else {
					//Inserire prodotto uova
					try {
						Uova u = new Uova(nomeProdotto, paese, quantitaNegozio, prezzo, 0, quantitaDeposito, forn, dataScadenza, jolly3.toString());
					
						if(!marca.equals(""))
							u.setMarca(marca);
					
						connection.setAutoCommit(false);
					
						int idFornitura = fornituraDAO.inserisciFornitura(forn);
						prodottoDAO.inserisciProdotto(u, "Uova", idFornitura);
						int codProdotto = prodottoDAO.getUltimoCodiceProdotto();
						uovaDAO.inserisciUova(codProdotto, u.getTipoAllevamento());
						connection.commit();
						connection.setAutoCommit(true);
						JOptionPane.showInternalMessageDialog(null, "Il prodotto � stato inserito con successo.", "Inserimento riuscito", JOptionPane.INFORMATION_MESSAGE);
					} catch (SQLException e) {
						JOptionPane.showInternalMessageDialog(null, e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
						try {
							connection.setAutoCommit(true);
						} catch (SQLException e1) {
							JOptionPane.showInternalMessageDialog(null, "Errore connessione. Uscita dal programma\n", "Errore", JOptionPane.ERROR_MESSAGE);
							System.exit(-1);
						}
					} catch(DateTimeParseException e) {
						JOptionPane.showInternalMessageDialog(null, "Inserire delle date valide\n", "Errore", JOptionPane.ERROR_MESSAGE);
						try {
							connection.setAutoCommit(true);
						} catch (SQLException e1) {
							JOptionPane.showInternalMessageDialog(null, "Errore connessione. Uscita dal programma\n", "Errore", JOptionPane.ERROR_MESSAGE);
							System.exit(-1);
						}
					}

				}
			} else {
				if(jolly1.equals(""))
					JOptionPane.showInternalMessageDialog(null, "Compilare il tipo confezione", "Errore", JOptionPane.ERROR_MESSAGE);
				else {
					//Inserire prodotto confezionato
					try {
						Confezionato c = new Confezionato(nomeProdotto, paese, quantitaNegozio, prezzo, 0, quantitaDeposito, forn, dataScadenza, jolly1.toString());
					
						if(!marca.equals(""))
							c.setMarca(marca);
					
						connection.setAutoCommit(false);
					
						int idFornitura = fornituraDAO.inserisciFornitura(forn);
						prodottoDAO.inserisciProdotto(c, "Confezionato", idFornitura);
						int codProdotto = prodottoDAO.getUltimoCodiceProdotto();
						confezionatoDAO.inserisciConfezionato(codProdotto, c.getTipoConfezione());
						connection.commit();
						connection.setAutoCommit(true);
						JOptionPane.showInternalMessageDialog(null, "Il prodotto � stato inserito con successo.", "Inserimento riuscito", JOptionPane.INFORMATION_MESSAGE);
					} catch (SQLException e) {
						JOptionPane.showInternalMessageDialog(null, e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
						try {
							connection.setAutoCommit(true);
						} catch (SQLException e1) {
							JOptionPane.showInternalMessageDialog(null, "Errore connessione. Uscita dal programma\n", "Errore", JOptionPane.ERROR_MESSAGE);
							System.exit(-1);
						}
					} catch(DateTimeParseException e) {
						JOptionPane.showInternalMessageDialog(null, "Inserire delle date valide\n", "Errore", JOptionPane.ERROR_MESSAGE);
						try {
							connection.setAutoCommit(true);
						} catch (SQLException e1) {
							JOptionPane.showInternalMessageDialog(null, "Errore connessione. Uscita dal programma\n", "Errore", JOptionPane.ERROR_MESSAGE);
							System.exit(-1);
						}
					}
				}
			}
		}
		nuovaFornitura.resetForm();
	}
	
	public void vaiNuovoFornitore(Persona p) {
		homepage.dispose();
		nuovoFornitore = new NuovoFornitoreFrame(this, p);
		nuovoFornitore.setVisible(true);
	}

	public void inserisciFornitore(String pIva, String nomeSocieta, String nomeTitolare, String cognomeTitolare) {
		
		if(pIva.equals("") || nomeSocieta.equals("") || nomeTitolare.equals("") || cognomeTitolare.equals("")) 
			JOptionPane.showInternalMessageDialog(null, "Inserire tutti i campi richiesti.", "Errore", JOptionPane.ERROR_MESSAGE);
		else {
			Fornitore f = new Fornitore(pIva, nomeSocieta, nomeTitolare, cognomeTitolare);
			try {
				fornitoreDAO.inserisciFornitore(f);
				JOptionPane.showInternalMessageDialog(null, "Fornitore inserito con successo", "Operazione riuscita", JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException e) {
				JOptionPane.showInternalMessageDialog(null, e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
	}
}
