package Classi;

import Enum.TRuolo;

public class Personale extends Persona {
	
	//Attributi
	private TRuolo Ruolo;

	//Getter e setter
	public TRuolo getRuolo() {
		return Ruolo;
	}

	public void setRuolo(TRuolo ruolo) {
		Ruolo = ruolo;
	}
	
}
