package Classi;

import java.time.LocalDate;

public class TesseraPunti {

	//Attributi
	private String codiceBarre;
	private LocalDate scadenza;
	private int puntiFrutta;
	private int puntiVerdura;
	private int puntiFarinacei;
	private int puntiLatticini;
	private int puntiUova;
	private int puntiConfezionati;
	private String CF;
	
	//Getter e setter
	public String getCodiceBarre() {
		return codiceBarre;
	}
	public void setCodiceBarre(String codiceBarre) {
		this.codiceBarre = codiceBarre;
	}
	public LocalDate getScadenza() {
		return scadenza;
	}
	public void setScadenza(LocalDate scadenza) {
		this.scadenza = scadenza;
	}
	public int getPuntiFrutta() {
		return puntiFrutta;
	}
	public void setPuntiFrutta(int puntiFrutta) {
		this.puntiFrutta = puntiFrutta;
	}
	public int getPuntiVerdura() {
		return puntiVerdura;
	}
	public void setPuntiVerdura(int puntiVerdura) {
		this.puntiVerdura = puntiVerdura;
	}
	public int getPuntiFarinacei() {
		return puntiFarinacei;
	}
	public void setPuntiFarinacei(int puntiFarinacei) {
		this.puntiFarinacei = puntiFarinacei;
	}
	public int getPuntiLatticini() {
		return puntiLatticini;
	}
	public void setPuntiLatticini(int puntiLatticini) {
		this.puntiLatticini = puntiLatticini;
	}
	public int getPuntiUova() {
		return puntiUova;
	}
	public void setPuntiUova(int puntiUova) {
		this.puntiUova = puntiUova;
	}
	public int getPuntiConfezionati() {
		return puntiConfezionati;
	}
	public void setPuntiConfezionati(int puntiConfezionati) {
		this.puntiConfezionati = puntiConfezionati;
	}
	public String getCF() {
		return CF;
	}
	public void setCF(String cF) {
		CF = cF;
	}
	

}
