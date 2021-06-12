package telas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Classes.CentralDeInformacoes;
import Classes.Locacao;
import Classes.Locador;
import excecoes.ItemInexistente;
import excecoes.QuantidadeInvalida;
import persistencia.Persistencia;

public class TelaAluguel extends TelaPadrao {

	private JTextField codigoJt;
	private JTextField cpfJt;
	private JTextField quantidadeJt;
	private JTextField prazoJt;
	private JButton alugarJb;
	private JButton voltarJb;

	public TelaAluguel() {
		setTitle("Aluga Bem");
		setLocationRelativeTo(null);
		setResizable(false);
		adicionarLabel();
		adicionarJbunto();
		adicionarJtexField();

		setVisible(true);

	}

	public void adicionarLabel() {
		JLabel texto = new JLabel(" Tela Aluguel");
		texto.setBounds(245, 13, 93, 20);
		texto.setForeground(Color.BLACK);
		getContentPane().add(texto);

		JLabel codigo = new JLabel("Codigo");
		codigo.setBounds(37, 87, 80, 25);
		getContentPane().add(codigo);

		JLabel cpf = new JLabel("CPF");
		cpf.setBounds(37, 147, 34, 25);
		getContentPane().add(cpf);

		JLabel quantidade = new JLabel(" Quantidade");
		quantidade.setBounds(37, 207, 80, 25);
		getContentPane().add(quantidade);

		JLabel prazo = new JLabel(" Prazo");
		prazo.setBounds(37, 267, 80, 25);
		getContentPane().add(prazo);

	}

	public void adicionarJtexField() {

		codigoJt = new JTextField();
		codigoJt.setBounds(146, 87, 253, 30);
		getContentPane().add(codigoJt);

		cpfJt = new JTextField();
		cpfJt.setBounds(145, 142, 253, 30);
		getContentPane().add(cpfJt);

		quantidadeJt = new JTextField();
		quantidadeJt.setBounds(146, 207, 253, 30);
		getContentPane().add(quantidadeJt);

		prazoJt = new JTextField();
		prazoJt.setBounds(145, 262, 253, 30);
		getContentPane().add(prazoJt);

	}

	public void adicionarJbunto() {
		alugarJb = new JButton("Alugar");
		alugarJb.setBounds(187, 382, 100, 30);
		getContentPane().add(alugarJb);

		voltarJb = new JButton("Voltar");
		voltarJb.setBounds(299, 382, 100, 30);
		getContentPane().add(voltarJb);

		Ouvinte voOuvinte = new Ouvinte(1);
		alugarJb.addActionListener(voOuvinte);

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

	public void cadastrar() {
		boolean entradaValida = validarEntrada(prazoJt.getText(), codigoJt.getText(), cpfJt.getText(),
				quantidadeJt.getText());
		if (entradaValida) {
			Persistencia persistencia = new Persistencia();
			CentralDeInformacoes central = persistencia.recuperarCentral();
			String cpfValido = central.getUsuarioLogado().getCpf();
			Locacao locacao = new Locacao();
			if (cpfValido.equals(cpfJt.getText())) {
				locacao.setCpfLocador(cpfJt.getText());
				int codigo = Integer.parseInt(codigoJt.getText());
				locacao.setCodigo(codigo);
				int prazo = Integer.parseInt(prazoJt.getText());
				locacao.setPrazo(prazo);
				int quant = Integer.parseInt(quantidadeJt.getText());
				locacao.setQuant(quant);
				locacao.setLocador((Locador)central.getUsuarioLogado());
				locacao.setLocatario(central.getLocatario());
				
				
				try {
					central.salvarLocacao(locacao);
					msgInformacao("Aluguel do bem realizado com sucesso.");
					new TelaHome("");

					dispose();

				} catch (ItemInexistente e) {
					msgInformacao(e.getMessage());
				} catch (QuantidadeInvalida q) {
					msgInformacao(q.getMessage());
				}

			} else {
				msgInformacao("O cpf informado não conrresponde ao usuario logado");
			}

		} else {
			msgInformacao("Campos obrigatórios não foram preenchidos");
		}
	}

	public void voltar() {
		new TelaHome("");
		dispose();
	}

	public static void main(String[] args) {
		new TelaAluguel();
	}

}
