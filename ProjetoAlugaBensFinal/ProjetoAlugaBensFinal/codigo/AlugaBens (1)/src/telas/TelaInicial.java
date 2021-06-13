package telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Classes.CentralDeInformacoes;
import persistencia.Persistencia;

public class TelaInicial extends TelaPadrao {
	private JButton sair;
	private JButton login;

	public TelaInicial() {
		setLocationRelativeTo(null);
		setTitle("Listas Bens ");
		ImageIcon icon = new ImageIcon("projeto2018.2.png");
		JLabel imagem = new JLabel(icon);

		// setBounds(1,0,600,500);
		setContentPane(imagem);
		adicionarjbuntton();
		adicionarJButton();

		setVisible(true);

	}

	public void adicionarJButton() {
		JButton cadastrar = new JButton("Cadastrar");
		cadastrar.setBounds(300, 400, 100, 40);
		cadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Cadastro();
				setVisible(false);

			}
		});
		add(cadastrar);

	}
	public void adicionarjbuntton() {
		JButton login = new JButton("Login");
		login.setBounds(100, 400, 100, 40);
		login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				Persistencia persistencia = new Persistencia();
				CentralDeInformacoes central = persistencia.recuperarCentral();

				if (central.getLocatario() == null) {

					JOptionPane.showMessageDialog(null,
							"Não existem locatários, você deve cadastrar um em primeiro lugar");

				} else {
					new TelaLogin();
					setVisible(false);

				}

			}
		});
		add(login);

	}

	public static void main(String[] args) {
		new TelaInicial();
	}
//Tela inicial
}
