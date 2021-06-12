package telas;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Classes.Bem;
import Classes.CentralDeInformacoes;
import persistencia.Persistencia;

public class TebelaDeBens extends JTable {
	Persistencia p = new Persistencia();
	private DefaultTableModel modelo = new DefaultTableModel();
	CentralDeInformacoes central = p.recuperarCentral();

	public void adicionarTabela(JFrame janela) {

		modelo.addColumn("codigo");
		modelo.addColumn("nome");
		modelo.addColumn("discricao");
		modelo.addColumn("quant");
		modelo.addColumn("valor");
		modelo.addColumn("condicao");
		modelo.addColumn("dataDeDevolucao");
		modelo.addColumn("locacao");

		JTable tabela = new JTable(modelo);
		JScrollPane contene = new JScrollPane(tabela);

		for (Bem bem : central.getListaBem()) {
			modelo.addRow(new Object[] { bem.getCodigo(), bem.getNome(), bem.getDescricao(), bem.getQuant(),
					bem.getValor(), bem.getCondicao(), bem.getDataDeDevolucao(), bem.getLocacao()

			});

		}
		contene.setBounds(20, 450, 600, 200);
		janela.add(contene);

	}

	public void adicionarLinha(Bem bem) {
		modelo.addRow(new Object[] { bem.getCodigo(), bem.getNome(), bem.getDescricao(), bem.getQuant(), bem.getValor(),
				bem.getCondicao(), bem.getDataDeDevolucao(), bem.getLocacao()

		});
	}

	public static void main(String[] args) {
		new TebelaDeBens();
	}
}
