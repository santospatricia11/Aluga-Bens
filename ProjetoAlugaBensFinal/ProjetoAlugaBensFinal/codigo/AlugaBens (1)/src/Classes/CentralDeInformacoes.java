package Classes;

import java.util.ArrayList;

import excecoes.ItemInexistente;
import excecoes.QuantidadeInvalida;
import persistencia.Persistencia;

public class CentralDeInformacoes {
	// public static final CentralDeInformacoes INSTANCE = new
	// CentralDeInformacoes();
	// private CentralDeInformacoes() {

	// }

	private ArrayList<Bem> listaBem = new ArrayList<Bem>();
	private ArrayList<Locacao> listaLocacao = new ArrayList<Locacao>();
	private static Usuario usuarioLogado;
	

	private ArrayList<Locador> locadoresCadastrados = new ArrayList<Locador>();
	private Locatario locatario;

	private ArrayList<Locatario> locatariosCadastrados = new ArrayList<Locatario>();

	public static boolean existeLocatariCadastrado() {
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral();

		Locatario locatario = central.getLocatario();

		if (locatario == null) {
			return false;
		}

		else {
			return true;
		}
	}

	public boolean validarCpfLocador(String cpf) {
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = new CentralDeInformacoes();
		Locatario locatario = central.getLocatario();

		if (locatario.getCpf().equals(cpf)) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean existeLocadorCadastrado() {
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral();
		ArrayList<Locador> locador = central.getLocador();
		if (locador == null) {
			return false;
		} else {
			return true;
		}

	}

	public void salvarLocador(Locador locador) {
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral();
		central.getLocador().add(locador);

		persistencia.salvaCentral(central);

		System.out.println(central.getLocadoresCadastrados().size() + " locadores");

	}

	public Locador recuperarLocador(String email) {
		for (Locador locador : locadoresCadastrados) {
			if (locador.getEmail().equals(email)) {
				return locador;
			}

		}
		return null;
	}

	public void adcionarLocador(Locador locador) {
		locadoresCadastrados.add(locador);
	}

	public Locatario recuperarLocatario(String email) {
		if(locatario.getEmail().equals(email)) {
			return locatario;	
		}
		return null;

	}

	public void salvarLocatario(Locatario locatario) {
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral();

		central.setLocatario(locatario);

		persistencia.salvaCentral(central);

		System.out.println(central.getLocadoresCadastrados().size() + " locadores");

		System.out.println("salvou locatario");
		// salvou o locatario na central e adicionou um novo arquivo

	}

	public void salvarBem() {
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral();

		persistencia.salvaCentral(central);

		System.out.println(central.getListaBem().size() + " bens");

		System.out.println("salvou bem");

	}
	public void atualizarBem(Bem bem) {
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral();
		for(Bem b:listaBem) {
			if(bem.getCodigo() == b.getCodigo()) {
				b = bem;
				central.setListaBem(listaBem);
				persistencia.salvaCentral(central);
			}
		}
	}

	public void salvarLocacao(Locacao locacao) throws ItemInexistente,QuantidadeInvalida {
		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral();
		Bem bem = central.getBem(locacao.getCodigo());
		if(bem == null) {
			throw new ItemInexistente("Não existe nem um bem cadastrado com um codigo informado");
			
		}
		if(bem.getQuant() < locacao.getQuant() || bem.getQuant() <= 0) {
			bem.setDisponivel(false);
			throw new QuantidadeInvalida("A quantidade disponivel é " + bem.getQuant());
			
		}
		if(bem.getPrazo() < locacao.getPrazo()) {
			throw new QuantidadeInvalida("Prazo maior do que o disponibilizado ");
		}
		bem.setQuant(bem.getQuant()- locacao.getQuant());
		bem.setQuantAlugueis(bem.getQuantAlugueis() + 1);
		central.atualizarBem(bem);
		listaLocacao.add(locacao);
		central.setListaLocacao(listaLocacao);
		p.salvaCentral(central);

	}

	public void adicionarLocador(Locador locador) {
		locadoresCadastrados.add(locador);
	}

	public void adcionarBem(Bem bem) {
		listaBem.add(bem);

	}

	public Bem getBem(int cod) {
	
		for (Bem bem : listaBem) {
			if (bem.getCodigo() == cod) {
				return bem;
			}
		}
		return null;
	}

	// getters and setters

	public ArrayList<Locador> getLocador() {

		return locadoresCadastrados;

	}

	public ArrayList<Locatario> getLocatariosCadastrados() {
		return locatariosCadastrados;
	}

	public void setLocatariosCadastrados(ArrayList<Locatario> locatariosCadastrados) {
		this.locatariosCadastrados = locatariosCadastrados;
	}

	public ArrayList<Bem> getListaBem() {
		return listaBem;
	}

	public void setListaBem(ArrayList<Bem> listaBem) {
		this.listaBem = listaBem;
	}

	public ArrayList<Locador> getLocadoresCadastrados() {
		return locadoresCadastrados;
	}

	public void setLocadoresCadastrados(ArrayList<Locador> locadoresCadastrados) {
		this.locadoresCadastrados = locadoresCadastrados;
	}

	public Locatario getLocatario() {
		return locatario;
	}

	public void setLocatario(Locatario locatario) {
		this.locatario = locatario;
	}

	public ArrayList<Locacao> getListaLocacao() {
		return listaLocacao;
	}

	public void setListaLocacao(ArrayList<Locacao> listaLocacao) {
		this.listaLocacao = listaLocacao;
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

}
