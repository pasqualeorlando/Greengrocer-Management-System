package Classi;

import java.util.ArrayList;

public class Fornitore {
	
	//Attributi
	private String PIva; 
	private String NomeSocieta;
	private String NomeTitolare;
	private String CognomeTitolare;
	private ArrayList<Fornitura>Forniture;
	
	//Costruttore
	public Fornitore(String pIva, String nomeSocieta, String nomeTitolare, String cognomeTitolare) {
		PIva = pIva;
		NomeSocieta = nomeSocieta;
		NomeTitolare = nomeTitolare;
		CognomeTitolare = cognomeTitolare;
	}
	
	//Getter e setter
	public String getPIVa() {
		return PIva;
	}
	public void setPIVa(String pIVa) {
		PIva = pIVa;
	}
	public String getNomeSocieta() {
		return NomeSocieta;
	}
	public void setNomeSocieta(String nomeSocieta) {
		NomeSocieta = nomeSocieta;
	}
	public String getNomeTitolare() {
		return NomeTitolare;
	}
	public void setNomeTitolare(String nomeTitolare) {
		NomeTitolare = nomeTitolare;
	}
	public String getCognomeTitolare() {
		return CognomeTitolare;
	}
	public void setCognomeTitolare(String cognomeTitolare) {
		CognomeTitolare = cognomeTitolare;
	}
	public String getPIva() {
		return PIva;
	}
	public void setPIva(String pIva) {
		PIva = pIva;
	}
	public ArrayList<Fornitura> getForniture() {
		return Forniture;
	}
	public void setForniture(ArrayList<Fornitura> forniture) {
		Forniture = forniture;
	}
	
}
