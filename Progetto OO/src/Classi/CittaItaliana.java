package Classi;

import java.util.ArrayList;

public class CittaItaliana {

	//Attributi
	private String codiceCatastale;
	private String denominazione;
	private String provincia;
	private String regione;
	private ArrayList<Persona> personeNate;
	
	//Costruttore
	public CittaItaliana(String codiceCatastale, String denominazione, String provincia, String regione,
			ArrayList<Persona> personeNate) {
		this.codiceCatastale = codiceCatastale;
		this.denominazione = denominazione;
		this.provincia = provincia;
		this.regione = regione;
		this.personeNate = personeNate;
	}
	
	public CittaItaliana(String denominazione, String provincia) {
		this.setDenominazione(denominazione);
		this.setProvincia(provincia);
	}
	
	//Getter e setter
	public String getCodiceCatastale() {
		return codiceCatastale;
	}
	public void setCodiceCatastale(String codiceCatastale) {
		this.codiceCatastale = codiceCatastale;
	}
	public String getDenominazione() {
		return denominazione;
	}
	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getRegione() {
		return regione;
	}
	public void setRegione(String regione) {
		this.regione = regione;
	}
	public ArrayList<Persona> getPersoneNate() {
		return personeNate;
	}
	public void setPersoneNate(ArrayList<Persona> personeNate) {
		this.personeNate = personeNate;
	}
}
