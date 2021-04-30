package Classi;

import Enum.TAllevamento;

public class Uova extends Prodotto {

	//Attributi
	private TAllevamento tipoAllevamento;
	
	//Costruttore
	public Uova(String nome, String paeseDiProvenienza, float quantitaNegozio, float prezzoUnitario,
			int scontoPercentuale, float quantitaDeposito, Classi.Fornitura fornitura, TAllevamento tipoAllevamento) {
		super(nome, paeseDiProvenienza, quantitaNegozio, prezzoUnitario, scontoPercentuale, quantitaDeposito,
				fornitura);
		this.tipoAllevamento = tipoAllevamento;
	}

	//Getter e setter
	public TAllevamento getTipoAllevamento() {
		return tipoAllevamento;
	}
	public void setTipoAllevamento(TAllevamento tipoAllevamento) {
		this.tipoAllevamento = tipoAllevamento;
	}
	
	
}
