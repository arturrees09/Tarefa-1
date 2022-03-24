import java.util.List;

public class Principal {

	public static void main(String[] args) {
		CatalogoVeiculos catalogo = new CatalogoVeiculos();
		
		String menu = "Seja bem-vindo ao cat�logo de ve�culos! Por favor, selecione a op��o desejada:"
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
				String placa = InputOutput.leString("Informe a placa do ve�culo:");
				Veiculo veiculo = catalogo.consultaPorPlaca(placa);
				
				InputOutput.mostraMensagem(veiculo != null
						? veiculo.toString()
						: "N�o foi encontrado um ve�culo com a placa " + placa);
			}
			
			else if (opcao == 2) {
				String marca = InputOutput.leString("Informe a marca do ve�culo:");
				String dados = veiculosToString(catalogo.consultaPorMarca(marca));
				
				InputOutput.mostraMensagem(dados != null
						? dados
						: "N�o foram encontrados ve�culos da marca " + marca);
			}
			
			else if (opcao == 3) {
				int ano = InputOutput.leInt("Informe o ano do ve�culo:");
				String dados = veiculosToString(catalogo.consultaPorAno(ano));
				
				InputOutput.mostraMensagem(dados != null
						? dados
						: "N�o foram encontrados ve�culos do ano " + ano);
			}
			
			else {
				String tipo = InputOutput.leString("Informe o tipo de ve�culo (passeio, utilit�rio ou passageiros):");
				
				try {
					String dados = veiculosToString(catalogo.consultaPorTipo(tipo));
					
					InputOutput.mostraMensagem(dados != null
							? dados
							: "N�o foram encontrados ve�culos do tipo " + tipo);
					
				} catch (IllegalArgumentException e) {
					InputOutput.mostraMensagem("O tipo de ve�culo informado � inv�lido");
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
