package Classi;

import Enum.TFarinaceo;

public class Farinaceo extends Prodotto {
	
	//Attributi
	private TFarinaceo TipoFarinaceo;
	
	//Costruttore
	public Farinaceo(String nome, String paeseDiProvenienza, float quantitaNegozio, float prezzoUnitario,
			int scontoPercentuale, float quantitaDeposito, Classi.Fornitura fornitura, TFarinaceo tipoFarinaceo) {
		super(nome, paeseDiProvenienza, quantitaNegozio, prezzoUnitario, scontoPercentuale, quantitaDeposito,
				fornitura);
		TipoFarinaceo = tipoFarinaceo;
	}
	
	//Getter e setter
	public TFarinaceo getTipoFarinaceo() {
		return TipoFarinaceo;
	}
	public void setTipoFarinaceo(TFarinaceo tipoFarinaceo) {
		TipoFarinaceo = tipoFarinaceo;
	}
	
	
}
