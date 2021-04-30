package Classi;

import java.time.LocalDate;

public class Fornitura {
	
	//Attributi
	private float quantitaFornita;
	private LocalDate dataFornitura;
	private float prezzoFornitura;
	private Prodotto prodotto;
	private Fornitore fornitore;
	
	//Costruttore
	public Fornitura(float quantitaFornita, LocalDate dataFornitura, float prezzoFornitura, Classi.Prodotto prodotto,
			Classi.Fornitore fornitore) {
		this.quantitaFornita = quantitaFornita;
		this.dataFornitura = dataFornitura;
		this.prezzoFornitura = prezzoFornitura;
		this.prodotto = prodotto;
		this.fornitore = fornitore;
	}
	
	//Getter e setter
	public float getQuantitaFornita() {
		return quantitaFornita;
	}
	public void setQuantitaFornita(float quantitaFornita) {
		this.quantitaFornita = quantitaFornita;
	}
	public LocalDate getDataFornitura() {
		return dataFornitura;
	}
	public void setDataFornitura(LocalDate dataFornitura) {
		this.dataFornitura = dataFornitura;
	}
	public float getPrezzoFornitura() {
		return prezzoFornitura;
	}
	public void setPrezzoFornitura(float prezzoFornitura) {
		this.prezzoFornitura = prezzoFornitura;
	}
	public Prodotto getProdotto() {
		return prodotto;
	}
	public void setProdotto(Prodotto prodotto) {
		this.prodotto = prodotto;
	}
	public Fornitore getFornitore() {
		return fornitore;
	}
	public void setFornitore(Fornitore fornitore) {
		this.fornitore = fornitore;
	}
	
}
