package telas;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Classes.CentralDeInformacoes;
import Classes.Locador;
import Classes.Usuario;
import persistencia.Persistencia;

public class TelaListaDeUsuario extends TelaPadrao {
	private DefaultTableModel model;
	private JTable tabela;
//lista usuarios
	public TelaListaDeUsuario() {
		setTitle("Listas de Usuario ");
		setLocationRelativeTo(null);
		adicionarjbuntton();
		adicionarTabela();
		setVisible(true);
	}

	public void adicionarjbuntton() {

		JButton voltar = new JButton("Voltar");
		voltar.setBounds(150, 430, 90, 30);
		add(voltar);

		JButton fazerLogin = new JButton("Login");
		fazerLogin.setBounds(350, 430, 90, 30);
		add(fazerLogin);

	}

	public void adicionarTabela() {
		Usuario usuario = new Usuario();

		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral();
		model = new DefaultTableModel();
		model.addColumn("nome");
		model.addColumn("e-mail");
		model.addColumn("profissão");
		tabela = new JTable(model);

		// cador locador = central.getLocador().get(0);
		for (Locador locador : central.getLocadoresCadastrados()) {
			String[] colunas = { locador.getNome(), locador.getEmail(), locador.getProfissao() };
			Object[] dados = {

					locador.getNome(), locador.getEmail(), locador.getProfissao()

			};
			model.addRow(colunas);
		}

		try {
			tabela.addRowSelectionInterval(0, 0);
		} catch (Exception e) {

		}
		JScrollPane barra = new JScrollPane(tabela);
		barra.setBounds(0, 5, 600, 200);
		add(barra);
	}

	public static void main(String[] args) {
		new TelaListaDeUsuario();
	}
}
