package Classi;

import java.time.LocalDate;

public class Fornitura {
	
	//Attributi
	private double QuantitaFornita;
	private LocalDate DataFornitura;
	private double PrezzoFornitura;
	private Prodotto Prodotto;
	private Fornitore Fornitore;
	
	//Costruttore
	public Fornitura(double quantitaFornita, LocalDate dataFornitura, double prezzoFornitura, Classi.Prodotto prodotto,
			Classi.Fornitore fornitore) {
		QuantitaFornita = quantitaFornita;
		DataFornitura = dataFornitura;
		PrezzoFornitura = prezzoFornitura;
		Prodotto = prodotto;
		Fornitore = fornitore;
	}
	
	//Getter e setter
	public double getQuantitaFornita() {
		return QuantitaFornita;
	}
	public void setQuantitaFornita(double quantitaFornita) {
		QuantitaFornita = quantitaFornita;
	}
	public LocalDate getDataFornitura() {
		return DataFornitura;
	}
	public void setDataFornitura(LocalDate dataFornitura) {
		DataFornitura = dataFornitura;
	}
	public double getPrezzoFornitura() {
		return PrezzoFornitura;
	}
	public void setPrezzoFornitura(double prezzoFornitura) {
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
