package Classi;

public class Confezionato extends Prodotto {
	
	//Attributi
	private String TipoConfezione;
	
	//Costruttore
	public Confezionato(String nome, String paeseDiProvenienza, float quantitaNegozio, float prezzoUnitario,
			int scontoPercentuale, float quantitaDeposito, Classi.Fornitura fornitura, String tipoConfezione) {
		super(nome, paeseDiProvenienza, quantitaNegozio, prezzoUnitario, scontoPercentuale, quantitaDeposito,
				fornitura);
		TipoConfezione = tipoConfezione;
	}
	
	//Getter e setter
	public String getTipoConfezione() {
		return TipoConfezione;
	}

	public void setTipoConfezione(String tipoConfezione) {
		TipoConfezione = tipoConfezione;
	}
	
}
