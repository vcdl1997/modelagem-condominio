package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Apartamento;
import entities.Condominio;
import entities.Morador;
import entities.Proprietario;
import entities.enums.StatusApartamento;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Digite o nome do Condominio: ");
		String nomeCondominio = scan.nextLine();
		
		System.out.println("Digite o endereço do Condominio: ");
		String enderecoCondominio = scan.nextLine();
		
		System.out.println("Deseja cadastrar os apartamentos ? Y/N");
		char cadastrarApartamentos = scan.next().charAt(0);
		
		Condominio condominio;
		List<Apartamento> apartamentos = new ArrayList<>();
		
		switch(cadastrarApartamentos) {
			case 'y': case 'Y': 
				char opcao;
				
				do {
					Apartamento apartamento;
					List<Morador> moradores = new ArrayList<>();
					
					System.out.println("Informe o numero:");
					Integer numeroApto = scan.nextInt();
					
					System.out.println("Informe a metragem:");
					Integer metragem = scan.nextInt();
					
					System.out.println("Informe a número de quartos:");
					Integer quartos = scan.nextInt();
					
					System.out.println("Informe a número de Suítes:");
					Integer suites = scan.nextInt();
					
					System.out.println("Informe a número de banheiros:");
					Integer banheiros = scan.nextInt();
					
					System.out.println("Informe a número de vagas:");
					Integer vagas = scan.nextInt();
					
					System.out.println("É mobiliado ? Y/N");
					char respostaMobiliado = scan.next().charAt(0);
					Boolean ehMobiliado = respostaMobiliado == 'y' || respostaMobiliado == 'Y' ? true : false;
					
					System.out.println("Informe o status do Apartamento: ");
					System.out.println("1 - OCUPADO");
					System.out.println("2 - A VENDA");
					System.out.println("3 - ALUGA-SE");
					StatusApartamento statusApto;
					
					switch (scan.nextInt()) {
						case 2: statusApto = StatusApartamento.A_VENDA; break;
						case 3: statusApto = StatusApartamento.ALUGA_SE; break;
						default: statusApto = StatusApartamento.OCUPADO; break;
					};
					
					System.out.println("Informe o nome do proprietário");
					String nomeProprietario = scan.next();
					scan.nextLine();
					
					System.out.println("Informe o cpf do proprietário");
					Long cpfProprietario = scan.nextLong();
					
					System.out.println("Informe o e-mail do proprietário");
					String emailProprietario = scan.next();
					scan.nextLine();
					
					System.out.println("O proprietário reside no apartamento ? Y/N");
					char respostaReside = scan.next().charAt(0);
					Boolean ehMorador = respostaReside == 'y' || respostaReside == 'Y' ? true : false;
					
					Proprietario proprietario = new Proprietario(nomeProprietario, cpfProprietario, emailProprietario, ehMorador);
					
					System.out.println("Deseja cadastrar outros moradores no apartamento ? Y/N");
					char resposta = scan.next().charAt(0);
					Boolean continuarCadastrando = resposta == 'y' || resposta == 'Y' ? true : false;
					
					if(continuarCadastrando) {
						
						System.out.println("Quantos moradores serão cadastrados ?");
						Integer qtdMoradores = scan.nextInt();
						
						for(int i = 0; i < qtdMoradores; i++) {
							System.out.println("Digite o nome do morador");
							String nomeMorador = scan.next();
							scan.nextLine();
							
							System.out.println("Digite o cpf do morador");
							Long cpfMorador = scan.nextLong();
							
							moradores.add(new Morador(nomeMorador, cpfMorador));
						}
					}
					
					apartamento = new Apartamento(numeroApto, metragem, quartos, suites, banheiros, vagas, ehMobiliado, proprietario, moradores, statusApto);
					apartamentos.add(apartamento);
					
					System.out.println("Deseja cadastrar outro apartamento ? Y/N");
					opcao = scan.next().charAt(0);
				} while (opcao == 'y' || opcao == 'Y');
				
				condominio = new Condominio(nomeCondominio, enderecoCondominio, apartamentos);
			break;
			
			default: condominio = new Condominio(nomeCondominio, enderecoCondominio, apartamentos); break;
		}
		
		condominio.reportApartamentos();
		
		scan.close();
	}

}
