
public class VeiculoPasseio extends Veiculo {
	private double consumoKmLt;

	public VeiculoPasseio(String placa, String marca, String modelo, int ano, double valor, double consumoKmLt) {
		super(placa, marca, modelo, ano, valor);
		this.consumoKmLt = consumoKmLt;
	}
	
	public VeiculoPasseio() {
		
	}

	public double getConsumoKmLt() {
		return consumoKmLt;
	}

	public void setConsumoKmLt(double consumoKmLt) {
		this.consumoKmLt = consumoKmLt;
	}
	
	@Override
	public String toString() {
		return super.toString()
				+ "\nConsumo Km/Litro: " + consumoKmLt;
	}
}
