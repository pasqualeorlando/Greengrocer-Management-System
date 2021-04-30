package Classi;

import Enum.TFarinaceo;

public class Farinaceo extends Prodotto {
	
	//Attributi
	private TFarinaceo tipoFarinaceo;
	
	//Costruttore
	public Farinaceo(String nome, String paeseDiProvenienza, float quantitaNegozio, float prezzoUnitario,
			int scontoPercentuale, float quantitaDeposito, Classi.Fornitura fornitura, TFarinaceo tipoFarinaceo) {
		super(nome, paeseDiProvenienza, quantitaNegozio, prezzoUnitario, scontoPercentuale, quantitaDeposito,
				fornitura);
		this.tipoFarinaceo = tipoFarinaceo;
	}
	
	//Getter e setter
	public TFarinaceo getTipoFarinaceo() {
		return tipoFarinaceo;
	}
	public void setTipoFarinaceo(TFarinaceo tipoFarinaceo) {
		this.tipoFarinaceo = tipoFarinaceo;
	}
	
	
}
