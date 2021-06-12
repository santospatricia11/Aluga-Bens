package telas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Classes.Bem;
import Classes.CentralDeInformacoes;
import persistencia.Persistencia;

public class CadastroDeBem extends TelaPadrao {
	private JButton cadastrar;
	private JButton voltar;
	private JTextField nometf;
	private JTextField descricaotf;
	private JTextField quantf;
	private JTextField valortf;
	private JTextField condicaotf;
	private JTextField dataDeDevolucaotf;
	private JTextField prazotf;
	private TebelaDeBens tabela;

	private String email;

	public CadastroDeBem(String email) {
		this.email = email;
		setSize(700, 700);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Aluga Bens");
		adicionaLabel();
		adicionarBotao();
		adicionarField();
//		adicionarJTextArea() ;
		tabela(this);
		setVisible(true);
	}

	public void adicionaLabel() {
		JLabel l = new JLabel("Cadastrar Bens");
		l.setBounds(250, 20, 500, 20);
		l.setForeground(Color.BLACK);
		getContentPane().add(l);

		JLabel nome = new JLabel("Nome");
		nome.setBounds(23, 80, 50, 25);
		getContentPane().add(nome);

		JLabel descricao = new JLabel("Descrição");
		descricao.setBounds(20, 123, 80, 25);
		getContentPane().add(descricao);

		JLabel quant = new JLabel("quant");
		quant.setBounds(23, 179, 50, 25);
		getContentPane().add(quant);

		JLabel valor = new JLabel("valor");
		valor.setBounds(226, 179, 50, 25);
		getContentPane().add(valor);

		JLabel condicao = new JLabel("condicao");
		condicao.setBounds(23, 236, 80, 25);
		getContentPane().add(condicao);

		JLabel prazo = new JLabel("Prazo");
		prazo.setBounds(23, 289, 90, 30);
		getContentPane().add(prazo);

	}

	int altura = 0;

	public void adicionarBotao() {
		voltar = new JButton("Voltar");
		voltar.setBounds(320, 395, 100, 30);
		voltar.addActionListener(new Ouvinte(2));

		getContentPane().add(voltar);

		cadastrar = new JButton("Cadastrar");
		cadastrar.setBounds(208, 395, 100, 30);
		getContentPane().add(cadastrar);
		cadastrar.addActionListener(new Ouvinte(1));
	}

	public class Ouvinte implements ActionListener {
		int op;

		public Ouvinte(int opcao) {
			op = opcao;

		}

		public void actionPerformed(ActionEvent e) {
			if (op == 1) {
				cadastrar();
			} else if (op == 2) {
				voltar();
			}

		}

	}

//	public void adicionarJTextArea() {
//		JTextArea a = new JTextArea();
//		add(a);
//		
//	}
	public void cadastrar() {
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral();

		Bem bem = new Bem();
		int cod = 0;
		for (Bem b : central.getListaBem()) {
			cod = b.getCodigo();
		}
		cod++;
		bem.setCodigo(cod);
		bem.setNome(nometf.getText());
		bem.setDescricao(descricaotf.getText());
		int quant = Integer.parseInt(quantf.getText());
		bem.setQuant(quant);
		bem.setValor(Float.parseFloat(valortf.getText()));
		bem.setCondicao(condicaotf.getText());
		bem.setPrazo(Integer.parseInt(prazotf.getText()));
		bem.setDisponivel(true);
		central.adcionarBem(bem);
		central.salvarBem();
		tabela.adicionarLinha(bem);

		// Locador locador = central.recuperarLocador(email);

		// locador.getAlugueis().add(bem);
		persistencia.salvaCentral(central);
		JOptionPane.showMessageDialog(null, "Novo bem adicionado!");
		new TelaHome(email);
		dispose();

	}

	public void voltar() {
		JOptionPane.showMessageDialog(null, "voltou");
	}

	public void adicionarField() {

		nometf = new JTextField();
		nometf.setBounds(111, 80, 414, 30);
		getContentPane().add(nometf);

		descricaotf = new JTextField();
		descricaotf.setBounds(111, 123, 414, 30);
		getContentPane().add(descricaotf);

		quantf = new JTextField();
		quantf.setBounds(111, 176, 103, 30);
		getContentPane().add(quantf);

		valortf = new JTextField();
		valortf.setBounds(276, 176, 249, 30);
		getContentPane().add(valortf);

		condicaotf = new JTextField();
		condicaotf.setBounds(111, 236, 414, 30);
		getContentPane().add(condicaotf);

//		dataDeDevolucaotf = new JTextField();
//		dataDeDevolucaotf.setBounds(150,250,300,30);
//		add(dataDeDevolucaotf);

		prazotf = new JTextField();
		prazotf.setBounds(111, 292, 414, 30);
		getContentPane().add(prazotf);

		// prazotf = new JTextField();
		// prazotf.setB

	}

	public void tabela(JFrame janela) {
		tabela = new TebelaDeBens();
		tabela.adicionarTabela(janela);
		janela.getContentPane().add(tabela);

	}

	public static void main(String[] args) {
		new CadastroDeBem("");
	}

}
