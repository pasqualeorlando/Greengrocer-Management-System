package Classi;

public class Confezionato extends Prodotto {
	
	//Attributi
	private String tipoConfezione;
	
	//Costruttore
	public Confezionato(String nome, String paeseDiProvenienza, float quantitaNegozio, float prezzoUnitario,
			int scontoPercentuale, float quantitaDeposito, Classi.Fornitura fornitura, String tipoConfezione) {
		super(nome, paeseDiProvenienza, quantitaNegozio, prezzoUnitario, scontoPercentuale, quantitaDeposito,
				fornitura);
		this.tipoConfezione = tipoConfezione;
	}
	
	//Getter e setter
	public String getTipoConfezione() {
		return tipoConfezione;
	}

	public void setTipoConfezione(String tipoConfezione) {
		this.tipoConfezione = tipoConfezione;
	}
	
}
