package Classi;

import java.time.LocalDate;

public class Frutta extends Prodotto {

	//Attributi
	private LocalDate DataRaccolta;

	//Getter e setter
	public LocalDate getDataRaccolta() {
		return DataRaccolta;
	}

	public void setDataRaccolta(LocalDate dataRaccolta) {
		DataRaccolta = dataRaccolta;
	}
	
	
}
