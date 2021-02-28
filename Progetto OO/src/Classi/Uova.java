package Classi;

import Enum.TAllevamento;

public class Uova extends Prodotto {

	//Attributi
	private TAllevamento TipoAllevamento;
	
	//Costruttore
	public Uova(String nome, String paeseDiProvenienza, float quantitaNegozio, float prezzoUnitario,
			int scontoPercentuale, float quantitaDeposito, Classi.Fornitura fornitura, TAllevamento tipoAllevamento) {
		super(nome, paeseDiProvenienza, quantitaNegozio, prezzoUnitario, scontoPercentuale, quantitaDeposito,
				fornitura);
		TipoAllevamento = tipoAllevamento;
	}

	//Getter e setter
	public TAllevamento getTipoAllevamento() {
		return TipoAllevamento;
	}
	public void setTipoAllevamento(TAllevamento tipoAllevamento) {
		TipoAllevamento = tipoAllevamento;
	}
	
	
}
