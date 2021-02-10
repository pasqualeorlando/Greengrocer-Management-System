package Classi;

import java.time.LocalDate;

public class Fornitura {
	
	//Attributi
	private double QuantitaFornita;
	private LocalDate DataFornitura;
	private double PrezzoFornitura;
	
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
	
}
