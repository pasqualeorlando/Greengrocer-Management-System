package Classi;

import java.time.LocalDate;

public class Latticino extends Prodotto {

	//Attributi
	private LocalDate DataProduzione;
	private LocalDate DataMungitura;
	
	//Costruttore
	public Latticino(String nome, String paeseDiProvenienza, double quantitaNegozio, double prezzoUnitario,
			int scontoPercentuale, double quantitaDeposito, Classi.Fornitura fornitura, LocalDate dataProduzione,
			LocalDate dataMungitura) {
		super(nome, paeseDiProvenienza, quantitaNegozio, prezzoUnitario, scontoPercentuale, quantitaDeposito,
				fornitura);
		DataProduzione = dataProduzione;
		DataMungitura = dataMungitura;
	}
	
	//Getter e setter
	public LocalDate getDataProduzione() {
		return DataProduzione;
	}
	public void setDataProduzione(LocalDate dataProduzione) {
		DataProduzione = dataProduzione;
	}
	public LocalDate getDataMungitura() {
		return DataMungitura;
	}
	public void setDataMungitura(LocalDate dataMungitura) {
		DataMungitura = dataMungitura;
	}
	
	
}
