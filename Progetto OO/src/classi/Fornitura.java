package classi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Fornitura {
	
	//Attributi
	private float quantitaFornita;
	private LocalDate dataFornitura;
	private float prezzoFornitura;
	private Fornitore fornitore;
	
	//Costruttore
	public Fornitura(float quantitaFornita, LocalDate dataFornitura, float prezzoFornitura, classi.Fornitore fornitore) {
		this.quantitaFornita = quantitaFornita;
		this.dataFornitura = dataFornitura;
		this.prezzoFornitura = prezzoFornitura;
		this.fornitore = fornitore;
	}
	
	public Fornitura(float quantitaFornita, String dataFornitura, float prezzoFornitura, classi.Fornitore fornitore) {
		this.quantitaFornita = quantitaFornita;
		this.setDataFornitura(dataFornitura);
		this.prezzoFornitura = prezzoFornitura;
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
	public void setDataFornitura(String dataFornitura) {
		this.dataFornitura = LocalDate.parse(dataFornitura, DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ITALIAN));
	}
	public float getPrezzoFornitura() {
		return prezzoFornitura;
	}
	public void setPrezzoFornitura(float prezzoFornitura) {
		this.prezzoFornitura = prezzoFornitura;
	}
	public Fornitore getFornitore() {
		return fornitore;
	}
	public void setFornitore(Fornitore fornitore) {
		this.fornitore = fornitore;
	}
	
}
