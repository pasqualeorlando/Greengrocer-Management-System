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
		setDataOra(dataOra);
		setCassa(cassa);
		setScontoPercentuale(scontoPercentuale);
		setTotale(totale);
		setCompletato(completato);
	}
	
	public Acquisto(LocalDateTime dataOra, char cassa, int scontoPercentuale, float totale, boolean completato, String cf) {
		setDataOra(dataOra);
		setCassa(cassa);
		setScontoPercentuale(scontoPercentuale);
		setTotale(totale);
		setCompletato(completato);
		setCF(cf);
	}
	
	//Getter e setter
	public LocalDateTime getDataOra() {
		return DataOra;
	}
	public void setDataOra(LocalDateTime dataOra) {
		if(dataOra.isAfter(LocalDateTime.now())) {
			System.out.println("Data e ora errati, sono stati automaticamente impostati ad oggi");
			dataOra = LocalDateTime.now();
		}else {
			DataOra = dataOra;
		}
	}
	public char getCassa() {
		return Cassa;
	}
	public void setCassa(char cassa) {
		if(cassa-'0' < 0 || cassa-'0' > 10) {
			System.out.println("La cassa deve essere compresa tra 0 o 9");
			Cassa = '0';
		}else {
			Cassa = cassa;
		}
	}
	public int getScontoPercentuale() {
		return ScontoPercentuale;
	}
	public void setScontoPercentuale(int scontoPercentuale) {
		if(scontoPercentuale < 0 || scontoPercentuale > 100) {
			System.out.println("Non è possibile impostare uno sconto negativo, sarà impostato a 0");
			ScontoPercentuale = 0;
		}else {
			ScontoPercentuale = scontoPercentuale;
		}
	}
	public float getTotale() {
		return Totale;
	}
	public void setTotale(float totale) {
		if(totale<0) {
			System.out.println("Non è possibile impostare un totale negativo");
			Totale = 0;
		}else {
			Totale = totale;
		}
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
		if(cF.length()!=16) {
			System.out.println("CF malformato, sarà impostato a null");
			CF = null;
		}else {
			CF = cF;
		}
	}
	public ArrayList<SpecificaAcquisto> getSpecificaAcquisto() {
		return SpecificaAcquisto;
	}
	public void setSpecificaAcquisto(ArrayList<SpecificaAcquisto> specificaAcquisto) {
		SpecificaAcquisto = specificaAcquisto;
	}
	
}
