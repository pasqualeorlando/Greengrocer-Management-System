package Classi;

import java.time.LocalDate;

public class Confezionato extends Prodotto {
	
	//Attributi
	private String tipoConfezione;
	
	//Costruttore
	public Confezionato(String nome, String paeseDiProvenienza, String marca, float quantitaNegozio, float prezzoUnitario,
			int scontoPercentuale, float quantitaDeposito, Classi.Fornitura fornitura, LocalDate dataScadenza, String tipoConfezione) {
		super(nome, paeseDiProvenienza, marca, quantitaNegozio, prezzoUnitario, scontoPercentuale, quantitaDeposito,
				fornitura);
		this.tipoConfezione = tipoConfezione;
		this.setDataScadenza(dataScadenza);
	}
	
	public Confezionato(String nome, String paeseDiProvenienza, String marca, float quantitaNegozio, float prezzoUnitario,
			int scontoPercentuale, float quantitaDeposito, Classi.Fornitura fornitura, String dataScadenza, String tipoConfezione) {
		super(nome, paeseDiProvenienza, marca, quantitaNegozio, prezzoUnitario, scontoPercentuale, quantitaDeposito,
				fornitura);
		this.tipoConfezione = tipoConfezione;
		this.setDataScadenza(dataScadenza);
	}
	
	//Getter e setter
	public String getTipoConfezione() {
		return tipoConfezione;
	}

	public void setTipoConfezione(String tipoConfezione) {
		this.tipoConfezione = tipoConfezione;
	}
	
}
