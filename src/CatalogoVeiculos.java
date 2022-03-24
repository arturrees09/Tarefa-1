import java.util.LinkedList;
import java.util.List;

public class CatalogoVeiculos {
	private List<Veiculo> veiculos;
	
	public CatalogoVeiculos() {
		veiculos = new LinkedList<Veiculo>();	
		veiculos.add(new VeiculoPasseio("ABC1234", "Fiat", "Uno", 2011, 15000, 20));
		veiculos.add(new VeiculoPasseio("TDW4242", "Ford", "Fusion", 2019, 120000, 15));
		veiculos.add(new VeiculoPasseio("TCW598", "Chevrolet", "Impala", 1967, 20000, 18));
		veiculos.add(new VeiculoPasseio("XYZ987", "Honda", "Civic", 2021, 90000, 16));
		veiculos.add(new VeiculoUtilitario("KBC5578", "Fiat", "Strada", 2020, 55000, 1, 1));
		veiculos.add(new VeiculoUtilitario("YBV2598", "Mercedes", "Sprinter", 2018, 165000, 3, 1));
		veiculos.add(new VeiculoUtilitario("AMO4442", "Renault", "Kangoo", 2017, 60000, 1, 2));
		veiculos.add(new VeiculoPassageiros("GAB5050", "Mercedes Benz", "Sprinter", 2021, 180000, 42));
		veiculos.add(new VeiculoPassageiros("AMY4548", "Volkswagen", "Marco Polo", 2017, 170000, 50));
		veiculos.add(new VeiculoPassageiros("AND1010", "Volvo", "Granvia", 2019, 175000, 45));
	}
	
	public Veiculo consultaPorPlaca(String placa) {
		String placaLetrasMaiusculas = placa.toUpperCase();
		
		for (Veiculo veiculo : veiculos) {
			if (veiculo.getPlaca().toUpperCase().equals(placaLetrasMaiusculas)) {
				return veiculo;
			}
		}
		
		return null;
	}
	
	public List<Veiculo> consultaPorMarca(String marca) {
		String marcaLetrasMinusculas = marca.toLowerCase();
		List<Veiculo> resultado = new LinkedList<Veiculo>();
		
		
		for (Veiculo veiculo : veiculos) {
			if (veiculo.getMarca().toLowerCase().equals(marcaLetrasMinusculas)) {
				resultado.add(veiculo);
			}
		}
		
		return resultado;
	}
	
	public List<Veiculo> consultaPorAno(int ano) {
		List<Veiculo> resultado = new LinkedList<Veiculo>();
		
		for (Veiculo veiculo : veiculos) {
			if (veiculo.getAno() == ano) {
				resultado.add(veiculo);
			}
		}
		
		return resultado;
	}

	public List<Veiculo> consultaPorTipo(String tipo) throws IllegalArgumentException {
		String tipoLetrasMinusculas = tipo.toLowerCase();
		
		if (tipoLetrasMinusculas.contains("passeio")) {
			return consultaVeiculosPasseio();
		}
		
		else if (tipoLetrasMinusculas.contains("utilitario") || tipoLetrasMinusculas.contains("utilitário")) {
			return consultaVeiculosUtilitarios();
		}
		
		else if (tipoLetrasMinusculas.contains("passageiro")) {
			return consultaVeiculosPassageiros();
		}
		
		else {
			throw new IllegalArgumentException("O tipo do veículo deve ser passeio, utilitário ou passageiros");
		}
	}
	
	private List<Veiculo> consultaVeiculosPasseio() {
		List<Veiculo> resultado = new LinkedList<Veiculo>();
		
		for (Veiculo veiculo : veiculos) {
			if (veiculo instanceof VeiculoPasseio) {
				resultado.add(veiculo);
			}
		}
		
		return resultado;
	}
	
	private List<Veiculo> consultaVeiculosUtilitarios() {
		List<Veiculo> resultado = new LinkedList<Veiculo>();
		
		for (Veiculo veiculo : veiculos) {
			if (veiculo instanceof VeiculoUtilitario) {
				resultado.add(veiculo);
			}
		}
		
		return resultado;
	}
	
	private List<Veiculo> consultaVeiculosPassageiros() {
		List<Veiculo> resultado = new LinkedList<Veiculo>();
		
		for (Veiculo veiculo : veiculos) {
			if (veiculo instanceof VeiculoPassageiros) {
				resultado.add(veiculo);
			}
		}
		
		return resultado;
	}
}
