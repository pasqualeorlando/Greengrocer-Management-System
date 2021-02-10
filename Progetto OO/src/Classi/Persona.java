package Classi;

import java.time.LocalDate;

import Enum.TSesso;

public class Persona {

	//Attributi
	private String Nome;
	private String Cognome;
	private String CF;
	private LocalDate DataNascita;
	private String Email;
	private TSesso Sesso;
	
	//Getter e setter
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getCognome() {
		return Cognome;
	}
	public void setCognome(String cognome) {
		Cognome = cognome;
	}
	public String getCF() {
		return CF;
	}
	public void setCF(String cF) {
		CF = cF;
	}
	public LocalDate getDataNascita() {
		return DataNascita;
	}
	public void setDataNascita(LocalDate dataNascita) {
		DataNascita = dataNascita;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public TSesso getSesso() {
		return Sesso;
	}
	public void setSesso(TSesso sesso) {
		Sesso = sesso;
	}
	
	
}
