package Classi;

import java.time.LocalDate;

public class Fornitura {
	
	//Attributi
	private float QuantitaFornita;
	private LocalDate DataFornitura;
	private float PrezzoFornitura;
	private Prodotto Prodotto;
	private Fornitore Fornitore;
	
	//Costruttore
	public Fornitura(float quantitaFornita, LocalDate dataFornitura, float prezzoFornitura, Classi.Prodotto prodotto,
			Classi.Fornitore fornitore) {
		QuantitaFornita = quantitaFornita;
		DataFornitura = dataFornitura;
		PrezzoFornitura = prezzoFornitura;
		Prodotto = prodotto;
		Fornitore = fornitore;
	}
	
	//Getter e setter
	public float getQuantitaFornita() {
		return QuantitaFornita;
	}
	public void setQuantitaFornita(float quantitaFornita) {
		QuantitaFornita = quantitaFornita;
	}
	public LocalDate getDataFornitura() {
		return DataFornitura;
	}
	public void setDataFornitura(LocalDate dataFornitura) {
		DataFornitura = dataFornitura;
	}
	public float getPrezzoFornitura() {
		return PrezzoFornitura;
	}
	public void setPrezzoFornitura(float prezzoFornitura) {
		PrezzoFornitura = prezzoFornitura;
	}
	public Prodotto getProdotto() {
		return Prodotto;
	}
	public void setProdotto(Prodotto prodotto) {
		Prodotto = prodotto;
	}
	public Fornitore getFornitore() {
		return Fornitore;
	}
	public void setFornitore(Fornitore fornitore) {
		Fornitore = fornitore;
	}
	
}
