package Classes;

import java.util.Scanner;

import persistencia.Persistencia;

public class Progama {

	private static final String String = null;

	public static void main(String[] args) {

		Persistencia persistencia = new Persistencia();

		CentralDeInformacoes central = persistencia.recuperarCentral();

		Scanner leitor = new Scanner(System.in);

		boolean execusao = true;

		do {
			System.out.println("1-Novo Locador");
			System.out.println("2-Listar Locadores");
			System.out.println("3-Cadastrar aluguel");
			System.out.println("4-Listar alugueis");
			System.out.println("5- Gerar Relatorio");
			System.out.println("S-sair");
			System.out.println("informe uma opcao:");
			String valorRecebido = leitor.nextLine();
			if (valorRecebido.equals("1")) {

				System.out.println("informe o locador:");
				String nome = leitor.nextLine();
				System.out.println("informe seu cpf:");
				String cpf = leitor.nextLine();
				System.out.println("Informe seu logim: ");
				String login = leitor.nextLine();
				System.out.println("Informe sua senha");
				String senha = leitor.nextLine();

				Locador locador = new Locador();
				locador.setSenha(senha);
				locador.setLogin(login);
				central.adcionarLocador(locador);
				persistencia.salvaCentral(central);

			} else if (valorRecebido.equals("2")) {

				for (Locador locatario : persistencia.recuperarCentral().getLocador()) {
					System.out.println(locatario);

				}

			} else if (valorRecebido.equals("S")) {
				System.out.println("saindo do programa.");
				execusao = false;

			} else {

				System.out.println("valor invalido.");

			}

		} while (execusao);

	}
}
