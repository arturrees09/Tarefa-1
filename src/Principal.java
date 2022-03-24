import java.util.List;

public class Principal {

	public static void main(String[] args) {
		CatalogoVeiculos catalogo = new CatalogoVeiculos();
		
		String menu = "Seja bem-vindo ao catálogo de veículos! Por favor, selecione a opção desejada:"
				+ "\n1. Consulta por placa"
				+ "\n2. Consulta por marca"
				+ "\n3. Consulta por ano"
				+ "\n4. Consulta por tipo"
				+ "\n5. Sair";
		
		int opcaoMinima = 1;
		int opcaoMaxima = 5;
		
		int opcao = InputOutput.leInt(opcaoMinima, opcaoMaxima, menu);
		
		while (opcao != 5) {
			if (opcao == 1) {
				String placa = InputOutput.leString("Informe a placa do veículo:");
				Veiculo veiculo = catalogo.consultaPorPlaca(placa);
				
				InputOutput.mostraMensagem(veiculo != null
						? veiculo.toString()
						: "Não foi encontrado um veículo com a placa " + placa);
			}
			
			else if (opcao == 2) {
				String marca = InputOutput.leString("Informe a marca do veículo:");
				String dados = veiculosToString(catalogo.consultaPorMarca(marca));
				
				InputOutput.mostraMensagem(dados != null
						? dados
						: "Não foram encontrados veículos da marca " + marca);
			}
			
			else if (opcao == 3) {
				int ano = InputOutput.leInt("Informe o ano do veículo:");
				String dados = veiculosToString(catalogo.consultaPorAno(ano));
				
				InputOutput.mostraMensagem(dados != null
						? dados
						: "Não foram encontrados veículos do ano " + ano);
			}
			
			else {
				String tipo = InputOutput.leString("Informe o tipo de veículo (passeio, utilitário ou passageiros):");
				
				try {
					String dados = veiculosToString(catalogo.consultaPorTipo(tipo));
					
					InputOutput.mostraMensagem(dados != null
							? dados
							: "Não foram encontrados veículos do tipo " + tipo);
					
				} catch (IllegalArgumentException e) {
					InputOutput.mostraMensagem("O tipo de veículo informado é inválido");
				}
			}

			opcao = InputOutput.leInt(opcaoMinima, opcaoMaxima, menu);
		}
	}
	
	private static String veiculosToString(List<Veiculo> veiculos) {
		if (!veiculos.isEmpty()) {
			String resultado = "";
			
			for (Veiculo veiculo : veiculos) {
				resultado += veiculo + "\n\n";
			}
			
			return resultado;
		}
		
		else {
			return null;
		}
	}

}
