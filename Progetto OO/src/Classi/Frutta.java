package Classi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Frutta extends Prodotto {

	//Attributi
	private LocalDate dataRaccolta;
	
	//Costruttore
	public Frutta(String nome, String paeseDiProvenienza, float quantitaNegozio, float prezzoUnitario,
			int scontoPercentuale, float quantitaDeposito, Classi.Fornitura fornitura, LocalDate dataRaccolta) {
		super(nome, paeseDiProvenienza, quantitaNegozio, prezzoUnitario, scontoPercentuale, quantitaDeposito,
				fornitura);
		this.setDataRaccolta(dataRaccolta);
	}
	public Frutta(String nome, String paeseDiProvenienza, float quantitaNegozio, float prezzoUnitario,
			int scontoPercentuale, float quantitaDeposito, Classi.Fornitura fornitura, String dataRaccolta) {
		super(nome, paeseDiProvenienza, quantitaNegozio, prezzoUnitario, scontoPercentuale, quantitaDeposito,
				fornitura);
		this.setDataRaccolta(dataRaccolta);
	}

	//Getter e setter
	public LocalDate getDataRaccolta() {
		return dataRaccolta;
	}
	public void setDataRaccolta(LocalDate dataRaccolta) {
		this.dataRaccolta = dataRaccolta;
	}
	public void setDataRaccolta(String dataRaccolta) {
		this.dataRaccolta = LocalDate.parse(dataRaccolta, DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ITALIAN));
	}
	
	
}
