package classi;

import java.time.LocalDate;

import enumerazioni.TFarinaceo;

public class Farinaceo extends Prodotto {
	
	//Attributi
	private TFarinaceo tipoFarinaceo;
	
	//Costruttore
	public Farinaceo(String nome, String paeseDiProvenienza, String marca, float quantitaNegozio, float prezzoUnitario,
			int scontoPercentuale, float quantitaDeposito, classi.Fornitura fornitura, LocalDate dataScadenza, TFarinaceo tipoFarinaceo) {
		super(nome, paeseDiProvenienza, marca, quantitaNegozio, prezzoUnitario, scontoPercentuale, quantitaDeposito,
				fornitura);
		this.tipoFarinaceo = tipoFarinaceo;
		this.setDataScadenza(dataScadenza);
	}
	
	public Farinaceo(String nome, String paeseDiProvenienza, String marca, float quantitaNegozio, float prezzoUnitario,
			int scontoPercentuale, float quantitaDeposito, classi.Fornitura fornitura, String dataScadenza, String tipoFarinaceo) {
		super(nome, paeseDiProvenienza, marca, quantitaNegozio, prezzoUnitario, scontoPercentuale, quantitaDeposito,
				fornitura);
		this.setTipoFarinaceo(tipoFarinaceo);
		this.setDataScadenza(dataScadenza);
	}
	
	//Getter e setter
	public TFarinaceo getTipoFarinaceo() {
		return tipoFarinaceo;
	}
	public void setTipoFarinaceo(TFarinaceo tipoFarinaceo) {
		this.tipoFarinaceo = tipoFarinaceo;
	}
	public void setTipoFarinaceo(String tipoFarinaceo) {
		if(tipoFarinaceo.equals("Pane"))
			this.tipoFarinaceo = TFarinaceo.Pane;
		else
			this.tipoFarinaceo = TFarinaceo.Panino;
	}
	
	
}
