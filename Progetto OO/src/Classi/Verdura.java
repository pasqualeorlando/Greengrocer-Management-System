package Classi;

import java.time.LocalDate;

public class Verdura extends Prodotto {

	//Attributi
	private LocalDate DataRaccolta;
	
	//Costruttore
	public Verdura(String nome, String paeseDiProvenienza, float quantitaNegozio, float prezzoUnitario,
			int scontoPercentuale, float quantitaDeposito, Classi.Fornitura fornitura, LocalDate dataRaccolta) {
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
