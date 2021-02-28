package Classi;

import java.time.LocalDate;
import java.util.ArrayList;

public class Prodotto {
	
	//Attributi
	private String Nome;
	private String PaeseDiProvenienza;
	private String Marca;
	private LocalDate DataScadenza;
	private float QuantitaNegozio;
	private float PrezzoUnitario;
	private int ScontoPercentuale;
	private float QuantitaDeposito;
	private Fornitura Fornitura;
	private ArrayList<SpecificaAcquisto>SpecificaAcquisto;
	
	//Costruttore
	public Prodotto(String nome, String paeseDiProvenienza, float quantitaNegozio, float prezzoUnitario,
			int scontoPercentuale, float quantitaDeposito, Classi.Fornitura fornitura) {
		Nome = nome;
		PaeseDiProvenienza = paeseDiProvenienza;
		QuantitaNegozio = quantitaNegozio;
		PrezzoUnitario = prezzoUnitario;
		ScontoPercentuale = scontoPercentuale;
		QuantitaDeposito = quantitaDeposito;
		Fornitura = fornitura;
	}
	
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
	public float getQuantitaNegozio() {
		return QuantitaNegozio;
	}
	public void setQuantitaNegozio(float quantitaNegozio) {
		QuantitaNegozio = quantitaNegozio;
	}
	public float getPrezzoUnitario() {
		return PrezzoUnitario;
	}
	public void setPrezzoUnitario(float prezzoUnitario) {
		PrezzoUnitario = prezzoUnitario;
	}
	public int getScontoPercentuale() {
		return ScontoPercentuale;
	}
	public void setScontoPercentuale(int scontoPercentuale) {
		ScontoPercentuale = scontoPercentuale;
	}
	public float getQuantitaDeposito() {
		return QuantitaDeposito;
	}
	public void setQuantitaDeposito(float quantitaDeposito) {
		QuantitaDeposito = quantitaDeposito;
	}
	public Fornitura getFornitura() {
		return Fornitura;
	}
	public void setFornitura(Fornitura fornitura) {
		Fornitura = fornitura;
	}
	
}
