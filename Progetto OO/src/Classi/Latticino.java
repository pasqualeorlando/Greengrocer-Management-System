package Classi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Latticino extends Prodotto {

	//Attributi
	private LocalDate dataProduzione;
	private LocalDate dataMungitura;
	
	//Costruttore
	public Latticino(String nome, String paeseDiProvenienza, float quantitaNegozio, float prezzoUnitario,
			int scontoPercentuale, float quantitaDeposito, Classi.Fornitura fornitura, LocalDate dataScadenza, LocalDate dataProduzione,
			LocalDate dataMungitura) {
		super(nome, paeseDiProvenienza, quantitaNegozio, prezzoUnitario, scontoPercentuale, quantitaDeposito,
				fornitura);
		this.dataProduzione = dataProduzione;
		this.dataMungitura = dataMungitura;
		this.setDataScadenza(dataScadenza);
	}
	
	public Latticino(String nome, String paeseDiProvenienza, float quantitaNegozio, float prezzoUnitario,
			int scontoPercentuale, float quantitaDeposito, Classi.Fornitura fornitura, String dataScadenza, String dataProduzione,
			String dataMungitura) {
		super(nome, paeseDiProvenienza, quantitaNegozio, prezzoUnitario, scontoPercentuale, quantitaDeposito,
				fornitura);
		this.setDataProduzione(dataProduzione);
		this.setDataMungitura(dataMungitura);
		this.setDataScadenza(dataScadenza);
	}
	
	//Getter e setter
	public LocalDate getDataProduzione() {
		return dataProduzione;
	}
	public void setDataProduzione(LocalDate dataProduzione) {
		this.dataProduzione = dataProduzione;
	}
	public LocalDate getDataMungitura() {
		return dataMungitura;
	}
	public void setDataMungitura(LocalDate dataMungitura) {
		this.dataMungitura = dataMungitura;
	}
	public void setDataProduzione(String dataProduzione) {
		this.dataProduzione = LocalDate.parse(dataProduzione, DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ITALIAN));
	}
	public void setDataMungitura(String dataMungitura) {
		this.dataMungitura = LocalDate.parse(dataMungitura, DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ITALIAN));
	}
	
}
