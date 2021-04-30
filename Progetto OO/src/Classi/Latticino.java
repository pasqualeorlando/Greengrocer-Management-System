package Classi;

import java.time.LocalDate;

public class Latticino extends Prodotto {

	//Attributi
	private LocalDate dataProduzione;
	private LocalDate dataMungitura;
	
	//Costruttore
	public Latticino(String nome, String paeseDiProvenienza, float quantitaNegozio, float prezzoUnitario,
			int scontoPercentuale, float quantitaDeposito, Classi.Fornitura fornitura, LocalDate dataProduzione,
			LocalDate dataMungitura) {
		super(nome, paeseDiProvenienza, quantitaNegozio, prezzoUnitario, scontoPercentuale, quantitaDeposito,
				fornitura);
		this.dataProduzione = dataProduzione;
		this.dataMungitura = dataMungitura;
	}
	
	//Getter e setter
	public LocalDate getDataProduzione() {
		return dataProduzione;
	}
	public void setDataProduzione(LocalDate dataProduzione) {
		this.dataProduzione = dataProduzione;
	}
	public LocalDate getDataMungitura() {
		return dataMungitura;
	}
	public void setDataMungitura(LocalDate dataMungitura) {
		this.dataMungitura = dataMungitura;
	}
	
	
}
