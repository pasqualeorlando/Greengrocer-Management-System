package Classi;

import java.time.LocalDate;

import Enum.TRuolo;
import Enum.TSesso;

public class Personale extends Persona{
	private TRuolo Ruolo;
	
	//Costruttore
	public Personale(String nome, String cognome, String cF, LocalDate dataNascita, String email, TSesso sesso,
			TRuolo ruolo, CittaItaliana citta) {
		super(nome, cognome, cF, dataNascita, email, sesso, citta);
		Ruolo = ruolo;
	}
	
	//Getter e Setter
	public TRuolo getRuolo() {
		return Ruolo;
	}

	public void setRuolo(TRuolo ruolo) {
		Ruolo = ruolo;
	}
	
	
	
}
