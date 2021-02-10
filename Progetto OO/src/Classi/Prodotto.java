package Classi;

import java.time.LocalDate;

public class Prodotto {
	
	//Attributi
	private String Nome;
	private String PaeseDiProvenienza;
	private String Marca;
	private LocalDate DataScadenza;
	private double QuantitaNegozio;
	private double PrezzoUnitario;
	private int ScontoPercentuale;
	private double QuantitaDeposito;
	
	//Getter e setter
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getPaeseDiProvenienza() {
		return PaeseDiProvenienza;
	}
	public void setPaeseDiProvenienza(String paeseDiProvenienza) {
		PaeseDiProvenienza = paeseDiProvenienza;
	}
	public String getMarca() {
		return Marca;
	}
	public void setMarca(String marca) {
		Marca = marca;
	}
	public LocalDate getDataScadenza() {
		return DataScadenza;
	}
	public void setDataScadenza(LocalDate dataScadenza) {
		DataScadenza = dataScadenza;
	}
	public double getQuantitaNegozio() {
		return QuantitaNegozio;
	}
	public void setQuantitaNegozio(double quantitaNegozio) {
		QuantitaNegozio = quantitaNegozio;
	}
	public double getPrezzoUnitario() {
		return PrezzoUnitario;
	}
	public void setPrezzoUnitario(double prezzoUnitario) {
		PrezzoUnitario = prezzoUnitario;
	}
	public int getScontoPercentuale() {
		return ScontoPercentuale;
	}
	public void setScontoPercentuale(int scontoPercentuale) {
		ScontoPercentuale = scontoPercentuale;
	}
	public double getQuantitaDeposito() {
		return QuantitaDeposito;
	}
	public void setQuantitaDeposito(double quantitaDeposito) {
		QuantitaDeposito = quantitaDeposito;
	}
	
	
}
