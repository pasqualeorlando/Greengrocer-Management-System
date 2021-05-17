package classi;

public class SpecificaAcquisto {

	//Attributi
	private float quantitaAcquistata;
	private Acquisto acq;
	private Prodotto prod;

	
	//Costruttore
	public SpecificaAcquisto(float quantitaAcquistata, Acquisto acq, Prodotto prod) {
		super();
		this.quantitaAcquistata = quantitaAcquistata;
		this.acq = acq;
		this.prod = prod;
	}
	
	
	//Getter e setter
	public float getQuantitaAcquistata() {
		return quantitaAcquistata;
	}
	public void setQuantitaAcquistata(float quantitaAcquistata) {
		this.quantitaAcquistata = quantitaAcquistata;
	}
	public Acquisto getAcq() {
		return acq;
	}
	public void setAcq(Acquisto acq) {
		this.acq = acq;
	}
	public Prodotto getProd() {
		return prod;
	}
	public void setProd(Prodotto prod) {
		this.prod = prod;
	}
	
	
}
