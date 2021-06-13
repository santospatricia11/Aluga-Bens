package telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class TelaHome extends TelaPadrao {
	private String email;
	private JMenuItem bemMenu;

	public TelaHome(String email) {
		this.email = email;
		setTitle("Tela Home");
		setLocationRelativeTo(null);
		adicionalJMemu(this);
		adicionarjlabel(this);
		adicionarBotao(this);

		setVisible(true);
	}

	public void adicionalJMemu(JFrame fame) {
		JMenuBar menu = new JMenuBar();
		setJMenuBar(menu);

		JMenu bensMenu = new JMenu("Bens");
		menu.add(bensMenu);

		JMenuItem menu1 = new JMenuItem("Cadastrar Bem");
		bensMenu.add(menu1);
		menu1.addActionListener(new Ouvinte(this));

		JMenuItem menu2 = new JMenuItem("Listar Bem");
		bensMenu.add(menu2);
		menu2.addActionListener(new Ouvinte(this));
		
		JMenu aluguelMenu = new JMenu("Aluguel");
		menu.add(aluguelMenu);

		bemMenu = new JMenuItem("Alugar bem");
		aluguelMenu.add(bemMenu);
		bemMenu.addActionListener(new Ouvinte(this));


	}

	public class Ouvinte implements ActionListener {
		private TelaHome telaHome;
		private TebelaDeBens listaBem;

		Ouvinte(TelaHome telaHome) {
			this.telaHome = telaHome;

		}

		Ouvinte(TebelaDeBens listaBrem) {
			this.listaBem = listaBem;

		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String botao = e.getActionCommand();

			if (botao.equals("Cadastrar Bem")) {
				CadastroDeBem bem = new CadastroDeBem(email);
				bem.setLocationRelativeTo(telaHome);
				dispose();
			} else if (botao.equals("Listar Bem")) {
				TebelaDeBens lista = new TebelaDeBens();

				new TebelaDeBens();
				dispose();

			} else if(e.getSource().equals(bemMenu)) {
				new TelaAluguel();
				dispose();

			}

		}

	}

	public void adicionarjlabel(JFrame frame) {
		JLabel texto = new JLabel("Aluga Bens");
		frame.getContentPane().add(texto);
		texto.setBounds(236, 106, 145, 25);
		texto.setForeground(Color.BLACK);
		texto.setFont(new Font("Arial", Font.BOLD, 25));

		JLabel t = new JLabel("Seja Bem Vindo(a)");
		frame.getContentPane().add(t);
		t.setBounds(256, 137, 113, 25);
		t.setFont(new Font("Arial", Font.BOLD, 12));

	}

	public void adicionarBotao(JFrame frame) {
		JButton editar = new JButton("Editar");
		editar.setBounds(200, 400, 80, 30);
		frame.getContentPane().add(editar);

		JButton excluir = new JButton("Excluir");
		excluir.setBounds(290, 400, 80, 30);
		frame.getContentPane().add(excluir);
	}

	public static void main(String[] args) {
		new TelaHome("Home");

	}
}
