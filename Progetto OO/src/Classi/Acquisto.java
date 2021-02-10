package Classi;

import java.time.LocalDateTime;

public class Acquisto {
	
	//Attributi
	private LocalDateTime DataOra;
	private char Cassa;
	private int ScontoPercentuale;
	private double Totale;
	private boolean Completato;
	
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
	public double getTotale() {
		return Totale;
	}
	public void setTotale(double totale) {
		Totale = totale;
	}
	public boolean isCompletato() {
		return Completato;
	}
	public void setCompletato(boolean completato) {
		Completato = completato;
	}
	
	
	
}
