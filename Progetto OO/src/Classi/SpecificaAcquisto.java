package Classi;

public class SpecificaAcquisto {

	//Attributi
	private float QuantitaAcquistata;
	private Acquisto Acq;
	private Prodotto Prod;

	
	//Costruttore
	public SpecificaAcquisto(float quantitaAcquistata, Acquisto acq, Prodotto prod) {
		super();
		QuantitaAcquistata = quantitaAcquistata;
		Acq = acq;
		Prod = prod;
	}
	
	
	//Getter e setter
	public float getQuantitaAcquistata() {
		return QuantitaAcquistata;
	}
	public void setQuantitaAcquistata(float quantitaAcquistata) {
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
