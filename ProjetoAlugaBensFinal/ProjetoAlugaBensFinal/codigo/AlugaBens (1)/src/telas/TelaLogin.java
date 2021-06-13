package telas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Classes.CentralDeInformacoes;
import Classes.Locador;
import Classes.Locatario;
import Classes.Usuario;
import persistencia.Persistencia;

public class TelaLogin extends TelaPadrao {
	private static final int Font = 0;
	private JButton logarB, voltarB;
	private JTextField emailtf, senhatf;
//tela login
	public TelaLogin() {

		adicionarBotao();
		adicionarField();
		adicionarLabel();

		setLocationRelativeTo(null);

		setVisible(true);

	}

	public void adicionarLabel() {

		JLabel texto = new JLabel("Aluga Bens");
		texto.setBounds(250, 20, 500, 35);
		texto.setFont(new java.awt.Font("Arial", Font, 30));

		texto.setForeground(Color.BLACK);
		add(texto);

		JLabel email = new JLabel("Email");
		email.setBounds(10, 80, 130, 25);
		add(email);

		JLabel senha = new JLabel("Senha");
		senha.setBounds(10, 145, 90, 25);
		add(senha);

	}

	int altura = 0;

	public void adicionarBotao() {
		logarB = new JButton("Logar");
		logarB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Persistencia persistencia = new Persistencia();

				CentralDeInformacoes central = persistencia.recuperarCentral();

				Usuario  usuario  = central.recuperarLocador(emailtf.getText());
				if(usuario == null) {
					usuario = central.recuperarLocatario(emailtf.getText());
					
				}
 
				if (usuario == null) {
					JOptionPane.showMessageDialog(null, "nao existe esse usuario" );

				} else {
					if (senhatf.getText().equals(usuario.getSenha())) {
						central.setUsuarioLogado(usuario);
						
						
						new TelaHome(emailtf.getText());

						dispose();

					}else {
						JOptionPane.showMessageDialog(null, "Senha invalida " );
						
					}
				}

			}
		});
		logarB.setBounds(150, 350, 150, 30);
		add(logarB);

		voltarB = new JButton("voltar");
		voltarB.setBounds(350, 350, 150, 30);
		add(voltarB);
		voltarB.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new TelaInicial();
				
			}
		});

	}

	public void adicionarField() {
		emailtf = new JTextField();
		emailtf.setBounds(150, 90, 300, 30);
		add(emailtf);

		senhatf = new JPasswordField();
		senhatf.setBounds(150, 140, 300, 30);
		add(senhatf);
		

		// Jlabel só nomes no caso etiqueta
		// JtextField campo de texto
		// Jbutton Botao
	}

	public static void main(String[] args) {
		new TelaLogin();
	}
}
