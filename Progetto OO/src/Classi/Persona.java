package Classi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

import Enum.*;

public class Persona {

	//Attributi
	private String nome;
	private String cognome;
	private String CF;
	private LocalDate dataNascita;
	private String email;
	private TSesso sesso;
	private TRuolo ruolo;
	private TPersona tipo;
	private ArrayList<Acquisto> acquisti;
	private String codiceBarre;
	private CittaItaliana natoIn;
	
	//Costruttori
	
	//Costruttore completo di tutti gli attributi
	public Persona(String nome, String cognome, String cF, LocalDate dataNascita, String email, String sesso,
			String ruolo, String tipo, ArrayList<Acquisto> acquisti, String codiceBarre, CittaItaliana natoIn) {
		this.setNome(nome);
		this.setCognome(cognome);
		this.setCF(cF);
		this.setDataNascita(dataNascita);
		this.setEmail(email);
		this.setSesso(sesso);
		this.setRuolo(ruolo);
		this.setTipo(tipo);
		this.setAcquisti(acquisti);
		this.setCodiceBarre(codiceBarre);
		this.setNatoIn(natoIn);
		this.checkInfo();
	}
	
	//costruttore con dataNascita LocalDate
	public Persona(String nome, String cognome, String cF, LocalDate dataNascita, String email, String sesso,
			String ruolo, CittaItaliana natoIn) {
		this.setNome(nome);
		this.setCognome(cognome);
		this.setCF(cF);
		this.setDataNascita(dataNascita);
		this.setEmail(email);
		this.setSesso(sesso);
		this.setRuolo(ruolo);
		this.setNatoIn(natoIn);
		//this.checkInfo();
	}
	
	//costruttore con dataNascita String
	public Persona(String nome, String cognome, String cF, String dataNascita, String email, String sesso,
			String ruolo, CittaItaliana natoIn) {
		this.setNome(nome);
		this.setCognome(cognome);
		this.setCF(cF);
		this.setDataNascita(dataNascita);
		this.setEmail(email);
		this.setSesso(sesso);
		this.setRuolo(ruolo);
		this.setNatoIn(natoIn);
		//this.checkInfo();
	}

	private void checkInfo() {
		if(this.getTipo().equals("Cliente") && this.getRuolo().equals("null")) {
			this.setTipo("Personale");
		}
	}



	//Getter e setter
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome.length()==0) System.out.println("Non puoi inserire un nome vuoto");
		else {
			for(char c:nome.toCharArray()) {
				if(c=='0' || c=='1' || c=='2' || c=='3' || c=='4' || c=='5' || c=='6' || c=='7' || c=='8' || c=='9') {
					System.out.println("La stringa contiene caratteri non validi");
					nome = " ";
					return;
				}
			}
			this.nome = nome;
		}
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		if(cognome.length()==0) System.out.println("Non puoi inserire un cognome vuoto");
		else {
			for(char c:cognome.toCharArray()) {
				if(c=='0' || c=='1' || c=='2' || c=='3' || c=='4' || c=='5' || c=='6' || c=='7' || c=='8' || c=='9') {
					System.out.println("La stringa contiene caratteri non validi");
					nome = " ";
					return;
				}
			}
			this.cognome = cognome;
		}
	}
	public String getCF() {
		return CF;
	}
	public void setCF(String cF) {
		CF = cF;
	}
	public LocalDate getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}
	public void setDataNascita(String dataNascita) {
		this.dataNascita = LocalDate.parse(dataNascita, DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ITALIAN));
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if(email.length()==0) System.out.println("Non puoi inserire una mail vuota");
		else {
			if(email.matches("^(.+)@(.+)$")) {
				this.email = email;
			}else {
				email = "mail@non.valida";
			}
		}
	}
	public TSesso getSesso() {
		return sesso;
	}
	public void setSesso(String sesso) {
		if(sesso.equalsIgnoreCase("maschio") || sesso.equalsIgnoreCase("m")) this.sesso = TSesso.M;
		else this.sesso = TSesso.F;
	}
	public String getRuolo() {
		if(ruolo == null) return "";
		return ruolo.toString();
	}
	public void setRuolo(String ruolo) {
		if(ruolo==null) ruolo=null;
		else if(ruolo.equalsIgnoreCase("titolare")) this.ruolo = TRuolo.Titolare;
		else if(ruolo.equalsIgnoreCase("dipendente")) this.ruolo = TRuolo.Dipendente;
		else ruolo=null;
	}
	public String getTipo() {
		return tipo.toString();
	}
	public void setTipo(String tipo) {
		//System.out.println(tipo);
		if(tipo.equalsIgnoreCase("cliente")) this.tipo = TPersona.Cliente;
		else this.tipo = TPersona.Personale;
	}
	public ArrayList<Acquisto> getAcquisti() {
		return acquisti;
	}
	public void setAcquisti(ArrayList<Acquisto> acquisti) {
		this.acquisti = acquisti;
	}
	public String getCodiceBarre() {
		return codiceBarre;
	}
	public void setCodiceBarre(String codiceBarre) {
		this.codiceBarre = codiceBarre;
	}
	public CittaItaliana getNatoIn() {
		return natoIn;
	}
	public void setNatoIn(CittaItaliana natoIn) {
		this.natoIn = natoIn;
	}
	
}
