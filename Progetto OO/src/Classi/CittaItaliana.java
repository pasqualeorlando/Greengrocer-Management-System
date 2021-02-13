package Classi;

import java.util.ArrayList;

public class CittaItaliana {

	//Attributi
	private String CodiceCatastale;
	private String Denominazione;
	private String Provincia;
	private String Regione;
	private ArrayList<Persona>PersoneNate;
	
	//Costruttore
	public CittaItaliana(String codiceCatastale, String denominazione, String provincia, String regione,
			ArrayList<Persona> personeNate) {
		CodiceCatastale = codiceCatastale;
		Denominazione = denominazione;
		Provincia = provincia;
		Regione = regione;
		PersoneNate = personeNate;
	}
	
	//Getter e setter
	public String getCodiceCatastale() {
		return CodiceCatastale;
	}
	public void setCodiceCatastale(String codiceCatastale) {
		CodiceCatastale = codiceCatastale;
	}
	public String getDenominazione() {
		return Denominazione;
	}
	public void setDenominazione(String denominazione) {
		Denominazione = denominazione;
	}
	public String getProvincia() {
		return Provincia;
	}
	public void setProvincia(String provincia) {
		Provincia = provincia;
	}
	public String getRegione() {
		return Regione;
	}
	public void setRegione(String regione) {
		Regione = regione;
	}
	public ArrayList<Persona> getPersoneNate() {
		return PersoneNate;
	}
	public void setPersoneNate(ArrayList<Persona> personeNate) {
		PersoneNate = personeNate;
	}
}
