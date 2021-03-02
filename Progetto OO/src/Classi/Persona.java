package Classi;

import java.time.LocalDate;
import java.util.ArrayList;

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
	
	//Costruttore
	public Persona(String nome, String cognome, String cF, LocalDate dataNascita, String email, TSesso sesso, CittaItaliana Citta) {
		Nome = nome;
		Cognome = cognome;
		CF = cF;
		DataNascita = dataNascita;
		Email = email;
		Sesso = sesso;
		NatoIn = Citta;
	}
	
	//Getter e setter
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getCognome() {
		return Cognome;
	}
	public void setCognome(String cognome) {
		Cognome = cognome;
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
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public TSesso getSesso() {
		return Sesso;
	}
	public void setSesso(TSesso sesso) {
		Sesso = sesso;
	}
	public TRuolo getRuolo() {
		return Ruolo;
	}
	public void setRuolo(TRuolo ruolo) {
		Ruolo = ruolo;
	}
	public TPersona getTipo() {
		return Tipo;
	}
	public void setTipo(TPersona tipo) {
		Tipo = tipo;
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
