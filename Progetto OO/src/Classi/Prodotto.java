package Classi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

public class Prodotto {
	
	//Attributi
	private String nome;
	private String paeseDiProvenienza;
	private String marca;
	private LocalDate dataScadenza;
	private float quantitaNegozio;
	private float prezzoUnitario;
	private int scontoPercentuale;
	private float quantitaDeposito;
	private Fornitura fornitura;
	private ArrayList<SpecificaAcquisto> specificaAcquisto;
	
	//Costruttore
	public Prodotto(String nome, String paeseDiProvenienza, float quantitaNegozio, float prezzoUnitario,
			int scontoPercentuale, float quantitaDeposito, Classi.Fornitura fornitura) {
		this.setNome(nome);
		this.setPaeseDiProvenienza(paeseDiProvenienza);
		this.setQuantitaNegozio(quantitaNegozio);
		this.setPrezzoUnitario(prezzoUnitario);
		this.setScontoPercentuale(scontoPercentuale);
		this.setQuantitaDeposito(quantitaDeposito);
		this.setFornitura(fornitura);
	}
	
	//Getter e setter
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPaeseDiProvenienza() {
		return paeseDiProvenienza;
	}
	public void setPaeseDiProvenienza(String paeseDiProvenienza) {
		this.paeseDiProvenienza = paeseDiProvenienza;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public LocalDate getDataScadenza() {
		return dataScadenza;
	}
	public void setDataScadenza(LocalDate dataScadenza) {
		this.dataScadenza = dataScadenza;
	}
	public void setDataScadenza(String dataScadenza) {
		this.dataScadenza = LocalDate.parse(dataScadenza, DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ITALIAN));
	}
	public float getQuantitaNegozio() {
		return quantitaNegozio;
	}
	public void setQuantitaNegozio(float quantitaNegozio) {
		this.quantitaNegozio = quantitaNegozio;
	}
	public float getPrezzoUnitario() {
		return prezzoUnitario;
	}
	public void setPrezzoUnitario(float prezzoUnitario) {
		this.prezzoUnitario = prezzoUnitario;
	}
	public int getScontoPercentuale() {
		return scontoPercentuale;
	}
	public void setScontoPercentuale(int scontoPercentuale) {
		this.scontoPercentuale = scontoPercentuale;
	}
	public float getQuantitaDeposito() {
		return quantitaDeposito;
	}
	public void setQuantitaDeposito(float quantitaDeposito) {
		this.quantitaDeposito = quantitaDeposito;
	}
	public Fornitura getFornitura() {
		return fornitura;
	}
	public void setFornitura(Fornitura fornitura) {
		this.fornitura = fornitura;
	}

	public ArrayList<SpecificaAcquisto> getSpecificaAcquisto() {
		return specificaAcquisto;
	}

	public void setSpecificaAcquisto(ArrayList<SpecificaAcquisto> specificaAcquisto) {
		this.specificaAcquisto = specificaAcquisto;
	}
}
