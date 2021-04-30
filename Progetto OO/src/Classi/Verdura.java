package Classi;

import java.time.LocalDate;

public class Verdura extends Prodotto {

	//Attributi
	private LocalDate dataRaccolta;
	
	//Costruttore
	public Verdura(String nome, String paeseDiProvenienza, float quantitaNegozio, float prezzoUnitario,
			int scontoPercentuale, float quantitaDeposito, Classi.Fornitura fornitura, LocalDate dataRaccolta) {
		super(nome, paeseDiProvenienza, quantitaNegozio, prezzoUnitario, scontoPercentuale, quantitaDeposito,
				fornitura);
		this.dataRaccolta = dataRaccolta;
	}

	//Getter e setter
	public LocalDate getDataRaccolta() {
		return dataRaccolta;
	}
	public void setDataRaccolta(LocalDate dataRaccolta) {
		this.dataRaccolta = dataRaccolta;
	}
	
	
}
