
public abstract class Veiculo {
	private String placa;
	private String marca;
	private String modelo;
	private int ano;
	private double valor;
	
	public Veiculo(String placa, String marca, String modelo, int ano, double valor) {
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.valor = valor;
	}
	
	public Veiculo() {
		
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return marca + " " + modelo + ""
				+ "\nPlaca: " + placa
				+ "\nAno: " + ano
				+ "Valor: R$" + valor;
	}
	
	
}
