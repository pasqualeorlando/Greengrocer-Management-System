package Classi;

public class SpecificaAcquisto {

	//Attributi
	private double QuantitaAcquistata;
	private Acquisto Acq;
	private Prodotto Prod;

	
	//Costruttore
	public SpecificaAcquisto(double quantitaAcquistata, Acquisto acq, Prodotto prod) {
		super();
		QuantitaAcquistata = quantitaAcquistata;
		Acq = acq;
		Prod = prod;
	}
	
	
	//Getter e setter
	public double getQuantitaAcquistata() {
		return QuantitaAcquistata;
	}
	public void setQuantitaAcquistata(double quantitaAcquistata) {
		QuantitaAcquistata = quantitaAcquistata;
	}
	public Acquisto getAcq() {
		return Acq;
	}
	public void setAcq(Acquisto acq) {
		Acq = acq;
	}
	public Prodotto getProd() {
		return Prod;
	}
	public void setProd(Prodotto prod) {
		Prod = prod;
	}
	
	
}
