package Classi;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Acquisto {
	
	//Attributi
	private LocalDateTime dataOra;
	private char cassa;
	private int scontoPercentuale;
	private float totale;
	private boolean completato;
	private String CF;
	private ArrayList<SpecificaAcquisto> specificaAcquisto;
	
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
		return dataOra;
	}
	public void setDataOra(LocalDateTime dataOra) {
		if(dataOra.isAfter(LocalDateTime.now())) {
			System.out.println("Data e ora errati, sono stati automaticamente impostati ad oggi");
			dataOra = LocalDateTime.now();
		}else {
			this.dataOra = dataOra;
		}
	}
	public char getCassa() {
		return cassa;
	}
	public void setCassa(char cassa) {
		if(cassa-'0' < 0 || cassa-'0' > 10) {
			System.out.println("La cassa deve essere compresa tra 0 o 9");
			cassa = '0';
		}else {
			this.cassa = cassa;
		}
	}
	public int getScontoPercentuale() {
		return scontoPercentuale;
	}
	public void setScontoPercentuale(int scontoPercentuale) {
		if(scontoPercentuale < 0 || scontoPercentuale > 100) {
			System.out.println("Non è possibile impostare uno sconto negativo, sarà impostato a 0");
			scontoPercentuale = 0;
		}else {
			this.scontoPercentuale = scontoPercentuale;
		}
	}
	public float getTotale() {
		return totale;
	}
	public void setTotale(float totale) {
		if(totale<0) {
			System.out.println("Non è possibile impostare un totale negativo");
			totale = 0;
		}else {
			this.totale = totale;
		}
	}
	public boolean isCompletato() {
		return completato;
	}
	public void setCompletato(boolean completato) {
		this.completato = completato;
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
		return specificaAcquisto;
	}
	public void setSpecificaAcquisto(ArrayList<SpecificaAcquisto> specificaAcquisto) {
		this.specificaAcquisto = specificaAcquisto;
	}
	
}
