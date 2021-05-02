package Classi;

import java.time.LocalDate;

import Enum.TAllevamento;

public class Uova extends Prodotto {

	//Attributi
	private TAllevamento tipoAllevamento;
	
	//Costruttore
	public Uova(String nome, String paeseDiProvenienza, float quantitaNegozio, float prezzoUnitario,
			int scontoPercentuale, float quantitaDeposito, Classi.Fornitura fornitura, LocalDate dataScadenza, TAllevamento tipoAllevamento) {
		super(nome, paeseDiProvenienza, quantitaNegozio, prezzoUnitario, scontoPercentuale, quantitaDeposito,
				fornitura);
		this.tipoAllevamento = tipoAllevamento;
		this.setDataScadenza(dataScadenza);
	}
	public Uova(String nome, String paeseDiProvenienza, float quantitaNegozio, float prezzoUnitario,
			int scontoPercentuale, float quantitaDeposito, Classi.Fornitura fornitura, String dataScadenza, String tipoAllevamento) {
		super(nome, paeseDiProvenienza, quantitaNegozio, prezzoUnitario, scontoPercentuale, quantitaDeposito,
				fornitura);
		this.setTipoAllevamento(tipoAllevamento);
		this.setDataScadenza(dataScadenza);
	}

	//Getter e setter
	public TAllevamento getTipoAllevamento() {
		return tipoAllevamento;
	}
	public void setTipoAllevamento(TAllevamento tipoAllevamento) {
		this.tipoAllevamento = tipoAllevamento;
	}
	public void setTipoAllevamento(String tipoAllevamento) {
		if(tipoAllevamento.equals("Biologico"))
			this.tipoAllevamento = TAllevamento.Biologico;
		else if(tipoAllevamento.equals("Terra"))
			this.tipoAllevamento = TAllevamento.Terra;
		else if(tipoAllevamento.equals("Aperto"))
			this.tipoAllevamento = TAllevamento.Aperto;
		else
			this.tipoAllevamento = TAllevamento.Gabbia;
	}
	
}
