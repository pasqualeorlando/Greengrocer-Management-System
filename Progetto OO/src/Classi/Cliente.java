package Classi;

import java.time.LocalDate;

import Enum.TSesso;

public class Cliente extends Persona{

	public Cliente(String nome, String cognome, String cF, LocalDate dataNascita, String email, TSesso sesso, CittaItaliana citta) {
		super(nome, cognome, cF, dataNascita, email, sesso, citta);
	}
	
}
