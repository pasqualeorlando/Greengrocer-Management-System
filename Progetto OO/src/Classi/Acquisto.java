package Classi;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Acquisto {
	
	//Attributi
	private LocalDateTime DataOra;
	private char Cassa;
	private int ScontoPercentuale;
	private float Totale;
	private boolean Completato;
	private String CF;
	private ArrayList<SpecificaAcquisto>SpecificaAcquisto;
	
	//Costruttore
	public Acquisto(LocalDateTime dataOra, char cassa, int scontoPercentuale, float totale, boolean completato) {
		DataOra = dataOra;
		Cassa = cassa;
		ScontoPercentuale = scontoPercentuale;
		Totale = totale;
		Completato = completato;
	}
	
	public Acquisto(LocalDateTime dataOra, char cassa, int scontoPercentuale, float totale, boolean completato, String cf) {
		DataOra = dataOra;
		Cassa = cassa;
		ScontoPercentuale = scontoPercentuale;
		Totale = totale;
		Completato = completato;
		CF = cf;
	}
	
	//Getter e setter
	public LocalDateTime getDataOra() {
		return DataOra;
	}
	public void setDataOra(LocalDateTime dataOra) {
		DataOra = dataOra;
	}
	public char getCassa() {
		return Cassa;
	}
	public void setCassa(char cassa) {
		Cassa = cassa;
	}
	public int getScontoPercentuale() {
		return ScontoPercentuale;
	}
	public void setScontoPercentuale(int scontoPercentuale) {
		ScontoPercentuale = scontoPercentuale;
	}
	public float getTotale() {
		return Totale;
	}
	public void setTotale(float totale) {
		Totale = totale;
	}
	public boolean isCompletato() {
		return Completato;
	}
	public void setCompletato(boolean completato) {
		Completato = completato;
	}
	public String getCF() {
		return CF;
	}
	public void setCF(String cF) {
		CF = cF;
	}
	public ArrayList<SpecificaAcquisto> getSpecificaAcquisto() {
		return SpecificaAcquisto;
	}
	public void setSpecificaAcquisto(ArrayList<SpecificaAcquisto> specificaAcquisto) {
		SpecificaAcquisto = specificaAcquisto;
	}
	
}
