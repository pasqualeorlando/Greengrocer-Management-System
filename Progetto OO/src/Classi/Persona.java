package Classi;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

import Enum.*;

public class Persona {

	//Attributi
	private String Nome;
	private String Cognome;
	private String CF;
	private LocalDate DataNascita;
	private String Email;
	private TSesso Sesso;
	private TRuolo Ruolo;
	private TPersona Tipo;
	private ArrayList<Acquisto>Acquisti;
	private String CodiceBarre;
	private CittaItaliana NatoIn;
	
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
		return Nome;
	}
	public void setNome(String nome) {
		if(nome.length()==0) System.out.println("Non puoi inserire un nome vuoto");
		else {
			for(char c:nome.toCharArray()) {
				if(c=='0' || c=='1' || c=='2' || c=='3' || c=='4' || c=='5' || c=='6' || c=='7' || c=='8' || c=='9') {
					System.out.println("La stringa contiene caratteri non validi");
					Nome = " ";
					return;
				}
			}
			Nome = nome;
		}
	}
	public String getCognome() {
		return Cognome;
	}
	public void setCognome(String cognome) {
		if(cognome.length()==0) System.out.println("Non puoi inserire un cognome vuoto");
		else {
			for(char c:cognome.toCharArray()) {
				if(c=='0' || c=='1' || c=='2' || c=='3' || c=='4' || c=='5' || c=='6' || c=='7' || c=='8' || c=='9') {
					System.out.println("La stringa contiene caratteri non validi");
					Nome = " ";
					return;
				}
			}
			Cognome = cognome;
		}
	}
	public String getCF() {
		return CF;
	}
	public void setCF(String cF) {
		CF = cF;
	}
	public LocalDate getDataNascita() {
		return DataNascita;
	}
	public void setDataNascita(LocalDate dataNascita) {
		DataNascita = dataNascita;
	}
	public void setDataNascita(String dataNascita) {
		DataNascita = LocalDate.parse(dataNascita, DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ITALIAN));
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		if(email.length()==0) System.out.println("Non puoi inserire una mail vuota");
		else {
			if(email.matches("^(.+)@(.+)$")) {
				Email = email;
			}else {
				Email = "mail@non.valida";
			}
		}
	}
	public TSesso getSesso() {
		return Sesso;
	}
	public void setSesso(String sesso) {
		if(sesso.equalsIgnoreCase("maschio") || sesso.equalsIgnoreCase("m")) Sesso = TSesso.M;
		else Sesso = TSesso.F;
	}
	public String getRuolo() {
		if(Ruolo == null) return "";
		return Ruolo.toString();
	}
	public void setRuolo(String ruolo) {
		if(ruolo==null) Ruolo=null;
		else if(ruolo.equalsIgnoreCase("titolare")) Ruolo = TRuolo.Titolare;
		else if(ruolo.equalsIgnoreCase("dipendente")) Ruolo = TRuolo.Dipendente;
		else Ruolo=null;
	}
	public String getTipo() {
		return Tipo.toString();
	}
	public void setTipo(String tipo) {
		//System.out.println(tipo);
		if(tipo.equalsIgnoreCase("cliente")) Tipo = TPersona.Cliente;
		else Tipo = TPersona.Personale;
	}
	public ArrayList<Acquisto> getAcquisti() {
		return Acquisti;
	}
	public void setAcquisti(ArrayList<Acquisto> acquisti) {
		Acquisti = acquisti;
	}
	public String getCodiceBarre() {
		return CodiceBarre;
	}
	public void setCodiceBarre(String codiceBarre) {
		CodiceBarre = codiceBarre;
	}
	public CittaItaliana getNatoIn() {
		return NatoIn;
	}
	public void setNatoIn(CittaItaliana natoIn) {
		NatoIn = natoIn;
	}
	
}
