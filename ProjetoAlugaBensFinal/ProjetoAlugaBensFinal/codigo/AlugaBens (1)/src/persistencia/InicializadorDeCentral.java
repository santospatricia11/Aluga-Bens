package persistencia;

import Classes.CentralDeInformacoes;

public class InicializadorDeCentral {

	public void iniciar() {

		Persistencia persistencia = new Persistencia();

		CentralDeInformacoes centralNova = new CentralDeInformacoes();

		persistencia.salvaCentral(centralNova);

	}
	//inicializar

	public static void main(String[] args) {
		InicializadorDeCentral i = new InicializadorDeCentral();
		i.iniciar();
	}
}
