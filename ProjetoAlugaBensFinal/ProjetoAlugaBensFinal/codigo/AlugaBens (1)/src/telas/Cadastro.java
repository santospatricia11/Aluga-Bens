package telas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Classes.CentralDeInformacoes;
import Classes.Locador;
import Classes.Locatario;
import persistencia.Persistencia;

public class Cadastro extends TelaPadrao implements ActionListener {
	private JButton salvar;
	private JButton voltar;

	private JTextField nometf;
	private JTextField emailtf;
	private JPasswordField senhatf;
	private JTextField dataNasctf;
	private JPasswordField confSenhatf;
	private JTextField ocupacaorf;
	private JTextField cpftf;

	public Cadastro() {

		setLocationRelativeTo(null);
		setTitle("Aluga Bems");
		adicionarLabel();
		adicionarBotao();
		adicionarField();
		adicionarRadioButtun();
		nometf = new JTextField();
		nometf.setBounds(100, 90, 200, 30);

		add(nometf);

		setVisible(true);

	}

	public void adicionarLabel() {

		JLabel texto = new JLabel("Cadastro do Usuário");

		{

		}
		texto.setBounds(250, 20, 500, 20);
		// texto.setFont(font );
		texto.setForeground(Color.BLACK);
		add(texto);

		JLabel email = new JLabel("E-mail");
		email.setBounds(10, 140, 250, 25);
		add(email);

		JLabel nome = new JLabel("Nome");
		nome.setBounds(10, 95, 90, 25);

		add(nome);

		JLabel senha = new JLabel("Senha");
		senha.setBounds(10, 200, 90, 25);
		add(senha);

		JLabel dataNasc = new JLabel("dataNasc");
		dataNasc.setBounds(340, 140, 60, 25);
		add(dataNasc);

		JLabel ocupacao = new JLabel("Ocupacao");
		ocupacao.setBounds(10, 290, 200, 25);
		add(ocupacao);

		JLabel confSenha = new JLabel("ConfSenha");
		confSenha.setBounds(10, 250, 95, 25);
		add(confSenha);

		JLabel cpf = new JLabel("CPF");
		cpf.setBounds(340, 90, 60, 25);
		add(cpf);

	}

	int altura = 0;

	public void adicionarBotao() {
		salvar = new JButton("Salvar");
		salvar.setBounds(150, 370, 100, 30);
		salvar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				boolean entradaValida = validarEntrada(nometf.getText(), emailtf.getText(), senhatf.getText(),
						dataNasctf.getText());
				if (entradaValida) {
					String confSenha = confSenhatf.getText();
					String nome = nometf.getText();
					String email = emailtf.getText();
					String senha = senhatf.getText();
					String dataNasc = dataNasctf.getText();
					String ocupacao = ocupacaorf.getText();
					String cpf = cpftf.getText();
					SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
					Date date = null;
					try {
						date = formato.parse(dataNasc);

						// date = formato.parse(dataNasc);

					} catch (ParseException e1) {

						try {
							date = formato.parse("01/01/1000");
						} catch (ParseException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
					}

					if (!CentralDeInformacoes.existeLocatariCadastrado()) {

						Locatario locatario = new Locatario();
						locatario.setNome(nome);
						locatario.setEmail(email);
						locatario.setSenha(senha);
						locatario.setProfissao(ocupacao);
						locatario.setDataDeNasc(date);
						locatario.setConfSenha(confSenha);
						locatario.setCpf(cpf);
						Persistencia p = new Persistencia();
						CentralDeInformacoes central = p.recuperarCentral();
						central.salvarLocatario(locatario);

						dispose();
						TelaLogin tl = new TelaLogin();
						tl.setLocationRelativeTo(null);

					} else {
						Locador locador = new Locador();
						locador.setNome(nome);
						locador.setEmail(email);
						locador.setSenha(senha);
						locador.setCpf(cpf);
						locador.setProfissao(ocupacao);
						locador.getConfSenha();

						Persistencia persistencia = new Persistencia();
						CentralDeInformacoes c = persistencia.recuperarCentral();
						c.salvarLocador(locador);
						dispose();
						TelaLogin tl = new TelaLogin();
						tl.setLocationRelativeTo(null);

					}

				}else {
					msgInformacao("Dados nao prechidos corretamente");
				}
			}
			
		});
		add(salvar);

		voltar = new JButton("Voltar");
		voltar.setBounds(320, 370, 100, 30);
		add(voltar);
		voltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaInicial();
				dispose();

			}

		});
	};

	public void adicionarField() {
		cpftf = new JTextField();
		cpftf.setBounds(400, 90, 100, 30);
		add(cpftf);

		ocupacaorf = new JTextField();
		ocupacaorf.setBounds(100, 290, 200, 30);
		add(ocupacaorf);

		dataNasctf = new JTextField();
		dataNasctf.setBounds(400, 140, 70, 30);
		add(dataNasctf);

		emailtf = new JTextField();
		emailtf.setBounds(100, 140, 200, 30);
		add(emailtf);

		senhatf = new JPasswordField();
		senhatf.setBounds(100, 195, 200, 30);
		add(senhatf);

		confSenhatf = new JPasswordField();
		confSenhatf.setBounds(100, 250, 200, 30);

		add(confSenhatf);

	}

	public void adicionarRadioButtun() {
		JRadioButton jr = new JRadioButton("feminino");
		jr.setBounds(380, 230, 100, 15);

		JRadioButton jr2 = new JRadioButton("masculino");
		jr2.setBounds(380, 250, 100, 15);
		ButtonGroup group = new ButtonGroup();
		group.add(jr);
		group.add(jr2);
		add(jr);
		add(jr2);

	}

	public static void main(String[] args) {
		new Cadastro();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
