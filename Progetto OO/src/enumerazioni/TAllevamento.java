package enumerazioni;

public enum TAllevamento{
	Biologico(0),
	Aperto(1),
	Terra(2),
	Gabbia(3);
	
	private int numeroAllevamento;

	private TAllevamento(int n) {
		this.numeroAllevamento = n;
	}

	public int getNumber() {
		return numeroAllevamento;
	}
}
