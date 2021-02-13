package Classi;

import java.time.LocalDate;

public class Frutta extends Prodotto {

	//Attributi
	private LocalDate DataRaccolta;
	
	//Costruttore
	public Frutta(String nome, String paeseDiProvenienza, double quantitaNegozio, double prezzoUnitario,
			int scontoPercentuale, double quantitaDeposito, Classi.Fornitura fornitura, LocalDate dataRaccolta) {
		super(nome, paeseDiProvenienza, quantitaNegozio, prezzoUnitario, scontoPercentuale, quantitaDeposito,
				fornitura);
		DataRaccolta = dataRaccolta;
	}

	//Getter e setter
	public LocalDate getDataRaccolta() {
		return DataRaccolta;
	}
	public void setDataRaccolta(LocalDate dataRaccolta) {
		DataRaccolta = dataRaccolta;
	}
	
	
}
