package classi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Verdura extends Prodotto {

	//Attributi
	private LocalDate dataRaccolta;
	
	//Costruttore
	public Verdura(String nome, String paeseDiProvenienza, String marca, float quantitaNegozio, float prezzoUnitario,
			int scontoPercentuale, float quantitaDeposito, classi.Fornitura fornitura, LocalDate dataRaccolta) {
		super(nome, paeseDiProvenienza, marca, quantitaNegozio, prezzoUnitario, scontoPercentuale, quantitaDeposito,
				fornitura);
		this.dataRaccolta = dataRaccolta;
	}
	public Verdura(String nome, String paeseDiProvenienza, String marca, float quantitaNegozio, float prezzoUnitario,
			int scontoPercentuale, float quantitaDeposito, classi.Fornitura fornitura, String dataRaccolta) {
		super(nome, paeseDiProvenienza, marca, quantitaNegozio, prezzoUnitario, scontoPercentuale, quantitaDeposito,
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
