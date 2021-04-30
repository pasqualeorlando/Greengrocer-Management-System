package Classi;

import java.util.ArrayList;

public class Fornitore {
	
	//Attributi
	private String PIva; 
	private String nomeSocieta;
	private String nomeTitolare;
	private String cognomeTitolare;
	private ArrayList<Fornitura> forniture;
	
	//Costruttore
	public Fornitore(String pIva, String nomeSocieta, String nomeTitolare, String cognomeTitolare) {
		PIva = pIva;
		this.nomeSocieta = nomeSocieta;
		this.nomeTitolare = nomeTitolare;
		this.cognomeTitolare = cognomeTitolare;
	}
	
	//Getter e setter
	public String getPIVa() {
		return PIva;
	}
	public void setPIVa(String pIVa) {
		PIva = pIVa;
	}
	public String getNomeSocieta() {
		return nomeSocieta;
	}
	public void setNomeSocieta(String nomeSocieta) {
		this.nomeSocieta = nomeSocieta;
	}
	public String getNomeTitolare() {
		return nomeTitolare;
	}
	public void setNomeTitolare(String nomeTitolare) {
		this.nomeTitolare = nomeTitolare;
	}
	public String getCognomeTitolare() {
		return cognomeTitolare;
	}
	public void setCognomeTitolare(String cognomeTitolare) {
		this.cognomeTitolare = cognomeTitolare;
	}
	public String getPIva() {
		return PIva;
	}
	public void setPIva(String pIva) {
		PIva = pIva;
	}
	public ArrayList<Fornitura> getForniture() {
		return forniture;
	}
	public void setForniture(ArrayList<Fornitura> forniture) {
		this.forniture = forniture;
	}
	
}
