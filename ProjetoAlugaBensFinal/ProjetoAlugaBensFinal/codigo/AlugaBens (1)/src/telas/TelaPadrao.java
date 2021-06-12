package telas;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.jtattoo.plaf.bernstein.BernsteinLookAndFeel;

public class TelaPadrao extends JFrame {
	public TelaPadrao() {
		//adiciona LookFeel (Tema)
		try {
			UIManager.setLookAndFeel(new BernsteinLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		setSize(600, 500);
		// posicionar no centro
		setResizable(false);

		setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// getContentPane().setBackground(Color.LIGHT_GRAY);
		Color minhaCor = new Color(255, 246, 143);
		getContentPane().setBackground(minhaCor);

		// adicionarTitulo(titulo);
	}

	private void adicionarTitulo(String texto) {

		JLabel titulo1 = new JLabel(texto, null, JLabel.CENTER);
		titulo1.setBounds(0, 30, 400, 40);
		// titulo1.setFont(new Font());
		titulo1.setForeground(Color.ORANGE);
		titulo1.setOpaque(true);

		add(titulo1);

	}
	
	protected boolean validarEntrada(String... args) {
		for (String string : args) {
			if(string == null || string.equals("")) return false;
		}
		return true;
	}
	
	protected void msgInformacao(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Aluga Bens",JOptionPane.INFORMATION_MESSAGE);
	}

}
