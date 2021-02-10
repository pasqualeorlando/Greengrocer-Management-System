package Classi;

import java.time.LocalDate;

public class Latticino extends Prodotto {

	//Attributi
	private LocalDate DataProduzione;
	private LocalDate DataMungitura;
	
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
