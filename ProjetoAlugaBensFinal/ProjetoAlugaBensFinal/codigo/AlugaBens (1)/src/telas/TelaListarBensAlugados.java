package telas;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Classes.Bem;
import Classes.CentralDeInformacoes;
import Classes.Locacao;
import Classes.Usuario;
import persistencia.Persistencia;

public class TelaListarBensAlugados extends TelaPadrao {
	Persistencia p = new Persistencia();

	private DefaultTableModel modelo = new DefaultTableModel();
	ArrayList<Bem> bens = new ArrayList<Bem>();
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

		for (Locacao locacao : central.getListaLocacao()) {
			if (central.getUsuarioLogado().getCpf().equals(locacao.getLocador().getCpf())) {
				Bem bem = locacao.getBem();
				modelo.addRow(new Object[] { bem.getCodigo(), bem.getNome(), bem.getDescricao(), bem.getQuant(),
						bem.getValor(), bem.getCondicao(), bem.getDataDeDevolucao(), bem.getLocacao()

				});

			}

		}

		contene.setBounds(20, 450, 600, 200);
		janela.add(contene);
		if (janela == null) {
			System.out.println("janela nula");
		}

	}

	public void listar(String cpf) {
		for (Locacao l : central.getListaLocacao()) {
			if (l.getCpfLocador().equals(cpf)) {
				bens.add(central.getBem(l.getCodigo()));

				System.out.println(l.getLocador().getCpf());

				Usuario logado = central.getUsuarioLogado();
				System.out.println("" + logado.getNome());

			}

		}

	}

	public static void main(String[] args) {
		new TelaListarBensAlugados().adicionarTabela(new TelaListarBensAlugados());
	}

}
